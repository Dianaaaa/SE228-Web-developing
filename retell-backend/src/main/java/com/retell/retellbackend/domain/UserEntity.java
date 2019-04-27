package com.retell.retellbackend.domain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserEntity {
    private Integer ID;
    private String username;
    private String password;
    private String email;
    private String role;
    private Integer status;

    public UserEntity(){}

    public UserEntity(Integer ID, String username, String password, String email, String role, Integer status) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.status = status;
    }


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
