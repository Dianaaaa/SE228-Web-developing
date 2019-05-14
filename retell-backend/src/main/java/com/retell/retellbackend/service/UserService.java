package com.retell.retellbackend.service;


import com.retell.retellbackend.dao.UserRepository;
import com.retell.retellbackend.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
//    @Autowired
//    private JdbcTemplate jdbc;

    @Resource
    private UserRepository userRepository;

    public Boolean checkUserName(String username) {
        if (userRepository.getUser(username) != null) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public void createUser(UserEntity user) {
        userRepository.save(user);
    }

    public UserEntity getUserByName(String name) {
        UserEntity user = userRepository.getUser(name);

//        UserEntity obj = new UserEntity();
//        obj.setID((Integer) user.get("ID"));
//        obj.setUsername((String)user.get("username"));
//        obj.setPassword((String)user.get("password"));
//        obj.setEmail((String)user.get("email"));
//        obj.setRole((String) user.get("role"));
//        obj.setStatus((Integer) user.get("status"));
//        System.out.print("get a user");
        return user;
    }

//    public List getAllUser() {
//        String sql = "select * from user";
//        List<Map<String, Object>> users = jdbc.queryForList(sql);
//
//        List results = new ArrayList();
//        for (int i = 0; i < users.size(); i++) {
//            UserEntity obj = new UserEntity();
//            obj.setID((Integer) users.get(i).get("ID"));
//            obj.setUsername((String)users.get(i).get("username"));
//            obj.setPassword((String)users.get(i).get("password"));
//            obj.setEmail((String)users.get(i).get("email"));
//            obj.setRole((String) users.get(i).get("role"));
//            obj.setStatus((Integer) users.get(i).get("status"));
//            results.add(obj);
//        }
//        return results;
//    }

    public Integer getIDByName(String username) {
        Integer id = userRepository.getIDByName(username);
        return id;
    }
}
