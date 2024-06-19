package Literature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LiteratureComposition4 {
    public static void main(String[] args) {
        // Compositions
        List<Student> students = new ArrayList<>();
        students.add(new Student("Juliet", "I'm Juliet, a diligent and ambitious student with a passion for literature."));
        students.add(new Student("Richard", "I'm Richard, a curious and inventive student fascinated by the world of science and technology."));
        students.add(new Student("Natasha", "I'm Natasha, a compassionate and driven student with a keen interest in social justice and activism."));
        students.add(new Student("Michael", "I'm Michael, a talented and versatile student with a passion for the arts."));

        // Process compositions
        processCompositions(students);
    }

    public static void processCompositions(List<Student> students) {
        // Calculate total words
        int totalWords = 0;
        for (Student student : students) {
            String composition = student.getComposition();
            String[] words = composition.split("\\s+");
            totalWords += words.length;
        }

        // Calculate average words
        int studentCount = students.size();
        int averageWordCount = totalWords / studentCount;

        // Create lists for below average and above average students
        List<Student> belowAverage = new ArrayList<>();
        List<Student> aboveAverage = new ArrayList<>();

        // Divide students based on word count and sort them
        for (Student student : students) {
            String composition = student.getComposition();
            String[] words = composition.split("\\s+");
            int wordCount = words.length;

            if (wordCount < averageWordCount) {
                belowAverage.add(student);
            } else {
                aboveAverage.add(student);
            }
        }

        // Sort students based on the length of their compositions
        Collections.sort(belowAverage, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // Compare compositions by their length
                int len1 = s1.getComposition().split("\\s+").length;
                int len2 = s2.getComposition().split("\\s+").length;
                return Integer.compare(len1, len2);
            }
        });

        Collections.sort(aboveAverage, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // Compare compositions by their length
                int len1 = s1.getComposition().split("\\s+").length;
                int len2 = s2.getComposition().split("\\s+").length;
                return Integer.compare(len1, len2);
            }
        });

        // Output sorted lists of students
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

class Student4 {
    private String name;
    private String composition;

    // Constructor
    public Student4(String name, String composition) {
        this.name = name;
        this.composition = composition;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for composition
    public String getComposition() {
        return composition;
    }
}
