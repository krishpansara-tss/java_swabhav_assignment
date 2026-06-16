package com.shopingmanagement.menu;

import com.shopingmanagement.model.Customer;
import com.shopingmanagement.services.CartService;
import com.shopingmanagement.services.CustomerService;
import com.shopingmanagement.services.OrderService;
import com.shopingmanagement.services.ProductService;

import java.util.Scanner;

import static com.shopingmanagement.services.AdminService.adminLogin;

public class MainMenu {
    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        CartService cartService = new CartService();

        while (true){
            System.out.println("Choose Operation: ");
            System.out.println("1. Open Admin Menu");
            System.out.println("2. Login as Customer");
            System.out.println("3. Register as Customer");
            System.out.println("4. Exit Program");
            System.out.print("Enter the option:");

            int opr = scanner.nextInt();

            switch (opr){
                case 1:
                    System.out.println("Enter UserName: ");
                    String username = scanner.nextLine();
                    System.out.println("Enter Password: ");
                    String password = scanner.nextLine();

                    if(adminLogin(username, password)){
                        System.out.println("Admin logged in successfully");
                        AdminMenu.adminMenu(productService);
                    }
                    break;

                case 2:
                    System.out.println("Enter your userId: ");
                    String userID = scanner.nextLine();
                    Customer customer = customerService.loginCustomer(userID);
                    if(customer != null){
                        CustomerMenu.customerMenu(productService, customer);
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
    }
}
