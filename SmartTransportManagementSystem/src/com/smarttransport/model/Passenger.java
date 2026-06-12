package com.smarttransport.model;

public class Passenger {
    private static int nextId = 100;
    private String passengerId;
    private String name;
    private int age;
    private  String destination;

    public Passenger(String name, int age, String destination) {
        this.passengerId = "PID" + ++nextId;
        this.name = name;
        this.age = age;
        this.destination = destination;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
}
