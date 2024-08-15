package com.johnabbott.OnlineBookstoreMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.johnabbott.OnlineBookstoreMS.entity.Book;
import com.johnabbott.OnlineBookstoreMS.service.BookService;
import com.johnabbott.OnlineBookstoreMS.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final BookService bookService; // Assume ProductService is already implemented

    @Autowired
    public CartController(CartService cartService, BookService bookService) {
        this.cartService = cartService;
        this.bookService = bookService;
    }

    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("total", cartService.getTotal());
        return "cart/view";
    }

    @PostMapping("/add/{productId}")
    public String addProductToCart(@PathVariable String theIsbn) {
        Book product = bookService.findById(theIsbn);
        if (product != null) {
            cartService.addProduct(product);
        }
        return "redirect:/cart";
    }

    @PostMapping("/remove/{productId}")
    public String removeProductFromCart(@PathVariable String productId) {
        cartService.removeProduct(productId);
        return "redirect:/cart";
    }

    @PostMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }
}

