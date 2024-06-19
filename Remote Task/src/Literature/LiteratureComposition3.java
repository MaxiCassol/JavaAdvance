package Literature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LiteratureComposition3 {
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
        int totalWords = 0;

        // Calculate total words and divide students into below and above average lists
        for (Student student : students) {
            String composition = student.getComposition();
            String[] words = composition.split("\\s+");
            totalWords += words.length;
        }

        // Calculate average word count
        int studentCount = students.size();
        int averageWordCount = totalWords / studentCount;

        // Create lists for below average and above average students
        List<Student> belowAverage = new ArrayList<>();
        List<Student> aboveAverage = new ArrayList<>();

        // Divide students based on word count
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

        // Sort below and above average lists based on the length of compositions
        Collections.sort(belowAverage, Comparator.comparingInt(s -> s.getComposition().split("\\s+").length));
        Collections.sort(aboveAverage, Comparator.comparingInt(s -> s.getComposition().split("\\s+").length));

        // Output total words
        System.out.println("Total words written in all compositions: " + totalWords);

        // Output sorted lists of students
        System.out.println("Students below average:");
        belowAverage.forEach(s -> System.out.println(s.getName() + " - " + s.getComposition().split("\\s+").length + " words"));

        System.out.println("Students above average:");
        aboveAverage.forEach(s -> System.out.println(s.getName() + " - " + s.getComposition().split("\\s+").length + " words"));
    }
}

class Student3 {
    private String name;
    private String composition;

    // Constructor
    public Student3(String name, String composition) {
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
