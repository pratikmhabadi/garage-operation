package com.garage.garage.controller;

import com.garage.garage.entities.Vehicle;
import com.garage.garage.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    //get All Vehicles
    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return this.vehicleService.getAllVehicles();
    }

    // get vehicle by ID
    @GetMapping("/vehicles/{vehicleId}")
    public Vehicle getVehicle(@PathVariable String vehicleId) {
        return this.vehicleService.getVehicle(Integer.parseInt(vehicleId));
    }

    //add new vehicle
    @PostMapping("/vehicles/{registerNo}/{vehicleType}")
    public Vehicle addVehicle(@PathVariable String registerNo,@PathVariable String vehicleType) {
        return this.vehicleService.addVehicle(registerNo,vehicleType);
    }

    //delete vehicle by ID
   @DeleteMapping("/vehicles/{vehicleId}")
    public void deleteVehicle(@PathVariable String vehicleId){
        this.vehicleService.deleteVehicle(Integer.parseInt(vehicleId));
    }

    //update vehicle by status by ID
    @PutMapping("/vehicles/{vehicleId}")
    public Vehicle updateVehicle(@PathVariable String vehicleId) {
        return this.vehicleService.updateVehicle(Integer.parseInt(vehicleId));
    }

    //get vehicles by repaired status
    @GetMapping("/vehicles/repaired")
    public List<Vehicle> getAllRepairedVehicles(){
        return  this.vehicleService.getVehiclesByStatus("repaired");
    }

    //get vehicles by repairing status
    @GetMapping("/vehicles/repairing")
    public List<Vehicle> getAllRepairingVehicles(){
        return this.vehicleService.getVehiclesByStatus("repairing");
    }

    // get all bikes
    @GetMapping("/vehicles/bike")
    public List<Vehicle> getAllBike(){
        return this.vehicleService.getVehiclesByType("bike");
    }

    // get all cars
    @GetMapping("/vehicles/car")
    public List<Vehicle> getAllCars(){
        return this.vehicleService.getVehiclesByType("car");
    }
}
