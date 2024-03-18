package com.reactive.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@SpringBootTest
class ReactiveProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void workingWithMono() throws InterruptedException {

		//mono - publisher that have 0...1 items
		//created mono
	/*	Mono<String> errorMono = Mono.error(new RuntimeException("error..."));
		Mono<String> m1 = Mono.just("Learn code  with saddam")
				.log()
				.then(errorMono);
		// consume the mono by subscribing
		m1.subscribe(System.out::println);*/

		Mono<String> m1 = Mono.just("Learn Web Development with Saddam");
		Mono<String> m2 = Mono.just("And subscribe to our Channel");
		Mono<Integer> m3 = Mono.just(123654);

		/*Mono<String> mapMono = m1.map(String::toUpperCase);
		mapMono.subscribe(System.out::println);
		Mono<String[]> flatMapMono = m1.flatMap(value1 -> Mono.just(value1.split(" ")));
		flatMapMono.subscribe(data -> {
			for(String s : data){
				System.out.println(s);
			}
		});*/
		/*Mono<Tuple3<String, String, Integer>> combinedMono = Mono.zip(m1, m2, m3);

		combinedMono.subscribe(data -> {
			System.out.println(data.getT1());
			System.out.println(data.getT2());
			System.out.println(data.getT3());
		});*/

	/*	Mono<Tuple2<String, String>> zipWithMono = m1.zipWith(m2);
		zipWithMono.subscribe(data -> {
			System.out.println(data.getT1());
			System.out.println(data.getT2());
		});*/

	/*	Flux<String> flatMapMany = m1.flatMapMany(value1 -> Flux.just(value1.split(" "))).log();
		flatMapMany.subscribe(data -> {
			System.out.println(data
			);
		});*/
		System.out.println(Thread.currentThread().getName());
		Flux<String> stringFlux = m1.concatWith(m2).log().delayElements(Duration.ofMillis(2000));
		stringFlux.subscribe(data ->
				{
					System.out.println(Thread.currentThread().getName());
					System.out.println(data);
				}
		);
		Thread.sleep(3000);
		System.out.println("terminated main Thread...");

	}

}
