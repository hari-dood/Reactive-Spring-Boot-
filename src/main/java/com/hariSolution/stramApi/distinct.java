package com.hariSolution.stramApi;

import java.util.List;

//avoid duplicate Removes duplicate elements.
public class distinct {
    public static void main(String[] args) {

        List<Employees> employees=EmployeeRepository.createEmployeeList();

        List<Integer> emp= employees.stream().map(employee -> employee.getSalary()).distinct().toList();
        System.out.println(emp);
    }



}
