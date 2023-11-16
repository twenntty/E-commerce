package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OrderTest {

    @Test
    public void testCalculateTotalPrice() {
        Order order = new Order();
        Product product1 = new Product(1, "apple", 20.0, 2);
        Product product2 = new Product(2, "orange", 30.0, 3);

        order.addProduct(product1, 2);
        order.addProduct(product2, 3);

        order.calculateTotalPrice();

        double expectedTotalPrice = 2 * 20.0 + 3 * 30.0;
        assertEquals(expectedTotalPrice, order.getTotalPrice(), 0.001);
    }
}
