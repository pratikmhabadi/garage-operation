package com.learn.garage;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner sc = new Scanner(System.in);
        GarageOperation garage = new GarageOperation();

        Map<Integer, Vehicle> garageMap = new TreeMap<>();
        garageMap.put(1, new Vehicle(1, "MH04AC9345", "repaired", "car", 500));
        garageMap.put(2, new Vehicle(2, "MH04AC9345", "repaired", "bike", 200));
        garageMap.put(3, new Vehicle(3, "MH04AC9345", "repaired", "bike", 200));
        garageMap.put(7, new Vehicle(7, "MH04AC9345", "repaired", "car", 500));
        garageMap.put(8, new Vehicle(8, "MH04AC9345", "repaired", "bike", 200));
        garageMap.put(4, new Vehicle(4, "MH04AC9345", "repaired", "car", 500));
        garageMap.put(6, new Vehicle(6, "MH04AC9345", "repaired", "bike", 200));
        garageMap.put(5, new Vehicle(5, "MH04AC9345", "repairing", "car", 500));

        int work = 1;
        while (work > 0) {
            System.out.println("Show account balance = 1 \n" +
                    "Show ongoing repairs = 2 \n" +
                    "Show repaired vehicles summary = 3 \n" +
                    "Add New Entry = 4 \n" +
                    "Update Status to repaired = 5 \n");
            System.out.println("Choose your options :");

            try {
                int operationNo = sc.nextInt();
                garage.operation(garageMap, operationNo);
            } catch (Exception e) {
                System.out.println("You Entered Something Unexpected Input, Enter Again :");
            }

            System.out.println("Would you like to continue? (y/n) :");
            String exit = sc.next().toUpperCase(Locale.ROOT);
            if (exit.equals("N")) {
                System.out.println("***Thank You***");
                work = 0;
            }
        }


    }
}
