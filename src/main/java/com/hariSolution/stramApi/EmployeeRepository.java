package com.hariSolution.stramApi;

import java.util.ArrayList;
import java.util.List;

// Repository class for Employee data
public class EmployeeRepository {

    // Static method to create and return a list of employees
    public static List<Employees> createEmployeeList() {
        List<Employees> employeeList = new ArrayList<>();

        // Add 5 employee objects to the list
        employeeList.add(new Employees(1, "John", "IT", 70000, "New York"));
        employeeList.add(new Employees(2, "Emma", "Finance", 65000, "Los Angeles"));
        employeeList.add(new Employees(3, "Raj", "HR", 60000, "Chicago"));
        employeeList.add(new Employees(4, "Sophia", "Marketing", 75000, "San Francisco"));
        employeeList.add(new Employees(5, "Mike", "Operations", 68000, "Seattle"));

        return employeeList;
    }
}
