package com.bookstore.rest;

import com.bookstore.dao.BookRepository;
import com.bookstore.domain.Book;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

/**
 * @author Ganga Aloori
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookstoreIntegrationTests {

    private static List<Book> books = Arrays.asList(
            new Book("0321356683", "Effective Java", "Joshua Bloch", 272),
            new Book("0132350882", "Clean Code", "Robert C Martin", 258),
            new Book("1935182366", "Camel In Action", "Claus Ibsen", 558),
            new Book("0321643518", "Java Puzzlers", "Joshua Bloch", 220));

    @LocalServerPort
    private int port;

    @Autowired
    private BookRepository bookRepository;

    @Before
    public void setup() {
        bookRepository.deleteAll();
        bookRepository.save(books);
        RestAssured.port = port;
    }

    @After
    public void cleanup() {
        bookRepository.deleteAll();
    }

    @Test
    public void getBooks() throws Exception {

        when().
                get("/bookstore/v1/books").
        then().
                body("isbn", hasItems("0321356683", "0132350882", "1935182366", "0321643518")).
                body("title", hasItems("Effective Java", "Clean Code", "Camel In Action", "Java Puzzlers")).
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    @Test
    public void getBooksByAuthor() throws Exception {

        final String author = "Joshua Bloch";
        given().
                queryParam("author", author);
        when().
                get("/bookstore/v1/books").
        then().
                body("isbn", hasItems("0321356683", "0321643518")).
                body("title", hasItems("Effective Java", "Java Puzzlers")).
                body("author", hasItems(author, author)).
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    @Test
    public void addBook() throws Exception {

        final Book book = new Book("0321146530", "Test Driven Development", "Kent Beck", 346);

        given().
                contentType(ContentType.JSON).
                body(book).
        when().
                put("/bookstore/v1/books").
        then().
                body("isbn", Matchers.is(book.getIsbn())).
                body("title", Matchers.is(book.getTitle())).
                body("author", Matchers.is(book.getAuthor())).
                statusCode(HttpStatus.SC_CREATED).
                contentType(ContentType.JSON);
    }

    @Test
    public void getBook() throws Exception {

        final String isbn = "0321356683";

        when().
                get("/bookstore/v1/books/"+isbn).
        then().
                body("isbn", Matchers.is(isbn)).
                body("title", Matchers.is("Effective Java")).
                body("author", Matchers.is("Joshua Bloch")).
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    @Test
    public void removeBook() throws Exception {

        final String isbn = "0132350882";

        when().
                delete("/bookstore/v1/books/"+isbn).
        then().
                statusCode(HttpStatus.SC_NO_CONTENT);
    }


    @Test
    public void updateBook() throws Exception {

        final String isbn = "1935182366";
        final Book book = new Book("0321146530", "Test Driven Development", "Kent Beck", 346);

        given().
                contentType(ContentType.JSON).
                body(book).
        when().
                post("/bookstore/v1/books/"+isbn).
        then().
                body("isbn", Matchers.is(book.getIsbn())).
                body("title", Matchers.is(book.getTitle())).
                body("author", Matchers.is(book.getAuthor())).
                statusCode(HttpStatus.SC_OK);
    }
}
