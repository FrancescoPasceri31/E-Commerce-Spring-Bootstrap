package com.adminportal.controller;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adminportal.service.BookService;

@RestController
public class ResourceController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/book/removeList", method=RequestMethod.POST)
	public String removeList(
			@RequestBody ArrayList<String> bookIdList, Model model
			) {
		for (int i = 0; i < bookIdList.size(); i++) {
			String bookId = bookIdList.get(i).substring(8);
			bookService.removeOne(Long.parseLong(bookId));
			File f = new File("src/main/resources/static/images/book/" + bookId +".png");
			if(f.exists())	f.delete();
		}
		
		return "delete success";
	}
	
}
