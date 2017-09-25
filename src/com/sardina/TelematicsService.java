package com.sardina;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TelematicsService extends VehicleInfo {

    void report(VehicleInfo vehicleInfo) {

      //Java to JSON -- verified working, prints out json object
        String jsonVehicleInfo = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonVehicleInfo = mapper.writeValueAsString(vehicleInfo);
        } catch (IOException ex) {
            ex.printStackTrace(); }

      //Create VIN.json file for the new instance of vehicleInfo
        try {
            File jsonFile = new File(vehicleInfo.getVIN() + ".json");
            FileWriter newFile = new FileWriter(jsonFile);

            newFile.write(jsonVehicleInfo);
            newFile.close();
        } catch (IOException ex) {
            ex.printStackTrace(); }

      //find .json files, get data for averages, build table html
        int jsonCount = 0;
        double allOdometer = 0;
        double allFuelConsumption = 0;
        double allOilChngMileage = 0;
        double allEngineSize = 0;
        String addTableDataHTML = "";       //this is the complete tale data to be concatenated

        File file = new File(".");
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                jsonCount++;

                try {
                    //JSON to Java Object
                    ObjectMapper mapper = new ObjectMapper();
                    VehicleInfo vi = mapper.readValue(f, VehicleInfo.class);

                    //gets averages for top of dashboard
                    allOdometer += vi.getOdometer();
                    allFuelConsumption += vi.getConsumptionGalGas();
                    allOilChngMileage += vi.getOdometerLastOilChange();
                    allEngineSize += vi.getEngineSizeLiters();

                    //build HTML table data
                    String tempTable = addTableHTML(VehicleInfo.HTML_DASH_TABLEDATA, vi.getVIN(), vi.getOdometer(), vi.getConsumptionGalGas(), vi.getOdometerLastOilChange(), vi.getEngineSizeLiters());

                    addTableDataHTML += tempTable;

                } catch (IOException ex) {
                    ex.printStackTrace(); }
            }//end if
        }//end forEach loop

        String avgOdometer = calcAvg(allOdometer, jsonCount);
        String avgFuelConsumption = calcAvg(allFuelConsumption, jsonCount);
        String avgOilChngMileage = calcAvg(allOilChngMileage, jsonCount);
        String avgEngineSize = calcAvg(allEngineSize, jsonCount);
        String count = Integer.toString(jsonCount);

        //builds whole dashboard
        String HTMLDashboard = addAvgsHTML_UPPER(VehicleInfo.HTML_DASH_UPPER, count, avgOdometer, avgFuelConsumption, avgOilChngMileage, avgEngineSize) + addTableDataHTML;

        //write dashboard.html file
        try {
            File htmlFile = new File("dashboard.html");
            FileWriter newFile = new FileWriter(htmlFile);

            newFile.write(HTMLDashboard);
            newFile.close();
        } catch (IOException ex) {
            ex.printStackTrace(); }

    }//end report method

//CALCULATION METHODS

public static String addAvgsHTML_UPPER ( String template, String jsonCount, String avgOdometer, String avgFuelConsumption, String avgOilChngMileage, String avgEngineSize) {
    String upperHTML = template.replace("{{count}}", jsonCount);
    upperHTML = upperHTML.replace("{{avgOdo}}", avgOdometer);
    upperHTML = upperHTML.replace("{{avgCons}}", avgFuelConsumption);
    upperHTML = upperHTML.replace("{{avgLastOil}}", avgOilChngMileage);
    upperHTML = upperHTML.replace("{{avgEngSize}}", avgEngineSize);
    return upperHTML;
}

public static String calcAvg(Double numerator, int count) {
    Double temp = numerator/count;
    Double rounded = Math.round(temp * 10d)/10d;
    return Double.toString(rounded);
}

public static String addTableHTML(String template, String vin, double odometer, double consumption, double lastOilChng, double engineSize) {
        String html = template.replace("{{vin}}", vin);
        html = html.replace("{{odo}}", Double.toString(odometer));
        html = html.replace("{{fuelCons}}", Double.toString(consumption));
        html = html.replace("{{lastOil}}", Double.toString(lastOilChng));
        html = html.replace("{{engSize}}", Double.toString(engineSize));
        return html;
}



}//end class TelematicsService










