package com.hariSolution.stramApi;

import java.util.List;

public class limit {
    //Limits the number of elements in the stream.
    public static void main(String[] args) {
        List<Employee> employees=EmployeeRepository.createEmployeeList();
        employees.stream().map(employee -> employee.getSalary()).limit(2).forEach(System.out::println);
    }
}
