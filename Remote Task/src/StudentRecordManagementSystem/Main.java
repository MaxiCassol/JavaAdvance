package StudentRecordManagementSystem;

import java.util.List;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        University university = new University();
        university.addStudent(new Student("Alice", 20, 1001, 3.8));
        university.addStudent(new Student("Bob", 22, 1002, 3.5));
        university.addStudent(new Student("Charlie", 21, 1003, 3.9));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sorting algorithm:");
        System.out.println("1. Selection Sort by GPA");
        System.out.println("2. Insertion Sort by Age");
        System.out.println("3. Heap Sort by Student ID");
        System.out.println("4. Sort by Student ID in reverse order");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                university.sortBy(Comparator.comparing(Student::getGPA));
                printSortedStudents(university.getStudents(), "GPA");
                break;
            case 2:
                university.sortBy(Comparator.comparing(Student::getAge));
                printSortedStudents(university.getStudents(), "Age");
                break;
            case 3:
                university.sortBy(Comparator.comparing(Student::getStudentID));
                printSortedStudents(university.getStudents(), "Student ID");
                break;
            case 4:
                university.sortBy(Comparator.comparing(Student::getStudentID).reversed());
                printSortedStudents(university.getStudents(), "Student ID (Reverse)");
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                return;
        }
    }

    private static void printSortedStudents(List<Student> students, String sortedAttribute) {
        System.out.println("\nAfter sorting by " + sortedAttribute + ":");
        for (Student student : students) {
            System.out.println(student.getName() + ": " + student.getStudentID());
        }
    }
}