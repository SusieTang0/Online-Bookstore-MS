package com.johnabbott.OnlineBookstoreMS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnabbott.OnlineBookstoreMS.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{
	
	public List<Purchase> findAllByOrderByPurchaseIdAsc();
}
