package almacen;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = cargarProductos();

        // Lista de productos
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        System.out.println("=============================");

        // Encontrar el producto más caro y el más barato
        Producto productoMasCaro = Collections.max(productos);
        Producto productoMasBarato = Collections.min(productos);

        System.out.println("Producto más caro: " + productoMasCaro.getNombre());
        System.out.println("Producto más barato: " + productoMasBarato.getNombre());
    }

    private static List<Producto> cargarProductos() {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Coca-Cola Zero", "Litros: 1.5", 20));
        productos.add(new Producto("Coca-Cola", "Litros: 1.5", 18));
        productos.add(new Producto("Shampoo Sedal", "Contenido: 500ml", 19));
        productos.add(new Producto("Frutillas", "Unidad de venta: kilo", 64));

        return productos;
    }
}