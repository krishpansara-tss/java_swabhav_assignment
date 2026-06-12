package com.smarttransport.menu;

import com.smarttransport.exception.PassengerNotFound;
import com.smarttransport.model.Passenger;
import com.smarttransport.service.PassengerServices;

import java.util.Scanner;

public class PassengerMenu {
    public static void PassengerMenu(){
        Scanner scanner = new Scanner(System.in);
        int opr;
        PassengerServices passengerServices = new PassengerServices();

            while(true){
            System.out.println("Select OPR");
            System.out.println("1. Register");
            System.out.println("2. Search by id");
            System.out.println("3. Display all");
            opr = scanner.nextInt();


            switch (opr){

                case 1:
                    String name, destination;
                    int age;
                    System.out.println("Name of the passenger : ");
                    scanner.nextLine();
                    name = scanner.nextLine();

                    System.out.println("Age of the passenger : ");
                    age = scanner.nextInt();

                    System.out.println("Destination of the passenger : ");
                    scanner.nextLine();
                    destination = scanner.nextLine();

                    try{
                        passengerServices.registerUser(name, age, destination);
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter id to search:");
                    scanner.nextLine();
                    String id = scanner.nextLine();

                    try{
                        Passenger p = passengerServices.searchUserById(id);

                        if(p!=null){
                            System.out.println("User exist with the id : " + id );
                        }
                    }catch (PassengerNotFound e){
                        System.out.println("Error occur : "+e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Displaying all the passengers: ");
                    passengerServices.displayAllPassenger();

                default:
                    return;
            }
        }

    }
}
