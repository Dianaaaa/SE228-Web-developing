package com.retell.retellbackend.service;

import java.util.List;

public interface CommentService {
    List getBookComment(Integer bookID);

    void addComment(Integer userID, Integer bookID, Integer score, String content);
}
