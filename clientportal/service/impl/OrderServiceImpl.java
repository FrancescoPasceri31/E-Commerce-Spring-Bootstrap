package com.myBookstoreProject.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBookstoreProject.domain.BillingAddress;
import com.myBookstoreProject.domain.Book;
import com.myBookstoreProject.domain.CartItem;
import com.myBookstoreProject.domain.Order;
import com.myBookstoreProject.domain.Payment;
import com.myBookstoreProject.domain.ShippingAddress;
import com.myBookstoreProject.domain.User;
import com.myBookstoreProject.domain.security.ShoppingCart;
import com.myBookstoreProject.repository.OrderRepository;
import com.myBookstoreProject.service.CartItemService;
import com.myBookstoreProject.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CartItemService cartItemService;
	
	// è synchronized poiché devo decrementare il numero di disponibili in maniera
	// sincronizzata e atomica
	@Override
	public synchronized Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress,
			BillingAddress billingAddress, Payment payment, String shippingMethod, User user) {
		Order order = new Order();
		order.setBillingAddress(billingAddress);
		order.setOrderStatus("created");
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingMethod);
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for(CartItem cartItem : cartItemList) {
			Book book = cartItem.getBook();
			cartItem.setOrder(order);
			book.setInStockNumber(book.getInStockNumber() - cartItem.getQty());
		}
		
		order.setCartItemList(cartItemList);
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setOrderTotal(shoppingCart.getGrandTotal());
		shippingAddress.setOrder(order);
		billingAddress.setOrder(order);
		payment.setOrder(order);
		order.setUser(user);
		order = orderRepository.save(order);
		
		return order;
		
	}

	@Override
	public Order findOne(Long id) {
		return orderRepository.findById(id).orElse(null);
	}

}
