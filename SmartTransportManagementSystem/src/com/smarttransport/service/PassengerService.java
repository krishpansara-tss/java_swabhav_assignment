package com.smarttransport.service;

import com.smarttransport.exception.PassengerNotFound;
import com.smarttransport.model.Passenger;

import java.util.HashMap;
import java.util.Map;

public class PassengerService {
    Map<String, Passenger> passengerMap = new HashMap<>();

    public void registerUser(String name, int age, String destination){
        System.out.println(passengerMap);
        if(age < 0 || age > 120){
            throw new IllegalArgumentException("Age must be between 0 to 100");
        }
        Passenger p = new Passenger(name, age, destination);
        passengerMap.put(p.getPassengerId().toUpperCase(), p);
        System.out.println("Passenger Added Successfully with ID: " + p.getPassengerId());
    }

    public void displayAllPassenger(){
        if(passengerMap.isEmpty()){
            System.out.println("No Passenger Found");
            return;
        }

        for(Passenger p : passengerMap.values()){
            System.out.println("ID: " + p.getPassengerId() + " | Name: " + p.getName() + " | Destination: " + p.getDestination());
        }
    }

    public Passenger searchUserById(String id){
        Passenger passenger = passengerMap.get(id.toUpperCase());
        if(passenger == null){
            throw new PassengerNotFound("Passenger having ID : " + id + " does not found");
        }
        return passenger;
    }

}
