package com.retell.retellbackend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class DealService {

    @Autowired
    private JdbcTemplate jdbc;

    public Boolean createDealByUserID(String phone, String address, BigDecimal total_price, Integer userID) {
        String sqlCart = "SELECT * FROM cart WHERE userID =  ?";
        List<Map<String, Object>> cartItems = jdbc.queryForList(sqlCart, userID);
        if (cartItems.size() == 0) {
            System.out.print("no cart item \n");
            return Boolean.FALSE;
        }
        String sqlDeal = "INSERT INTO deal(phone, address, total_price, userID) values (\"" + phone + "\",\"" + address + "\"," + total_price.toString() + "," + userID + ")";
        jdbc.execute(sqlDeal);
        String sqlID = "SELECT LAST_INSERT_ID()";
        Map<String, Object> ID = jdbc.queryForMap(sqlID);
        Integer dealID = Integer.valueOf(ID.get("LAST_INSERT_ID()").toString());

        for (int i = 0; i < cartItems.size(); i++) {
            String sqlDealBook = "INSERT INTO deal_book(bookID, ammount, dealID) values(" + cartItems.get(i).get("bookID") + "," + cartItems.get(i).get("ammount") + "," + dealID + ")";
            jdbc.execute(sqlDealBook);
            String sqlDeleteCart = "DELETE FROM cart WHERE ID = " + cartItems.get(i).get("ID");
            jdbc.execute(sqlDeleteCart);
        }

        return Boolean.TRUE;
    }
}
