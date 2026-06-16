package com.shopingmanagement.model;

public class LineItem {
    private static long nextId = 0;
    private String lineItemId;
    private int quantity;
    private Product product;

    public LineItem(int quantity, Product product) {
        this.lineItemId = "" + ++nextId;
        this.quantity = quantity;
        this.product = product;
    }

    public String getLineItemId() {
        return lineItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double calculateLineItemTotal(){
        return product.calculateDiscountedPrice() * quantity;
    }
}
