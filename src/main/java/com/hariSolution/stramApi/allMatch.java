package com.hariSolution.stramApi;

import java.util.List;
import java.util.Locale;

public class allMatch {
    public static void main(String[] args) {
        List<Employees> employees=EmployeeRepository.createEmployeeList();

        boolean outcome=employees.stream()
                .anyMatch(emp->emp
                        .getName()
                        .toUpperCase(Locale.ROOT)
                        .contains("A"));
        System.out.println(outcome);
    }
}
