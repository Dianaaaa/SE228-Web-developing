package com.retell.retellbackend.repository;

import com.retell.retellbackend.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    @Query(value = "select * from categories", nativeQuery = true)
    public List<Category> getCate();

    @Query(value = "select id from categories where name = (:name)", nativeQuery = true)
    public Integer getCateByName(@Param("name") String name);

    @Query(value = "select * from categories where id = (:id)", nativeQuery = true)
    public Category getCateByID(@Param("id") Integer id);
}
