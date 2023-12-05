package biblioteca;

class Libro {
    private String titulo;
    private double precio;
    private int stock;

    public Libro(String titulo, double precio, int stock) {
        this.titulo = titulo;
        this.precio = precio;
        this.stock = stock;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void restarStock(int cantidad) {
        stock -= cantidad;
    }

    public boolean hayStockSuficiente(int cantidad) {
        return stock >= cantidad;
    }
}

