package assignment;

public class Van extends Vehicle {

    private int maxPassengers;
    private float maxWeight;
    private float maxVolume;

    public Van(int maxPassengers, float maxWeight, float maxVolume, boolean forPassenger, boolean forCargo, String make, String model, String licensePlate, float gasUsageKm) {
        super(forPassenger, forCargo, make, model, licensePlate, gasUsageKm);
        this.maxPassengers = maxPassengers;
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
    }
    
    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public float getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(float maxVolume) {
        this.maxVolume = maxVolume;
    }

}
