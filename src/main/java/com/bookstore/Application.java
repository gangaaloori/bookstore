package com.bookstore;

import com.bookstore.dao.BookRepository;
import com.bookstore.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * @author Ganga Aloori
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... strings) throws Exception {
        bookRepository.save(Arrays.asList(
                new Book("0321356683", "Effective Java", "Joshua Bloch"),
                new Book("0132350882", "Clean Code", "Robert C Martin"),
                new Book("1935182366", "Camel In Action", "Claus Ibsen")));
    }
}
