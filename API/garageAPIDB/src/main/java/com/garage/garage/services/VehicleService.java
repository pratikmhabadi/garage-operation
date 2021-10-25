package com.garage.garage.services;

import com.garage.garage.entities.Vehicle;

import java.util.List;

public interface VehicleService {
    //get list of all vehicle
    List<Vehicle> getAllVehicles();

    // get list of vehicles by status
    List<Vehicle> getVehiclesByStatus(String vehicleStatus);

    //get list of vehicles by type
    List<Vehicle> getVehiclesByType(String vehicleType);

    //get vehicle by id
    Vehicle getVehicle(int vehicleId);

    //add new vehicle by registerNo and type
    Vehicle addVehicle(String registerNo,String vehicleType);

    //update vehicle by id
    Vehicle updateVehicle(int vehicleId);

    // delete vehicle by id
    void deleteVehicle(int vehicleId);
}
