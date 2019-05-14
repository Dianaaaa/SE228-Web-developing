package com.retell.retellbackend.dao;

import com.retell.retellbackend.domain.Cart;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Long> {

    @Query(value = "SELECT * FROM carts WHERE user_id = (:id)", nativeQuery = true)
    public Cart getCartByUser(@Param("id") Integer id);
}
