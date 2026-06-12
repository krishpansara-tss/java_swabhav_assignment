package com.smarttransport.model;

public class Texi extends Vehicle{
    public Texi(String driverName, String vehicleNumber) {
        super(driverName, vehicleNumber, 4);
    }

    @Override
    public double calculateFair(double distance) {
        if(distance < 0){
            throw new IllegalArgumentException("Distance must be positive");
        }

        return distance * (150);
    }
}
