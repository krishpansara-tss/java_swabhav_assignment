package com.account.test;

import com.account.entity.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Account[] accounts = new Account[10];
//        ArrayList<Account> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int accountCount = 0;

        int operation;
        while(true){
            System.out.println("\n\nEnter the operation you want to perform");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Get Account Details");
            System.out.println("6. Exit");

            while(true){
                if(scanner.hasNextInt()){
                    operation = scanner.nextInt();
                    break;
                }else{
                    System.out.println("Please enter valid number");
                    scanner.next();
                }
                System.out.println("Please select the operation : ");
            }

            switch (operation){
                // craete account
                case 1:
                    if(accountCount == 10){
                        System.out.println("Bank is full");
                        break;
                    }
                    Account newAccount = createAccount(scanner);
                    // add new account in the array
                    accounts[accountCount++] = newAccount;
//                    accounts.add(newAccount);
                    System.out.println("Account created successfully");

                    newAccount.displayAccountDetails();

                    break;

                // deposit
                case 2:

                    Account currAccountToDeposit = accountVerification(accounts, accountCount, scanner);
                    if(currAccountToDeposit != null){
                        int amountToDeposit = inputAmount(scanner);
                        if(currAccountToDeposit.deposit(amountToDeposit)){
                            System.out.println("Operation Done successfully");
                        }else{
                            System.out.println("Operation failed");
                        }
                    }else{
                        System.out.println("No account found");
                    }
                    break;

                // withdraw
                case 3:
                    Account currAccountToWithdraw = accountVerification(accounts, accountCount, scanner);
                    if(currAccountToWithdraw != null){
                        int amountToWithdraw = inputAmount(scanner);
                        if(currAccountToWithdraw.withdraw(amountToWithdraw)){
                            System.out.println("Operation Done successfully");
                        }else{
                            System.out.println("Operation Failed");
                        }
                    }else{
                        System.out.println("No account found");
                    }
                    break;

                // transfer
                case 4:
                    System.out.println("Enter Details about the sender's account : ");
                    Account accountSender = accountVerification(accounts, accountCount, scanner);
                    if(accountSender == null){
                        System.out.println("No account exist");
                        break;
                    }
                    System.out.println("Enter Details about the receiver's account : ");
                    Account accountReceiver = accountVerification(accounts, accountCount, scanner);

                    if(accountReceiver == null){
                        System.out.println("No account exist");
                        break;
                    }

                    if(accountReceiver.getAccountNumber() == accountSender.getAccountNumber()){
                        System.out.println("Account number are same!! invalid");
                        break;
                    }

                    int amountToTransfer = inputAmount(scanner);

                    if(accountSender.withdraw(amountToTransfer)){
                        if(accountReceiver.deposit(amountToTransfer)){
                            System.out.println("Transfer Done successfully");
                        }else{
                            System.out.println("Issue at the reciever side");
                        }
//                        33736646
//                        18331821
                    }else{
                        System.out.println("Issue at the sender side");
                    }
                    break;

                // account detail
                case 5:
                    Account currAccountToDisplay = accountVerification(accounts, accountCount, scanner);
                    if(currAccountToDisplay != null){
                        currAccountToDisplay.displayAccountDetails();
                    }else{
                        System.out.println("Account not found");
                    }

                    break;

                default:
                    System.out.println("Program Exited");
                    return;
            }
        }
    }

    public static int inputAmount(Scanner scanner){
        int amount;

        while(true){
            System.out.println("\nEnter amount : ");

            if(scanner.hasNextInt()){
                amount = scanner.nextInt();

                if (amount >= 0) {
                    break;
                } else {
                    System.out.println("Amount cannot be negative");
                }
            }else{
                System.out.println("Invalid input. Please enter a number");
                scanner.next();
            }
        }
        return amount;
    }

    public static Account accountVerification(Account[] accounts, int accountCount, Scanner scanner){
        int accountNumber;
        while(true){
            System.out.print("\n\nEnter account number : ");
            if(scanner.hasNextInt()){
                accountNumber = scanner.nextInt();
                for(int i = 0; i < accountCount; i++)
                    if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) {
                        return accounts[i];
                    }
                break;
            }else{
                System.out.println("Please enter only digits.");
                scanner.next();
            }
        }
        System.out.println("Account not found");
        return null;
    }

    public static Account createAccount(Scanner scanner){
        String name;
        int accountType, balance;

        System.out.print("\nEnter your Name : ");
        scanner.nextLine();
        name = scanner.nextLine();

        System.out.print("Enter type of the account you wanna to open\n1. Saving\n2. Current\n Enter your choice : ");
        while(true){
            if(scanner.hasNextInt()){
                accountType = scanner.nextInt();
                if (accountType == 1 || accountType == 2) {
                    break;
                } else {
                    System.out.println("Please enter 1 or 2.");
                }
            }else{
                System.out.println("Please enter 1 or 2.");
                scanner.next();
            }
        }
        System.out.println("\nEnter balance of your account : ");

        while(true){
            if(scanner.hasNextInt()){
                balance = scanner.nextInt();
                if (balance >= 0) {
                    break;
                } else {
                    System.out.println("Balance cannot be negative");
                }
            }else{
                System.out.println("Invalid input. Please enter a number");
                scanner.next();
            }
        }

        return new Account(name, balance, accountType);
    }
}
