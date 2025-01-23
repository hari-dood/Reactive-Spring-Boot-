package com.hariSolution.stramApi;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class peek {
    public static void main(String[] args) {
        List<Employee> employees=EmployeeRepository.createEmployeeList();
        employees.stream().sorted(Comparator.comparing(Employee::getName))
                .peek(name-> System.out
                        .println("befor"+name))
                .map(employee -> employee.getName().toUpperCase(Locale.ROOT)).forEach(System.out::println);

    }
}
