package com.learn.garage;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static GarageOperation garage = new GarageOperation();
    static Map<Integer, Vehicle> garageMap = new TreeMap<>();

    public static void updateStatus(int token) {
        try {
            Vehicle vehicle = garageMap.get(token);
            vehicle = garage.updateStatusToRepaired(vehicle);
            garageMap.put(token, vehicle);
        } catch (Exception e) {
            System.out.println("Enter Token is not present");
        }
    }

    public static void displayBalance() {
        String status = "repaired";
        double balance = 0.0;
        List<Vehicle> repairedAllVehicleList = garage.getVehiclesByStatus(garageMap, status);
        for (Vehicle vehicle : repairedAllVehicleList) {
            balance += vehicle.getCost();
        }
        System.out.println("Balance :" + balance);
    }

    public static void displayOngoingRepair() {
        String status = "repairing";
        List<Vehicle> repairingVehicleList = garage.getVehiclesByStatus(garageMap, status);
        if (!repairingVehicleList.isEmpty()) {
            for (Vehicle vehicle : repairingVehicleList) {
                System.out.println("ID :" + vehicle.getId() + "  Register No :" + vehicle.getRegisterNo() + "  Vehicle Type :" + vehicle.getType());
            }
        } else {
            System.out.println(" Garage is Empty");
        }
    }

    public static void addNewEntry(String registerNo, String type) {
        int token = garage.getId(garageMap);
        List<Vehicle> repairedAllVehicleList = garage.getVehiclesByStatus(garageMap, "repairing");
        if (repairedAllVehicleList.size() < 2) {
            switch (type) {
                case "bike":
                    garageMap.put(token, new Vehicle(token, registerNo, "repairing", type, 200));
                    System.out.println("Token no is " + token);
                    break;
                case "car":
                    garageMap.put(token, new Vehicle(token, registerNo, "repairing", type, 500));
                    System.out.println("Token no is " + token);
                    break;
                default:
                    System.out.println("We not repair this vehicle type");
                    break;
            }
        } else {
            System.out.println("Sorry, We have maximum 2 space");
        }
    }

    public static void displayRepairedSummary() {
        int car = 0;
        int bike = 0;
        String status = "repaired";
        List<Vehicle> repairedVehicleList = garage.getVehiclesByStatus(garageMap, status);
        for (Vehicle vehicle : repairedVehicleList) {
            if (vehicle.getType().equals("bike")) {
                bike++;
            } else {
                car++;
            }
            System.out.println("Id :" + vehicle.getId() + " Register No :" + vehicle.getRegisterNo() + "  Vehicle Type :" + vehicle.getType() + "  Vehicle Cost :" + vehicle.getCost());
        }
        double bikeTotal = bike * 200;
        double carTotal = car * 500;
        double total = bikeTotal + carTotal;
        System.out.println("Total Balance :" + total);
        System.out.println(" Bikes = " + bike + " * 200 = " + bikeTotal);
        System.out.println(" Cars = " + car + " * 500 = " + carTotal);
    }

    public static void displayMap() {
        for (Map.Entry<Integer, Vehicle> entry : garageMap.entrySet()) {
            System.out.println("Id :" + entry.getKey() + " Register No :" + entry.getValue().getRegisterNo() + "  Vehicle Type :" + entry.getValue().getType() + "  Vehicle Cost :" + entry.getValue().getCost() + "  Status : " + entry.getValue().getStatus());
        }
    }

    public static void main(String[] args) {
        // write your code here

        garageMap.put(1, new Vehicle(1, "MH04AC9345", "repaired", "car", 500));
        garageMap.put(2, new Vehicle(2, "MH04AC9345", "repaired", "bike", 200));
        garageMap.put(3, new Vehicle(3, "MH04AC9345", "repaired", "bike", 200));
        garageMap.put(7, new Vehicle(7, "MH04AC9345", "repaired", "car", 500));
        garageMap.put(8, new Vehicle(8, "MH04AC9345", "repaired", "bike", 200));
        garageMap.put(4, new Vehicle(4, "MH04AC9345", "repaired", "car", 500));
        garageMap.put(6, new Vehicle(6, "MH04AC9345", "repairing", "bike", 200));
        garageMap.put(5, new Vehicle(5, "MH04AC9345", "repairing", "car", 500));


        displayMap();
        displayBalance();
        displayRepairedSummary();
        displayOngoingRepair();
        addNewEntry("MH04AC2345", "car");
        updateStatus(1);


    }
}
