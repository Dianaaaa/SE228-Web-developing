package com.retell.retellbackend.serviceimpl;

import com.retell.retellbackend.entity.CommentM;
import com.retell.retellbackend.entity.UserEntity;
import com.retell.retellbackend.repository.CommentMRepository;
import com.retell.retellbackend.repository.UserRepository;
import com.retell.retellbackend.service.CommentMService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CommentMServiceImpl implements CommentMService {

    @Autowired
    private CommentMRepository cmmRepository;

    @Autowired
    private UserRepository userRepository;

    public List getBookCommentM(Integer bookID){
        List<CommentM> comments = cmmRepository.findByBook(bookID);
        List objects = new ArrayList();
        for (int i = 0; i < comments.size(); i++) {
            JSONObject result = new JSONObject();
            CommentM comment = comments.get(i);
            result.put("content", comment.getContent());
            result.put("time", comment.getTime().toString());
            result.put("score", comment.getScore());
            result.put("ID", comment.getId());

            Integer user_id = comment.getUser_id();
            UserEntity user = userRepository.getUserByID(user_id);

            result.put("userID", user.getID());
            result.put("username", user.getUsername());

            System.out.print(result);

            objects.add(result);
        }
        return objects;
    }

    public void addCommentM(Integer userID, Integer bookID, Integer score, String content){
        Date d = new Date();
        UUID uuid = UUID.randomUUID();
        CommentM newComm = new CommentM(uuid.toString(), content, userID, bookID, score, d);
        cmmRepository.save(newComm);
    }
}
