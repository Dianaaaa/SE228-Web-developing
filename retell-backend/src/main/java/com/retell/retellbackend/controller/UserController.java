package com.retell.retellbackend.controller;

import com.retell.retellbackend.entity.UserEntity;
import com.retell.retellbackend.serviceimpl.UserServiceImpl;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    public UserServiceImpl service;

    @CrossOrigin(origins = "http://localhost:3000")
    @ResponseBody
    @RequestMapping(value="/signin", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject signIn(@RequestBody UserEntity user){
        JSONObject result = new JSONObject();
        Boolean check = service.checkUserName(user.getUsername());
        if (!check) {
            result.put("status", 400);
            result.put("msg", "Username used already");
            return result;
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
        return result;
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @ResponseBody
//    @RequestMapping(value="/login", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
//        public String Login(@RequestBody UserEntity user){
//        JSONObject result = new JSONObject();
//        result.put("status", 200);
//        result.put("msg", "User created");
//        return result.toJSONString();
//    }
@RequestMapping(value="/getname", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
public JSONObject getUserName(Principal principal){
    String username = principal.getName();
    JSONObject result = new JSONObject();
    result.put("status", 200);
    result.put("name", username);
    return result;
}

}
