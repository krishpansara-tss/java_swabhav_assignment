package com.smarttransport.menu;

import com.smarttransport.exception.UnsupportedOperation;
import com.smarttransport.exception.VehicleNotFound;
import com.smarttransport.model.Bus;
import com.smarttransport.model.Metro;
import com.smarttransport.model.Taxi;
import com.smarttransport.model.Vehicle;
import com.smarttransport.service.VehicleService;

import java.util.Scanner;

import static com.smarttransport.inputfunction.InputFunction.*;

public class VehicleMenu {
    public static void vehicleMenu(VehicleService vehicleService, Scanner scanner){
        String opr;

        while(true){
            System.out.println("\nEnter the number to choose operation");
            System.out.println("1. Add vehicle");
            System.out.println("2. Search Vehicle by id");
            System.out.println("3. Display all Vehicle");
            System.out.println("4. Send vehicle to Maintenance");
            System.out.println("5. Receive vehicle from Maintenance");
            System.out.println("6. Highest revenue generated vehicle");
            System.out.println("6. Maximum occupancy vehicle");
            System.out.println("6. Display all vehicle which is under Maintenance ");
            System.out.println("7. Return to all option");
            System.out.print("Enter your choice: ");
            opr = scanner.nextLine();

            switch (opr){

                case "1":
                    System.out.println("\nType number according to your vehicle");
                    System.out.println("1. Bus");
                    System.out.println("2. Taxi");
                    System.out.println("3. Metro");
                    System.out.print("Enter your choice: ");
                    String vehicleType = scanner.nextLine();


                    String driverName = inputDriverName(scanner);

                    String vehicleNumber = inputVehicleNumber(scanner);

                    switch (vehicleType){
                        case "1":
                            vehicleService.addVehicle(new Bus(driverName, vehicleNumber));
                            break;

                        case "2":
                            vehicleService.addVehicle(new Taxi(driverName, vehicleNumber));
                            break;

                        case "3":
                            vehicleService.addVehicle(new Metro(driverName, vehicleNumber));
                            break;

                        default:
                            System.out.println("Enter valid vehicle type");
                    }
                    break;

                case "2":
                    String id = inputVehicleId(scanner);

                    try{
                        Vehicle vehicle = vehicleService.searchVehicleById(id);

                        if(vehicle!=null){
                            System.out.println("Vehicle exist with the id : " + id );
                        }
                    }catch (VehicleNotFound e){
                        System.out.println("Error occur : "+ e.getMessage());
                    }catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "3":
                    System.out.println("Displaying all the Vehicle: ");
                    vehicleService.displayAllVehicle();
                    break;

                case "4":
                    id = inputVehicleId(scanner);
                    try{
                        vehicleService.sendVehicleToMaintenance(id);
                    } catch (UnsupportedOperation e) {
                        System.out.println(e.getMessage());
                    } catch (VehicleNotFound e){
                        System.out.println(e.getMessage());
                    }catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "5":
                    id = inputVehicleId(scanner);
                    try{
                        vehicleService.takeVehicleFromMaintenance(id);
                    } catch (UnsupportedOperation e) {
                        System.out.println(e.getMessage());
                    } catch (VehicleNotFound e){
                        System.out.println(e.getMessage());
                    }catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "6":
                    vehicleService.displayVehicleWithHighestRevenue();
                    break;

                case "7":
                    vehicleService.displayMaximumOccupancyVehicle();
                    break;

                case "8":
                    vehicleService.displayVehiclesUnderMaintenance();
                    break;

                case "9":
                    System.out.println("Returning to all menu");
                    return;

                default:
                    System.out.println("Enter valid menu option");
            }
        }
    }
}
