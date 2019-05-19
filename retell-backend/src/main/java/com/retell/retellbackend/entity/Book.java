package com.retell.retellbackend.entity;

import javax.persistence.*;
import java.math.BigDecimal;

import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer ID;
    @Column(name="name", nullable = false, length = 128)
    private String name;
    @Column(name="author",  nullable = false, length = 128)
    private String author;
    @Column(name="ISBN",  nullable = false, length = 128)
    private String ISBN;
    @Column(name="stock",  nullable = false)
    private Integer stock;
    @Column(name="front_page", length = 128)
    private String frontpage;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cate_id", referencedColumnName = "id")
    private Category category;
    @Column(name="cur_cost",  nullable = false)
    private BigDecimal curCost;
    @Column(name="prev_cost",  nullable = false)
    private BigDecimal prevCost;
    @Column(name="book_detail", columnDefinition="text")
    private String bookDetail;
    @Column(name="author_detail", columnDefinition="text")
    private String authorDetail;

    public Book() { }

//    public Book(Integer ID, String name, String author, String ISBN, Integer stock, String frontpage, Integer category) {
//        this.ID = ID;
//        this.name = name;
//        this.author = author;
//        this.ISBN = ISBN;
//        this.stock = stock;
//        this.frontpage = frontpage;
//        this.category = category;
//    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getCurCost() {return this.curCost;}
    public void setCurCost(BigDecimal curCost) {this.curCost=curCost;}
    public BigDecimal getPrevCost() {return this.prevCost;}
    public void setPrevCost(BigDecimal prevCost) {this.prevCost = prevCost;}
    public String getBookDetail() {return this.bookDetail;}
    public void setBookDetail(String bookDetail) {this.bookDetail = bookDetail;}
    public String getAuthorDetail() {return this.authorDetail;}
    public void setAuthorDetail(String authorDetail) {this.authorDetail = authorDetail;}
}
