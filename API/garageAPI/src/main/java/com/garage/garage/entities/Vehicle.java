package com.garage.garage.entities;

public class Vehicle {

    private int id;
    private String registerNo;
    private String vehicleStatus;
    private String vehicleType;
    private double cost;

    public Vehicle(int id, String registerNo, String vehicleStatus, String vehicleType, double cost) {
        this.id = id;
        this.registerNo = registerNo;
        this.vehicleStatus = vehicleStatus;
        this.vehicleType = vehicleType;
        this.cost = cost;
    }

    public Vehicle() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
