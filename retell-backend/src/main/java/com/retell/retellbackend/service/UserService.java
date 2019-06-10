package com.retell.retellbackend.service;


import com.retell.retellbackend.entity.UserEntity;

import java.util.List;

public interface UserService {
    Boolean checkUserName(String username);

    List getAllUser();

    void createUser(UserEntity user);

    UserEntity getUserByName(String name);

    Integer getIDByName(String username);

    void banUser(String username);

    void rebanUser(String username);

}
