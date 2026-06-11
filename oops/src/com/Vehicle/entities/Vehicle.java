package com.Vehicle.entities;

public class Vehicle {
    private String name, companey;
    private double price;

    public Vehicle(String name, String companey, double price) {
        this.name = name;
        this.companey = companey;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCompaney() {
        return companey;
    }

    public void setCompaney(String companey) {
        this.companey = companey;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", companey='" + companey + '\'' +
                ", price=" + price +
                '}';
    }
}
