package com.hariSolution.stramApi;

import java.util.List;
import java.util.stream.Collectors;

public class skip {


    public static void main(String[] args) {
        List<Employee> employees=EmployeeRepository.createEmployeeList();
        employees.stream().map(emp->emp.getSalary()).skip(2).toList().forEach(System.out::println);
    }
}
