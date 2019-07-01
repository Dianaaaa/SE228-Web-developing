package com.retell.retellbackend.repository;

import com.retell.retellbackend.entity.Deal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DealRepository extends CrudRepository<Deal, Long> {
    @Query(value = "SELECT * From deals WHERE user_id = (:user_id)", nativeQuery = true)
    public List<Deal> getDeals(@Param("user_id") Integer user_id);

    @Query(value = "SELECT * FROM deals", nativeQuery = true)
    public List<Deal> getAllDeals();

}

