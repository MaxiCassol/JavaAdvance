package interfaces.Producto;

public class LogicaFiltrable {
    public static boolean esVendible(Producto producto) {
        // Define aquí la lógica para determinar si un producto es "vendible"
        return producto.getPrecio() > 0;
    }

    public static boolean esImperecedero(Producto producto) {
        // Define aquí la lógica para determinar si un producto es "imperecedero"
        // Por ejemplo, podría ser un producto no perecedero como un libro.
        return false;
    }
}
