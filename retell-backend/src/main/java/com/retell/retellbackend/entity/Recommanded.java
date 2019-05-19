package com.retell.retellbackend.entity;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Recommanded {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer ID;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public Recommanded() {}

    public Recommanded(Integer ID, Book book) {
        this.ID = ID;
        this.book = book;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
