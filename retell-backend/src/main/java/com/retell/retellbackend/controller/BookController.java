package com.retell.retellbackend.controller;


import com.retell.retellbackend.domain.Book;
import com.retell.retellbackend.domain.User;
import com.retell.retellbackend.service.BookService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookController {

    @Autowired
    public BookService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value="/book/{ID}", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getBook(@PathVariable Integer ID){
        Book curBook = service.getBookByID(ID);
        if (curBook == null) {
            return "no such bool";
        }
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


    //待修理
    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value="/book/create", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getBook(@RequestBody Book book){
        JSONObject book_detail = new JSONObject();
        book_detail.put("name", book.getName());
        book_detail.put("author", book.getAuthor());
        book_detail.put("bookDetail", book.getBookDetail());
        book_detail.put("authorDetail", book.getAuthorDetail());
        book_detail.put("stock", book.getStock());
        book_detail.put("cur_cost", book.getCurCost());
        book_detail.put("prev_cost", book.getPrevCost());
        book_detail.put("category", book.getCategory());
        book_detail.put("front-page", book.getFrontpage());
        JSONObject result = new JSONObject();
//        service.createBook(book);

        result.put("status", 200);
        result.put("msg", "User created");

        return book_detail.toJSONString();
    }

    @RequestMapping(value="/msg", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String msg(){
        return "hello world";
    }

}
