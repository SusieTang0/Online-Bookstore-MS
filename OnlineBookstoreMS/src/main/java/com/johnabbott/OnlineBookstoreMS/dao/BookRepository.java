package com.johnabbott.OnlineBookstoreMS.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnabbott.OnlineBookstoreMS.entity.Book;

public interface BookRepository extends JpaRepository<Book, String>{
	

	public List<Book> findAllByOrderByIsbnAsc();

}
