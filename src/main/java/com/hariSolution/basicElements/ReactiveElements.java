package com.hariSolution.basicElements;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReactiveElements {

    public Mono<String> getMono(){


       // return Mono.just("hello world").log(); //mono.just won't return null value
       //return Mono.empty();  while sending empty value considered as null value

      // return Mono.justOrEmpty(null) we can send null value
        return Mono.just("hello world").log();
        //Through mon type of data, we can send one data only

    }

    //if we want to send multiple data, we have to use flex data type


    public Flux<String> getAllData(){
        List<String> data= Arrays.asList("java","react","spring","webflux");

      //  return Flux.just("java","react","spring","webflux").log();
       return Flux.fromIterable(data).log();

    }

    public static void main(String[] args) {
        ReactiveElements reactiveElements=new ReactiveElements();
        reactiveElements.getMono().subscribe(System.out::println);

        reactiveElements.getAllData().subscribe(System.out::println);

    }
}
