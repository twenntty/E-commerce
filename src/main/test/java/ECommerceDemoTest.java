package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ECommerceDemoTest {

    @Test
    public void testECommerceDemo() {
        ECommercePlatform platform = new ECommercePlatform();

        User user1 = new User(1, "Ann");
        User user2 = new User(2, "Mark");

        Product product1 = new Product(1, "apple", 20.0, 50);
        Product product2 = new Product(2, "orange", 30.0, 100);

        platform.addUser(user1);
        platform.addUser(user2);

        platform.addProduct(product1);
        platform.addProduct(product2);

        user1.addToCart(product1, 3);
        user2.addToCart(product2, 2);

        platform.createOrder(user1, user1.getCart());
        platform.createOrder(user2, user2.getCart());

        platform.displayAvailableProducts();
        platform.displayUsers();
        platform.displayOrders();

        User user = platform.getUserById(1);
        assertNotNull(user);

    }
}
