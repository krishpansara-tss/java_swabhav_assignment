package com.smarttransport.model;

public class Metro extends Vehicle {
    public Metro(String driverName, String vehicleNumber) {
        super(driverName, vehicleNumber, 500);
    }

    @Override
    public double calculateFair(double distance) {
        if(distance < 0){
            throw new IllegalArgumentException("Distance must be positive");
        }

        return distance * (75);
    }
}
