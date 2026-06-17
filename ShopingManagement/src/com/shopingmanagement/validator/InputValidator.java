package com.shopingmanagement.validator;

import java.util.Scanner;

public class InputValidator {
    static Scanner scanner = new Scanner(System.in);

    public static String inputCustomerId() {
        while (true) {
            System.out.print("Enter Customer ID: ");
            String customerId = scanner.nextLine().trim();

            if (customerId.isEmpty()) {
                System.out.println("Customer ID cannot be empty.");
                continue;
            }

            return customerId;
        }
    }

    public static String inputProductId() {
        while (true) {
            System.out.print("Enter Product ID: ");
            String productId = scanner.nextLine().trim();

            if (productId.isEmpty()) {
                System.out.println("Product ID cannot be empty.");
                continue;
            }

            return productId;
        }
    }


    public static String inputProductName() {
        while (true) {
            System.out.print("Enter Product Name: ");
            String productName = scanner.nextLine().trim();

            if (productName.isEmpty()) {
                System.out.println("Product name cannot be empty.");
                continue;
            }

            if (productName.length() < 2) {
                System.out.println("Product name must contain at least 2 characters.");
                continue;
            }

            return productName;
        }
    }

    public static double inputPrice() {
        while (true) {
            System.out.print("Enter Product Price: ");

            try {
                double price = Double.parseDouble(scanner.nextLine());

                if (price <= 0) {
                    System.out.println("Price must be greater than 0.");
                    continue;
                }

                return price;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid price.");
            }
        }
    }

    public static int inputStock() {
        while (true) {
            System.out.print("Enter Product Stock: ");

            try {
                int stock = Integer.parseInt(scanner.nextLine());

                if (stock < 0) {
                    System.out.println("Stock cannot be negative.");
                    continue;
                }

                return stock;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer value.");
            }
        }
    }

    public static int inputQuantity() {
        while (true) {
            System.out.print("Enter Quantity: ");

            try {
                int quantity = Integer.parseInt(scanner.nextLine());

                if (quantity <= 0) {
                    System.out.println("Quantity must be greater than 0.");
                    continue;
                }

                return quantity;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer value.");
            }
        }
    }

    public static double inputDiscountPercentage() {
        while (true) {
            System.out.print("Enter Discount Percentage: ");

            try {
                double discount = Double.parseDouble(scanner.nextLine());

                if (discount < 0 || discount > 100) {
                    System.out.println("Discount must be between 0 and 100.");
                    continue;
                }

                return discount;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid discount percentage.");
            }
        }
    }

    public static String inputUsername() {
        while (true) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine().trim();

            if (username.isEmpty()) {
                System.out.println("Username cannot be empty.");
                continue;
            }
            if (username.length() < 4) {
                System.out.println("Username must be at least 4 characters long.");
                continue;
            }

            return username;
        }
    }

    public static String inputPassword() {
        while (true) {
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            if (password.isEmpty()) {
                System.out.println("Password cannot be empty.");
                continue;
            }
            return password;
        }
    }
    public static String inputCustomerName() {
        while (true) {
            System.out.print("Enter Customer Name: ");
            String customerName = scanner.nextLine().trim();
            if (customerName.isEmpty()) {
                System.out.println("Customer name cannot be empty.");
                continue;
            }
            if (customerName.length() < 2) {
                System.out.println("Customer name must contain at least 2 characters.");
                continue;
            }

            return customerName;
        }
    }

    public static int inputMenuOption(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int option = Integer.parseInt(scanner.nextLine().trim());
                if (option >= min && option <= max) {
                    return option;
                }
                System.out.println("Invalid choice. Please enter a choice between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer choice.");
            }
        }
    }
}
