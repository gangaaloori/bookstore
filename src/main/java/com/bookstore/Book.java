package com.bookstore;

import java.io.Serializable;

/**
 * @author Ganga Aloori
 */
public class Book implements Serializable {

    private String isbn;

    private String title;

    private String author;

    protected Book() {}

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("Book[isbn=%s, title=%s, author=%s]", isbn, title, author);
    }
}
