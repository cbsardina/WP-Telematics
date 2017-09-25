package com.sardina;

public class VehicleInfo {

    String VIN;
    double odometer;
    double consumptionGalGas;
    double odometerLastOilChange;
    double engineSizeLiters;

//Constructor (POJO)
    public VehicleInfo() {}

//getters/setters
    public String getVIN() { return VIN; }

    public void setVIN(String VIN) { this.VIN = VIN; }

    public double getOdometer() { return odometer; }

    public void setOdometer(double odometer) { this.odometer = odometer; }

    public double getConsumptionGalGas() { return consumptionGalGas; }

    public void setConsumptionGalGas(double consumptionGalGas) {
        this.consumptionGalGas = consumptionGalGas; }

    public double getOdometerLastOilChange() {
        return odometerLastOilChange; }

    public void setOdometerLastOilChange(double odometerLastOilChange) {
        this.odometerLastOilChange = odometerLastOilChange; }

    public double getEngineSizeLiters() {
        return engineSizeLiters; }

    public void setEngineSizeLiters(double engineSizeLiters) {
        this.engineSizeLiters = engineSizeLiters; }

    //HTML text
    public static final String HTML_DASH_UPPER = "<html>"
            + "<title>Vehicle Telematics Dashboard</title>"
            + "<body>"
            + "<h1 align=\"center\">Averages for {{fleetCount}}️ vehicles</h1>"
            + "<table align=\"center\">"
            + "<tr>"
            + "<th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>"
            + "</tr>"
            + "<tr>"
            + "<td align=\"center\">{{avgOdometer}}</td><td align=\"center\">{{avgFuelConsumption}}️</td><td align=\"center\">{{avgOilChngMileage}}️</td align=\"center\"><td align=\"center\">{{avgEngineSize}}️</td>"
            + "</tr>"
            + "</table>"
            + "<h1 align=\"center\">History</h1>"
            + "<table align=\"center\" border=\"1\">"
            + "<tr>"
            + "<th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>"
            + "</tr>";

    public static final String HTML_DASH_TABLEDATA = "<tr>"
            + "<td align=\"center\">{{thisVIN}}️</td><td align=\"center\">{{thisOdometer}}️</td><td align=\"center\">{{thisFuelConsumption}}️</td><td align=\"center\">{{thisOilChngMileage}}</td align=\"center\"><td align=\"center\">{{thisEngineSize}}️</td>"
            + "</tr>";

    public static final String HTML_DASH_LOWER = "</table>"
            + "</body>"
            + "</html>";

}//end VehicleInfo class
