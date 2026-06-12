package com.smarttransport.service;

import com.smarttransport.exception.VehicleNotFound;
import com.smarttransport.model.Passenger;
import com.smarttransport.model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleService {
    Map<String, Vehicle> vehicleMap = new HashMap<>();

    public void addVehicle(Vehicle vehicle){
        vehicleMap.put(vehicle.getVehicleId().toUpperCase(), vehicle);
        System.out.println(vehicle.getClass().getSimpleName() + " added with ID: " + vehicle.getVehicleId());
    }

    public Vehicle searchVehicleById(String id){
        Vehicle v = vehicleMap.get(id.toUpperCase());
        if(v == null){
            throw new VehicleNotFound("Vehicle with id: " + id + " not found");
        }
        return v;
    }

    public void displayAllVehicle(){
        if(vehicleMap.isEmpty()){
            System.out.println("No Vehicle yet");
            return;
        }

        for(Vehicle v : vehicleMap.values()){
            System.out.println("ID: " + v.getVehicleId() +
                    " | Type: " + v.getClass().getSimpleName() +
                    " | Vehicle Number: " + v.getVehicleNumber() +
                    " | Driver Name: " + v.getDriverName() +
                    " | Capacity: " + v.getCapacity()
            );
        }
    }
}
