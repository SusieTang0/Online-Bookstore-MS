package com.johnabbott.OnlineBookstoreMS.entity;

public class CartItem {
	private Book book;
    private int quantity;
    
    // constructor
    public CartItem(){}
    
    public CartItem(Book book, int quantity){
    	this.book = book;
    	this.quantity = quantity;
    }
    
    //getter and setter
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    // define tostring
  	@Override
  	public String toString() {
  		return "CartItem [isbn=" + book.getIsbn() + ", title=" + book.getTitle() + ", author=" +  book.getAuthor()  + ", price=" +  book.getPrice()  + ", stock=" + book.getStock() +"]";
  	}
}
