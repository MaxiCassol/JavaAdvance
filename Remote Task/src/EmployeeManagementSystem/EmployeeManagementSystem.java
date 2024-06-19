package EmployeeManagementSystem;

import java.util.*;

public class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee object cannot be null.");
        }

        // Perform validation for employee details
        if (employee.getId() <= 0) {
            throw new IllegalArgumentException("Employee ID must be a positive integer.");
        }

        if (employee.getAge() < 18 || employee.getAge() > 100) {
            throw new IllegalArgumentException(employee.getName() + "'s age must be between 18 and 100.");
        }

        if (employee.getSalary() < 0) {
            throw new IllegalArgumentException("Employee salary cannot be negative.");
        }

        if (employee.getPosition() == null || employee.getPosition().isEmpty()) {
            throw new IllegalArgumentException("Employee position cannot be empty or null.");
        }

        employees.add(employee);
    }

    //Remove employee method
    public void removeEmployee(int employeeId) {
        if (employeeId <= 0) {
            throw new IllegalArgumentException("Employee ID must be a positive integer.");
        }

        boolean removed = employees.removeIf(e -> e.getId() == employeeId);
        if (!removed) {
            throw new NoSuchElementException("Employee with ID " + employeeId + " not found.");
        }
    }

    //Sorting options:
    public void sortEmployeesByName() {
        employees.sort(Comparator.comparing(Employee::getName));
    }

    public void sortEmployeesByAge() {
        employees.sort(Comparator.comparingInt(Employee::getAge));
    }

    public void sortEmployeesBySalary() {
        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
    }

    public void sortEmployeesByPosition() {
        employees.sort(Comparator.comparing(Employee::getPosition));
    }

    public void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
