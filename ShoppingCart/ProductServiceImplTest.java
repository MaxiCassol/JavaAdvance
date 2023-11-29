package ShoppingCart;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

    @Test
    public void testAddProductToCart() {
        // Crear un carrito de compras simulado con Mockito
        ShoppingCart mockShoppingCart = Mockito.mock(ShoppingCart.class);

        // Crear una instancia de ProductServiceImpl con el carrito simulado
        ProductService productService = new ProductServiceImpl(mockShoppingCart);

        // Crear un producto simulado
        Product mockProduct = Mockito.mock(Product.class);

        // Agregar el producto al carrito (llamando al método addProductToCart)
        productService.addProductToCart(mockProduct, 3);

        // Verificar que el método addProduct se llamó correctamente en el carrito simulado
        verify(mockShoppingCart, times(3)).addProduct(mockProduct);
    }
}
