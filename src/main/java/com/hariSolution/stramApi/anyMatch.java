package com.hariSolution.stramApi;

import java.util.List;

public class anyMatch {
    //Checks if any element matches a given predicate.
    public static void main(String[] args) {
        List<Employee> employees=EmployeeRepository.createEmployeeList();

        boolean pass=employees.stream().map(employee -> employee.getSalary()).anyMatch(salary->salary < 40000);

        System.out.println(pass);
    }
}
