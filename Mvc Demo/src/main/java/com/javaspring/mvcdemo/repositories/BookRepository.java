package com.javaspring.mvcdemo.repositories;

import com.javaspring.mvcdemo.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> { //Long same as in Book.java id
    List<Book> findAll();

    List<Book> findByDescriptionContaining(String search);

    Long countByTitleContaining(String search);

    Long deleteByTitleStartingWith(String search);
}
