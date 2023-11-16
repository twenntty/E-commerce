package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserConstructorAndGetters() {
        User user = new User(1, "John");

        assertEquals(1, user.getId());
        assertEquals("John", user.getUsername());
        assertNotNull(user.getCart());
    }

    @Test
    public void testAddToCart() {
        User user = new User(1, "John");
        Product product = new Product(1, "apple", 20.0, 50);

        user.addToCart(product, 3);

        assertEquals(3, user.getCart().get(product));
    }

    @Test
    public void testRemoveFromCart() {
        User user = new User(1, "John");
        Product product = new Product(1, "apple", 20.0, 50);

        user.addToCart(product, 3);
        user.removeFromCart(product);

        assertNull(user.getCart().get(product));
    }
}
