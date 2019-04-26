package com.retell.retellbackend.controller;

import com.retell.retellbackend.service.CommentService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CommentController {
    @Autowired
    public CommentService service;


    @RequestMapping(value="/comment/{bookID}", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getCate(@PathVariable Integer bookID){
        List comments = service.getBookComment(bookID);
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", "OK");
        result.put("comments", comments);
        return result.toJSONString();
    }
}
