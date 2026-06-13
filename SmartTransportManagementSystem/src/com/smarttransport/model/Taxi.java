package com.smarttransport.model;

import com.smarttransport.interfaces.Maintainable;

public class Taxi extends Vehicle implements Maintainable {
    private boolean inMaintenance;

    public Taxi(String driverName, String vehicleNumber) {
        super(driverName, vehicleNumber, 4);
    }

    @Override
    public double calculateFare(double distance) {
        if(distance < 0){
            throw new IllegalArgumentException("Distance must be positive");
        }
        return distance * (150);
    }

    @Override
    public void sendToMaintenance() {
        if(this.inMaintenance){
            System.out.println("Taxi is already in the maintenance");
            return;
        }
        this.inMaintenance = true;
        System.out.println("Taxi is send in the maintenance");
    }

    @Override
    public void takeFromMaintenance() {
        if(!this.inMaintenance){
            System.out.println("Taxi is not in maintenance");
            return;
        }
        this.inMaintenance = false;
        System.out.println("Taxi received from the maintenance successfully");
    }

    @Override
    public boolean isUnderMaintenance() {
        return inMaintenance;
    }
}
