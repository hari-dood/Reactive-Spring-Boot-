package com.hariSolution.stramApi;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class peek {
    public static void main(String[] args) {
        List<Employees> employees=EmployeeRepository.createEmployeeList();
        employees.stream().sorted(Comparator.comparing(Employees::getName))
                .peek(name-> System.out
                        .println("befor"+name))
                .map(employee -> employee.getName().toUpperCase(Locale.ROOT)).forEach(System.out::println);

    }
}
