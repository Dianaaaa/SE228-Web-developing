package com.retell.retellbackend.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.retell.retellbackend.domain.Book;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query(value = "select * from books where id = (:id)", nativeQuery = true)
    public Book getBook(@Param("id")Integer id);

    @Query(value = "SELECT * FROM books limit 16", nativeQuery = true)
    public List<Book> getBookCarousel();

    @Query(value = "SELECT * FROM books WHERE cate_id = (:cate_id) limit 8", nativeQuery = true)
    public List<Book> getBookByCateLimit(@Param("cate_id")Integer cate_id);

    @Query(value = "SELECT * FROM books WHERE cate_id = (:cate_id)", nativeQuery = true)
    public List<Book> getBookByCate(@Param("cate_id")Integer cate_id);

    @Query(value = "SELECT * FROM books", nativeQuery = true)
    public List<Book> getBookAll();
}
