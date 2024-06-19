package Literature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LiteratureComposition {
    public static void main(String[] args) {
        // Compositions
        List<Student> students = new ArrayList<>();
        students.add(new Student("Juliet", "I'm Juliet, a diligent and ambitious student with a passion for literature."));
        students.add(new Student("Richard", "I'm Richard, a curious and inventive student fascinated by the world of science and technology."));
        students.add(new Student("Natasha", "I'm Natasha, a compassionate and driven student with a keen interest in social justice and activism."));
        students.add(new Student("Michael", "I'm Michael, a talented and versatile student with a passion for the arts."));

        processCompositions(students);
    }

    public static void processCompositions(List<Student> students) {
        int totalWords = 0;
        int studentCount = students.size();

        // Total words
        for (Student student : students) {
            String composition = student.getComposition();
            String[] words = composition.split("\\s+");
            totalWords += words.length;
        }

        // Average words
        int averageWordCount = totalWords / studentCount;

        // Two lists
        List<Student> belowAverage = new ArrayList<>();
        List<Student> aboveAverage = new ArrayList<>();

        // Divide students
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

        // Sort alphabetically
        Collections.sort(belowAverage, Comparator.comparing(Student::getName));
        Collections.sort(aboveAverage, Comparator.comparing(Student::getName));

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

class Student {
    private String name;
    private String composition;

    public Student(String name, String composition) {
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
