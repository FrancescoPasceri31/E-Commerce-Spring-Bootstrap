package com.myBookstoreProject.service;

import com.myBookstoreProject.domain.BillingAddress;
import com.myBookstoreProject.domain.Order;
import com.myBookstoreProject.domain.Payment;
import com.myBookstoreProject.domain.ShippingAddress;
import com.myBookstoreProject.domain.User;
import com.myBookstoreProject.domain.security.ShoppingCart;

public interface OrderService {

	Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, BillingAddress billingAddress,
			Payment payment, String shippingMethod, User user);

	Order findOne(Long id);
	
}
