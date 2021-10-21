package com.learn.garage;


import java.util.*;

public class GarageOperation {
    //get ID for new vehicle
    public int getId(Map<Integer, Vehicle> vehicleMap) {
        if (vehicleMap.isEmpty()) {
            return 0;
        } else {
            TreeMap<Integer, Vehicle> vehicleTreeMap = new TreeMap<>(vehicleMap);
            return vehicleTreeMap.lastKey() + 1;
        }
    }

    public Vehicle updateStatusToRepaired(Vehicle vehicle) {
        if (vehicle.getStatus().equals("repairing")) {
            vehicle.setStatus("repaired");
            System.out.println("Token No " + vehicle.getId() + " has been repaired");
        } else {
            System.out.println("Token No " + vehicle.getId() + " is already repaired");
        }
        return vehicle;
    }

    //to get Vehicles by Status repairing or repaired.
    public List<Vehicle> getVehiclesByStatus(Map<Integer, Vehicle> vehicleMap, String status) {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (Map.Entry<Integer, Vehicle> vehicleEntry : vehicleMap.entrySet()) {
            if (vehicleEntry.getValue().getStatus().equals(status)) {
                vehicleList.add(vehicleEntry.getValue());
            }
        }
        return vehicleList;
    }


}
