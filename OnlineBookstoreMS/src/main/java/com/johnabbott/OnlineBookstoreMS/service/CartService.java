package com.johnabbott.OnlineBookstoreMS.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.johnabbott.OnlineBookstoreMS.entity.Book;
import com.johnabbott.OnlineBookstoreMS.entity.CartItem;

@Service
public class CartService {
    private Map<String, CartItem> cart = new HashMap<>();

    public void addProduct(Book book) {
        CartItem cartItem = cart.get(book.getIsbn());
        if (cartItem == null) {
            cartItem = new CartItem();
            cartItem.setBook(book);
            cartItem.setQuantity(1);
            cart.put(book.getIsbn(), cartItem);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        }
    }

    public void removeProduct(String theIsbn) {
        cart.remove(theIsbn);
    }

    public Map<String, CartItem> getCartItems() {
        return cart;
    }

    public void clearCart() {
        cart.clear();
    }

    public double getTotal() {
        return cart.values().stream()
                .mapToDouble(item -> item.getBook().getPrice() * item.getQuantity())
                .sum();
    }
}
