package com.shopingmanagement.menu;

import com.shopingmanagement.exceptions.ProductNotFound;
import com.shopingmanagement.model.Customer;
import com.shopingmanagement.services.ProductService;

import java.util.Scanner;

import static com.shopingmanagement.services.AdminService.adminLogin;
import static com.shopingmanagement.validator.InputValidator.*;

public class AdminMenu {
    public static void adminMenu(ProductService productService) {

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n\nChoose the following Operation: ");
            System.out.println("1. View All Products");
            System.out.println("2. Add Product to Shop");
            System.out.println("3. Remove Product from Shop");
            System.out.println("4. Add Stock of product");
            System.out.println("5. Update Discount");
            System.out.println("6. Break");
            int choice = inputMenuOption("Enter your choice: ", 1, 6);

            switch (choice) {
                // view all product
                case 1:
                    productService.displayAllProduct();
                    break;

                // add product to shop
                case 2:
                    String productName = inputProductName();
                    double price = inputPrice();
                    double discountPercentage = inputDiscountPercentage();
                    int productStock = inputStock();
                    productService.addProduct(productName, price, discountPercentage, productStock);
                    break;

                // Remove Product from Shop
                case 3:
                    System.out.println("Enter Product Id to remove from shop: ");
                    String productId = inputProductId();
                    try {
                        productService.removeProductFromShop(productId);
                    } catch (ProductNotFound e) {
                        System.out.println("ERROR: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                // Add Stock of product
                case 4:
                    System.out.println("Enter Product Id to add in stock: ");
                    productId = inputProductId();
                    productStock = inputStock();
                    try {
                        productService.addStock(productId, productStock);
                    } catch (ProductNotFound e) {
                        System.out.println("ERROR: " + e.getMessage());
                        ;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                //Update Discount
                case 5:
                    productId = inputProductId();
                    discountPercentage = inputDiscountPercentage();
                    try {
                        productService.updateDiscount(productId, discountPercentage);
                    } catch (ProductNotFound e) {
                        System.out.println("ERROR: " + e.getMessage());
                        ;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Going back to Main menu....");
                    return;

                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}
