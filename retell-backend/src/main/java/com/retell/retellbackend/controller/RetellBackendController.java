package com.retell.retellbackend.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.retell.retellbackend.domain.Book;
import com.retell.retellbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

import com.retell.retellbackend.service.BookService;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RetellBackendController {

    @Autowired
    public CategoryService service;

//    @CrossOrigin(origins = "http://localhost:3000")
//    @ResponseBody
//    @RequestMapping(value="/book/{ID}", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
//    public String getBook(@PathVariable Integer ID){
//        Book curBook = service.getBookByID(ID);
//        if (curBook == null) {
//            return "no such bool";
//        }
//        JSONObject book = new JSONObject();
//        book.put("book-name", curBook.getName());
//        book.put("author", curBook.getAuthor());
//        book.put("prev-cost", curBook.getPrevCost());
//        book.put("cur-cost", curBook.getCurCost());
//        book.put("book-detail", curBook.getBookDetail());
//        book.put("author-detail", curBook.getAuthorDetail());
//        book.put("img-url", curBook.getFrontpage());
//        return book.toJSONString();
//    }

    @RequestMapping(value="/cate", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getCate(){
        List cates = service.getCategory();
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", "OK");
        result.put("cate", cates);
        return result.toJSONString();
    }


}
