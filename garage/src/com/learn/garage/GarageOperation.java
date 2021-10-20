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

    //for changing status repairing to repaired
    public void getUpdateStatus(Map<Integer, Vehicle> vehicleMap, int id) {
        if (vehicleMap.get(id).getStatus().equals("repairing")) {
            vehicleMap.get(id).setStatus("repaired");
            System.out.println("Token No " + id + " has been repaired");
        } else {
            System.out.println("Token No " + id + " is already repaired");
        }
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

    //switching operations by inputs
    public void operation(Map<Integer, Vehicle> vehicleMap, int operationNO) {
        try {
            String repaired = "repaired";
            String repairing = "repairing";
            switch (operationNO) {
                case 1://show  account balance
                    double balance = 0.0;
                    List<Vehicle> repairedAllVehicleList = getVehiclesByStatus(vehicleMap, repaired);
                    for (Vehicle vehicle : repairedAllVehicleList) {
                        balance += vehicle.getCost();
                    }
                    System.out.println("***********************");
                    System.out.println("Balance :" + balance);
                    System.out.println("***********************");
                    break;

                case 2://Show ongoing repairs
                    List<Vehicle> repairingVehicleList = getVehiclesByStatus(vehicleMap, repairing);
                    System.out.println("***********************");
                    for (Vehicle vehicle : repairingVehicleList) {
                        System.out.println("ID :" + vehicle.getId() + "  Register No :" + vehicle.getRegisterNo() + "  Vehicle Type :" + vehicle.getType());
                    }
                    System.out.println("***********************");
                    break;

                case 3://Show repaired vehicles summary
                    int car = 0;
                    int bike = 0;
                    List<Vehicle> repairedVehicleList = getVehiclesByStatus(vehicleMap, repaired);
                    System.out.println("***********************");
                    System.out.println("*Repaired vehicles Summary*");
                    for (Vehicle vehicle : repairedVehicleList) {
                        if (vehicle.getType().equals("bike")) {
                            bike++;
                        } else {
                            car++;
                        }
                        System.out.println("Id :" + vehicle.getId() + " Register No :" + vehicle.getRegisterNo() + "  Vehicle Type :" + vehicle.getType() + "  Vehicle Cost :" + vehicle.getCost());
                    }
                    System.out.println("***********************");
                    double bikeTotal = bike * 200;
                    double carTotal = car * 500;
                    double total = bikeTotal + carTotal;
                    System.out.println("Total Balance :" + total);
                    System.out.println(" Bikes = " + bike + " * 200 = " + bikeTotal);
                    System.out.println(" Cars = " + car + " * 500 = " + carTotal);
                    System.out.println("***********************");
                    break;

                case 4:// add new vehicle
                    Scanner sc = new Scanner(System.in);
                    List<Vehicle> repairingAllVehicleList = getVehiclesByStatus(vehicleMap, repairing);
                    System.out.println("***********************");
                    if (repairingAllVehicleList.size() < 2) {
                        System.out.println("Enter Your Vehicle Register No");
                        String registerNo = sc.next().toUpperCase(Locale.ROOT);
                        System.out.println("Enter Your Vehicle Type (bike / car) ");
                        String vehicleType = sc.next().toLowerCase(Locale.ROOT);
                        int n = 1;
                        while (n > 0) {
                            if (vehicleType.equals("bike") || vehicleType.equals("car")) {
                                n = 0;
                            } else {
                                System.out.println("Sorry ,we repair only cars and bike " +
                                        "Enter Your Vehicle Type again (bike / car):");
                                vehicleType = sc.next().toLowerCase(Locale.ROOT);
                            }
                        }
                        int token = getId(vehicleMap);
                        if (vehicleType.equals("bike")) {
                            vehicleMap.put(token, new Vehicle(token, registerNo, "repairing", vehicleType, 200));
                        } else {
                            vehicleMap.put(token, new Vehicle(token, registerNo, "repairing", vehicleType, 500));
                        }
                        System.out.println("Your Token No is :" + token);

                    } else {
                        System.out.println("Sorry ,We have maximum of 2 space ");
                    }
                    System.out.println("***********************");
                    break;

                case 5://get update Status
                    System.out.println("***********************");
                    operation(vehicleMap, 2);
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Select id to change status :");
                    int token = sc1.nextInt();
                    getUpdateStatus(vehicleMap, token);
                    System.out.println("***********************");
                    break;

                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
    }


}
