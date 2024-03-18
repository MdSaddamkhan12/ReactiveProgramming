package com.reactive.service;

import com.reactive.services.FluxLearnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class FluxLearnTest {

    @Autowired
    private FluxLearnService fluxLearnService;

    @Test
    void simpleFluxTest(){
       /* fluxLearnService.getFlux().subscribe(data -> {
            System.out.println(data);
            System.out.println("Done with flux data...");
        });*/
        fluxLearnService.fruitFlux().subscribe(System.out::println);
    }

    @Test
    void mapTest(){

        Flux<String> stringFlux = fluxLearnService.mapExampleFlux();
        StepVerifier.create(stringFlux)
                .expectNext("Saddam".toUpperCase(),"Khan".toUpperCase(), "Adnan".toUpperCase(), "Shams".toUpperCase(), "Quest".toUpperCase())
                .verifyComplete();
    }
    @Test
    void filterTest(){

        Flux<String> filteredFlux = fluxLearnService.getFilterFlux();
        StepVerifier.create(filteredFlux)
                .expectNextCount(2)
                .verifyComplete();
    }
    @Test
    void flatMapTest(){
        Flux<String> flapMapFlux = fluxLearnService.flatMapExample();
        StepVerifier.create(flapMapFlux)
                .expectNextCount(4)
                .verifyComplete();
    }

    @Test
    void fluxTransformTest(){

        Flux flux = fluxLearnService.transformExample();
        StepVerifier.create(flux)
                .expectNextCount(6)
                .verifyComplete();
    }
    @Test
    void ifExampleTest(){
        Flux ifExample = fluxLearnService.ifExample(8);
        StepVerifier.create(ifExample)
                .expectNextCount(3)
                .verifyComplete();
    }
    @Test
    void concatTest(){
        Flux concat = fluxLearnService.concatExample().log();
        StepVerifier.create(concat)
                .expectNextCount(9)
                .verifyComplete();
    }
    @Test
    void mergeTest(){
        Flux merge = fluxLearnService.mergeExample().log();
        StepVerifier.create(merge)
                .expectNextCount(9)
                .verifyComplete();
    }

    @Test
    void zipTest(){
        Flux<String> tuple2Flux = fluxLearnService.zipExample().log();
        StepVerifier.create(tuple2Flux).expectNextCount(3).verifyComplete();
    }

    @Test
    void doOnNextTest(){
        fluxLearnService.sideEffectFlux().log().subscribe(System.out::println);
    }
}
