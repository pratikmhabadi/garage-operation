package com.learn.garage;


import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class garageOperation extends Garage {
    //get key
    public int getIndex(Map<Integer, Vehicle> vehicleMap) {
        if (vehicleMap.isEmpty()) {
            return 0;
        } else {
            TreeMap<Integer, Vehicle> vehicleTreeMap = new TreeMap<>(vehicleMap);
            return vehicleTreeMap.lastKey() + 1;
        }
    }

    public void getUpdateStatus(Map<Integer, Vehicle> vehicleMap, int id) {
        if (vehicleMap.get(id).getStatus().equals("repairing")) {
            vehicleMap.get(id).setStatus("repaired");
            System.out.println("Token No " +id + " has been repaired");
            setBalance(getBalance() + vehicleMap.get(id).getCost());
        } else {
            System.out.println("Token No " +id + " is already repaired");
        }
    }

    public Map<Integer, Vehicle> getAllOngoingRepair(Map<Integer, Vehicle> vehicleMap) {
        Map<Integer, Vehicle> vehicleMap1 = new TreeMap<>();
        for (Map.Entry<Integer, Vehicle> vehicleEntry : vehicleMap.entrySet()) {
            if (vehicleEntry.getValue().getStatus().equals("repairing")) {
                vehicleMap1.put(vehicleEntry.getKey(), vehicleEntry.getValue());
            }
        }
        return vehicleMap1;
    }

    public Map<Integer, Vehicle> getAllRepaired(Map<Integer, Vehicle> vehicleMap) {
        Map<Integer, Vehicle> vehicleMap1 = new TreeMap<>();
        for (Map.Entry<Integer, Vehicle> vehicleEntry : vehicleMap.entrySet()) {
            if (vehicleEntry.getValue().getStatus().equals("repaired")) {
                vehicleMap1.put(vehicleEntry.getKey(), vehicleEntry.getValue());
            }
        }
        return vehicleMap1;
    }

    /* public void displayAll(Map<Integer, Vehicle> vehicleMap) {
        for (Map.Entry<Integer, Vehicle> vehicleEntry : vehicleMap.entrySet()) {
            System.out.println("***********************");
            System.out.println("Id :" + vehicleEntry.getKey());
            System.out.println("Register No :" + vehicleEntry.getValue().getRegisterNo());
            System.out.println("Vehicle Type :" + vehicleEntry.getValue().getType());
            System.out.println("Vehicle Cost :" + vehicleEntry.getValue().getCost());
            System.out.println("Vehicle Status :" + vehicleEntry.getValue().getStatus());
        }
        System.out.println("***********************");
    }

    public Map<Integer, Vehicle> getAllBikes(Map<Integer, Vehicle> vehicleMap) {
        Map<Integer, Vehicle> bikeMap = new TreeMap<>();
        for (Map.Entry<Integer, Vehicle> vehicleEntry : vehicleMap.entrySet()) {
            if (vehicleEntry.getValue().getType().equals("bike")) {
                bikeMap.put(vehicleEntry.getKey(), vehicleEntry.getValue());
            }
        }
        return bikeMap;
    }

   public Map<Integer, Vehicle> getAllCars(Map<Integer, Vehicle> vehicleMap) {
        Map<Integer, Vehicle> carMap = new TreeMap<>();
        for (Map.Entry<Integer, Vehicle> vehicleEntry : vehicleMap.entrySet()) {
            if (vehicleEntry.getValue().getType().equals("car")) {
                carMap.put(vehicleEntry.getKey(), vehicleEntry.getValue());
            }
        }
        return carMap;
    }*/

    public void operation(Map<Integer, Vehicle> vehicleMap, int operationNO) {
        try {
            switch (operationNO) {
                case 1://show  account balance
                    System.out.println("***********************");
                    System.out.println("Balance :" + getBalance());
                    System.out.println("***********************");
                    break;

                case 2://Show ongoing repairs
                    Map<Integer, Vehicle> map = getAllOngoingRepair(vehicleMap);
                    System.out.println("***********************");
                    for (Map.Entry<Integer, Vehicle> entry : map.entrySet()) {
                        System.out.println("ID :" + entry.getKey() + "  Register No :" + entry.getValue().getRegisterNo() + "  Vehicle Type :" + entry.getValue().getType());
                    }
                    System.out.println("***********************");
                    break;

                case 3://Show repaired vehicles summary
                    int car = 0;
                    int bike = 0;
                    Map<Integer, Vehicle> map1 = getAllRepaired(vehicleMap);
                    System.out.println("***********************");
                    System.out.println("*Repaired vehicles Summary*");
                    for (Map.Entry<Integer, Vehicle> entry : map1.entrySet()) {
                        if (entry.getValue().getType().equals("bike")) {
                            bike++;
                        } else {
                            car++;
                        }
                        System.out.println("Id :"+entry.getKey()+ " Register No :" + entry.getValue().getRegisterNo() + "  Vehicle Type :" + entry.getValue().getType() + "  Vehicle Cost :" + entry.getValue().getCost());
                    }
                    System.out.println("***********************");
                    double bikeTotal = bike * 200;
                    double carTotal = car * 500;
                    double total = bikeTotal + carTotal;
                    System.out.println("Total Balance :" + total);
                    System.out.println(" Bikes = " + bike + " * 200 = " + bikeTotal);
                    System.out.println(" Cars = " + car + " * 200 = " + carTotal);
                    System.out.println("***********************");
                    break;

                case 4:// add new
                    Scanner sc = new Scanner(System.in);
                    Map<Integer, Vehicle> map2 = getAllOngoingRepair(vehicleMap);
                    System.out.println("***********************");
                    if ((map2.size() < 2) && (map2.size() > 0)) {
                        System.out.println("Enter Your Vehicle Register No");
                        String registerNo = sc.next().toUpperCase(Locale.ROOT);
                        System.out.println("Enter Your Vehicle Type ");
                        String vehicleType = sc.next().toLowerCase(Locale.ROOT);
                        if (!vehicleType.equals("bike") || !vehicleType.equals("car")) {
                            int n = 1;
                            while (n > 0) {
                                System.out.println("Enter Your Vehicle Type again (bike / car) ");
                                vehicleType = sc.next().toLowerCase(Locale.ROOT);
                                if (vehicleType.equals("bike") || vehicleType.equals("car")) {
                                    n = 0;
                                }
                            }
                        }
                        int token = getIndex(vehicleMap);
                        if (vehicleType.equals("bike")) {
                            vehicleMap.put(token, new Vehicle(registerNo, "repairing", vehicleType, 200));
                        } else {
                            vehicleMap.put(token, new Vehicle(registerNo, "repairing", vehicleType, 500));
                        }
                        System.out.println("Your Token No is :" + token);

                    } else {
                        System.out.println("Sorry ,We have maximum of 2 space ");
                    }
                    System.out.println("***********************");
                    break;

                case 5://get update Status
                    System.out.println("***********************");
                    operation(vehicleMap,2);
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Select id to change status :");
                    int token = sc1.nextInt();
                    getUpdateStatus(vehicleMap,token);
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
