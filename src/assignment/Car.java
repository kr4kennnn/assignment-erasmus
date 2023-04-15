package assignment;

public class Car extends Vehicle {

    private int maxPassengers;
    
    public Car(int maxPassengers, boolean forPassenger, boolean forCargo, String make, String model, String licensePlate, float gasUsageKm) {
        super(forPassenger, forCargo, make, model, licensePlate, gasUsageKm);
        this.maxPassengers = maxPassengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

}
