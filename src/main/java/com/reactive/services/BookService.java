package com.reactive.services;

import com.reactive.entity.Book;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public interface BookService {

    public Mono<Book> create(Book book);
    public Mono<Book> get(int bookId);
    public Flux<Book> getAll();
    public Mono<Book> update(Book book, int bookId);
    public Mono<Void> delete(int bookId);
    public Flux<Book> searchBooks(String searchKeyword);


}
