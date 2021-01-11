package com.javaspring.mvcdemo.services;

import com.javaspring.mvcdemo.models.Book;
import com.javaspring.mvcdemo.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    // update a book
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
        Book updateBook = findBook(id); //saving the book we got by id in a variable
        updateBook.setTitle(title);
        updateBook.setDescription(desc);
        updateBook.setLanguage(lang);
        updateBook.setNumberOfPages(numOfPages);
        return bookRepository.save(updateBook);
    }

    //Delete
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }
}
