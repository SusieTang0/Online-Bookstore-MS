package com.johnabbott.OnlineBookstoreMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.johnabbott.OnlineBookstoreMS.entity.Book;
import com.johnabbott.OnlineBookstoreMS.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

	private BookService bookService;
	public BookController(BookService theBookService){
		this.bookService = theBookService;
	}

	// add mapping for "/list"
	@GetMapping("/list")
	public String listBooks(Model theModel) {

		//get the employee from db
		List<Book> books = bookService.findAll();

		// add to the spring model
		theModel.addAttribute("books", books);

		return "list-books";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Book theBook = new Book();

		theModel.addAttribute("book", theBook);

		return "books/book-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("isbn") String theIsbn,
									Model theModel) {

		// get the book from the service
		Book theBook = bookService.findById(theIsbn);

		// set book as a model attribute to pre-populate the form
		theModel.addAttribute("book", theBook);

		// send over to our form
		return "books/book-form";
	}

	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") Book theBook) {

		// save the book
		bookService.save(theBook);

		// use a redirect to prevent duplicate submissions
		return "redirect:/books/list";
	}
	


	@GetMapping("/delete")
	public String delete(@RequestParam("isbn") String theIsbn) {

		// delete the employee
		bookService.deleteById(theIsbn);

		// redirect to /employees/list
		return "redirect:/books/list";

	}

}