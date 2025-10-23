package Vehicles;

import Exceptions.InvalidOperationException;

abstract public class LandVehicle extends Vehicle {
    private int numWheels;

    //constructor
    public LandVehicle(String id, String model, double maxSpeed, double currentMileage,int numWheels) {
        super(id, model, maxSpeed, currentMileage);
        this.numWheels = numWheels;
    }

    //abstract methods
    public abstract void move(double distance) throws InvalidOperationException;
    public abstract double calculateFuelEfficiency();
    public abstract String toCSV();

    //getter method for number of wheels, setter not needed  right now (anyway number of wheels rarely changes)
    public int getNumWheels() {
        return numWheels;
    }

    @Override
    public double estimateJourneyTime(double distance) throws InvalidOperationException{
        if (distance < 0){
            throw new InvalidOperationException("Distance cannot be negative.");
        }
        return 1.1*(distance/super.getMaxSpeed());
    }

}
