package com.sardina;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TelematicsService extends VehicleInfo {

    void report(VehicleInfo vehicleInfo) {

      //Java to JSON
        ObjectMapper mapper = new ObjectMapper();
        String jsonVehicleInfo = mapper.writeValueAsString(vehicleInfo);

      //Create VIN.json file for each instance of vehicleInfo
        try {
            File jsonFile = new File(this.getVIN() + ".json");
            FileWriter newFile = new FileWriter(jsonFile);

            newFile.write(jsonVehicleInfo);
            newFile.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //1. write the Vehicle info to a file as json
            //VIN is file name eg. 66783jf9.json
                // file overwrites existing files for the same VIN
        //2. find all the files that end w/".json" and convert back to a VehicleInfo object
        //3. update a dashboard.html

      //find .json files
        File file = new File(".");
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                // Now you have a File object named "f".
                // You can use this to create a new instance of Scanner
                try {
                    //JSON to Java
                    ObjectMapper mapper = new ObjectMapper();
                    VehicleInfo vi = mapper.readValue(f, VehicleInfo.class);

                    //** +++++ PICK UP HERE +++++ **

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }
    }//end report method



//HTML text
    public static final String HTMLdashUpper = "<html>"
        + "<title>Vehicle Telematics Dashboard</title>"
        + "<body>"
        + "<h1 align=\"center\">Averages for {{fleetCount}} vehicles</h1>"
        + "<table align=\"center\">"
        + "<tr>"
        + "<th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>"
        + "</tr>"
        + "<tr>"
        + "<td align=\"center\">{{avgOdometer}}</td><td align=\"center\">{{avgFuelConsumption}}</td><td align=\"center\">{{avgOilChngMileage}}</td align=\"center\"><td align=\"center\">{{avgEngineSize}}</td>"
        + "</tr>"
        + "</table>"
        + "<h1 align=\"center\">History</h1>"
        + "<table align=\"center\" border=\"1\">"
        + "<tr>"
        + "<th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>"
        + "</tr>";

    public static final String HTMLdashTableData = "<tr>"
            + "<td align=\"center\">{{thisVIN}}</td><td align=\"center\">{{thisOdometer}}</td><td align=\"center\">{{thisFuelConsumption}}</td><td align=\"center\">{{thisOilChngMileage}}</td align=\"center\"><td align=\"center\">{{thisEngineSize}}</td>"
            + "</tr>"

    public static final String HTMLdashLower = "</table>"
            + "</body>"
            + "</html>";
}//end class TelematicsService

//finds files ending in .json










