package com.retell.retellbackend.service;

import java.util.List;

public interface CommentMService {
    List getBookCommentM(Integer bookID);

    void addCommentM(Integer userID, Integer bookID, Integer score, String content);
}
