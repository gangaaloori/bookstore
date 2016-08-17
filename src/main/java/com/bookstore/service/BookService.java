package com.bookstore.service;

import com.bookstore.dao.BookRepository;
import com.bookstore.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ganga Aloori
 */
@Service
public class BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public void removeBook(final String isbn){
        bookRepository.delete(isbn);
    }

    public List<Book> getBooks() {
        final Iterable<Book> bookIterable = bookRepository.findAll();
        final List<Book> books = new ArrayList<>();
        bookIterable.iterator().forEachRemaining(books::add);
        return books;
    }

    public Book getBook(final String isbn) {
        return bookRepository.findOne(isbn);
    }

    public Book updateBook(final Book book) {
        return bookRepository.save(book);
    }

    public boolean isBookExists(final String isbn) {
        return bookRepository.exists(isbn);
    }
}
