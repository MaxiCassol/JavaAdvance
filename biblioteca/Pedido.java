package biblioteca;

    public class Pedido {
    private Libro libro;
    private int cantidad;

    public Pedido(Libro libro, int cantidad) {
        this.libro = libro;
        this.cantidad = cantidad;
    }

    public double calcularTotal() {
        return libro.getPrecio() * cantidad;
    }

    public Libro getLibro() {
        return libro;
    }

    public int getCantidad() {
        return cantidad;
    }
}