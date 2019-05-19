package com.retell.retellbackend.service;

import com.retell.retellbackend.entity.Book;
import java.util.List;


public interface BookService {
    Book getBookByID(Integer ID);

    void createBook(Book book);

    List getBookCarousel();

    List getBookByCateIDLimited(Integer ID);

    List getBookByCateID(Integer ID);

    List getAllBook();

    List bookDump(List<Book> books);
}
