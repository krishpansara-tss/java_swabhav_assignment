package com.Vehicle.Test;

import com.Vehicle.entities.FourWheel;
import com.Vehicle.entities.TwoWheel;

import java.util.Scanner;

public class VehicleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operation;
        do{
            System.out.println("1. Two Wheel\n2.Four Wheel\nChoose from following operations");
            while(true){
                if(scanner.hasNextInt()){
                    operation = scanner.nextInt();
                    break;
                }else{
                    System.out.println("Please enter valid number");
                }
            }

            switch (operation){
                case 1:
                    String name, company;
                    System.out.println("Two wheel selected\n");

                    System.out.print("Enter name of the bike: ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    System.out.print("Enter name of the companey: ");
//                    scanner.nextLine();
                    company = scanner.nextLine();
                    System.out.print("Enter price of the bike: ");
                    double price = takeDoubleInput(scanner);
                    System.out.print("Enter milage of the bike: ");
                    double mileage = takeDoubleInput(scanner);

                    TwoWheel tw = new TwoWheel(name, company, price, mileage);
                    System.out.println(tw);


                    break;
                case 2:
                    System.out.println("Four wheel selected");
                    System.out.print("Enter name of the four wheel: ");
                    scanner.nextLine();
                    name = scanner.nextLine();
                    System.out.print("Enter name of the company: ");
                    company = scanner.nextLine();
                    System.out.print("Enter price of the four wheel: ");
                    price = takeDoubleInput(scanner);
                    System.out.print("Enter number of the seats : ");
                    int noOfSeats = takeIntInput(scanner);

                    FourWheel fw = new FourWheel(name, company, price, noOfSeats);
                    System.out.println(fw);
                    break;
                default:
                    System.out.println("Program Exited");
                    return;

            }

        }while(true);
    }

    public static int takeIntInput(Scanner scanner){
        int value;
        while(true){
            if(scanner.hasNextInt()){
                value = scanner.nextInt();
                if(value >= 0){
                    break;
                }else{
                    System.out.println("Negative value is not possible");
                }
            }else{
                System.out.println("Please enter valid number");
            }
        }

        return value;
    }

    public static double takeDoubleInput(Scanner scanner){
        double value;
        while(true){
            if(scanner.hasNextDouble()){
                value = scanner.nextDouble();
                if(value >= 0){
                    break;
                }else{
                    System.out.println("Negative value is not possible");
                }
            }else{
                System.out.println("Please enter valid number");
            }
        }

        return value;
    }
}
