package com.smarttransport;


import com.smarttransport.menu.BookingMenu;
import com.smarttransport.menu.PassengerMenu;
import com.smarttransport.menu.VehicleMenu;
import com.smarttransport.service.BookingService;
import com.smarttransport.service.PassengerService;
import com.smarttransport.service.VehicleService;

import java.awt.print.Book;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PassengerService passengerService = new PassengerService();
        VehicleService vehicleService = new VehicleService();
        BookingService bookingService = new BookingService(passengerService, vehicleService);
        String opr;
        while(true){
            System.out.println("\nEnter the number to choose operation");
            System.out.println("1. Open Vehicle Menu");
            System.out.println("2. Open Passenger Menu");
            System.out.println("3. Open Booking Menu");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            opr = scanner.nextLine();

            switch (opr){
                case "1":
                    System.out.println("Opening Vehicle Menu");
                    VehicleMenu.vehicleMenu(vehicleService, scanner);
                    break;

                case "2":
                    System.out.println("Opening Passenger Menu");
                    PassengerMenu.passengerMenu(passengerService, scanner);
                    break;

                case "3":
                    System.out.println("Opening Booking Menu");
                    BookingMenu.bookingMenu(bookingService, scanner);
                    break;

                case "4":
                    System.out.println("Exiting the Program....");
                    return;

                default:
                    System.out.println("Enter valid menu option");

            }


        }
    }
}
