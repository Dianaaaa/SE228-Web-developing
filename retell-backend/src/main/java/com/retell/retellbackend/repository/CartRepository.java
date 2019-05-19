package com.retell.retellbackend.repository;

import com.retell.retellbackend.entity.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends CrudRepository<Cart, Long> {

    @Query(value = "SELECT * FROM carts WHERE user_id = (:id)", nativeQuery = true)
    public Cart getCartByUser(@Param("id") Integer id);
}
