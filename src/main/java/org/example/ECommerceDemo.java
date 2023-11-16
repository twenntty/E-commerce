package org.example;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ECommerceDemo {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        User user1 = new User(1, "Ann");
        User user2 = new User(2, "Mark");
        User user3 = new User(3, "Sasha");

        Product product1 = new Product(1, "apple", 20.0, 50);
        Product product2 = new Product(2, "orange", 30.0, 100);
        Product product3 = new Product(3, "kiwi", 50.0, 10);

        platform.addUser(user1);
        platform.addUser(user2);
        platform.addUser(user3);

        platform.addProduct(product1);
        platform.addProduct(product2);
        platform.addProduct(product3);

        user3.addToCart(product2, 1);
        user3.addToCart(product1, 1);

        user1.addToCart(product3, 4);

        user2.addToCart(product2, 5);
        user2.addToCart(product3, 2);
        user2.addToCart(product1, 1);

        platform.createOrder(user1, user1.getCart());
        platform.createOrder(user2, user2.getCart());
        platform.createOrder(user3, user3.getCart());

        platform.displayAvailableProducts();
        platform.displayUsers();
        platform.displayOrders();

        displaySortedProductsByName(platform);
        displaySortedProductsByStock(platform);

        User user = platform.getUserById(1);
        displayRecommendations(platform, user);
    }

    public static void displaySortedProductsByName(ECommercePlatform platform) {
        Collection<Product> productCollection = platform.getProducts();
        List<Product> productList = new ArrayList<>(productCollection);
        Collections.sort(productList, new ProductNameComparator());

        System.out.println("Products Sorted by Name:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static void displaySortedProductsByStock(ECommercePlatform platform) {
        Collection<Product> productCollection = platform.getProducts();
        List<Product> productList = new ArrayList<>(productCollection);
        Collections.sort(productList, new ProductStockComparator());

        System.out.println("Products Sorted by Stock:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public static void displayAvailableProducts(ECommercePlatform platform) {
        System.out.println("Available Products:");
        for (Product product : platform.getProducts().values()) {
            if (product.getStock() > 0) {
                System.out.println(product);
            }
        }
    }

    public static void displayRecommendations(ECommercePlatform platform, User user) {
        List<Product> recommendations = platform.recommendProducts(user);

        System.out.println("Recommended Products:");
        for (Product product : recommendations) {
            System.out.println(product);
        }
    }
}