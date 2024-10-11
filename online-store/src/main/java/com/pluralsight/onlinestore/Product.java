package com.pluralsight.onlinestore;

public class Product {
    private String sku;
    private String productName;
    private double price;
    private String department;

    //String colors
    String reset = "\033[1;0m";
    String blueForeground = "\033[1;34m";
    String magentaForeground = "\033[1;35m";
    String redForeground = "\033[1;31m";
    String greenForeground = "\033[1;32m";

    public Product(String sku, String productName, double price, String department) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.department = department;
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

    public void setDepartment(String department) {
        this.department = department;
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

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(redForeground).append("Product name: ").append(this.productName);
        sb.append(blueForeground).append(" Price: $").append(this.price);
        sb.append(greenForeground).append(" Department: ").append(this.department);
        sb.append(magentaForeground).append(" SKU: ").append(this.sku);
        sb.append(reset);
        return sb.toString();
    }
}
