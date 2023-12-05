package estudiantes;
import java.util.List;

public class Estudiante {
    String nombre;
    int edad;
    List<Curso> cursos;

    public Estudiante(String nombre, int edad, List<Curso> cursos) {
        this.nombre = nombre;
        this.edad = edad;
        this.cursos = cursos;
    }
}
