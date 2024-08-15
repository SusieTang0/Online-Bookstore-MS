package com.johnabbott.OnlineBookstoreMS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnabbott.OnlineBookstoreMS.entity.Book;
import com.johnabbott.OnlineBookstoreMS.entity.Purchase;

public interface CartItemRepository extends JpaRepository<Book, String>{
	public List<Purchase> findAllByOrderByIsbnAsc();
}
