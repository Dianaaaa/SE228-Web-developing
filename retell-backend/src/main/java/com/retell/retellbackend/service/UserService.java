package com.retell.retellbackend.service;


import com.retell.retellbackend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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

    public void createUser(User user) {
        Integer role = 1;
        String sql = "insert into user (username, password, email, role) values(\"" + user.getUsername() + "\",\"" +  user.getPassword() + "\",\"" + user.getEmail() + "\"," + role.toString() + ")";
        jdbc.execute(sql);
    }
}
