package com.hariSolution.stramApi;

import com.hariSolution.stramApi.Employee;

import java.util.ArrayList;
import java.util.List;

// Repository class for Employee data
public class EmployeeRepository {

    // Static method to create and return a list of employees
    public static List<Employee> createEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();

        // Add 5 employee objects to the list
        employeeList.add(new Employee(1, "John", "IT", 70000, "New York"));
        employeeList.add(new Employee(2, "Emma", "Finance", 65000, "Los Angeles"));
        employeeList.add(new Employee(3, "Raj", "HR", 60000, "Chicago"));
        employeeList.add(new Employee(4, "Sophia", "Marketing", 75000, "San Francisco"));
        employeeList.add(new Employee(5, "Mike", "Operations", 68000, "Seattle"));

        return employeeList;
    }
}
