package com.hariSolution.stramApi;

import java.util.Comparator;
import java.util.List;

public class sorted {

    public static void main(String[] args) {
        List<Employees> employees=EmployeeRepository.createEmployeeList();

        employees.stream()
                .map(emp->emp.getSalary())
                .sorted((s1,s2)->s2-s1).toList().forEach(System.out::println);

        employees.stream()
                .map(emp->emp.getSalary())
                .sorted((s1,s2)->s1-s2).toList().forEach(System.out::println);

        employees.stream().sorted(Comparator.comparing(Employees::getName)).toList().forEach(System.out::println);
    }
}
