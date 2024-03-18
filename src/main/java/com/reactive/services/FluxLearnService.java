package com.reactive.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

@Service
public class FluxLearnService {

   //All Operators example goes from here
    /*
    Creating Flux
     */
    public Flux<String> getFlux(){

        return Flux.just("Saddam","Khan", "Adnan", "Shams", "Quest","Cognizant");
    }

    public Flux<String> fruitFlux(){

        List<String> fruitsName = List.of("Apple", "Banana", "Orange");
        return Flux.fromIterable(fruitsName).log();
    }

    public Flux<Void> getblankFlux(){

        return Flux.empty();
    }

    public Flux<String> mapExampleFlux(){

        Flux<String> nameCapsFlux = getFlux().map(String::toUpperCase).log();
        return nameCapsFlux;
    }
    public Flux<String> getFilterFlux(){

        return getFlux().filter(name -> name.length() > 5).log();
    }

    //FlatMap
    public Flux<String> flatMapExample(){

//        return getFlux().flatMap(name -> Flux.just(name.split(" "))).log();
        return getFlux().flatMap(name -> Flux.just(name.split(" "))).delayElements(Duration.ofSeconds(2)).log();
    }

    // Transform Example
    public Flux transformExample(){

        Function<Flux<String>, Flux<String>> funcInterface = (name) -> name.map(String::toUpperCase);
        return getFlux().transform(funcInterface).log();
    }
    // defaultIfEmpty
    //switchIfEmpty
    public Flux ifExample(int length){
        return getFlux()
                .filter(name -> name.length() > length)
//                .defaultIfEmpty("No name")
                .switchIfEmpty(fruitFlux())
                .log();
    }
    //concatWith(static), concatWith(instance)

    public Flux concatExample(){

        return Flux.concat(getFlux().delayElements(Duration.ofSeconds(1)),fruitFlux().delayElements(Duration.ofSeconds(2)));
//        return getFlux().concatWith(fruitFlux());
    }

    //merge and mergeWith
    public Flux mergeExample(){

        return Flux.merge(getFlux()
                .delayElements(Duration.ofSeconds(1)), fruitFlux().delayElements(Duration.ofSeconds(2)));
    }
    //zip and zipWith
    public Flux<String> zipExample(){

//        return Flux.zip(getFlux(), Flux.just(123,2,24));
        return Flux.zip(getFlux(), Flux.just(123,2,24), (first, second) -> {
            return first + " : " + second;
        });
        }
        public Flux<String> sideEffectFlux(){
            return getFlux().doOnNext(data -> {
                System.out.println(data + " On Next");
            }).doOnSubscribe(data -> {
                System.out.println(data + " do on subscribe ");
            }).doOnEach(data -> {
                System.out.println(data + " do On Each");
            }).doOnComplete(() -> {
                System.out.println("Completed...");
            });
    }
}
