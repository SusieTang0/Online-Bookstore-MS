package com.johnabbott.OnlineBookstoreMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johnabbott.OnlineBookstoreMS.dao.BookRepository;
import com.johnabbott.OnlineBookstoreMS.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository theBookRepository) {

		bookRepository = theBookRepository;
	}
	
	@Override
	public List<Book> findAll() {
		return bookRepository.findAllByOrderByIsbnAsc();
	}

	@Override
	public Book findById(String theIsbn) {
		Optional<Book> result = bookRepository.findById(theIsbn);
		
		Book theBook = null;
		
		if (result.isPresent()) {
			theBook = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find book with the isbn - " + theIsbn);
		}
		
		return theBook;
	}

	@Override
	public void save(Book theBook) {
		bookRepository.save(theBook);
	}
	

	@Override
	public void deleteById(String theIsbn) {
		bookRepository.deleteById(theIsbn);
	}
	
	

}







