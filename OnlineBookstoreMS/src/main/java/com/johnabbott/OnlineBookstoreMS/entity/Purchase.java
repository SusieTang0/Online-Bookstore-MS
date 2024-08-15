package com.johnabbott.OnlineBookstoreMS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="purchase")
public class Purchase {
	
	@Id
	private int purchaseId;
	
	private String isbn;
    private int quantity;
    private String customerName;

    private String customerEmail;

    
    // Constructors
    public Purchase() {}
    
    public Purchase(int purchaseId,String isbn, int quantity,String customerName, String customerEmail) {
    	this.purchaseId =purchaseId;
        this.isbn = isbn;
        this.quantity = quantity;
        this.customerName = customerName;
        this.customerEmail=customerEmail;

    }

    public Purchase(String isbn, int quantity) {
        this.isbn = isbn;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }
    
   
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String CustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String CustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    
    @Override
 	public String toString() {
 		return "Purchase [isbn=" + isbn + ", quantity=" + quantity + "customerName" + customerName + "customerEmail=" + customerEmail +"]";
 	}

}
