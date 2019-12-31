package com.myBookstoreProject.service;

import java.util.List;

import com.myBookstoreProject.domain.Book;

public interface BookService {
	List<Book> findAll();

	Book findOne(Long id);

	List<Book> findByCategory(String category);

	List<Book> blurrySearchBook(String keywordBook);

	List<Book> blurrySearchAuthor(String keywordAuthor);
}
