package com.retell.retellbackend.domain;

public class Deal_Book {
    private Integer ID;
    private Integer bookID;
    private Integer ammount;
    private Integer dealID;

    public Deal_Book() {}

    public Deal_Book(Integer ID, Integer bookID, Integer ammount, Integer dealID) {
        this.ID = ID;
        this.bookID = bookID;
        this.ammount = ammount;
        this.dealID = dealID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public Integer getDealID() {
        return dealID;
    }

    public void setDealID(Integer dealID) {
        this.dealID = dealID;
    }
}
