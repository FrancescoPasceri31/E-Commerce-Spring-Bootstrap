package com.myBookstoreProject.service;

import com.myBookstoreProject.domain.security.ShoppingCart;

public interface ShoppingCartService {

	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);

	void clearShoppingCart(ShoppingCart shoppingCart);
}
