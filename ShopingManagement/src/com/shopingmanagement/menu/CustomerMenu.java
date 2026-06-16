package com.shopingmanagement.menu;

import com.shopingmanagement.model.Customer;
import com.shopingmanagement.services.CartService;
import com.shopingmanagement.services.OrderService;
import com.shopingmanagement.services.ProductService;

import java.util.Scanner;

import static com.shopingmanagement.services.AdminService.adminLogin;
import static com.shopingmanagement.validator.InputValidator.*;

public class CustomerMenu {
    public static void customerMenu(ProductService productService, CartService cartService, OrderService orderService, Customer customer) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\nChoose the following Operation: ");
            System.out.println("1. View All Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. View Order History");
            System.out.println("7. Return to main menu");
            int choice = inputMenuOption("Enter your choice: ", 1, 7);
            switch (choice) {
                //            View All Products
                case 1:
                    productService.displayAllProduct();
                    break;

                //            Add Product to Cart
                case 2:
                    System.out.println("Enter Product Id to to add in cart: ");
                    String productId = inputProductId();
                    int quantity = inputQuantity();
                    try{
                        cartService.addToCart(customer, productId, quantity);
                    } catch (RuntimeException e) {
                        System.out.println("ERROR::" + e.getMessage());
                    }
                    break;

                //            Remove Product from Cart
                case 3:
                    System.out.println("Enter Product Id to to remove from the cart: ");
                    productId = inputProductId();
                    try{
                        cartService.removeFromCart(customer, productId);
                    } catch (RuntimeException e) {
                        System.out.println("ERROR::" + e.getMessage());
                    }
                    break;

                // View Cart
                case 4:
                    cartService.viewCart(customer);
                    break;

                // Place Order
                case 5:
                    orderService.placeOrder(customer);
                    break;
                //            View Order History

                case 6:
                    orderService.viewOrderHistory(customer);
                    break;

                case 7:
                    System.out.println("Returning to main Menu");
                    return;

                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}