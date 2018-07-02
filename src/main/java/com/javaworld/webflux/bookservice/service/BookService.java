package com.javaworld.webflux.bookservice.service;

import com.javaworld.webflux.bookservice.model.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Defines the business services for interacting with Books.
 */
public interface BookService {
    /**
     * Finds a book by its id.
     * @param id    The id of the book to find.
     * @return      A Book, wrapped in a Mono.
     */
    Mono<Book> findById(String id);

    /**
     * Returns all books in the database.
     * @return      A collection of Books, wrapped in a Flux.
     */
    Flux<Book> findAll();

    /**
     * Persists a Book to the database.
     * @param book  The book to save to the database.
     * @return      The saved book, wrapped in a Mono.
     */
    Mono<Book> save(Book book);

    /**
     * Deletes the Book with the specified id.
     * @param id    The id of the Book to delete.
     * @return      A Mono<Void>, which sends a completion notification when the deletion is finished.
     */
    Mono<Void> deleteById(String id);
}
