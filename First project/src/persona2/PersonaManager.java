package persona2;

import java.util.Arrays;
import java.util.List;

public class PersonaManager {
    public static void main(String[] args) {
        // Crear lista de objetos Persona
        List<Persona> personas = Arrays.asList(
                new Persona("Juan", "25", "programar"),
                new Persona("Maria", "30", "leer"),
                new Persona("Pedro", "22", "programar"),
                new Persona("Ana", "19", "viajar"),
                new Persona("Luis", "28", "programar"),
                new Persona("Laura", "35", "cocinar")
        );

        // a) Filtrar las personas que sean mayores de 18 años y cuyos hobbies incluyan la palabra "programar"
        System.out.println("Personas mayores de 18 años con hobby 'programar':");
        personas.stream()
                .filter(persona -> Integer.parseInt(persona.edad) > 18 && persona.hobby.contains("programar"))
                .forEach(persona -> System.out.println(persona.nombre));

        // b) Obtener una lista con los nombres de todas las personas
        System.out.println("\nLista de nombres de todas las personas:");
        personas.stream()
                .map(persona -> persona.nombre)
                .forEach(System.out::println);

        // c) Limitar la lista de personas a un máximo de 5 personas
        System.out.println("\nLista de nombres de las primeras 5 personas:");
        personas.stream()
                .limit(5)
                .map(persona -> persona.nombre)
                .forEach(System.out::println);

        // d) Imprimir los nombres de todas las personas en la lista
        System.out.println("\nImprimir los nombres de todas las personas:");
        personas.stream()
                .map(persona -> persona.nombre)
                .forEach(System.out::println);
    }
}
