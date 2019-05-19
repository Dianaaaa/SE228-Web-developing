package com.retell.retellbackend.service;
import java.util.List;

public interface CartService {
    List  getCartByUser(Integer userID);

    void addToCart(Integer userID, Integer bookID, Integer amount);

    void deleteCart(Integer ID);

    Boolean updateAmmount(Integer userID, Integer bookID, Integer amount);
}
