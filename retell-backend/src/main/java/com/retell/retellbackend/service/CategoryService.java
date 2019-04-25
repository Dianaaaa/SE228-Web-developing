package com.retell.retellbackend.service;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Autowired
    private JdbcTemplate jdbc;

    public List getCategory() {
        String sql = "SELECT name FROM book_category";

        List<Map<String, Object>> categories = jdbc.queryForList(sql);
        List result = new ArrayList();
//        System.out.print(categories.get(1).);
        for (int i = 0; i < categories.size(); i++) {
            result.add(categories.get(i).get("name"));
        }
//        System.out.print(result);
        return result;
    }

}
