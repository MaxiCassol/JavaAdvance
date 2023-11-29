package ShoppingCart;

public class ProductServiceImpl implements ProductService {
    private ShoppingCart shoppingCart;

    public ProductServiceImpl(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void addProductToCart(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            shoppingCart.addProduct(product);
        }
    }
}
