package com.retell.retellbackend.controller;


import com.retell.retellbackend.service.DealService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DealController {

    @Autowired
    public DealService service;

    @RequestMapping(value="/deal/create", method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String createDeal(@RequestBody JSONObject s){
        String phone = (String) s.get("phone");
        String address = (String) s.get("address");
        BigDecimal total_price = BigDecimal.valueOf(Double.valueOf(s.get("tot_price").toString()));
        Boolean flag = service.createDealByUserID(phone, address, total_price,1);
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
        return result.toJSONString();
    }
}
