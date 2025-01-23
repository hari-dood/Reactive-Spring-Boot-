package com.hariSolution.stramApi;

import java.util.List;

public class reduce {
    public static void main(String[] args) {
        List<Employees> employees=EmployeeRepository.createEmployeeList();
      int sum=  employees.stream().map(Employees::getSalary).reduce(0,Integer::sum);
        System.out.println(sum);
    }
}
