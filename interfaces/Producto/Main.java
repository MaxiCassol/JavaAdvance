package interfaces.Producto;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // Crear una lista de productos
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("Producto1", 50.0, "001"));
        listaProductos.add(new Producto("Producto2", 30.0, "002"));
        listaProductos.add(new Producto("Producto3", 100.0, "003"));
        listaProductos.add(new Producto("Producto4", 10.0, "004"));
        listaProductos.add(new Producto("Producto5", 75.0, "005"));

        // Ordenar productos por precio
        listaProductos.sort(null);

        System.out.println("Productos ordenados por precio:");
        for (Producto producto : listaProductos) {
            System.out.println(producto);
        }

        System.out.println("\nProductos que son vendibles:");
        Filtrable vendibleFilter = LogicaFiltrable::esVendible;
        mostrarProductosFiltrados(listaProductos, vendibleFilter);

        System.out.println("\nProductos que son imperecederos:");
        Filtrable imperecederoFilter = LogicaFiltrable::esImperecedero;
        mostrarProductosFiltrados(listaProductos, imperecederoFilter);
    }

    public static void mostrarProductosFiltrados(List<Producto> productos, Filtrable filtro) {
        for (Producto producto : productos) {
            if (filtro.cumpleFiltro(producto)) {
                System.out.println(producto);
            }
        }
    }
}
