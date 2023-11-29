package almacen;

public class Producto implements Comparable<Producto> {
    private String nombre;
    private String descripcion;
    private double precio;

    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public int compareTo(Producto otroProducto) {
        return Double.compare(this.precio, otroProducto.precio);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " /// " + descripcion + " /// Precio: $" + precio;
    }
}