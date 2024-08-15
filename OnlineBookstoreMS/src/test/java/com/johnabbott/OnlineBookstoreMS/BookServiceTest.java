package com.johnabbott.OnlineBookstoreMS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.johnabbott.OnlineBookstoreMS.entity.Book;
import com.johnabbott.OnlineBookstoreMS.service.BookService;


@SpringBootTest
public class BookServiceTest {
	@Autowired
    private BookService bookService;

    @Test
    public void testSaveAndRetrieveBook() {
    	// First, save a book
        Book book = new Book("1234567890", "1984", "George Orwell",5.00,3);
        bookService.save(book);

        Book retrievedBook = bookService.findById("1234567890");
        assertNotNull(retrievedBook);
        assertEquals("1984", retrievedBook.getTitle());
        assertEquals("George Orwell", retrievedBook.getAuthor());
        assertEquals(5.00, retrievedBook.getPrice());
    }
    
    
    @Test
    public void testFindAllAndRetrieveBook() {
    	// First, save some books
        Book book1 = new Book("1234567890", "1984", "George Orwell", 5.00, 3);
        Book book2 = new Book("0987654321", "To Kill a Mockingbird", "Harper Lee", 6.00, 4);
        Book book3 = new Book("2345678901", "Brave New World", "Aldous Huxley", 7.00, 5);

        bookService.save(book1);
        bookService.save(book2);
        bookService.save(book3);

        // Now, retrieve all books ordered by ISBN
        List<Book> books = bookService.findAll();

        // Check that the books are retrieved in the correct order
        assertNotNull(books);
        assertEquals(3, books.size());
        assertEquals("0987654321", books.get(0).getIsbn());
        assertEquals("1234567890", books.get(1).getIsbn());
        assertEquals("2345678901", books.get(2).getIsbn());
    }
    
    
}
