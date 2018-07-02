package com.javaworld.webflux.bookservice.web;

import com.javaworld.webflux.bookservice.model.Book;
import com.javaworld.webflux.bookservice.service.BookService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/book/{id}")
    public Mono<Book> getBookById(@PathVariable String id) {
        return bookService.findById(id);
    }

    @GetMapping(value = "/books")
    public Flux<Book> getAllBooks() {
        Thread.dumpStack();
        return bookService.findAll();
    }

    @PostMapping(value = "/book")
    public Mono<Book> createBook(@RequestBody Book book) {
        return bookService.save(book);
    }
}
