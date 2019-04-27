package com.retell.retellbackend.controller;

import com.retell.retellbackend.domain.UserEntity;
import com.retell.retellbackend.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    public UserService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value="/signin", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String signIn(@RequestBody UserEntity user){
        JSONObject result = new JSONObject();
        Boolean check = service.checkUserName(user.getUsername());
        if (!check) {
            result.put("status", 400);
            result.put("msg", "Username used already");
            return result.toJSONString();
        }
//        JSONObject userinfo = new JSONObject();
//        userinfo.put("username", user.getUsername());
//        userinfo.put("password", user.getPassword());
//        userinfo.put("email", user.getEmail());
        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        user.setPassword(password);
        service.createUser(user);
        result.put("status", 200);
        result.put("msg", "User created");
        return result.toJSONString();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value="/login", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
        public String Login(@RequestBody UserEntity user){
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", "User created");
        return result.toJSONString();
    }
}
