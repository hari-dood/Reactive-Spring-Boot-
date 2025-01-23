package com.hariSolution.stramApi;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class map {
   /* Transforms each element into another object.

    Real-world Example:
    You have a list of product prices and want to calculate the prices after adding 18% GST.*/
    public static void main(String[] args) {

        List<Integer> numberList= Arrays.asList(1,2,3,4,5,6,7);

        numberList.stream().map(number->number*1.18).toList().forEach(System.out::println);

        List<String> products= Arrays.asList("car","bike","auto");

        products.stream().map(product->product.toUpperCase(Locale.ROOT)).collect(Collectors.toSet()).forEach(System.out::println);
    }
}
