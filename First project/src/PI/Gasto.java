package PI;

public class Gasto {
    private int id;
    private double cantidad;
    private String categoria;

    private static int contador = 1;

    public Gasto(double cantidad, String categoria) {
        this.id = contador++;
        this.cantidad = cantidad;
        this.categoria = categoria.toLowerCase();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static void setContador(int contador) {
        Gasto.contador = contador;
    }

    public int getId() {
        return id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public static int getContador() {
        return contador;
    }
}
