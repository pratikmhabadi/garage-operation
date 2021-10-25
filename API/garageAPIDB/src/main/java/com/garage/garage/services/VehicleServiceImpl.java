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
        return vehicleDao.findAllByStatus(vehicleStatus);
    }

    @Override
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return vehicleDao.findAllByType(vehicleType);
    }

    @Override
    public Vehicle getVehicle(int vehicleId) {
        return vehicleDao.getById(vehicleId);
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleDao.save(vehicle);
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

