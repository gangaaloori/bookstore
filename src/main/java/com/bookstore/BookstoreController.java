package com.bookstore;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ganga Aloori
 */
@RestController
@RequestMapping("/bookstore/books")
public class BookstoreController {

    private final Bookstore bookstore;

    public BookstoreController(final Bookstore bookstore) {
        this.bookstore = bookstore;
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addBook(@RequestBody final Book book) {
        bookstore.saveBook(book);
        return String.format("Book %s is added to the Bookstore", book.getIsbn());
    }

    @RequestMapping(method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Book> listBooks() {
        return bookstore.listBooks();
    }

    @RequestMapping(value = "/{isbn}", method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String removeBook(@PathVariable final String isbn) {
        bookstore.removeBook(isbn);
        return String.format("Book %s is removed from the Bookstore", isbn);
    }
}
