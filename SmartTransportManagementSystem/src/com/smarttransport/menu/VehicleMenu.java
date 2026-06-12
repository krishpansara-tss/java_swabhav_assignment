package com.smarttransport.menu;

import com.smarttransport.exception.VehicleNotFound;
import com.smarttransport.model.Bus;
import com.smarttransport.model.Metro;
import com.smarttransport.model.Texi;
import com.smarttransport.model.Vehicle;
import com.smarttransport.service.VehicleService;

import java.util.Scanner;

public class VehicleMenu {
    public static void vehicleMenu(){
        Scanner scanner = new Scanner(System.in);
        int opr;
        VehicleService vehicleService = new VehicleService();

        while(true){
            System.out.println("Select OPR");
            System.out.println("1. Add vehicle");
            System.out.println("2. Search by id");
            System.out.println("3. Display all");
            opr = scanner.nextInt();

            switch (opr){

                case 1:
                    System.out.println("Type number according to your vehicle");
                    System.out.println("1. Bus");
                    System.out.println("2. Taxi");
                    System.out.println("3. Metro");
                    int vehicleType = scanner.nextInt();


                    String driverName, vehicleNumber;

                    int age;
                    System.out.println("Name of the driver : ");
                    scanner.nextLine();
                    driverName = scanner.nextLine();

                    System.out.println("Enter vehicle number : ");
                    vehicleNumber = scanner.nextLine();

                    switch (vehicleType){
                        case 1:
                            vehicleService.addVehicle(new Bus(driverName, vehicleNumber));
                            break;

                        case 2:
                            vehicleService.addVehicle(new Texi(driverName, vehicleNumber));
                            break;

                        case 3:
                            vehicleService.addVehicle(new Metro(driverName, vehicleNumber));
                            break;

                        default:
                            System.out.println("Enter valid vehicle type");
                            return;
                    }
                    break;

                case 2:
                    System.out.print("Enter id to search : ");
                    scanner.nextLine();
                    String id = scanner.nextLine();

                    try{
                        Vehicle vehicle = vehicleService.searchVehicleById(id);

                        if(vehicle!=null){
                            System.out.println("User exist with the id : " + id );
                        }
                    }catch (VehicleNotFound e){
                        System.out.println("Error occur : "+ e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Displaying all the Vehicle: ");
                    vehicleService.displayAllVehicle();
                    break;

                default:
                    return;
            }
        }

    }
}
