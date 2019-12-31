package com.myBookstoreProject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBookstoreProject.domain.Book;
import com.myBookstoreProject.repository.BookRepository;
import com.myBookstoreProject.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		List<Book> bookList = (List<Book>) bookRepository.findAll();

		List<Book> activeBookList = new ArrayList<>();

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).isActive()) {
				activeBookList.add(bookList.get(i));
			}
		}

		return activeBookList;
	}

	@Override
	public Book findOne(Long id) {
		return bookRepository.findById(id).orElse(null); // findOne(id)
	}

	@Override
	public List<Book> findByCategory(String category) {
		List<Book> bookList = bookRepository.findByCategory(category);

		List<Book> activeBookList = new ArrayList<>();

		for (int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			if (book.isActive()) {
				activeBookList.add(book);
			}
		}

		return activeBookList;
	}

	@Override
	public List<Book> blurrySearchBook(String keywordBook) {
		List<Book> bookList = bookRepository.findByTitleContaining(keywordBook);

		List<Book> activeBookList = new ArrayList<>();

		for (int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			if (book.isActive()) {
				activeBookList.add(book);
			}
		}

		return activeBookList;
	}
	
	@Override
	public List<Book> blurrySearchAuthor(String keywordAuthor) {
		List<Book> bookList = bookRepository.findByAuthorContaining(keywordAuthor);

		List<Book> activeBookList = new ArrayList<>();

		for (int i = 0; i < bookList.size(); i++) {
			Book book = bookList.get(i);
			if (book.isActive()) {
				activeBookList.add(book);
			}
		}

		return activeBookList;
	}

}
