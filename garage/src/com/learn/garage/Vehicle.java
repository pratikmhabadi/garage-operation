package com.learn.garage;

public class Vehicle {
    private int id;
    private String registerNo;
    private String status;
    private String type;
    private double cost;

    public Vehicle(int id, String registerNo, String status, String type, double cost) {
        this.id = id;
        this.registerNo = registerNo;
        this.status = status;
        this.type = type;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public double getCost() {
        return cost;
    }

}
