package com.retell.retellbackend.serviceimpl;

import com.retell.retellbackend.entity.CommentM;
import com.retell.retellbackend.repository.BookRepository;
import com.retell.retellbackend.repository.CommentMRepository;
import com.retell.retellbackend.repository.CommentRepository;
import com.retell.retellbackend.repository.UserRepository;
import com.retell.retellbackend.entity.Book;
import com.retell.retellbackend.entity.Comment;
import com.retell.retellbackend.entity.UserEntity;
import com.retell.retellbackend.service.CommentService;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
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
