package com.retell.retellbackend.service;


import com.retell.retellbackend.repository.*;
import com.retell.retellbackend.entity.*;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface DealService {

    Boolean createDealByUserID(String phone, String address, String receiver,  BigDecimal total_price, Integer userID);

    void createDealOneBook(String phone, String address, String receiver,BigDecimal total_price, Integer bookID, Integer amount, Integer userID);

    List  getDealByUser(Integer userID);
}
