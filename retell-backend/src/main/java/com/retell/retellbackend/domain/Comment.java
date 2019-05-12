package com.retell.retellbackend.domain;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer ID;
    @Column(name="content", nullable = false, columnDefinition="text")
    private String content;
    @Column(name="time", nullable = false)
    private Timestamp time;
    @Column(name="score", nullable = false)
    private Integer score;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public Comment() {}

//    public Comment(Integer ID, String content, Timestamp time, Integer score, UserEntity user, Book book) {
//        this.ID = ID;
//        this.content = content;
//        this.time = time;
//        this.score = score;
//        this.user = user;
//        this.book = book;
//    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
