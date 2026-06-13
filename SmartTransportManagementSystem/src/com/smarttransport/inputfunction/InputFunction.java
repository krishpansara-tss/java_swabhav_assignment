package com.smarttransport.inputfunction;

import java.util.Scanner;

public class InputFunction {
    public static String inputVehicleNumber(Scanner scanner){
        String vehicleNumber;
        while(true){
            System.out.println("Enter vehicle number : ");
            vehicleNumber = scanner.nextLine().toUpperCase();
            if(vehicleNumber.isEmpty()){
                System.out.println("Please enter the value, field can't be empty");
            }else{
                break;
            }
        }
        return vehicleNumber;
    }

    public static String inputDriverName(Scanner scanner){
        String driverName;
        while(true){
            System.out.println("Name of the driver : ");
            driverName = scanner.nextLine();
            if(driverName.isEmpty()){
                System.out.println("Please enter the value, field can't be empty");
            }else{
                break;
            }
        }
        return driverName;
    }

    public static String inputPassengerName(Scanner scanner) {
        String name;
        while(true){
            System.out.println("Name of the passenger : ");
            name = scanner.nextLine();
            if(name.isEmpty()){
                System.out.println("Please enter the value, field can't be empty");
            }else{
                break;
            }
        }
        return name;
    }

    public static int inputAge(Scanner scanner) {
        int age;
        while(true){
            if(scanner.hasNextInt()){
                System.out.println("Age of the passenger : ");
                age = scanner.nextInt();

                if(age <= 0){
                    System.out.println("Age must be greater then 0");
                }else{
                    break;
                }
            }else{
                System.out.println("Please enter digit.");
            }
        }

        return age;

    }

    public static String inputDestination(Scanner scanner){
        String destination;
        while(true){
            System.out.println("Destination of the passenger : ");
            scanner.nextLine();
            destination = scanner.nextLine();
            if(destination.isEmpty()){
                System.out.println("Please enter the value, field can't be empty");
            }else{
                break;
            }
        }
        return destination;
    }

    public static String inputVehicleId(Scanner scanner){
        String id;

        while(true){
            System.out.print("Enter vehicle id to search : ");
            scanner.nextLine();
            id = scanner.nextLine();
            if(id.isEmpty()){
                System.out.println("Please enter the value, field can't be empty");
            }else{
                break;
            }
        }
        return id;
    }

    public static String inputPassengerId(Scanner scanner){
        String id;

        while(true){
            System.out.print("Enter passenger id to search : ");
            scanner.nextLine();
            id = scanner.nextLine();
            if(id.isEmpty()){
                System.out.println("Please enter the value, field can't be empty");
            }else{
                break;
            }
        }

        return id;
    }

    public static double inputDistance(Scanner scanner){
        double distance;
        while(true){
            System.out.print("Enter distance : ");
            if(scanner.hasNextDouble()){
                distance = scanner.nextDouble();
                if (distance <= 0){
                    throw new IllegalArgumentException("Distance can't be zero or less then zero");
                }
                break;
            }else{
                throw new IllegalArgumentException("Distance enter digits");
            }
        }
        return distance;
    }
}
