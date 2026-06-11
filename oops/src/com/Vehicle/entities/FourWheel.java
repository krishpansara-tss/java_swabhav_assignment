package com.Vehicle.entities;

public class FourWheel extends Vehicle{
    private int numOfSeats;

    public FourWheel(String name, String companey, double price, int numOfSeats) {
        super(name, companey, price);
        this.numOfSeats = numOfSeats;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFourWheel{" +
                "numOfSeats=" + numOfSeats +
                '}';
    }
}
