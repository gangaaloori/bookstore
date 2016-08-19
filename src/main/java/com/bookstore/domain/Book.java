package com.bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Ganga Aloori
 */
@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    private Integer pages;

    protected Book() {}

    public Book(final String isbn, final String title, final String author, final Integer pages) {
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

    public Integer getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return String.format("Book[isbn=%s, title=%s, author=%s, pages=%d]", isbn, title, author, pages);
    }
}
