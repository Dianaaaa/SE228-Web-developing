package com.retell.retellbackend.controller;


import com.retell.retellbackend.serviceimpl.DealServiceImpl;
import com.retell.retellbackend.serviceimpl.UserServiceImpl;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DealController {

    @Autowired
    public DealServiceImpl service;

    @Autowired
    public UserServiceImpl userService;

    @RequestMapping(value="/deal/create", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject createDeal(@RequestBody JSONObject s, Principal principal){
        String username = principal.getName();
        Integer userID = userService.getIDByName(username);
        String phone = (String) s.get("phone");
        String address = (String) s.get("address");
        String receiver = (String) s.get("receiver");
        BigDecimal total_price = BigDecimal.valueOf(Double.valueOf(s.get("tot_price").toString()));
        Boolean flag = service.createDealByUserID(phone, address, receiver, total_price,userID);
        JSONObject result = new JSONObject();
        System.out.print(flag);
        if (flag == true) {
            System.out.print("ok");
            result.put("status", 200);
            result.put("msg", "ok");
        } else {
            System.out.print("not ok");
            result.put("status", 400);
            result.put("msg", "You shopping cart is empty");
        }
        return result;
    }

    @RequestMapping(value="/deal/create/{bookID}/{ammount}", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject createDealOneBook(@RequestBody JSONObject s,@PathVariable Integer bookID, @PathVariable Integer ammount, Principal principal){
        String username = principal.getName();
        Integer userID = userService.getIDByName(username);

        String phone = (String) s.get("phone");
        String address = (String) s.get("address");
        String receiver = (String) s.get("receiver");
        BigDecimal total_price = BigDecimal.valueOf(Double.valueOf(s.get("tot_price").toString()));

        service.createDealOneBook(phone, address, receiver, total_price,bookID, ammount, userID);
        JSONObject result = new JSONObject();
        System.out.print("ok");
        result.put("status", 200);
        result.put("msg", "ok");
        return result;
    }

    @RequestMapping(value="/deal", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JSONObject getCart(Principal principal){
        String username = principal.getName();
        Integer userID = userService.getIDByName(username);

        List deals = service.getDealByUser(userID);
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", "OK");
        result.put("dealitems", deals);
        return result;
    }
}
