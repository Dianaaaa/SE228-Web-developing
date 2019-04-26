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
        String sql = "SELECT ID, name FROM book_category";

        List<Map<String, Object>> categories = jdbc.queryForList(sql);
        List objects = new ArrayList();
        for (int i = 0; i < categories.size(); i++) {
//            System.out.print(categories.get(i));
            JSONObject result = new JSONObject();
            result.put("name", categories.get(i).get("name"));
            result.put("id", categories.get(i).get("ID"));

            objects.add(result);
        }
        return objects;
    }

    public Integer getCateByName(String name) {
        String sql = "SELECT ID FROM book_category where name = ?";
        Map<String, Object> cate = jdbc.queryForMap(sql, name);

        return (Integer)cate.get("ID");
    }

}
