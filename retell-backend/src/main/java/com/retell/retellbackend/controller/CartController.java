package com.retell.retellbackend.controller;

import com.retell.retellbackend.service.CartService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CartController {
    @Autowired
    public CartService service;


    @RequestMapping(value="/cart", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getCart(){
        List items = service.getCartByUser(1);
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", "OK");
        result.put("items", items);
        return result.toString();
    }

    @RequestMapping(value="/cart/{userID}/{bookID}/{ammount}", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String changeAmmount(@PathVariable Integer userID, @PathVariable Integer bookID, @PathVariable Integer ammount){
        Boolean result = service.updateAmmount(userID, bookID, ammount);
        JSONObject res = new JSONObject();
        res.put("status", 200);
        res.put("msg", "OK");
        res.put("result", result);
        return res.toString();
    }

    @RequestMapping(value="/cart/add/{bookID}/{ammount}", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String changeAmmount(@PathVariable Integer bookID, @PathVariable Integer ammount){
        service.addToCart(1, bookID, ammount);
        JSONObject res = new JSONObject();
        res.put("status", 200);
        res.put("msg", "OK");
        return res.toString();
    }

    @RequestMapping(value="/cart/delete/{cartID}", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String deleteCart(@PathVariable Integer cartID){
        service.deleteCart(cartID);
        JSONObject res = new JSONObject();
        res.put("status", 200);
        res.put("msg", "OK");
        return res.toString();
    }
}
