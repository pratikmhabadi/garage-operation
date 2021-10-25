package com.garage.garage.services;

import com.garage.garage.entities.Vehicle;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VehicleServiceImpl implements VehicleService {
    TreeMap<Integer, Vehicle> garageMap = new TreeMap<>();

    public VehicleServiceImpl() {
        garageMap.put(1, new Vehicle(1, "MH04AC9345", "repaired", "car", 500));
        garageMap.put(2, new Vehicle(2, "MH04AC9345", "repaired", "bike", 200));
        garageMap.put(3, new Vehicle(3, "MH04AC9345", "repaired", "bike", 200));
        garageMap.put(7, new Vehicle(7, "MH04AC9345", "repaired", "car", 500));
        garageMap.put(8, new Vehicle(8, "MH04AC9345", "repaired", "bike", 200));
        garageMap.put(4, new Vehicle(4, "MH04AC9345", "repaired", "car", 500));
        garageMap.put(6, new Vehicle(6, "MH04AC9345", "repairing", "bike", 200));
        garageMap.put(5, new Vehicle(5, "MH04AC9345", "repairing", "car", 500));
    }
// generate new ID
    public int getId() {
        if (garageMap.isEmpty()) {
            return 1;
        } else {
            return garageMap.lastKey() + 1;
        }
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (Map.Entry<Integer, Vehicle> vehicleEntry : garageMap.entrySet()) {
            vehicleList.add(vehicleEntry.getValue());
        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> getVehiclesByStatus(String vehicleStatus) {
        List<Vehicle> list = new ArrayList<>();
        for (Vehicle vehicle : getAllVehicles()) {
            if (vehicle.getVehicleStatus().equals(vehicleStatus)) {
                list.add(vehicle);
            }
        }
        return list;
    }

    @Override
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> list = new ArrayList<>();
        for (Vehicle vehicle : getAllVehicles()) {
            if (vehicle.getVehicleType().equals(vehicleType)) {
                list.add(vehicle);
            }
        }
        return list;
    }

    @Override
    public Vehicle getVehicle(int vehicleId) {
        Vehicle v = null;
        for (Vehicle vehicle : getAllVehicles()) {
            if (vehicle.getId() == vehicleId) {
                v = vehicle;
            }
        }
        return v;
    }

    @Override
    public Vehicle addVehicle(String registerNo, String vehicleType) {
        int vehicleId = getId();
        String type = vehicleType.toLowerCase(Locale.ROOT);
        if (getVehiclesByStatus("repairing").size() < 2) {
            switch (type) {
                case "bike":
                    garageMap.put(vehicleId, new Vehicle(vehicleId, registerNo.toUpperCase(Locale.ROOT), "repairing", type, 200));
                    return garageMap.get(vehicleId);
                case "car":
                    garageMap.put(vehicleId, new Vehicle(vehicleId, registerNo.toUpperCase(Locale.ROOT), "repairing", type, 500));
                    return garageMap.get(vehicleId);
                default:
                    return null;
            }
        }
        return null;
    }


    @Override
    public Vehicle updateVehicle(int vehicleId) {
        garageMap.get(vehicleId).setVehicleStatus("repaired");
        return garageMap.get(vehicleId);
    }

    @Override
    public void deleteVehicle(int vehicleId) {
        garageMap.remove(vehicleId, garageMap.get(vehicleId));
    }
}

