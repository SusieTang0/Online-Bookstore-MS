package com.johnabbott.OnlineBookstoreMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.johnabbott.OnlineBookstoreMS.entity.Book;
import com.johnabbott.OnlineBookstoreMS.entity.Purchase;
import com.johnabbott.OnlineBookstoreMS.service.BookService;
import com.johnabbott.OnlineBookstoreMS.service.PurchaseService;


@Controller
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;
    private final BookService bookService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService, BookService bookService) {
        this.purchaseService = purchaseService;
        this.bookService = bookService;
    }

    @PostMapping("/showPurchaseForm")
    public String showPurchasePage(@RequestParam("isbn") String theIsbn, Model theModel) {
        Book book = bookService.findById(theIsbn);
        Purchase thePurchase = new Purchase();
        if (book != null) {
            double taxRate = 0.15;
            double tax = book.getPrice() * taxRate;
            double totalPrice = book.getPrice() + tax;

            theModel.addAttribute("book", book);
            theModel.addAttribute("tax", tax);
            theModel.addAttribute("totalPrice", totalPrice);
            theModel.addAttribute("purchase", thePurchase);

            return "purchases/purchase-form";
        } else {
            return "redirect:/books/list"; // Redirect to book list if book is not found
        }
    }


    @PostMapping("/save")
    public String makePurchaseRequest(@ModelAttribute("purchase") Purchase thePurchase) {
    	
    	Book book = bookService.findById(thePurchase.getIsbn());
    	System.out.print(thePurchase);
    	List<Purchase> purchases = purchaseService.findAll();
    	int listSize = purchases.size();
    	Purchase lastPurchase = purchases.get(listSize-1);
    	thePurchase.setPurchaseId(lastPurchase.getPurchaseId()+1);
        if (book == null || book.getStock() < thePurchase.getQuantity()) {
            return "Book not available or insufficient stock";
        }
        System.out.print(thePurchase.toString());
        purchaseService.save(thePurchase);
        book.setStock(book.getStock() - 1);
        bookService.save(book);
        return "purchases/purchase-success";
    }
    
   
    
    @GetMapping("/success")
    public String showSuccessPage(@RequestParam("isbn") String theIsbn) {
    	 Book book = bookService.findById(theIsbn);
    	 if (book == null || book.getStock() < 1) {
             return "Book not available or insufficient stock";
         }
         book.setStock(book.getStock() - 1);
         bookService.save(book);
        return "purchases/purchase-success";
    }

    
}

