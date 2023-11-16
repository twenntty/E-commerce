package org.example;
import java.util.Map;
import java.util.HashMap;

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

    @Override
    public String toString() {
        return "Order{id=" + id + ", userId=" + userId + ", orderDetails=" + orderDetails + ", totalPrice=" + totalPrice + '}';
    }
}
