package com.reactive.repository;

import com.reactive.entity.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends R2dbcRepository<Book, Integer> {


    Mono<Book> findByName(String name);

    Flux<Book> findByAuthor(String author);

    Flux<Book> findByPublisher(String publisher);

    Flux<Book> findByNameAndAuthor(String name, String author);

    @Query("select * from book_details where author = :author AND name = :n")
    Flux<Book> getAllBooksByAuthor(String author, @Param("n") String name);

    @Query("select * from book_details where name LIKE :title")
    Flux<Book> searchBookByTitle(String title);

}
