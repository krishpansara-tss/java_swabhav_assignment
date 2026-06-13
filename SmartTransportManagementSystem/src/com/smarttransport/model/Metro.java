package com.smarttransport.model;

public class Metro extends Vehicle {
    private final boolean inMaintenance = false;
    public Metro(String driverName, String vehicleNumber) {
        super(driverName, vehicleNumber, 500);
    }

    @Override
    public double calculateFare(double distance) {
        if(distance < 0){
            throw new IllegalArgumentException("Distance must be positive");
        }

        return distance * (75);
    }

    public boolean isUnderMaintenance() {
        return inMaintenance;
    }
}
