package com.shopingmanagement.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private static long nextId = 100;
    private String customerId;
    private String name;
    private List<Order> orderHistory = new ArrayList<>();
    private Map<String, LineItem> cart = new HashMap<>();

    public Customer(String name) {
        this.customerId = "CID" + ++nextId;
        this.name = name;
        this.orderHistory = new ArrayList<>();
        this.cart = new HashMap<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }
    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public Map<String, LineItem> getCart() {
        return cart;
    }
    public void setCart(Map<String, LineItem> cart) {
        this.cart = cart;
    }
}
