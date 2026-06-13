package com.smarttransport.menu;

import com.smarttransport.exception.PassengerNotFound;
import com.smarttransport.model.Passenger;
import com.smarttransport.service.PassengerService;

import java.util.Scanner;

import static com.smarttransport.inputfunction.InputFunction.*;

public class PassengerMenu {
    public static void passengerMenu(PassengerService passengerServices, Scanner scanner){
        String opr;

        while(true){
            System.out.println("\nEnter the number to choose operation");
            System.out.println("1. Register");
            System.out.println("2. Search by id");
            System.out.println("3. Display all");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            opr = scanner.nextLine();

            switch (opr){

                case "1":
                    String name, destination;
                    int age;
                    name = inputPassengerName(scanner);
                    age = inputAge(scanner);
                    destination = inputDestination(scanner);

                    try{
                        passengerServices.registerUser(name, age, destination);
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "2":
                    String id = inputPassengerId(scanner);

                    try{
                        Passenger p = passengerServices.searchUserById(id);

                        if(p!=null){
                            System.out.println("User exist with the id : " + id );
                        }
                    }catch (PassengerNotFound e){
                        System.out.println("Error occur : "+e.getMessage());
                    }catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "3":
                    System.out.println("Displaying all the passengers: ");
                    passengerServices.displayAllPassenger();

                    break;

                default:
                    System.out.println("Returning to all menu");
                    return;
            }
        }
    }
}
