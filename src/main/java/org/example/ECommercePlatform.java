package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class ECommercePlatform {
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void createOrder(User user, Map<Product, Integer> orderDetails) {
        Order order = new Order(orders.size() + 1, user.getId(), orderDetails);
        order.calculateTotalPrice();
        orders.put(order.getId(), order);
    }

    public  void displayAvailableProducts() {
        System.out.println("Available Products:");
        for (Product product : products.values()) {
            System.out.println(product);
        }
        System.out.println();
    }

    public  void displayUsers() {
        System.out.println("Users:");
        for (User user : users.values()) {
            System.out.println(user);
        }
        System.out.println();
    }

    public void displayOrders() {
        System.out.println("Orders:");
        for (Order order : orders.values()) {
            System.out.println(order);
        }
        System.out.println();
    }

    public List<Product> recommendProducts(User user) {
        List<Product> recommendations = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : user.getCart().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            for (int i = 0; i < quantity; i++) {
                recommendations.add(product);
            }
        }

        return recommendations;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public User getUserById(int userId) {
        return users.get(userId);
    }
}
