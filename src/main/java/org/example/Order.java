package org.example;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private Integer id;
    private Integer userId;
    private Map<Product, Integer> orderDetails;
    private double totalPrice;

    public Order(int id, int userId, Map<Product, Integer> orderDetails) {
        this.id = id;
        this.userId = userId;
        this.orderDetails = orderDetails;
    }

    public Order() {
        this.id = 0;
        this.userId = 0;
        this.orderDetails = new HashMap<>();
    }

    public void calculateTotalPrice() {
        totalPrice = orderDetails.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public Integer getId() {
        return id;
    }

    public void addProduct(Product product, int quantity) {
        orderDetails.put(product, quantity);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", userId=" + userId + ", orderDetails=" + orderDetails + ", totalPrice=" + totalPrice + '}';
    }
}
