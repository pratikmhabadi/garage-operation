package com.learn.garage;

public class Vehicle {
    private String registerNo;
    private String status;
    private String type;
    private double cost;

    public Vehicle(String registerNo, String status, String type, double cost) {
        this.registerNo = registerNo;
        this.status = status;
        this.type = type;
        this.cost = cost;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
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

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
