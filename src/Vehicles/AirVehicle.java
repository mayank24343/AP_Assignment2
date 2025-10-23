package Vehicles;

import Exceptions.InvalidOperationException;

abstract public class AirVehicle extends Vehicle {
    private double maxAltitude;

    //constructor
    public AirVehicle(String id, String model, double maxSpeed, double currentMileage, double maxAltitude) {
        super(id,model,maxSpeed,currentMileage);
        this.maxAltitude = maxAltitude;
    }

    //abstract functions
    public abstract String toCSV();
    public abstract void move(double distance) throws InvalidOperationException;
    public abstract double calculateFuelEfficiency();

    //getter for maximum altitude (no setter as max altitude won't change, also not required)
    public double getMaxAltitude() {
        return maxAltitude;
    }

    @Override
    public double estimateJourneyTime(double distance) throws InvalidOperationException {
        if (distance < 0){
            throw new InvalidOperationException("Distance cannot be negative.");
        }
        return 0.95*(distance/super.getMaxSpeed());
    }
}
