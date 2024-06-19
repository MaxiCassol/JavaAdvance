package StudentRecordManagementSystem;

class Student {
    private String name;
    private int age;
    private int studentID;
    private double GPA;

    public Student(String name, int age, int studentID, double GPA) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStudentID() {
        return studentID;
    }

    public double getGPA() {
        return GPA;
    }
}