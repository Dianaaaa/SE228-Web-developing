package com.retell.retellbackend.dao;

import com.retell.retellbackend.domain.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query(value = "select * from users where username = (:username)", nativeQuery = true)
    public UserEntity getUser(@Param("username")String username);

    @Query(value = "select * from users where id = (:id)", nativeQuery = true)
    public UserEntity getUserByID(@Param("id")Integer id);

    @Query(value = "select id from users where username = (:username)", nativeQuery = true)
    public Integer getIDByName(@Param("username")String username);
}
