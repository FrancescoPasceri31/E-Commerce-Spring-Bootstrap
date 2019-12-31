package com.myBookstoreProject.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myBookstoreProject.domain.Book;
import com.myBookstoreProject.domain.CartItem;
import com.myBookstoreProject.domain.User;
import com.myBookstoreProject.domain.security.ShoppingCart;
import com.myBookstoreProject.service.BookService;
import com.myBookstoreProject.service.CartItemService;
import com.myBookstoreProject.service.ShoppingCartService;
import com.myBookstoreProject.service.UserService;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private ShoppingCartService shoppingCartService;

	@RequestMapping("/cart")
	public String shoppingCart(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();

		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

		shoppingCartService.updateShoppingCart(shoppingCart);

		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("shoppingCart", shoppingCart);

		return "shoppingCart";

	}

	@RequestMapping("/addItem")
	public String addItem(@ModelAttribute("book") Book book, @ModelAttribute("qty") String qty, Model model,
			Principal principal) {
		User user = userService.findByUsername(principal.getName());
		book = bookService.findOne(book.getId());

		// non abbastanza nello stock
		if (Integer.parseInt(qty) > book.getInStockNumber()) {
			model.addAttribute("notEnoughStock", true);
			return "forward:/bookDetail?id=" + book.getId();
			// posso usare redirect ma passa per il backend e rallenta
			// forward ritorna direttamente al link con il suo contenuto
		}

		// vi sono abbastanza copie
		CartItem cartItem = cartItemService.addBookToCartItem(book, user, Integer.parseInt(qty));
		model.addAttribute("addBookSuccess", true);

		return "forward:/bookDetail?id=" + book.getId();
	}

	@RequestMapping("/updateCartItem")
	public String updateCartItem(@ModelAttribute("id") Long cartItemId, @ModelAttribute("qty") int qty) {
		CartItem cartItem = cartItemService.findById(cartItemId);
		cartItem.setQty(qty);
		cartItemService.updateCartItem(cartItem);

		return "forward:/shoppingCart/cart";
	}

	@RequestMapping("/removeItem")
	public String removeItem(@RequestParam("id") Long id) {
		cartItemService.removeCartItem(cartItemService.findById(id));

		return "forward:/shoppingCart/cart";
	}

}
