package com.hariSolution.stramApi;

import java.util.List;
import java.util.stream.Collectors;
//avoid duplicate Removes duplicate elements.
public class distinct {
    public static void main(String[] args) {

        List<Employee> employees=EmployeeRepository.createEmployeeList();

        List<Integer> emp= employees.stream().map(employee -> employee.getSalary()).distinct().toList();
        System.out.println(emp);
    }



}
