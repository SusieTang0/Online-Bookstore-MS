package com.johnabbott.OnlineBookstoreMS.service;

import java.util.List;

import com.johnabbott.OnlineBookstoreMS.entity.Book;
import com.johnabbott.OnlineBookstoreMS.entity.Purchase;



public interface PurchaseService {
	
	
	List<Purchase> findAll();
	Purchase findById(int theId);
	void save(Purchase thePurchase);
	void deleteById(int thePurchaseId);
	
}
