package com.retell.retellbackend.dao;

import com.retell.retellbackend.domain.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    @Query(value = "select * from comments where book_id = (:book_id)", nativeQuery = true)
    public List<Comment> getComments(@Param("book_id") Integer book_id);

}
