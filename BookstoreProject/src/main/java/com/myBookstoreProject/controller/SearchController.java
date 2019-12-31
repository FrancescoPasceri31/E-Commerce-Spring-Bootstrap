package com.myBookstoreProject.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myBookstoreProject.domain.Book;
import com.myBookstoreProject.domain.User;
import com.myBookstoreProject.service.BookService;
import com.myBookstoreProject.service.UserService;

@Controller
public class SearchController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@RequestMapping("searchByCategory")
	public String searchByCategory(@RequestParam("category") String category, Model model, Principal principal) {
		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}

		String classActiveCategory = "active" + category;
		classActiveCategory = classActiveCategory.replaceAll("\\s+", "");
		classActiveCategory = classActiveCategory.replaceAll("&", "");
		model.addAttribute(classActiveCategory, true);

		List<Book> bookList = bookService.findByCategory(category);

		if (bookList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "bookshelf";
		}

		model.addAttribute("bookList", bookList);

		return "bookshelf";

	}

	@RequestMapping("/search")
	public String search(@ModelAttribute("keywordBook") String keywordBook,
			@ModelAttribute("keywordAuthor") String keywordAuthor, Principal principal, Model model) {
		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}

		
		List<Book> bookList = new ArrayList<>();

		if (keywordBook != null && !keywordBook.isEmpty() && !keywordBook.equals("")) {
			bookList.addAll(bookService.blurrySearchBook(keywordBook));

		}
		if (keywordAuthor != null && !keywordAuthor.isEmpty() && !keywordAuthor.equals("")) {
			bookList.addAll(bookService.blurrySearchAuthor(keywordAuthor));
		}

		if (bookList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "bookshelf";
		}

		model.addAttribute("bookList", bookList);

		return "bookshelf";
	}
}
