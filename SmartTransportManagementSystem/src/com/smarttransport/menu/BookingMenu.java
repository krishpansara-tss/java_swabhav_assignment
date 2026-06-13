package com.smarttransport.menu;

import com.smarttransport.exception.FullVehicleException;
import com.smarttransport.exception.PassengerNotFound;
import com.smarttransport.exception.VehicleNotFound;
import com.smarttransport.exception.VehicleUnderMaintenance;
import com.smarttransport.service.BookingService;
import com.smarttransport.service.PassengerService;
import com.smarttransport.service.VehicleService;

import java.util.Scanner;

import static com.smarttransport.inputfunction.InputFunction.*;

public class BookingMenu {
    public static void bookingMenu(BookingService bookingService, Scanner scanner){

        String opr;
        while(true) {
            System.out.println("\nEnter the number to choose operation");
            System.out.println("1. Book Vehicle");
            System.out.println("2. Display all passenger of particular vehicle.");
            System.out.println("3. Display the number of available seats in a vehicle.");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            opr = scanner.nextLine();

            switch (opr) {
                case "1":
                    try{
                        String passengerId = inputPassengerId(scanner);
                        String vehicleId = inputVehicleId(scanner);
                        double distance = inputDistance(scanner);


                        bookingService.addBooking(passengerId, vehicleId, distance);

                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }catch (FullVehicleException e){
                        System.out.println(e.getMessage());
                    }catch (PassengerNotFound e){
                        System.out.println(e.getMessage());
                    }catch (VehicleNotFound e){
                        System.out.println(e.getMessage());
                    }catch (VehicleUnderMaintenance e){
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    break;

                case "2":
                    try{
                        String vehicleId = inputVehicleId(scanner);

                        bookingService.displayPassengerOfVehicle(vehicleId);

                    }catch (VehicleNotFound e){
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "3":
                    try{
                        String vehicleId = inputVehicleId(scanner);

                        bookingService.displayAvailableSeats(vehicleId);

                    }catch (VehicleNotFound e){
                        System.out.println(e.getMessage());
                    }catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "4":
                    System.out.println("Returning to all menu....");
                    return;

                default:
                    System.out.println("Enter valid menu option");
            }
        }

    }
}
