package com.retell.retellbackend.service;

import com.retell.retellbackend.domain.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
}
