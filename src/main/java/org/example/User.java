package org.example;

import java.util.HashMap;
import java.util.Map;

public class User {
    private  Integer id;
    private String username;
    private Map<Product, Integer> cart;

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
        this.cart = new HashMap<>();
    }

    public void addToCart (Product product, int quantity) {
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void removeFromCart(Product product) {
        cart.remove(product);
    }

    public Integer getId() {
        return id;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public  String toString() {
        return "User{id=" + id + ", username='" + username + "', cart=" + cart + '}';
    }
}
