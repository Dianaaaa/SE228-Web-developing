package com.retell.retellbackend.domain;

public class User {
    private Integer ID;
    private String name;
    private String password;
    private String email;
    private Integer role;

    public User(){}

    public User(Integer ID, String name, String password, String email, Integer role) {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
