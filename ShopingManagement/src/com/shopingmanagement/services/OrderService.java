package com.shopingmanagement.services;

import com.shopingmanagement.model.Customer;
import com.shopingmanagement.model.LineItem;
import com.shopingmanagement.model.Order;
import com.shopingmanagement.model.Product;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.shopingmanagement.reposetory.OrderRepository.allOrders;

public class OrderService {

    // Place Order
    public void placeOrder(Customer customer){
        Map<String, LineItem> cart = customer.getCart();

        if(cart.isEmpty()){
            System.out.println("Your cart is empty.");
            return;
        }

        // Validate the stock
        for(LineItem lineItem : cart.values()){
            if(lineItem.getQuantity() > lineItem.getProduct().getProductStock()){
                System.out.println("Transaction Failed: " + lineItem.getProduct().getProductName() + " only has " + lineItem.getProduct().getProductStock() + " left in stock.");
                return;
            }
        }

        // actual order
        // decresing stock
        for (LineItem item : cart.values()) {
            Product p = item.getProduct();
            p.setProductStock(p.getProductStock() - item.getQuantity());
        }

        // storing object into order
        Order finalOrder = new Order(new Date(),cart);
        customer.getOrderHistory().add(finalOrder);
        allOrders.add(finalOrder);
        cart.clear();

        System.out.println("Order placed successfully.");
        System.out.println();
        System.out.println("Customer Name: "+ customer.getName());
        System.out.println("Date: "+ finalOrder.getOrderDate());

        double orderTotal = 0;
        for (LineItem item : cart.values()) {
            double itemCost = item.calculateLineItemTotal();
            orderTotal += itemCost;

            System.out.printf("%-5d | %-15s | %-10.2f | %-8d | %-10.2f\n",
                    item.getProduct().getProductId(),
                    item.getProduct().getProductName(),
                    item.getProduct().calculateDiscountedPrice(),
                    item.getQuantity(),
                    itemCost
            );
        }

        System.out.println("------------------------------------------------------------");
        System.out.printf("Total Order Value: $%.2f\n\n", orderTotal);



    }

    // View Order History
    public void viewOrderHistory(Customer customer){
        List<Order> orderHistory = customer.getOrderHistory();

        if (orderHistory.isEmpty()) {
            System.out.println("No past orders found for " + customer.getName());
            return;
        }

        System.out.println("\n=== Order History for " + customer.getName() + " ===");
        for (Order order : orderHistory) {
            System.out.println("Order ID: " + order.getOrderId() + " | Date: " + order.getOrderId());
            System.out.println("----------------------------------------------");
            for (LineItem item : order.getLineItemList().values()) {
                System.out.printf("Product: %s | Qty: %d | Cost: $%.2f\n",
                        item.getProduct().getProductName(),
                        item.getQuantity(),
                        item.calculateLineItemTotal());
            }
            System.out.println("----------------------------------------------\n");
        }

    }
}
