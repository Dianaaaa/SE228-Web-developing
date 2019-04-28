package com.retell.retellbackend.controller;

import com.retell.retellbackend.service.CommentService;
import com.retell.retellbackend.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CommentController {
    @Autowired
    public CommentService service;

    @Autowired
    public UserService userService;


    @RequestMapping(value="/comment/{bookID}", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getCate(@PathVariable Integer bookID){
        List comments = service.getBookComment(bookID);
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", "OK");
        result.put("comments", comments);
        return result.toJSONString();
    }

    @RequestMapping(value="/addcomment", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addComment(@RequestBody JSONObject s, Principal principal){
        Integer bookID = Integer.valueOf((String)s.get("bookID"));
        Integer score = (Integer) s.get("score");
        String content = (String) s.get("content");
        String username = principal.getName();
        Integer userID = userService.getIDByName(username);
        service.addComment(userID, bookID, score, content);
//
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", "OK");
        return result.toJSONString();
    }
}
