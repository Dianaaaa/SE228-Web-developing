package com.retell.retellbackend.service;


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
        Map<String, Object> result = jdbc.queryForMap(sql, username);

        return Boolean.FALSE;
    }
}
