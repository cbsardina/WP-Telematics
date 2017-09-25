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
    public static final String HTML_DASH_UPPER = "<!DOCTYPE html>"
            + "<head>"
            + "<html>"
            + "<meta charset=\"utf-8\">"
            + "<title>Vehicle Telematics Dashboard</title>"
            + "</head>"
            + "<body>"
            + "<h1 align=\"center\">Averages for {{count}}️ vehicles</h1>"
            + "<table align=\"center\">"
            + "<tr>"
            + "<th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>"
            + "</tr>"
            + "<tr>"
            + "<td align=\"center\">{{avgOdo}}</td><td align=\"center\">{{avgCons}}️</td><td align=\"center\">{{avgLastOil}}️</td align=\"center\"><td align=\"center\">{{avgEngSize}}️</td>"
            + "</tr>"
            + "</table>"
            + "<h1 align=\"center\">History</h1>"
            + "<table align=\"center\" border=\"1\">"
            + "<tr>"
            + "<th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>"
            + "</tr>";

    public static final String HTML_DASH_TABLEDATA = "<tr>"
            + "<td align=\"center\">{{vin}}️</td><td align=\"center\">{{odo}}️</td><td align=\"center\">{{fuelCons}}️</td><td align=\"center\">{{lastOil}}</td align=\"center\"><td align=\"center\">{{engSize}}️</td>"
            + "</tr>";

    public static final String HTML_DASH_LOWER = "</table>"
            + "</body>"
            + "</html>";

}//end VehicleInfo class