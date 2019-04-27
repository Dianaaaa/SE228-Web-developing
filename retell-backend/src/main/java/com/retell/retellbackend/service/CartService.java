package com.retell.retellbackend.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CartService {
    @Autowired
    private JdbcTemplate jdbc;

    public List  getCartByUser(Integer userID) {
        String sql = "select cart.ammount, cart.bookID, book.cur_cost, book.name, book.front_page, book.author From book JOIN cart ON book.ID = Cart.bookID WHERE cart.userID = ?";
        List<Map<String, Object>> results = jdbc.queryForList(sql, userID);

        List objects = new ArrayList();
        for (int i = 0; i < results.size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("ammount", results.get(i).get("ammount"));
            obj.put("bookID", results.get(i).get("bookID"));
            obj.put("cur_cost", results.get(i).get("cur_cost"));
            obj.put("name", results.get(i).get("name"));
            obj.put("front_page", results.get(i).get("front_page"));
            obj.put("author", results.get(i).get("author"));

            objects.add(obj);
        }
        return results;
    }

    public Boolean updateAmmount(Integer userID, Integer bookID, Integer ammount) {
        String sql = "UPDATE cart set ammount = "  + ammount.toString() + " where userID = " + userID.toString()+ " and bookID = " + bookID.toString();
        jdbc.execute(sql);

        return Boolean.TRUE;
    }
}
