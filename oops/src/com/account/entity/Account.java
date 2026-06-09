package com.account.entity;

import java.sql.SQLOutput;
import java.util.Random;

public class Account {
    private int accountId;
    private static int nextId = 0;
    private int accountNumber;
    private String name;
    private double balance;
    private  String accountType;

    public Account(String name, double balance, int accountType){
        this.accountId = ++nextId;
        this.accountNumber = 10000000 + new Random().nextInt(90000000);
        this.name = name;
        this.balance = balance;
        switch (accountType){
            case 1:
                this.accountType = "Saving";
                break;
            case 2:
                this.accountType = "Current";
                break;
            default:
                this.accountType = "Saving";
        }
    }

    public Account(){
        this.accountId = ++nextId;
        this.accountNumber = 10000000 + new Random().nextInt(90000000);
        this.name = "Unknown";
        this.balance = 0;
        this.accountType = "Saving";
    }

    public int getAccountNumber() { return accountNumber;}
    public int getAccountId() { return accountId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }



    public void displayAccountDetails() {
        System.out.println("\n===== Account Details =====");
        System.out.println("Account Id : " + this.accountId);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + name);
        System.out.println("Account Type   : " + accountType);
        System.out.println("Balance        : ₹" + balance);
    }

    public double checkBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
            return false;
        }

        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
        System.out.println("Updated Balance: ₹" + balance);

        return true;
    }

    public boolean withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return false;
        }

        if((balance - amount) <= 500){
            System.out.println("Your account must have balance more than 500 after withdrawn.");
            return false;
        }

        balance -= amount;
        System.out.println("₹" + amount + " withdrawn successfully.");
//        System.out.println("Following notes are came from ATM : ");
//        noteCalcultor(amount);
        System.out.println("Remaining Balance: ₹" + balance);

        return true;
    }


    public void noteCalcultor(int amount){
        int[] currency = {2000, 500, 200, 100};
        for (int j : currency) {
            int notesCount = 0;
            if (amount == 0) {
                break;
            }

            while (amount >= j) {
                amount = amount - j;
                notesCount++;
            }
            if (notesCount != 0) {
                System.out.println("No. of " + j + " Note : " + notesCount);
            }
        }
    }
}
