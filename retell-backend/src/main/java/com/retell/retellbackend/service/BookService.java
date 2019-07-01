package com.retell.retellbackend.service;

import com.retell.retellbackend.entity.Book;
import org.json.simple.JSONObject;

import java.util.List;


public interface BookService {
    Book getBookByID(Integer ID);

    void createBook(Book book);

    List getBookCarousel();

    List getBookByCateIDLimited(Integer ID);

    List getBookByCateID(Integer ID);

    List getAllBook();

    List bookDump(List<Book> books);

    void saveBook(Book book);

    void deleteBook(Integer ID);

    void addSales(Integer ID, Integer amount);

    List<JSONObject> statBookByTime(String begin, String end);

    List<JSONObject> statBookByTimeUser(String begin, String end, Integer ID);
}
