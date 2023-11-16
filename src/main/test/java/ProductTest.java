package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testProductConstructorAndGetters() {
        Product product = new Product(1, "apple", 20.0, 50);

        assertEquals(1, product.getId());
        assertEquals("apple", product.getName());
        assertEquals(20.0, product.getPrice(), 0.01);
        assertEquals(50, product.getStock());
    }

    @Test
    public void testToString() {
        Product product = new Product(1, "apple", 20.0, 50);

        String expectedString = "Product{id=1, name='apple', price=20.0, stock=50}";
        assertEquals(expectedString, product.toString());
    }
}