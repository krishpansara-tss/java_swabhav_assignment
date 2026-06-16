package com.shopingmanagement.model;

public class Product {
    private static long nextId = 100;
    private String productId;
    private String productName;
    private double price;
    private double discountPercentage;
    private int productStock;

    public Product(String productName, double price, double discountPercentage, int productStock) {
        this.productId = "PID" + ++nextId;
        this.productName = productName;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.price = price;;
        this.productStock = productStock;
    }

    public String getProductId() {
        return productId;
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

    public double getDiscountPercentage() {
        return discountPercentage;
    }
    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public double calculateDiscountedPrice() {
        return price - (price * discountPercentage / 100);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", productStock=" + productStock +
                '}';
    }
}
