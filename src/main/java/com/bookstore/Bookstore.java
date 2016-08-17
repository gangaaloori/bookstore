package com.bookstore;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ganga Aloori
 */
@Service
public class Bookstore {

    private Map<String, Book> bookstore = new HashMap<>();

    public void saveBook(final Book book) {
        bookstore.put(book.getIsbn(), book);
    }

    public void removeBook(final String isbn){
        bookstore.remove(isbn);
    }

    public List<Book> listBooks() {
        final Iterable<Book> bookIterable = bookstore.values();
        final List<Book> books = new ArrayList<>();
        bookIterable.iterator().forEachRemaining(books::add);
        return books;
    }
}
