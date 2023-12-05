package CRUD.dao.dto;

public class ProductDto {

    private String name;
    private double price;

    // Constructor vacío
    public ProductDto() {
    }

    // Constructor con parámetros
    public ProductDto(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters y setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Método toString para representación de cadena
    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
