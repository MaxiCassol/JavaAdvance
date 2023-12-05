package registroDeAlumnos;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentRecord {
    private Map<String, Integer> studentMap;

    public StudentRecord() {
        studentMap = new HashMap<>();
    }

    public void addStudent(String name, int grade) {
        studentMap.put(name, grade);
    }

    public void removeStudent(String name) {
        studentMap.remove(name);
    }

    public Integer getGrade(String name) {
        return studentMap.get(name);
    }

    public boolean isStudentInRecord(String name) {
        return studentMap.containsKey(name);
    }

    public static void main(String[] args) {
        StudentRecord studentRecord = new StudentRecord();

        // Agregar alumnos y calificaciones
        studentRecord.addStudent("Juan", 90);
        studentRecord.addStudent("Maria", 85);
        studentRecord.addStudent("Pedro", 78);

        // Verificar si un alumno está en el registro
        System.out.println("¿Está Juan en el registro? " + studentRecord.isStudentInRecord("Juan"));

        // Obtener la calificación de un alumno
        System.out.println("Calificación de Pedro: " + studentRecord.getGrade("Pedro"));

        // Eliminar a un alumno
        studentRecord.removeStudent("Maria");

        // Verificar si una calificación está en el registro
        System.out.println("¿Está la calificación 85 en el registro? " + studentRecord.studentMap.containsValue(85));

        // Obtener un conjunto de nombres de alumnos
        Set<String> studentNames = studentRecord.studentMap.keySet();
        System.out.println("Nombres de alumnos en el registro: " + studentNames);
    }
}
