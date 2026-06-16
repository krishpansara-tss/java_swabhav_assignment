package com.shopingmanagement.services;

import com.shopingmanagement.exceptions.ProductNotFound;
import com.shopingmanagement.model.Customer;
import com.shopingmanagement.model.LineItem;
import com.shopingmanagement.model.Product;

import java.util.List;
import java.util.Map;

public class CartService {

    //  Add Product to Cart
    public void addToCart(Customer customer, String productId, int quantity) throws ProductNotFound {
        Product product = ProductService.findProductById(productId);

        if(product.getProductStock() < quantity){
            System.out.println("Error: No enough stock available");
            return;
        }

        Map<String, LineItem> cart = customer.getCart();

        LineItem lineItem = cart.get(productId);

        if(lineItem == null){
            cart.put(productId, new LineItem(quantity, product));
            System.out.println("Item added to cart successfully");
            return;
        }

        int newQuantity = lineItem.getQuantity() + quantity;

        if(newQuantity > product.getProductStock()){
            System.out.println("Error: Cannot add more. Exceeds available stock");
            return;
        }

        lineItem.setQuantity(newQuantity);
        System.out.println("Updated quantity of product into cart");

    }

    // Remove Product from Cart
    public void removeFromCart(Customer customer, String productId) throws ProductNotFound {
        Product product = ProductService.findProductById(productId);

        Map<String, LineItem> cart =  customer.getCart();

        if(cart.isEmpty()){
            System.out.println("Your cart is empty.");
            return;
        }

        LineItem remove = cart.remove(productId);

        if(remove == null){
            System.out.println("Error: Product doesn't exist into cart.");
            return;
        }

        System.out.println("Product removed from cart Successfully");

    }

    // View Cart
    public void viewCart(Customer customer){
        Map<String, LineItem> cart = customer.getCart();

        if(cart.isEmpty()){
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("\n--- Your Shopping Cart ---");
        System.out.printf("%-5s | %-15s | %-10s | %-8s | %-10s\n", "ID", "Product", "Price", "Qty", "Total Cost");
        System.out.println("------------------------------------------------------------");

        double cartTotal = 0;
        for (LineItem item : cart.values()) {
            double itemCost = item.calculateLineItemTotal();
            cartTotal += itemCost;

            System.out.printf("%-5d | %-15s | %-10.2f | %-8d | %-10.2f\n",
                    item.getProduct().getProductId(),
                    item.getProduct().getProductName(),
                    item.getProduct().calculateDiscountedPrice(),
                    item.getQuantity(),
                    itemCost
            );
        }

        System.out.println("------------------------------------------------------------");
        System.out.printf("Total Cart Value: $%.2f\n\n", cartTotal);

    }
}
