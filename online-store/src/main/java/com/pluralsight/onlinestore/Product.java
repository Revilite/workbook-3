package com.pluralsight.onlinestore;

public class Product {
    //String colors
    String reset = "\033[1;0m";
    String blueForeground = "\033[1;34m";
    String magentaForeground = "\033[1;35m";
    String redForeground = "\033[1;31m";
    String greenForeground = "\033[1;32m";
    private String sku;
    private String productName;
    private double price;
    private String department;

    public Product(String sku, String productName, double price, String department) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.department = department;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        String sb = redForeground + "Product name: " + this.productName +
                blueForeground + " Price: $" + this.price +
                greenForeground + " Department: " + this.department +
                magentaForeground + " SKU: " + this.sku +
                reset;
        return sb;
    }
}
