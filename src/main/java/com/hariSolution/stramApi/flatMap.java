package com.hariSolution.stramApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


class Employees {
    private Integer id;
    private String name;
    private String department;
    private final Double salary;

    // Constructor
    public Employees(Integer id, String name, String department, Double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getter for name and salary (used in processing)
    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
    }
}

class Department {
    private String departmentName;
    private List<Employees> employees;

    // Constructor
    public Department(String departmentName, List<Employees> employees) {
        this.departmentName = departmentName;
        this.employees = employees;
    }

    // Getter for employees
    public List<Employees> getEmployees() {
        return employees;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

public class flatMap {
    public static void main(String[] args) {
        List<Employees> itEmployees = Arrays.asList(new Employees(1, "John", "IT", 75000.0), new Employees(2, "Jane", "IT", 80000.0));

        List<Employees> hrEmployees = Arrays.asList(new Employees(3, "Alice", "HR", 60000.0), new Employees(4, "Bob", "HR", 65000.0));

        List<Employees> financeEmployees = Arrays.asList(new Employees(5, "Charlie", "Finance", 90000.0), new Employees(6, "David", "Finance", 85000.0));

        // Create departments
        List<Department> departments = Arrays.asList(new Department("IT", itEmployees), new Department("HR", hrEmployees), new Department("Finance", financeEmployees));

        List<Employees> allEmployees = departments.stream().flatMap(department -> department.getEmployees().stream()).collect(Collectors.toList());

        allEmployees.forEach(System.out::println);

        Employees highestPaidEmployee = allEmployees.stream().max(Comparator.comparing(Employees::getSalary)).get();

        System.out.println(highestPaidEmployee);


    }

    /*All Employees:
Employee [id=1, name=John, department=IT, salary=75000.0]
Employee [id=2, name=Jane, department=IT, salary=80000.0]
Employee [id=3, name=Alice, department=HR, salary=60000.0]
Employee [id=4, name=Bob, department=HR, salary=65000.0]
Employee [id=5, name=Charlie, department=Finance, salary=90000.0]
Employee [id=6, name=David, department=Finance, salary=85000.0]

Highest Paid Employee:
Employee [id=5, name=Charlie, department=Finance, salary=90000.0]
*/
}
