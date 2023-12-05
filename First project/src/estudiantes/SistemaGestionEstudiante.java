package estudiantes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SistemaGestionEstudiante {
    public static void main(String[] args) {
        // Instanciar una lista de Estudiante y agregar 5 o más estudiantes a la misma
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Estudiante1", 23, Arrays.asList(new Curso("Introducción a la Programación"), new Curso("Java Básico"))));
        estudiantes.add(new Estudiante("Estudiante2", 28, Arrays.asList(new Curso("Introducción a la Programación"), new Curso("Java Avanzado"))));
        estudiantes.add(new Estudiante("Estudiante3", 22, Arrays.asList(new Curso("Java Avanzado"), new Curso("Bases de Datos"))));
        estudiantes.add(new Estudiante("Estudiante4", 30, Arrays.asList(new Curso("Bases de Datos"), new Curso("Web Development"))));
        estudiantes.add(new Estudiante("Estudiante5", 26, Arrays.asList(new Curso("Web Development"), new Curso("Introducción a la Programación"))));

        // Filtrar los estudiantes que estén anotados al curso "Introducción a la Programación" y mostrar por consola
        List<Estudiante> estudiantesCurso = filtrarEstudiantesPorCurso(estudiantes, "Introducción a la Programación");
        System.out.println("Estudiantes anotados a 'Introducción a la Programación':");
        estudiantesCurso.forEach(estudiante -> System.out.println(estudiante.nombre));

        // Filtrar todos los estudiantes mayores de 25 años y mostrar por consola
        List<Estudiante> estudiantesMayores = filtrarEstudiantesPorEdad(estudiantes, edad -> edad > 25);
        System.out.println("\nEstudiantes mayores de 25 años:");
        estudiantesMayores.forEach(estudiante -> System.out.println(estudiante.nombre));

        // Filtrar un estudiante de la lista y mapear todos los cursos a los que está anotado
        String nombreEstudiante = "Estudiante3";
        List<Curso> cursosEstudiante = obtenerCursosDeEstudiante(estudiantes, nombreEstudiante);
        System.out.println("\nCursos del estudiante '" + nombreEstudiante + "':");
        cursosEstudiante.forEach(curso -> System.out.println(curso.nombre));
    }

    // Método para filtrar estudiantes por curso
    private static List<Estudiante> filtrarEstudiantesPorCurso(List<Estudiante> estudiantes, String nombreCurso) {
        return estudiantes.stream()
                .filter(estudiante -> estudiante.cursos.stream().anyMatch(curso -> curso.nombre.equals(nombreCurso)))
                .collect(Collectors.toList());
    }

    // Método para filtrar estudiantes por edad usando un Predicate
    private static List<Estudiante> filtrarEstudiantesPorEdad(List<Estudiante> estudiantes, Predicate<Integer> condicionEdad) {
        return estudiantes.stream()
                .filter(estudiante -> condicionEdad.test(estudiante.edad))
                .collect(Collectors.toList());
    }

    // Método para obtener los cursos de un estudiante específico
    private static List<Curso> obtenerCursosDeEstudiante(List<Estudiante> estudiantes, String nombreEstudiante) {
        return estudiantes.stream()
                .filter(estudiante -> estudiante.nombre.equals(nombreEstudiante))
                .flatMap(estudiante -> estudiante.cursos.stream())
                .collect(Collectors.toList());
    }
}
