package com.retell.retellbackend.domain;

public class Cart {
    private Integer ID;
    private Integer userID;
    private Integer bookID;
    private Integer ammount;

    public Cart() {}

    public Cart(Integer ID, Integer userID, Integer bookID, Integer ammount) {
        this.ID = ID;
        this.userID = userID;
        this.bookID = bookID;
        this.ammount = ammount;
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

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }
}
