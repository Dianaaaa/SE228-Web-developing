package com.retell.retellbackend.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    @Autowired
    private JdbcTemplate jdbc;

    public List getBookComment(Integer bookID) {
        String sql = "SELECT ID, content, time, score, userID FROM comment where bookID = ?";
        List<Map<String, Object>> comments = jdbc.queryForList(sql, bookID);
        List objects = new ArrayList();
        for (int i = 0; i < comments.size(); i++) {
            System.out.print(comments.get(i));
            JSONObject result = new JSONObject();
            result.put("content", comments.get(i).get("content"));
            result.put("time", comments.get(i).get("time").toString());
            result.put("score", comments.get(i).get("score"));
            result.put("userID", comments.get(i).get("userID"));
            result.put("ID", comments.get(i).get("ID"));

            objects.add(result);
        }
        return objects;
    }
}
