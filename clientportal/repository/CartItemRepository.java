package com.myBookstoreProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.myBookstoreProject.domain.CartItem;
import com.myBookstoreProject.domain.Order;
import com.myBookstoreProject.domain.security.ShoppingCart;

@Transactional
public interface CartItemRepository extends CrudRepository<CartItem, Long> {

	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

	List<CartItem> findByOrder(Order order);
}