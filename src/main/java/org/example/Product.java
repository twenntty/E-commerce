package org.example;
import java.util.Comparator;

public class Product implements Comparable<Product>{
    private Integer id;
    private String name;
    private double price;
    private int stock;

    public Product(Integer id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + ", stock=" + stock + '}';
    }

    @Override
    public int compareTo(Product otherProduct) {
        return  Double.compare(this.price, otherProduct.price);
    }

}