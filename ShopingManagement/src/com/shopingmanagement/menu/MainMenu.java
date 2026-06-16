package com.shopingmanagement.menu;

import com.shopingmanagement.model.Customer;
import com.shopingmanagement.services.CartService;
import com.shopingmanagement.services.CustomerService;
import com.shopingmanagement.services.OrderService;
import com.shopingmanagement.services.ProductService;

import java.util.Scanner;

import static com.shopingmanagement.services.AdminService.adminLogin;
import static com.shopingmanagement.validator.InputValidator.*;

public class MainMenu {
    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        CartService cartService = new CartService();

        while (true){
            System.out.println("\n\nChoose Operation: ");
            System.out.println("1. Open Admin Menu");
            System.out.println("2. Login as Customer");
            System.out.println("3. Register as Customer");
            System.out.println("4. Exit Program");
            int opr = inputMenuOption("Enter the option: ", 1, 4);

            switch (opr){
                case 1:
                    String username = inputUsername();
                    String password = inputPassword();

                    if(adminLogin(username, password)){
                        System.out.println("Admin logged in successfully");
                        AdminMenu.adminMenu(productService);
                    }
                    break;

                case 2:
                    String userID = inputCustomerId();
                    Customer customer = customerService.loginCustomer(userID);
                    if(customer != null){
                        CustomerMenu.customerMenu(productService, cartService, orderService, customer);
                    }
                    break;

                case 3:
                    String customerName = inputCustomerName();
                    customerService.registerCustomer(customerName);

                    break;

                case 4:
                    System.out.println("Program Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}
