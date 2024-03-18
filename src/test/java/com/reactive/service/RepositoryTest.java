package com.reactive.service;

import com.reactive.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testFindByMethod(){

        /*Mono<Book> bookMono = bookRepository.findByName("spring boot in action");
        StepVerifier.create(bookMono)
                .expectNextCount(1)
                .verifyComplete();*/
        /*Flux<Book> bookFlux = bookRepository.findByAuthor("saddam");
        StepVerifier.create(bookFlux)
                .expectNextCount(1)
                .verifyComplete();*/
        bookRepository.findByNameAndAuthor("spring boot in action", "saddam")
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    public void testQueryMethod(){
        /*bookRepository.getAllBooksByAuthor("saddam", "spring boot in action")
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();*/

        bookRepository.searchBookByTitle("%action%")
                .as(StepVerifier::create)
                .expectNextCount(3)
                .verifyComplete();
    }
}
