package org.example;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ECommercePlatformTest {

    @Test
    public void testECommercePlatform() {
        // Create and initialize the platform
        ECommercePlatform platform = new ECommercePlatform();

        User user1 = new User(1, "Ann");
        User user2 = new User(2, "Mark");

        Product product1 = new Product(1, "apple", 20.0, 50);
        Product product2 = new Product(2, "orange", 30.0, 100);

        // Test adding users and products
        platform.addUser(user1);
        platform.addUser(user2);
        platform.addProduct(product1);
        platform.addProduct(product2);

        assertNotNull(platform.getUserById(1));
        assertNotNull(platform.getUserById(2));
        assertNotNull(platform.getProducts().get(1));
        assertNotNull(platform.getProducts().get(2));

        Map<Product, Integer> orderDetailsUser1 = new HashMap<>();
        orderDetailsUser1.put(product1, 3);
        orderDetailsUser1.put(product2, 2);

        Map<Product, Integer> orderDetailsUser2 = new HashMap<>();
        orderDetailsUser2.put(product2, 1);

        platform.createOrder(user1, orderDetailsUser1);
        platform.createOrder(user2, orderDetailsUser2);

        platform.displayAvailableProducts();
        platform.displayUsers();
        platform.displayOrders();
    }
}
