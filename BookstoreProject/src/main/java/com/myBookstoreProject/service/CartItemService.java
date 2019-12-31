package com.myBookstoreProject.service;

import java.util.List;

import com.myBookstoreProject.domain.Book;
import com.myBookstoreProject.domain.CartItem;
import com.myBookstoreProject.domain.Order;
import com.myBookstoreProject.domain.User;
import com.myBookstoreProject.domain.security.ShoppingCart;

public interface CartItemService {

	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

	CartItem updateCartItem(CartItem cartItem);

	CartItem addBookToCartItem(Book book, User user, int parseInt);

	CartItem findById(Long cartItemId);

	void removeCartItem(CartItem findById);

	CartItem save(CartItem cartItem);

	List<CartItem> findByOrder(Order order);
}
