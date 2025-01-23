package com.hariSolution.stramApi;

import java.util.List;

public class reduce {
    public static void main(String[] args) {
        List<Employee> employees=EmployeeRepository.createEmployeeList();
      int sum=  employees.stream().map(Employee::getSalary).reduce(0,Integer::sum);
        System.out.println(sum);
    }
}
