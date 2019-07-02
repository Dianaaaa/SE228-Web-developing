package com.retell.retellbackend.repository;

import com.retell.retellbackend.entity.CommentM;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentMRepository extends MongoRepository<CommentM, Integer> {
    public List<CommentM> findByBook(Integer book_id);
}
