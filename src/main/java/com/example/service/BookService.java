package com.example.service;

import com.example.model.Book;
import com.example.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) { this.bookRepository = bookRepository; }

    public Book getBook(long bookId){
        return bookRepository.findById(bookId).get();
    }

    public Book createBook(Book newBook){
        return bookRepository.save(newBook);
    }
}
