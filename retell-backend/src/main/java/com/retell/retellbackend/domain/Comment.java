package com.retell.retellbackend.domain;

import java.sql.Timestamp;

public class Comment {
    private Integer ID;
    private String content;
    private Timestamp time;
    private Integer score;
    private Integer userID;
    private Integer bookID;

    public Comment() {}

    public Comment(Integer ID, String content, Timestamp time, Integer score, Integer userID, Integer bookID) {
        this.ID = ID;
        this.content = content;
        this.time = time;
        this.score = score;
        this.userID = userID;
        this.bookID = bookID;
    }

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
}
