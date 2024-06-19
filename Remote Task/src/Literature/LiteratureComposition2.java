package Literature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LiteratureComposition2 {
    public static void main(String[] args) {
        // Define students array
        List<Student> students = new ArrayList<>();
        students.add(new Student("Juliet", "I'm Juliet, a diligent and ambitious student with a passion for literature."));
        students.add(new Student("Richard", "I'm Richard, a curious and inventive student fascinated by the world of science and technology."));
        students.add(new Student("Natasha", "I'm Natasha, a compassionate and driven student with a keen interest in social justice and activism."));
        students.add(new Student("Michael", "I'm Michael, a talented and versatile student with a passion for the arts."));

        // Process compositions
        processCompositions(students);
    }

    public static void processCompositions(List<Student> students) {
        if (students == null || students.isEmpty()) {
            System.out.println("No students provided.");
            return;
        }

        int totalWords = 0;
        int studentCount = students.size();

        // Calculate total words
        for (Student student : students) {
            if (student == null || student.getComposition() == null) {
                continue;
            }
            String composition = student.getComposition();
            String[] words = composition.split("\\s+");
            totalWords += words.length;
        }

        if (totalWords == 0) {
            System.out.println("No words found in compositions.");
            return;
        }

        // Calculate average word count
        int averageWordCount = totalWords / studentCount;

        // Split students into two lists
        List<Student> belowAverage = new ArrayList<>();
        List<Student> aboveAverage = new ArrayList<>();

        // Classify students based on average word count
        for (Student student : students) {
            if (student == null || student.getComposition() == null) {
                continue;
            }
            String composition = student.getComposition();
            String[] words = composition.split("\\s+");
            int wordCount = words.length;

            if (wordCount < averageWordCount) {
                belowAverage.add(student);
            } else {
                aboveAverage.add(student);
            }
        }

        // Sort students alphabetically
        Collections.sort(belowAverage, Comparator.comparing(Student::getName));
        Collections.sort(aboveAverage, Comparator.comparing(Student::getName));

        // Display results
        System.out.println("Average word count: " + averageWordCount);
        System.out.println("Students below average:");

        for (Student student : belowAverage) {
            System.out.println(student.getName() + " - " + student.getComposition().split("\\s+").length + " words");
        }

        System.out.println("Students above average:");

        for (Student student : aboveAverage) {
            System.out.println(student.getName() + " - " + student.getComposition().split("\\s+").length + " words");
        }
    }
}

class Student2 {
    private String name;
    private String composition;

    public Student2(String name, String composition) {
        this.name = name;
        this.composition = composition;
    }

    public String getName() {
        return name;
    }

    public String getComposition() {
        return composition;
    }
}
