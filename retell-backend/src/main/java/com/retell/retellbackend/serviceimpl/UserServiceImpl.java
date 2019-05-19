package com.retell.retellbackend.serviceimpl;


import com.retell.retellbackend.repository.UserRepository;
import com.retell.retellbackend.entity.UserEntity;
import com.retell.retellbackend.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
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
