package com.javaworld.webflux.bookservice.repository;

import com.javaworld.webflux.bookservice.model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {
}
