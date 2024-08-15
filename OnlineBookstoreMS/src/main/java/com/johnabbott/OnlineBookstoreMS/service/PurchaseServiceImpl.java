package com.johnabbott.OnlineBookstoreMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johnabbott.OnlineBookstoreMS.dao.PurchaseRepository;
import com.johnabbott.OnlineBookstoreMS.entity.Book;
import com.johnabbott.OnlineBookstoreMS.entity.Purchase;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	private PurchaseRepository purchaseRepository;
	private BookService bookService;
	
	public PurchaseServiceImpl(PurchaseRepository purchaseRepository,BookService bookService) {
        this.purchaseRepository = purchaseRepository;
        this.bookService = bookService;
        
    }
	
	@Override
	public List<Purchase> findAll() {
		return purchaseRepository.findAllByOrderByPurchaseIdAsc();
	}
	
	@Override
	public Purchase findById(int theId) {
		Optional<Purchase> result = purchaseRepository.findById(theId);
		
		Purchase thePurchase = null;
		
		if (result.isPresent()) {
			thePurchase = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find this purchase record with the id - " + theId);
		}
		
		return thePurchase;
	}
    
    @Override
	public void save(Purchase thePurchase) {
    	
    	purchaseRepository.save(thePurchase);
    
	}
    
    @Override
    public void deleteById(int thePurchaseId) {
    	purchaseRepository.deleteById(thePurchaseId);
    }
}
