package com.retell.retellbackend.repository;

import com.retell.retellbackend.entity.Deal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface DealRepository extends CrudRepository<Deal, Long> {
    @Query(value = "SELECT * From deals WHERE user_id = (:user_id)", nativeQuery = true)
    public List<Deal> getDeals(@Param("user_id") Integer user_id);

    @Query(value = "SELECT * FROM deals", nativeQuery = true)
    public List<Deal> getAllDeals();

    @Query(value = "SELECT * From deals where time < (:endtime) and time > (:begintime)", nativeQuery = true)
    public List<Deal> getDealsByTime(@Param("endtime") String endtime, @Param("begintime")String begintime);

    @Query(value = "SELECT * From deals where time < (:endtime) and time > (:begintime) and user_id = (:id)", nativeQuery = true)
    public List<Deal> getDealsByTimeUser(@Param("endtime") String endtime, @Param("begintime")String begintime, @Param("id")Integer id);

}

