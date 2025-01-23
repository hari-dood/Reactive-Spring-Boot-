package com.hariSolution.stramApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class filter {



    public static void main(String[] args) {

        List<Integer> numberList= Arrays.asList(1,2,3,4,5,6,7);

        numberList.stream().filter(number->number>3).collect(Collectors.toSet())
                .forEach(System.out::println);


        List<String> nameList= Arrays.asList("ram","gob","murmuring","venation");
        nameList.stream().filter(name->name.startsWith("ram")).toList().forEach(System.out::println);

    }
}
