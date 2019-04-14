package com.retell.retellbackend.domain;

public class Book {
    private Integer ID;
    private String name;
    private String author;
    private String ISBN;
    private Integer stock;
    private String frontpage;
    private String category;
    private String curCost;
    private String prevCost;
    private String bookDetail;
    private String authorDetail;

    public Book() { }

    public Book(Integer ID, String name, String author, String ISBN, Integer stock, String frontpage, String category) {
        this.ID = ID;
        this.name = name;
        this.author = author;
        this.ISBN = ISBN;
        this.stock = stock;
        this.frontpage = frontpage;
        this.category = category;
    }

    public Integer getID(){return  this.ID; }
    public void setID(Integer ID) {this.ID = ID; }
    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}
    public String getAuthor() {return this.author;}
    public void setAuthor(String author) {this.author=author;}
    public String getISBN() {return this.ISBN;}
    public void setISBN(String ISBN) {this.ISBN = ISBN;}
    public Integer getStock() {return this.stock;}
    public void setStock(Integer stock) {this.stock=stock;}
    public String getFrontpage() {return this.frontpage;}
    public void setFrontpage(String frontpage) {this.frontpage = frontpage;}
    public String getCategory() {return this.category;}
    public void setCategory(String category) {this.category=category;}
    public String getCurCost() {return this.curCost;}
    public void setCurCost(String curCost) {this.curCost=curCost;}
    public String getPrevCost() {return this.prevCost;}
    public void setPrevCost(String prevCost) {this.prevCost = prevCost;}
    public String getBookDetail() {return this.bookDetail;}
    public void setBookDetail(String bookDetail) {this.bookDetail = bookDetail;}
    public String getAuthorDetail() {return this.authorDetail;}
    public void setAuthorDetail(String authorDetail) {this.authorDetail = authorDetail;}
}
