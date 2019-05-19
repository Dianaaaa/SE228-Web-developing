package com.retell.retellbackend.repository;

import com.retell.retellbackend.entity.CartItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from cart_items where id = (:id)", nativeQuery = true)
    void deleteCartItem(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update cart_items SET amount = (:amount) where id = (:id)", nativeQuery = true)
    void updateCartItem(@Param("amount") Integer amount, @Param("id") Integer id);
}
