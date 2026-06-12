package com.smarttransport.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    private static int nextVehicleId = 100;
    private final String vehicleId;
    private final String vehicleNumber;
    private String driverName;
    private final int capacity;
    private double totalRevenue;

    private List<Passenger> currPassengerList;

    public Vehicle(String driverName, String vehicleNumber, int capacity) {
        this.vehicleId = "VID" + ++nextVehicleId;
        this.vehicleNumber = vehicleNumber;
        this.driverName = driverName;
        this.capacity = capacity;
        this.totalRevenue = 0.0;

        this.currPassengerList = new ArrayList<>();
    }

    public abstract double calculateFair(double distance);

    public int getAvailableSeats(){
        return this.capacity - this.currPassengerList.size();
    }

    public void addPassenger(Passenger passenger){
        this.currPassengerList.add(passenger);
    }

    public void addRevenue(double fair){
        this.totalRevenue += fair;
    }


    public String getVehicleId() {
        return vehicleId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getDriverName() {
        return driverName;
    }
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
