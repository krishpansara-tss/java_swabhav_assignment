package com.smarttransport.model;

public class Booking {
    private static int nextId = 100;
    private String bookingId;
    private Passenger passenger;
    private Vehicle vehicle;
    private String destination;
    private double fareOfTravel;

    public Booking(Vehicle vehicle, Passenger passenger, String destination, double fareOfTravel) {
        this.bookingId = "BKID"+ ++nextId;
        this.passenger = passenger;
        this.vehicle = vehicle;
        this.destination = destination;
        this.fareOfTravel = fareOfTravel;
    }

    public String getBookingId() {
        return bookingId;
    }
    public Passenger getPassenger() {
        return passenger;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public double getFareOfTravel() {
        return fareOfTravel;
    }
}
