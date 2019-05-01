package com.retell.retellbackend.service;

import com.retell.retellbackend.domain.Book;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    @Autowired
    private JdbcTemplate jdbc;

    public Book getBookByID(Integer ID) {
        String sql = "select * from book where ID = ?";
        if (jdbc.queryForList(sql, ID).size() == 0 ) {
            return null;
        }
        Map<String, Object> result = jdbc.queryForMap(sql, ID);

        Book cur_book = new Book();
        cur_book.setID((Integer) result.get("ID"));
        cur_book.setName((String)result.get("name"));
        cur_book.setAuthor((String)result.get("author"));
        cur_book.setISBN((String)result.get("ISBN"));
        cur_book.setStock((Integer)result.get("stock"));
        cur_book.setFrontpage((String)result.get("front_page"));
        cur_book.setCategory((Integer)result.get("category"));
        cur_book.setCurCost((BigDecimal)result.get("cur_cost"));
        cur_book.setPrevCost((BigDecimal)result.get("prev_cost"));
        cur_book.setBookDetail((String)result.get("book_detail"));
        cur_book.setAuthorDetail((String)result.get("author_detail"));
        cur_book.setStock((Integer) result.get("stock"));

        return cur_book;
    }

    public void createBook(Book book) {
        String sql = "insert into book (name, author, ISBN, stock, front_page, book_detail, author_detail, category, cur_cost, prev_cost) values(\"" + book.getName() + "\",\"" +  book.getAuthor() + "\",\"" + book.getISBN() + "\"," + book.getStock() + ",\"" + book.getFrontpage() + "\",\"" +  book.getBookDetail() + "\",\"" +  book.getAuthorDetail() + "\",\"" + book.getCategory() + "\"," +  book.getCurCost()  +  "," + book.getPrevCost() + ")";
        jdbc.execute(sql);
    }

    public List getBookCarousel() {
        String sql = "SELECT ID, name, author, prev_cost, cur_cost, front_page FROM book limit 16";
        List<Map<String, Object>> results = jdbc.queryForList(sql);

        return results;
    }

    public List getBookByCateIDLimited(Integer ID) {
        String sql = "SELECT ID, name, author, prev_cost, cur_cost, front_page FROM book WHERE category = ? limit 8";
        List<Map<String, Object>> results = jdbc.queryForList(sql, ID);
//        System.out.print(results);
        return results;
    }

    public List getBookByCateID(Integer ID) {
        String sql = "SELECT ID, name, author, prev_cost, cur_cost, front_page FROM book WHERE category = ?";
        List<Map<String, Object>> results = jdbc.queryForList(sql, ID);
//        System.out.print(results);
        return results;
    }

    public List getAllBook() {
        String sql = "SELECT ID, name, author, prev_cost, cur_cost, front_page FROM book";
        List<Map<String, Object>> results = jdbc.queryForList(sql);
        return results;
    }

//    public List getBookByCateName(String name) {
//        String sql = "SELECT ID from book_category where name = ?";
//        Map<String, Object> ID = jdbc.queryForMap(sql, name);
//        List<Map<String, Object>> results = getBookByCateIDLimited((Integer) ID.get("ID"));
//
//        return results;
//    }
    public List bookDump(List<Map<String, Object>> books) {
        List objects = new ArrayList();
        for (int i = 0; i < books.size(); i++) {
//            System.out.print(books.get(i));
            JSONObject result = new JSONObject();
            result.put("author", books.get(i).get("author"));
            result.put("prev_cost", books.get(i).get("prev_cost"));
            result.put("cur_cost", books.get(i).get("cur_cost"));
            result.put("front_page", books.get(i).get("front_page"));
            result.put("name", books.get(i).get("name"));
            result.put("id", books.get(i).get("ID"));

            objects.add(result);
        }
        return objects;
    }

//    public List getBookByCateID() {
//
//    }
}
