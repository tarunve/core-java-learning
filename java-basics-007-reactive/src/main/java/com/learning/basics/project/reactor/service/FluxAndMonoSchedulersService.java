package com.learning.basics.project.reactor.service;

import com.learning.basics.project.reactor.util.CommonUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;

public class FluxAndMonoSchedulersService {

    private static List<String> namesList = List.of("alex", "ben", "chloe");

    public Flux<String> namesFlux() {
        return Flux.fromIterable(namesList);
    }

    public Mono<String> nameMono() {
        return Mono.just("Spring");
    }

    public static void main(String[] args) {
        FluxAndMonoSchedulersService fluxAndMonoSchedulersService = new FluxAndMonoSchedulersService();
        fluxAndMonoSchedulersService.namesFlux()
                .subscribe(System.out::println);

        CommonUtil.delay(1000);
        fluxAndMonoSchedulersService.nameMono()
                .subscribe(System.out::println);
    }

}