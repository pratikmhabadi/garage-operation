package com.garage.garage.services;

import com.garage.garage.dao.VehicleDao;
import com.garage.garage.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleDao vehicleDao;

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.findAll();
    }

    @Override
    public List<Vehicle> getVehiclesByStatus(String vehicleStatus) {
        List<Vehicle> list = new ArrayList<>();
         for(Vehicle vehicle:vehicleDao.findAll()){
             if(vehicle.getVehicleStatus().equals(vehicleStatus)){
                 list.add(vehicle);
             }
         }
        return list;
    }

    @Override
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> list = new ArrayList<>();
        for(Vehicle vehicle:vehicleDao.findAll()){
            if(vehicle.getVehicleType().equals(vehicleType)){
                list.add(vehicle);
            }
        }
        return list;
    }

    @Override
    public Vehicle getVehicle(int vehicleId) {
        return vehicleDao.getById(vehicleId);
    }

    @Override
    public Vehicle addVehicle(String registerNo, String vehicleType) {
        String type = vehicleType.toLowerCase(Locale.ROOT);
        Vehicle vehicle = new Vehicle();
        vehicle.setRegisterNo(registerNo.toUpperCase(Locale.ROOT));
        vehicle.setVehicleStatus("repairing");
        if (type.equals("bike")) {
            vehicle.setVehicleType(type);
            vehicle.setCost(200);
            return vehicleDao.save(vehicle);
        } else if (type.equals("car")) {
            vehicle.setVehicleType(type);
            vehicle.setCost(500);
            return vehicleDao.save(vehicle);
        } else {
            return null;
        }
    }


    @Override
    public Vehicle updateVehicle(int vehicleId) {
        Vehicle vehicle = vehicleDao.getById(vehicleId);
        vehicle.setVehicleStatus("repaired");
        return vehicleDao.save(vehicle);
    }

    @Override
    public void deleteVehicle(int vehicleId) {
        vehicleDao.deleteById(vehicleId);
    }
}

