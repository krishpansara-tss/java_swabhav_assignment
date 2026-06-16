package com.shopingmanagement.reposetory;

import com.shopingmanagement.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    public static List<Order> allOrders = new ArrayList<>();

    public static void saveOrder(Order order) {
        allOrders.add(order);
    }


    // Retrieve ALL orders (useful for an "Admin Sales Report" feature)
    public static List<Order> getAllOrders() {
        return new ArrayList<>(allOrders);
    }
}
