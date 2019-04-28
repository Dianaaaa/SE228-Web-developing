package com.retell.retellbackend.service;


import com.retell.retellbackend.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbc;

    public Boolean checkUserName(String username) {
        String sql = "select * from user where username = ?";
        if (jdbc.queryForList(sql, username).size() == 0) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public void createUser(UserEntity user) {
        String sql = "insert into user (username, password, email) values(\"" + user.getUsername() + "\",\"" +  user.getPassword() + "\",\"" + user.getEmail() + "\")";
        jdbc.execute(sql);
    }

    public UserEntity getUserByName(String name) {
        String sql = "select * from user where username = ?";
        Map<String, Object> user = jdbc.queryForMap(sql, name);

        UserEntity obj = new UserEntity();
        obj.setID((Integer) user.get("ID"));
        obj.setUsername((String)user.get("username"));
        obj.setPassword((String)user.get("password"));
        obj.setEmail((String)user.get("email"));
        obj.setRole((String) user.get("role"));
        obj.setStatus((Integer) user.get("status"));
//        System.out.print("get a user");
        return obj;
    }

    public List getAllUser() {
        String sql = "select * from user";
        List<Map<String, Object>> users = jdbc.queryForList(sql);

        List results = new ArrayList();
        for (int i = 0; i < users.size(); i++) {
            UserEntity obj = new UserEntity();
            obj.setID((Integer) users.get(i).get("ID"));
            obj.setUsername((String)users.get(i).get("username"));
            obj.setPassword((String)users.get(i).get("password"));
            obj.setEmail((String)users.get(i).get("email"));
            obj.setRole((String) users.get(i).get("role"));
            obj.setStatus((Integer) users.get(i).get("status"));
            results.add(obj);
        }
        return results;
    }

    public Integer getIDByName(String username) {
        String sql = "SELECT ID FROM user where username = ?";
        Map<String, Object> usr = jdbc.queryForMap(sql, username);
        return (Integer) usr.get("ID");
    }
}
