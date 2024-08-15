package com.johnabbott.OnlineBookstoreMS.service;

import java.util.List;


import com.johnabbott.OnlineBookstoreMS.entity.Book;

public interface BookService {
	
	List<Book> findAll();
	
	Book findById(String theIsbn);
	
	void save(Book theBook);
	
	void deleteById(String theIsbn);
}
