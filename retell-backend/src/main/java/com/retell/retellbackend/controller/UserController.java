package com.retell.retellbackend.controller;

import com.retell.retellbackend.entity.UserEntity;
import com.retell.retellbackend.service.UserService;
import com.retell.retellbackend.serviceimpl.UserServiceImpl;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    public UserService service;

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
        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        user.setPassword(password);
        user.setRole("USER");
        user.setStatus(1);
        user.setAvator("http://localhost:8080/resources/avator3.jpg");
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

    @RequestMapping(value="/checkadmin", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JSONObject checkAdmin(Principal principal){
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("flag", 1);
        return result;
    }

    @RequestMapping(value="/user/all", method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JSONObject getAllUsers(){
        List<UserEntity> all = service.getAllUser();

        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("users", all);
        return result;
    }

    @RequestMapping(value="/user/ban/{username}", method=RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject banUser(@PathVariable String username){
        service.banUser(username);

        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", "ok");
        return result;
    }

    @RequestMapping(value="/user/reban/{username}", method=RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject rebanUser(@PathVariable String username){
        service.rebanUser(username);

        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", "ok");
        return result;
    }

    @ResponseBody
    @RequestMapping(value="/statuser/{begin}/{end}", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JSONObject stateUser(@PathVariable String begin,@PathVariable String end){
        List<JSONObject> objects = service.statUserByTime(begin, end);
        System.out.println(objects);
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", "ok");
        result.put("stat", objects);

        return result;
    }

    @ResponseBody
    @RequestMapping(value="/mystat/{begin}/{end}", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JSONObject myState(@PathVariable String begin,@PathVariable String end, Principal principal){
        String username = principal.getName();
        Integer userID = service.getIDByName(username);

        BigDecimal cost = service.statUserByTimeUser(begin, end, userID);
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", "ok");
        result.put("cost", cost);

        return result;
    }

}
