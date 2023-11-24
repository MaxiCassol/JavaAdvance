package biblioteca;
import java.util.Scanner;

public class SistemaGestionLibros {
    public static void main(String[] args) {
        Libro[] inventario = {
                new Libro("Libro 1", 19.99, 10),
                new Libro("Libro 2", 12.50, 5),
                new Libro("Libro 3", 29.95, 8)
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inventario de libros:");
        for (int i = 0; i < inventario.length; i++) {
            System.out.println(i + 1 + ". " + inventario[i].getTitulo() + " - Precio: $" + inventario[i].getPrecio() + " - Stock: " + inventario[i].getStock());
        }

        System.out.print("¿Qué libro deseas comprar? (Ingresa el número): ");
        int seleccion = scanner.nextInt();

        if (seleccion >= 1 && seleccion <= inventario.length) {
            Libro libroSeleccionado = inventario[seleccion - 1];

            System.out.print("¿Cuántas copias deseas comprar?: ");
            int cantidadCompra = scanner.nextInt();

            if (libroSeleccionado.hayStockSuficiente(cantidadCompra)) {
                Pedido pedido = new Pedido(libroSeleccionado, cantidadCompra);
                double total = pedido.calcularTotal();

                System.out.println("Has realizado un pedido de " + cantidadCompra + " copias de '" + libroSeleccionado.getTitulo() + "'.");
                System.out.println("El total a pagar es: $" + total);

                libroSeleccionado.restarStock(cantidadCompra);
                System.out.println("Stock actual de '" + libroSeleccionado.getTitulo() + "': " + libroSeleccionado.getStock());
            } else {
                System.out.println("Lo siento, no hay suficiente stock para tu pedido.");
            }
        } else {
            System.out.println("Selección no válida.");
        }
    }
}