package com.retell.retellbackend.repository;

import com.retell.retellbackend.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query(value = "select * from users where username = (:username)", nativeQuery = true)
    public UserEntity getUserByName(@Param("username")String username);

    @Query(value = "select * from users where id = (:id)", nativeQuery = true)
    public UserEntity getUserByID(@Param("id")Integer id);

    @Query(value = "select id from users where username = (:username)", nativeQuery = true)
    public Integer getIDByName(@Param("username")String username);

    @Query(value = "select * from users", nativeQuery = true)
    public List<UserEntity> getAllUsers();

    @Transactional
    @Modifying
    @Query(value = "update users SET status = 0 where username = (:username)", nativeQuery = true)
    void banUser(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "update users SET status = 1 where username = (:username)", nativeQuery = true)
    void rebanUser(@Param("username") String username);
}
