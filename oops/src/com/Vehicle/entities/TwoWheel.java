package com.Vehicle.entities;

public class TwoWheel extends Vehicle {
    private double mileage;

    public TwoWheel(String name, String companey, double price, double mileage) {
        super(name, companey, price);
        this.mileage = mileage;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\nTwoWheel{" +
                "mileage=" + mileage +
                '}';
    }
}
