package com.retell.retellbackend.service;


import com.retell.retellbackend.entity.UserEntity;

public interface UserService {
    Boolean checkUserName(String username);

    void createUser(UserEntity user);

    UserEntity getUserByName(String name);

    Integer getIDByName(String username);
}
