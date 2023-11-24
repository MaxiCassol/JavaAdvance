package utilidades;
import java.util.List;

public class Utilidades {

    // Método para imprimir elementos de cualquier tipo en la lista
    public static <T> void imprimirElementos(List<T> lista) {
        for (T elemento : lista) {
            System.out.println(elemento);
        }
    }

    // Método para copiar elementos de la lista de origen a la lista de destino
    // Usando bounded generic para asegurar que la lista de destino sea del mismo tipo o superclase
    public static <T, U extends T> void copiarElementos(List<? extends T> origen, List<? super T> destino) {
        destino.addAll(origen);
    }

    public static void main(String[] args) {
        // Ejemplo con listas de diferentes tipos: Integer, String, y una clase personalizada

        // Lista de enteros
        List<Integer> listaEnteros = List.of(1, 2, 3, 4, 5);
        System.out.println("Elementos de la lista de enteros:");
        imprimirElementos(listaEnteros);

        // Lista de cadenas de texto
        List<String> listaCadenas = List.of("Hola", "Mundo", "Java", "Generics");
        System.out.println("\nElementos de la lista de cadenas:");
        imprimirElementos(listaCadenas);

        // Lista de una clase personalizada (por ejemplo, Persona)
        List<Persona> listaPersonas = List.of(new Persona("Juan", 25), new Persona("María", 30));
        System.out.println("\nElementos de la lista de personas:");
        imprimirElementos(listaPersonas);

        // Copiar elementos de una lista a otra (enteros a objetos)
        List<Object> listaDestino = new java.util.ArrayList<>();
        copiarElementos(listaEnteros, listaDestino);
        System.out.println("\nElementos de la lista de destino después de copiar enteros:");
        imprimirElementos(listaDestino);
    }
}

// Clase de ejemplo para representar una Persona

