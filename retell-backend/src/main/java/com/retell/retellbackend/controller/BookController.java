package com.retell.retellbackend.controller;


import com.retell.retellbackend.entity.Book;
import com.retell.retellbackend.entity.Category;
import com.retell.retellbackend.service.BookService;
import com.retell.retellbackend.service.CategoryService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookController {

    @Autowired
    public BookService service;

    @Autowired
    private CategoryService cateservice;

    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value="/book/{ID}", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JSONObject getBook(@PathVariable Integer ID){
        Book curBook = service.getBookByID(ID);
        Category cate = curBook.getCategory();
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
        book.put("ISBN", curBook.getISBN());
        book.put("cate", cate.getID());
        return book;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value="/book/carousel", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JSONObject getBookCar(){
//        List<Map<String, Object>> books = service.getBookCarousel();
        List<Book> books = service.getBookCarousel();
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
//        List<Map<String, Object>> books = service.getBookByCateIDLimited(ID);
        List<Book> books = service.getBookByCateIDLimited(ID);
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
//            List<Map<String, Object>> books = service.getAllBook();
            List<Book> books = service.getAllBook();
            objects = service.bookDump(books);
        } else {
//            List<Map<String, Object>> books = service.getBookByCateID(ID);
            List<Book> books = service.getBookByCateID(ID);
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
    @RequestMapping(value="/createbook", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject newBook(HttpServletRequest request, @RequestBody JSONObject s){
        BigDecimal curCost = BigDecimal.valueOf(Double.valueOf(s.get("cur_cost").toString()));
        BigDecimal prevCost = BigDecimal.valueOf(Double.valueOf(s.get("prev_cost").toString()));
        Book book = new Book();
        book.setName((String) s.get("name"));
        book.setAuthor((String) s.get("author"));
        book.setBookDetail((String) s.get("book_detail"));
        book.setAuthorDetail((String) s.get("author_detail"));
        book.setStock(Integer.valueOf(s.get("stock").toString()));
        book.setCurCost(curCost);
        book.setPrevCost(prevCost);
        Category cate = cateservice.getCateByID(Integer.valueOf(s.get("cate").toString()));
        book.setCategory(cate);
//        book.setFrontpage((String) s.get("front_page"));
        book.setFrontpage("http://localhost:8080/resources/ml.jpg");
        book.setISBN((String) s.get("ISBN"));

        JSONObject result = new JSONObject();
        service.createBook(book);

        result.put("status", 200);
        result.put("msg", s);

        return result;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value="/updatebook/{ID}", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject updateBook(HttpServletRequest request, @RequestBody JSONObject s, @PathVariable Integer ID){
        Book curBook = service.getBookByID(ID);
        Category cate = cateservice.getCateByID(Integer.valueOf(s.get("cate").toString()));
        BigDecimal curCost = BigDecimal.valueOf(Double.valueOf(s.get("cur_cost").toString()));
        BigDecimal prevCost = BigDecimal.valueOf(Double.valueOf(s.get("prev_cost").toString()));
        curBook.setName((String) s.get("name"));
        curBook.setAuthor((String) s.get("author"));
        curBook.setBookDetail((String) s.get("book_detail"));
        curBook.setAuthorDetail((String) s.get("author_detail"));
        curBook.setStock(Integer.valueOf(s.get("stock").toString()));
        curBook.setCurCost(curCost);
        curBook.setPrevCost(prevCost);
        curBook.setCategory(cate);
        curBook.setISBN((String) s.get("ISBN"));
        service.saveBook(curBook);
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", s);

        return result;
    }

}
