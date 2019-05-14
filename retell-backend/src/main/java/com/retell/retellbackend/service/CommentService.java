package com.retell.retellbackend.service;

import com.retell.retellbackend.dao.BookRepository;
import com.retell.retellbackend.dao.CommentRepository;
import com.retell.retellbackend.dao.UserRepository;
import com.retell.retellbackend.domain.Book;
import com.retell.retellbackend.domain.Comment;
import com.retell.retellbackend.domain.UserEntity;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    @Resource
    private CommentRepository commRepository;

    @Resource
    private BookRepository bookRepository;

    @Resource
    private UserRepository userRepository;

    public List getBookComment(Integer bookID) {
        List<Comment> comments = commRepository.getComments(bookID);
        List objects = new ArrayList();
        for (int i = 0; i < comments.size(); i++) {
//            System.out.print(comments.get(i));
            JSONObject result = new JSONObject();
            result.put("content", comments.get(i).getContent());
            result.put("time", comments.get(i).getTime().toString());
            result.put("score", comments.get(i).getScore());
            result.put("ID", comments.get(i).getID());
            UserEntity user = comments.get(i).getUser();
            result.put("userID", user.getID());
            result.put("username", user.getUsername());

            System.out.print(result);

            objects.add(result);
        }
        return objects;
    }

    public void addComment(Integer userID, Integer bookID, Integer score, String content) {
//        String sql = "INSERT INTO comment(userID, bookID, score, content) VALUES (" + userID.toString() + "," + bookID.toString() + "," + score.toString() + ",\"" + content + "\")";
//        jdbc.execute(sql);
        Book newBook = bookRepository.getBook(bookID);
        UserEntity newUser = userRepository.getUserByID(userID);
        Comment newComm = new Comment();
        newComm.setBook(newBook);
        newComm.setUser(newUser);
        newComm.setScore(score);
        newComm.setContent(content);
        Timestamp d = new Timestamp(System.currentTimeMillis());
        newComm.setTime(d);
        commRepository.save(newComm);

        return;
    }
}
