package Vehicles;

import Exceptions.InvalidOperationException;

public abstract class WaterVehicle extends Vehicle {
    private boolean hasSail;

    //constructor
    public WaterVehicle(String id, String model, double maxSpeed, double currentMileage, boolean hasSail) {
        super(id, model, maxSpeed, currentMileage);
        this.hasSail=hasSail;
    }

    //abstract functions
    public abstract String toCSV();
    public abstract void move(double distance) throws InvalidOperationException;
    public abstract double calculateFuelEfficiency();

    @Override
    public double estimateJourneyTime(double distance) throws InvalidOperationException{
        if (distance < 0){
            throw new  InvalidOperationException("Distance cannot be negative.");
        }
        return 1.15*(distance/super.getMaxSpeed());
    }

    //getter for hasSail (setter not needed, if a ship has sail or not rarely changes)
    public boolean getHasSail(){
        return hasSail;
    }
}
