package com.retell.retellbackend.entity;

import javax.persistence.*;

import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="users")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @Column(name="username", unique=true)
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    @Column(name="role")
    private String role;
    @Column(name="status")
    private Integer status;

    public UserEntity(){}

//    public UserEntity(Integer ID, String username, String password, String email, String role, Integer status) {
//        this.ID = ID;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.role = role;
//        this.status = status;
//    }


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
