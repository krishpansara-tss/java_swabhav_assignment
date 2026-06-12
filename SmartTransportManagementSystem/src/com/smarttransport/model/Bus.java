package com.smarttransport.model;

public class Bus extends Vehicle{

    public Bus(String driverName, String vehicleNumber) {
        super(driverName, vehicleNumber, 50);
    }

    @Override
    public double calculateFair(double distance) {
        if(distance < 0){
            throw new IllegalArgumentException("Distance must be positive");
        }
        return distance * (100);
    }
}
