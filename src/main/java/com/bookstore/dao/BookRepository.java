package com.bookstore.dao;

import com.bookstore.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ganga Aloori
 */
@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, String> {

    Page<Book> findAll(Pageable pageable);
    List<Book> findAllByAuthorIgnoringCase(String author);
}
