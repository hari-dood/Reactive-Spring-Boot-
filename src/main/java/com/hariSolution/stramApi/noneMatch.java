package com.hariSolution.stramApi;

import java.util.List;

public class noneMatch {
    public static void main(String[] args) {
        List<Employees> employees=EmployeeRepository.createEmployeeList();

        boolean nonMach=employees.stream().noneMatch(employee -> employee.getSalary() <5000);

        System.out.println(nonMach);
    }
}
