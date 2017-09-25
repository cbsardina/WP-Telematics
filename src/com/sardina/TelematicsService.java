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
        //1. write the Vehicle info to a file as json
            //VIN is file name eg. 66783jf9.json
                // file overwrites existing files for the same VIN
        //2. find all the files that end w/".json" and convert back to a VehicleInfo object
        //3. update a dashboard.html

      //find .json files
        File file = new File(".");
        int jsonCount = 0;
        double allOdometer = 0;
        double allFuelConsumption = 0;
        double allOilChngMileage = 0;
        double allEngineSize = 0;
        String addTableDataHTML = "";
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                jsonCount++;
                // Now you have a File object named "f".
                // You can use this to create a new instance of Scanner
                try {
                    //JSON to Java Object
                    ObjectMapper mapper = new ObjectMapper();
                    VehicleInfo vi = mapper.readValue(f, VehicleInfo.class);

                    //gets averages for top of dashboard
                    allOdometer += vi.getOdometer();
                    allFuelConsumption += vi.getConsumptionGalGas();
                    allOilChngMileage += vi.getOdometerLastOilChange();
                    allEngineSize += vi.getEngineSizeLiters();

                    String tempTableData = VehicleInfo.HTML_DASH_TABLEDATA;
                    addTableDataHTML += tempTableData.replace("{{thisVIN}}", vi.getVIN()) + tempTableData.replace("{{thisOdometer}}", vi.getVIN()) + tempTableData.replace("{{thisFuelConsumption}}", Double.toString(vi.getConsumptionGalGas())) + tempTableData.replace("{{thisOilChngMileage}}", Double.toString(vi.getOdometerLastOilChange())) + tempTableData.replace("{{thisEngineSize}}", Double.toString(vi.getEngineSizeLiters()));


                    //✳️ ** +++++ PICK UP HERE +++++ ** ✳️


                } catch (IOException ex) {
                    ex.printStackTrace(); }
            }//end if
        }//end forEach loop
        String avgOdometer = Double.toString(allOdometer/jsonCount);
        String avgFuelConsumption = Double.toString(allFuelConsumption/jsonCount);
        String avgOilChngMileage = Double.toString(allOilChngMileage/jsonCount);
        String avgEngineSize = Double.toString(allEngineSize/jsonCount);
        String count = Integer.toString(jsonCount);

    }//end report method

public static String addAvgsHTML_UPPER ( String template, String jsonCount, String avgOdometer, String avgFuelConsumption, String avgOilChngMileage, String avgEngineSize) {
    String upperHTML = "";
    upperHTML = template.replace("{{fleetCount}}", jsonCount);
    upperHTML += template.replace("{{avgOdometer}}", avgOdometer);
    upperHTML += template.replace("{{avgFuelConsumption}}", avgFuelConsumption);
    upperHTML += template.replace("{{avgOilChngMileage}}", avgOilChngMileage);
    upperHTML += template.replace("{avgEngineSize}}", avgEngineSize);
    return upperHTML;
}

}//end class TelematicsService










