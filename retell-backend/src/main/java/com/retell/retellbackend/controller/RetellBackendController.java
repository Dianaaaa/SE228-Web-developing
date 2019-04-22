package com.retell.retellbackend.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.retell.retellbackend.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

import com.retell.retellbackend.service.BookService;

import java.io.IOException;

@RestController
public class RetellBackendController {

    @Autowired
    public BookService service;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value="/book", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getBook(){
        Book curBook = service.getBookByID(1);
        JSONObject book = new JSONObject();
        book.put("book-name", curBook.getName());
        book.put("author", curBook.getAuthor());
        book.put("prev-cost", curBook.getPrevCost());
        book.put("cur-cost", curBook.getCurCost());
        book.put("book-detail", curBook.getBookDetail());
        book.put("author-detail", curBook.getAuthorDetail());
        book.put("img-url", curBook.getFrontpage());
        return book.toJSONString();
    }


}
