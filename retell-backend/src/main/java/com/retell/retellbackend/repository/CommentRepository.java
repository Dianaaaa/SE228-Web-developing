package com.retell.retellbackend.repository;

import com.retell.retellbackend.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    @Query(value = "select * from comments where book_id = (:book_id)", nativeQuery = true)
    public List<Comment> getComments(@Param("book_id") Integer book_id);

}
