package com.retell.retellbackend.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Deal {
    private Integer ID;
    private Integer userID;
    private String phone;
    private String address;
    private Timestamp time;
    private BigDecimal total_price;

    public Deal () {}

    public Deal (Integer ID, Integer userID, String phone, String address, Timestamp time, BigDecimal total_price) {
        this.ID = ID;
        this.userID = userID;
        this.phone = phone;
        this.address = address;
        this.time = time;
        this.total_price = total_price;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }
}
