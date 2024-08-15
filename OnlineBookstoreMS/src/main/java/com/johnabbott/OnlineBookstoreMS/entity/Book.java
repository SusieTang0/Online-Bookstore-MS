package com.johnabbott.OnlineBookstoreMS.entity;


import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book {

	@Id
	private String isbn;
	
    private String title;
	
    private String author;
	
    private double price;

    private int stock;

 // Constructors
    public Book() {}

    public Book(String isbn, String title, String author, double price, int stock) {
    	this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }


    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
 // define tostring

 	@Override
 	public String toString() {
 		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + ", stock=" + stock +"]";
 	}
}
