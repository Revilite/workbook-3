package com.pluralsight.onlinestore;

public class Product {
    private String sku;
    private String productName;
    private double price;
    private String electronics;

    public Product(String sku, String productName, double price, String electronics) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.electronics = electronics;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setElectronics(String electronics) {
        this.electronics = electronics;
    }

    public String getSku() {
        return sku;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getElectronics() {
        return electronics;
    }
}
