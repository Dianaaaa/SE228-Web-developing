package com.retell.retellbackend.serviceimpl;


import com.retell.retellbackend.entity.Book;
import com.retell.retellbackend.entity.CartItem;
import com.retell.retellbackend.entity.Deal;
import com.retell.retellbackend.repository.DealRepository;
import com.retell.retellbackend.repository.UserRepository;
import com.retell.retellbackend.entity.UserEntity;
import com.retell.retellbackend.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
//    @Autowired
//    private JdbcTemplate jdbc;

    @Resource
    private UserRepository userRepository;

    @Resource
    private DealRepository dealRepository;

    public Boolean checkUserName(String username) {
        UserEntity user = userRepository.getUserByName(username);
        if ( user == null) {
            System.out.print(user);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public void createUser(UserEntity user) {
        userRepository.save(user);
    }

    public UserEntity getUserByName(String name) {
        UserEntity user = userRepository.getUserByName(name);
//        System.out.print(user);
        return user;
    }

    public List getAllUser() {
        String sql = "select * from user";
        List<UserEntity> users = userRepository.getAllUsers();

        return users;
    }

    public Integer getIDByName(String username) {
        Integer id = userRepository.getIDByName(username);
        return id;
    }

    public void banUser(String username) {
        userRepository.banUser(username);
        return;
    }

    public void rebanUser(String username) {
        userRepository.rebanUser(username);
        return;
    }

    public void addConsumption(Integer ID, BigDecimal tot_price){
        UserEntity user = userRepository.getUserByID(ID);
        BigDecimal consump = user.getConsumption();
        consump = consump.add(tot_price);
        user.setConsumption(consump);
        userRepository.save(user);
    }

    public List<JSONObject> statUserByTime(String begin, String end){
        begin = begin + " 00:00:00";
        end = end + " 23:59:59";
        System.out.println(begin);
        System.out.println(end);
        Timestamp betime = Timestamp.valueOf(begin);
        Timestamp entime = Timestamp.valueOf(end);

        List<Deal> deals =  dealRepository.getDealsByTime(end, begin);

        Map<String, BigDecimal> stat = new HashMap<>();

        for (int i = 0; i < deals.size(); i++) {
            UserEntity user = deals.get(i).getUser();
            String key = user.getUsername();
            if (stat.containsKey(key)) {
                BigDecimal sale = stat.get(key);
                sale = sale.add(deals.get(i).getTotal_price());
                stat.put(key, sale);
            }
            stat.put(key, deals.get(i).getTotal_price());
        }

        List<JSONObject> result = new ArrayList<>();

        Iterator iter = stat.keySet().iterator();
        while (iter.hasNext()) {
            Object key = iter.next();
            Object val = stat.get(key);
            JSONObject obj = new JSONObject();
            obj.put("name", (String) key);
            obj.put("sale", (BigDecimal) val);
            result.add(obj);
        }
        return result;
    }

    public BigDecimal statUserByTimeUser(String begin, String end, Integer ID) {
        begin = begin + " 00:00:00";
        end = end + " 23:59:59";
        System.out.println(begin);
        System.out.println(end);
        Timestamp betime = Timestamp.valueOf(begin);
        Timestamp entime = Timestamp.valueOf(end);

        List<Deal> deals =  dealRepository.getDealsByTimeUser(end, begin, ID);
        BigDecimal cost = BigDecimal.valueOf(0);
        for (int i = 0; i < deals.size(); i++) {
            cost = cost.add(deals.get(i).getTotal_price());
        }

        return cost;
    }
}
