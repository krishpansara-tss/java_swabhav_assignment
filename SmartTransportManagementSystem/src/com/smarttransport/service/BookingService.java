package com.smarttransport.service;

import com.smarttransport.exception.FullVehicleException;
import com.smarttransport.exception.PassengerNotFound;
import com.smarttransport.exception.VehicleNotFound;
import com.smarttransport.exception.VehicleUnderMaintenance;
import com.smarttransport.interfaces.Maintainable;
import com.smarttransport.model.Booking;
import com.smarttransport.model.Passenger;
import com.smarttransport.model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class BookingService {
    private Map<String, Booking> bookingMap = new HashMap<>();

    private PassengerService passengerService;
    private VehicleService vehicleService;

    public BookingService(PassengerService passengerService, VehicleService vehicleService){
        this.passengerService = passengerService;
        this.vehicleService = vehicleService;
    }

    public void addBooking(String passengerId, String vehicleId, double distance) throws PassengerNotFound, VehicleNotFound {
        if(distance <= 0) {
            throw new IllegalArgumentException("Booking Failed: Distance can't be 0 or negative");
        }

        Passenger passenger = passengerService.searchUserById(passengerId);
        Vehicle vehicle = vehicleService.searchVehicleById(vehicleId);

        if(vehicle instanceof Maintainable){
            Maintainable maintainableVehicle = (Maintainable) vehicle;
            if(maintainableVehicle.isUnderMaintenance()){
                throw new VehicleUnderMaintenance("Booking Failed: Vehicle " + vehicleId + " is under maintenance");
            }
        }

        if(vehicle.getAvailableSeats() <= 0){
            throw new FullVehicleException("Booking Failed: " + vehicle.getClass().getSimpleName() + " " + vehicleId + " is under maintenance");
        }

        double fare = vehicle.calculateFare(distance);

        vehicle.addPassenger(passenger);
        vehicle.addRevenue(fare);

        Booking booking = new Booking(vehicle, passenger, passenger.getDestination(), fare);

        bookingMap.put(booking.getBookingId().toUpperCase(), booking);

        System.out.println("\n=======================================");
        System.out.println("TICKET BOOKED SUCCESSFULLY!");
        System.out.println("Booking ID  : " + booking.getBookingId());
        System.out.println("Passenger   : " + passenger.getName() + " ID: " + passengerId );
        System.out.println("Assigned To : " + vehicle.getClass().getSimpleName() + " (ID: " + vehicleId + ")");
        System.out.println("Fare Charged: " + String.format("%.2f", fare));
        System.out.println("Seats Left  : " + vehicle.getAvailableSeats());
        System.out.println("=======================================");
    }

    //display passenger of the vehicle
    public void displayPassengerOfVehicle(String vehicleId){
        Vehicle vehicle = vehicleService.searchVehicleById(vehicleId);

        System.out.println("Vehicle Type   : " + vehicle.getClass().getSimpleName());
        System.out.println("Driver Name    : " + vehicle.getDriverName());
        System.out.println("Available Seats: " + vehicle.getAvailableSeats());

        System.out.println("\n=======================================");
        System.out.println("Passenger List:");

        if(vehicle.getCurrPassengerList().isEmpty()){
            System.out.println("No passenger yet!");
            return;
        }

        for(Passenger p : vehicle.getCurrPassengerList()){
            System.out.println("• ID: " + p.getPassengerId() +
                                " | Name: " + p.getName() +
                                " | Age: " + p.getAge() +
                                " | Destination: " + p.getDestination()
            );
        }
    }

    public void displayAvailableSeats(String vehicleId){
        Vehicle vehicle = vehicleService.searchVehicleById(vehicleId);

        System.out.println("Available seats in the vehicle having ID:" + vehicleId +" is "  + vehicle.getAvailableSeats());
    }
}
