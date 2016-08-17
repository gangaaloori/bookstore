package com.bookstore.dao;

import com.bookstore.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ganga Aloori
 */
@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, String> {

    Page findAll(Pageable pageable);
}
