package com.retell.retellbackend.service;

import com.retell.retellbackend.domain.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

        return cur_book;
    }

    public void create() {

    }
}
