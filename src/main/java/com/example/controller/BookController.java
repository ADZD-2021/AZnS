package com.example.controller;

import com.example.model.Book;
import com.example.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    final BookService bookService;

    public BookController(BookService bookService){ this.bookService = bookService; }


    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable("bookId") long bookId){
        return bookService.getBook(bookId);
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }



}
