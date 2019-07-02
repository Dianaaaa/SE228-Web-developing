package com.retell.retellbackend.entity;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.Date;

public class CommentM {
    @Id
    public String id;

    public String content;
    public Integer user;
    public Integer book;
    public Integer score;
    public Date time;

    public CommentM() {}

    public CommentM(String id, String content, Integer user_id, Integer book_id, Integer score, Date time) {
        this.id = id;
        this.content = content;
        this.user = user_id;
        this.book = book_id;
        this.score = score;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUser_id() {
        return user;
    }

    public void setUser_id(Integer user_id) {
        this.user = user_id;
    }

    public Integer getBook_id() {
        return book;
    }

    public void setBook_id(Integer book_id) {
        this.book = book_id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format(
                "{id:'%d', content:'%s', user_id:'%d', book_id:'%d', score:'%d', time:'%s'}",
                id, content, user, book, score, time.toString());
    }

}
