package com.retell.retellbackend.controller;


import com.retell.retellbackend.domain.Book;
import com.retell.retellbackend.service.BookService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookController {

    @Autowired
    public BookService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value="/book/{ID}", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JSONObject getBook(@PathVariable Integer ID){
        Book curBook = service.getBookByID(ID);
        if (curBook == null) {
            return null;
        }
        JSONObject book = new JSONObject();
        book.put("book-name", curBook.getName());
        book.put("author", curBook.getAuthor());
        book.put("prev-cost", curBook.getPrevCost());
        book.put("cur-cost", curBook.getCurCost());
        book.put("book-detail", curBook.getBookDetail());
        book.put("author-detail", curBook.getAuthorDetail());
        book.put("img-url", curBook.getFrontpage());
        book.put("id", curBook.getID());
        book.put("stock", curBook.getStock());
        return book;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value="/book/carousel", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JSONObject getBookCar(){
        List<Map<String, Object>> books = service.getBookCarousel();
        if (books.size() == 0) {
            return null;
        }
        JSONObject response = new JSONObject();
        List objects = service.bookDump(books);
        response.put("status", 201);
        response.put("msg", "OK");
        response.put("books", objects);
        return response;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value="/book/cate/limit/{ID}", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JSONObject getBookByCateLimit(@PathVariable Integer ID){
        List<Map<String, Object>> books = service.getBookByCateIDLimited(ID);

        List objects = service.bookDump(books);
        JSONObject response = new JSONObject();

        response.put("status", 200);
        response.put("msg", "OK");
        response.put("books", objects);
        return response;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value="/book/cate/{ID}", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JSONObject getBookByCate(@PathVariable Integer ID){
        List objects;
        if (ID == 10086) {
            List<Map<String, Object>> books = service.getAllBook();
            objects = service.bookDump(books);
        } else {
            List<Map<String, Object>> books = service.getBookByCateID(ID);
            objects = service.bookDump(books);
        }

        JSONObject response = new JSONObject();

        response.put("books", objects);
        response.put("status", 200);
        response.put("msg", "OK");
        return response;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value="/book/create", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject getBook(HttpServletRequest request, @RequestBody JSONObject s){
        BigDecimal curCost = BigDecimal.valueOf((Double) s.get("cur_cost"));
        BigDecimal prevCost = BigDecimal.valueOf((Double) s.get("prev_cost"));
        Book book = new Book();
        book.setName((String) s.get("name"));
        book.setAuthor((String) s.get("author"));
        book.setBookDetail((String) s.get("book_detail"));
        book.setAuthorDetail((String) s.get("author_detail"));
        book.setStock((Integer) s.get("stock"));
        book.setCurCost(curCost);
        book.setPrevCost(prevCost);
//        book.setCategory((Integer) s.get("category"));
        book.setFrontpage((String) s.get("front_page"));
        book.setISBN((String) s.get("ISBN"));

        JSONObject result = new JSONObject();
//        service.createBook(book);

        result.put("status", 200);
        result.put("msg", s);

        return result;
    }

    @RequestMapping(value="/msg", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String msg(){
        return "hello world";
    }

}
