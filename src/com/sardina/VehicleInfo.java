package com.sardina;

public class VehicleInfo {

    int VIN;
    double odometer;
    double consumptionGalGas;
    double odometerLastOilChange;
    double engineSizeLiters;

//Constructor (POJO/bean)
    public VehicleInfo() {}

//getters/setters
    public int getVIN() { return VIN; }

    public void setVIN(int VIN) { this.VIN = VIN; }

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


}//end VehicleInfo class
