import java.util.Scanner;

public class ManipulacionDeStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Paso 1: Solicitar al usuario que ingrese una frase
        System.out.print("Ingresa una frase: ");
        String frase = scanner.nextLine();

        // Paso 2: Contar la cantidad de caracteres en la frase
        int cantidadCaracteres = frase.length();
        System.out.println("Cantidad de caracteres en la frase: " + cantidadCaracteres);

        // Paso 3: Verificar si la frase contiene una determinada palabra
        System.out.print("Ingresa una palabra para buscar en la frase: ");
        String palabraBuscada = scanner.nextLine();
        if (frase.contains(palabraBuscada)) {
            System.out.println("La frase contiene la palabra '" + palabraBuscada + "'.");
        } else {
            System.out.println("La frase no contiene la palabra '" + palabraBuscada + "'.");
        }

        // Paso 4: Convertir la frase a minúsculas y mayúsculas
        System.out.println("Frase en minúsculas: " + frase.toLowerCase());
        System.out.println("Frase en mayúsculas: " + frase.toUpperCase());

        // Paso 5: Imprimir solo la primera palabra de la frase
        int primerEspacio = frase.indexOf(" ");
        if (primerEspacio != -1) {
            String primeraPalabra = frase.substring(0, primerEspacio);
            System.out.println("Primera palabra de la frase: " + primeraPalabra);
        } else {
            System.out.println("La frase es una sola palabra: " + frase);
        }

        // Paso 6: Agregar 2 o más palabras en cualquier punto de la frase
        System.out.print("Agrega 2 o más palabras para insertar en la frase: ");
        String palabrasAInsertar = scanner.nextLine();
        System.out.print("Ingresa la posición (índice) donde quieres insertar las palabras: ");
        int indiceInsercion = scanner.nextInt();

        if (indiceInsercion >= 0 && indiceInsercion <= frase.length()) {
            StringBuilder fraseModificada = new StringBuilder(frase);
            fraseModificada.insert(indiceInsercion, palabrasAInsertar);
            System.out.println("Frase con palabras adicionales: " + fraseModificada.toString());
        } else {
            System.out.println("Índice de inserción no válido.");
        }
    }
}
