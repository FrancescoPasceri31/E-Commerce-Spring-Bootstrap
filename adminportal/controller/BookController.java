package com.adminportal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.adminportal.domain.Book;
import com.adminportal.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "addBook";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {

		bookService.save(book); // save the book in the database to persist
		MultipartFile bookImage = book.getBookImage();

		try {
			byte[] bytes = bookImage.getBytes();
			String name = book.getId() + ".png";
			File f = new File("src/main/resources/static/images/book/" + name);
			if (!f.exists())
				f.createNewFile();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(f));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:bookList";
	}

	@RequestMapping("/bookList")
	public String bookList(Model model) {
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);
		return "bookList";
	}

	@RequestMapping("/bookInfo")
	public String bookInfo(@RequestParam("id") Long id, Model model) {
		Book book = bookService.findOne(id);
		model.addAttribute("book", book);
		return "bookInfo";
	}

	@RequestMapping("/updateBook")
	public String updateBook(@RequestParam("id") Long id, Model model) {
		Book book = bookService.findOne(id);
		model.addAttribute("book", book);
		return "updateBook";
	}

	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public String updateBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {

		bookService.save(book);

		MultipartFile bookImage = book.getBookImage();

		if (!bookImage.isEmpty()) {
			try {
				byte[] bytes = bookImage.getBytes();
				String name = book.getId() + ".png";

				File f = new File("src/main/resources/static/images/book/" + name);
				f.delete();
				f.createNewFile();

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(f));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "redirect:/book/bookInfo?id=" + book.getId();
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@ModelAttribute("id") String id, Model model) {
		bookService.removeOne(Long.parseLong(id.substring(8))); // questo perche th:id del bottone è
																// 'oneBook-'+{book.id} e l'id inizia all'ottava
																// posizione
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);

		File f = new File("src/main/resources/static/images/book/" + Long.parseLong(id.substring(8)) + ".png");
		if (f.exists())
			f.delete();

		return "redirect:/book/bookList";

	}
}
