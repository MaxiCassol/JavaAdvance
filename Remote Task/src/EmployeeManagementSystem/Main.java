package EmployeeManagementSystem;

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        // Example usage with validation and error handling
        try {
            // Adding employees to order them later
            ems.addEmployee(new Employee(101, "John Doe", 30, 50000, "Manager"));
            ems.addEmployee(new Employee(102, "Alice Smith", 25, 45000, "Sales Associate"));
            ems.addEmployee(new Employee(103, "Marr Poppins", 85, 40000, "Sales Associate"));
            ems.addEmployee(new Employee(104, "Bob Marley", 35, 60000, "Supervisor"));

            // Attempt to add an employee with invalid details
            ems.addEmployee(new Employee(105, "Jane", 17, 1000, "Intern")); // This should throw exceptions

        } catch (IllegalArgumentException e) {
            // Extract name and ID from the message of the exception
            String errorMessage = e.getMessage();
            System.err.println(errorMessage);
        }

        // Sorting and printing employees by name
        ems.sortEmployeesByName();
        System.out.println("Sorted by Name:");
        ems.printEmployees();

        // Sorting and printing employees by age
        ems.sortEmployeesByAge();
        System.out.println("\nSorted by Age in ascending order:");
        ems.printEmployees();

        // Sorting and printing employees by salary
        ems.sortEmployeesBySalary();
        System.out.println("\nSorted by Salary in descending order:");
        ems.printEmployees();

        // Sorting and printing employees by position
        ems.sortEmployeesByPosition();
        System.out.println("\nSorted by Position:");
        ems.printEmployees();
    }
}


