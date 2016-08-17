package com.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Ganga Aloori
 */
@SpringBootApplication
@RestController
public class Application implements CommandLineRunner {

    @RequestMapping("/")
    public String hello() {
        return "Hello from Spring Boot Docker!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private Bookstore bookstore;

    @Override
    public void run(String... strings) throws Exception {
        bookstore.saveBook(new Book(UUID.randomUUID().toString(), "Effective Java", "Joshua Bloch"));
        bookstore.saveBook(new Book(UUID.randomUUID().toString(), "Clean Code", "Robert C Martin"));
        bookstore.saveBook(new Book(UUID.randomUUID().toString(), "Camel In Action", "Claus Ibsen"));
    }
}
