package com.retell.retellbackend.service;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DealService {

    @Autowired
    private JdbcTemplate jdbc;

    public Boolean createDealByUserID(String phone, String address, String receiver,  BigDecimal total_price, Integer userID) {
        String sqlCart = "SELECT * FROM cart WHERE userID =  ?";
        List<Map<String, Object>> cartItems = jdbc.queryForList(sqlCart, userID);
        if (cartItems.size() == 0) {
            System.out.print("no cart item \n");
            return Boolean.FALSE;
        }
        String sqlDeal = "INSERT INTO deal(phone, address, receiver, total_price, userID) values (\"" + phone + "\",\"" + address + "\",\"" + receiver + "\", " + total_price.toString() + "," + userID + ")";
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

    public List  getDealByUser(Integer userID) {
        String sqlDeal = "SELECT * From deal WHERE userID = ?";
        List<Map<String, Object>> deals = jdbc.queryForList(sqlDeal, userID);

        List objects = new ArrayList();
        for (int i = 0; i < deals.size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("ID", deals.get(i).get("ID"));
            obj.put("phone", deals.get(i).get("phone"));
            obj.put("address", deals.get(i).get("address"));
            obj.put("time", deals.get(i).get("time").toString());
            obj.put("total_price", deals.get(i).get("total_price"));
            obj.put("receiver", deals.get(i).get("receiver"));
            Integer dealID = (Integer) deals.get(i).get("ID");
            String sqlBooks = "select deal_book.ammount, deal_book.bookID, book.cur_cost, book.name, book.front_page, book.author From book JOIN deal_book ON book.ID = deal_book.bookID WHERE deal_book.dealID= ?";
            List<Map<String, Object>> books = jdbc.queryForList(sqlBooks, dealID);


            List jsonbooks = new ArrayList();
            for (int j = 0; j < books.size(); j++) {
                JSONObject bok = new JSONObject();
                bok.put("ammount", books.get(j).get("ammount"));
                bok.put("bookID", books.get(j).get("bookID"));
//                System.out.print(books.get(j).get("front_page").toString()+"\n");
                bok.put("name", books.get(j).get("name"));
                bok.put("author", books.get(j).get("author"));
                bok.put("cur_cost", books.get(j).get("cur_cost"));
                bok.put("front_page", books.get(j).get("front_page"));
                jsonbooks.add(bok);
            }
//            System.out.print(jsonbooks+"\n");
            obj.put("books", jsonbooks);

            objects.add(obj);
        }
        return objects;
    }
}
