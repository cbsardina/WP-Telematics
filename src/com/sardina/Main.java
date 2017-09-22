package com.sardina;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your VIN number: ");
            String userVIN = scanner.nextLine();
        System.out.println("Enter your odometer: ");
            double userOdometer = scanner.nextDouble();
        System.out.println("Enter your gas consumption: ");
            double userConsumptionGalGas = scanner.nextDouble();
        System.out.println("Enter your odometer reading at your last oil change: ");
            double userOdometerLastOilChange = scanner.nextDouble();
        System.out.println("Enter your engine size in Liters: ");
            double userEngineSizeLiters = scanner.nextDouble();

        VehicleInfo user1 = new VehicleInfo();


        System.out.println(user1.getVIN());
        System.out.println(user1.getOdometer());
        System.out.println(user1.getConsumptionGalGas());
        System.out.println(user1.getOdometerLastOilChange());
        System.out.println(user1.getEngineSizeLiters());


    }
}
