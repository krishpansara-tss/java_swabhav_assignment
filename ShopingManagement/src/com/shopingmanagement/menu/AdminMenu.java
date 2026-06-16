package com.shopingmanagement.menu;

import com.shopingmanagement.model.Customer;
import com.shopingmanagement.services.ProductService;

import java.util.Scanner;

import static com.shopingmanagement.services.AdminService.adminLogin;

public class AdminMenu {
    public static void adminMenu(ProductService productService) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nChoose the following Operation: ");
        System.out.println("1. View All Products");
        System.out.println("2. Add Product to Shop");
        System.out.println("3. Remove Product from Shop");
        System.out.println("4. Add Stock of product");
        System.out.println("5. Update Discount");
        System.out.println("6. Break");
        int choice = scanner.nextInt();

        switch (choice) {
            // view all product
            case 1:
                productService.displayAllProduct();
                break;

            // add product to shop
            case 2:
                System.out.println("Product Name: ");
                String productName = scanner.nextLine();
                System.out.println("Product price: ");
                double price = scanner.nextDouble();
                System.out.println("Discount Percentage: ");
                double discountPercentage = scanner.nextDouble();
                System.out.println("Product stock: ");
                int productStock = scanner.nextInt();
                productService.addProduct(productName, price, discountPercentage, productStock);
                break;

            case 3:
                break;

            case 4:
                System.out.println("Program Exiting...");
                break;

            default:
                System.out.println("Invalid choice");

        }
    }
}
