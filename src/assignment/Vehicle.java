package assignment;

import java.io.Serializable;

public class Vehicle implements Serializable {

    private boolean forPassenger;
    private boolean forCargo;
    private boolean available = true;
    private String make;
    private String model;
    private String licensePlate;
    private float gasUsageKm;
    private float pricePerKm;
    private float totalDist = 0;

    public Vehicle(boolean forPassenger, boolean forCargo, String make, String model, String licensePlate, float gasUsageKm) {
        this.forPassenger = forPassenger;
        this.forCargo = forCargo;
        this.make = make;
        this.model = model;
        this.licensePlate = licensePlate;
        this.gasUsageKm = gasUsageKm;
        this.pricePerKm = 100 / gasUsageKm;
    }

    public boolean isForPassenger() {
        return forPassenger;
    }

    public void setForPassenger(boolean forPassenger) {
        this.forPassenger = forPassenger;
    }

    public boolean isForCargo() {
        return forCargo;
    }

    public void setForCargo(boolean forCargo) {
        this.forCargo = forCargo;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public float getGasUsageKm() {
        return gasUsageKm;
    }

    public void setGasUsageKm(float gasUsageKm) {
        this.gasUsageKm = gasUsageKm;
    }

    public float getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(float pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public float calcRidePrice(int distance, float gasUsageKm) {
        return gasUsageKm * distance;
    }

    public void addTotal(float distance) {
        totalDist += distance;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "make=" + make + ", model=" + model + ", licensePlate=" + licensePlate + '}';
    }

}
