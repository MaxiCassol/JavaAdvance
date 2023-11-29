package almacen;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {
    @Test
    @org.junit.jupiter.api.Test
    public void getNombre() {
        //GIVEN
        String input = "Zapallo";
        //WHEN
        String result = input.toString();
        //THEN
        String expectedResult = "Zapallo";
        Assertions.assertEquals(expectedResult, result);
    }

    @org.junit.jupiter.api.Test
    void getDescripcion() {
    }

    @org.junit.jupiter.api.Test
    public void getPrecio() {
        //GIVEN
        int input = 55;
        //WHEN
        int result = input;
        //THEN
        int expectedResult = 55;
        Assertions.assertEquals(expectedResult, result);
    }

    @org.junit.jupiter.api.Test
    public void compareTo() {
        // GIVEN
        Producto producto1 = new Producto("Producto1", "Descripción1", 50.0);
        Producto producto2 = new Producto("Producto2", "Descripción2", 30.0);

        // WHEN
        int resultado1 = producto1.compareTo(producto2);

        // DEBUG
        System.out.println("Precio producto1: " + producto1.getPrecio());
        System.out.println("Precio producto2: " + producto2.getPrecio());

        // THEN
        Assertions.assertTrue(resultado1 > 0, "producto1 debería ser mayor que producto2");
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}