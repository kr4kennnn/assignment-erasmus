package assignment;

public class Freight extends Vehicle {

    private float maxWeight;
    private float maxVolume;
    
    public Freight(float maxWeight, float maxVolume, boolean forPassenger, boolean forCargo, String make, String model, String licensePlate, float gasUsageKm) {
        super(forPassenger, forCargo, make, model, licensePlate, gasUsageKm);
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
