package com.retell.retellbackend.dao;

import com.retell.retellbackend.domain.CartItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    @Query(value = "delete from cart_items where id = (:id)", nativeQuery = true)
    @Modifying
    void deleteCartItem(@Param("id") Integer id);

    @Query(value = "update from cart_items SET amount = (:amount) where id = (:id)", nativeQuery = true)
    @Modifying
    void updateCartItem(@Param("amount") Integer amount, @Param("id") Integer id);
}
