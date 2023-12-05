package ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public int getTotalProducts() {
        return this.products.size();
    }

    public List<Product> getProducts() {
        return new ArrayList<>(this.products); // Devolvemos una copia para evitar modificaciones externas
    }
}
