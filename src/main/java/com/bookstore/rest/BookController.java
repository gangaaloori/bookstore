package com.bookstore.rest;

import com.bookstore.domain.Book;
import com.bookstore.exception.BookNotFoundException;
import com.bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ganga Aloori
 */
@RestController
@RequestMapping("/bookstore/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody final Book book) {
        return bookService.saveBook(book);
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @RequestMapping(value = "/{isbn}",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBook(@PathVariable final String isbn) {
        bookService.removeBook(isbn);
    }

    @RequestMapping(value = "/{isbn}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@PathVariable final String isbn,
                             @RequestBody final Book book) {
        if (bookService.isBookExists(isbn))
            return bookService.updateBook(book);
        else
            throw new BookNotFoundException(String.format("Book with Id %s is not found", isbn));
    }

    @RequestMapping(value = "/{isbn}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@PathVariable final String isbn) {
        return bookService.getBook(isbn);
    }
}
