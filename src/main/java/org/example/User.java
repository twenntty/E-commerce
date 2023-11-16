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

    public void removeFromCart(Product product, int quantity) {
        if (cart.containsKey(product)){
            int updatedQuantity = cart.get(product) - quantity;
            if (updatedQuantity > 0) {
                cart.put(product, updatedQuantity);
            } else {
                cart.remove(product);
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public Map<Product, Integer> getCart() {
        return null;
    }

    @Override
    public  String toString() {
        return "User{id=" + id + ", username='" + username + "', cart=" + cart + '}';
    }
}
