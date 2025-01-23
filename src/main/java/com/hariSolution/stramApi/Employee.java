package com.hariSolution.stramApi;


import java.util.Locale;
import java.util.stream.Collectors;

public class Employee {
    private Integer id;
    private String name;
    private String department;
    private Integer salary;
    private String location;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary='" + salary + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employee(Integer id, String name, String department, Integer salary, String location) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.location = location;
    }

    public static void main(String[] args) {



       Double average= EmployeeRepository.createEmployeeList()
                .stream()
                .map(employee -> employee.salary).mapToInt(salary->salary).average().getAsDouble();

        System.out.println(average);

        int averageSomeEmployee=  EmployeeRepository
                .createEmployeeList()
                .stream()
                .filter(emp->emp.name.toUpperCase(Locale.ROOT).contains("A")).map(employee -> employee.salary).mapToInt(salary->salary).sum();

        System.out.println(averageSomeEmployee);







    }
}
