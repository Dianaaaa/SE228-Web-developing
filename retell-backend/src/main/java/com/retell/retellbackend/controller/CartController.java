package com.retell.retellbackend.controller;

import java.security.Principal;
import com.retell.retellbackend.service.CartService;
import com.retell.retellbackend.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CartController {
    @Autowired
    public CartService service;

    @Autowired
    public UserService userService;


    @RequestMapping(value="/cart", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getCart(Principal principal){
        String username = principal.getName();
        Integer userID = userService.getIDByName(username);
        List items = service.getCartByUser(userID);
        JSONObject result = new JSONObject();
        result.put("status", 200);
        result.put("msg", "OK");
        result.put("items", items);
        return result.toString();
    }

    @RequestMapping(value="/cart/{bookID}/{ammount}", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String changeAmmount(@PathVariable Integer bookID, @PathVariable Integer ammount, Principal principal){
        String username = principal.getName();
        Integer userID = userService.getIDByName(username);

        Boolean result = service.updateAmmount(userID, bookID, ammount);
        JSONObject res = new JSONObject();
        res.put("status", 200);
        res.put("msg", "OK");
        res.put("result", result);
        return res.toString();
    }

    @RequestMapping(value="/cart/add/{bookID}/{ammount}", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addBookToCart(@PathVariable Integer bookID, @PathVariable Integer ammount, Principal principal){
        String username = principal.getName();
        Integer userID = userService.getIDByName(username);

        service.addToCart(userID, bookID, ammount);
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
