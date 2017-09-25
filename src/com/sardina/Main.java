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

        VehicleInfo user = new VehicleInfo();

        user.setVIN(userVIN);
        user.setOdometer(userOdometer);
        user.setConsumptionGalGas(userConsumptionGalGas);
        user.setOdometerLastOilChange(userOdometerLastOilChange);
        user.setEngineSizeLiters(userEngineSizeLiters);

        TelematicsService teleReport = new TelematicsService();
        teleReport.report(user);


    }
}
