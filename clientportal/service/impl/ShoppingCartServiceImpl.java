package com.myBookstoreProject.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBookstoreProject.domain.CartItem;
import com.myBookstoreProject.domain.security.ShoppingCart;
import com.myBookstoreProject.repository.ShoppingCartRepository;
import com.myBookstoreProject.service.CartItemService;
import com.myBookstoreProject.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Override
	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
		BigDecimal cartTotal = new BigDecimal(0);

		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

		for (CartItem cartItem : cartItemList) {
			if (cartItem.getBook().getInStockNumber() > 0) {
				cartItemService.updateCartItem(cartItem);
				cartTotal = cartTotal.add(cartItem.getSubtotal());
			}
			System.out.println("-----------------------");
		}

		shoppingCart.setGrandTotal(cartTotal);

		shoppingCartRepository.save(shoppingCart);

		return shoppingCart;
	}

	@Override
	public void clearShoppingCart(ShoppingCart shoppingCart) {
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for (int i = 0; i < cartItemList.size(); i++) {
			cartItemList.get(i).setShoppingCart(null);
			cartItemService.save(cartItemList.get(i));
		}
		
		shoppingCart.setGrandTotal(new BigDecimal(0));
		
		shoppingCartRepository.save(shoppingCart);
	}

}
