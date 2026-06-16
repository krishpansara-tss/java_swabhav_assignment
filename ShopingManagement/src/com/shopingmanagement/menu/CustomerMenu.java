package com.shopingmanagement.menu;

import com.shopingmanagement.model.Customer;
import com.shopingmanagement.services.ProductService;

import java.util.Scanner;

import static com.shopingmanagement.services.AdminService.adminLogin;

public class CustomerMenu {
    public static void customerMenu(ProductService productService, Customer customer){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nChoose the following Operation: ");
        System.out.println("1. View All Products");
        System.out.println("2. Add Product to Cart");
        System.out.println("3. Remove Product from Cart");
        System.out.println("4. View Cart");
        System.out.println("4. Place Order");
        System.out.println("5. View Order History");
        System.out.println("6. Break");
        System.out.print("Enter your choice:");

        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter UserName: ");
                String username = scanner.nextLine();
                System.out.println("Enter Password: ");
                String password = scanner.nextLine();

                if(adminLogin(username, password)){
                    System.out.println("Admin logged in successfully");
                    AdminMenu.adminMenu();
                }
                break;

            case 2:
                System.out.println("Enter your userId: ");
                String userID = scanner.nextLine();
                Customer customer = customerService.loginCustomer(userID);
                if(customer != null){
                    CustomerMenu.customerMenu(customer);
                }
                break;

            case 3:
                System.out.println("Enter your name: ");
                String customerName = scanner.nextLine();
                customerService.registerCustomer(customerName);

                break;

            case 4:
                System.out.println("Program Exiting...");
                break;

            default:
                System.out.println("Invalid choice");

        }
}
