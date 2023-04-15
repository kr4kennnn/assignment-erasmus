package assignment;

import java.io.Serializable;
import java.util.*;

public class Ride implements Serializable{

    private Vehicle vehicle;
    private boolean finished = false;
    private int numOfPeople;
    private int distance;
    private float volCargo;
    private float weightCargo;
    private float startPrice = (float) 10.5;
    private float finalPrice;
    private Date startTime;
    private Date endTime;

    public Ride(Vehicle vehicle, int distance, Date startTime, Date endTime) {
        this.vehicle = vehicle;
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public float getVolCargo() {
        return volCargo;
    }

    public void setVolCargo(float volCargo) {
        this.volCargo = volCargo;
    }

    public float getWeightCargo() {
        return weightCargo;
    }

    public void setWeightCargo(float weightCargo) {
        this.weightCargo = weightCargo;
    }

    public float getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(float startPrice) {
        this.startPrice = startPrice;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public float finalRidePrice() {
        return finalPrice = startPrice + vehicle.getPricePerKm() * distance;
    }

    @Override
    public String toString() {
        return "Ride{" + "vehicle=" + vehicle + ", distance=" + distance + ", startTime=" + startTime + ", endTime=" + endTime + 
                ", Price=" + finalPrice + '}';
    }
    
    
}
