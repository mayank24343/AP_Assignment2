package Vehicles;

import Exceptions.InvalidOperationException;

public abstract class Vehicle implements Comparable<Vehicle>{
    private String id;
    private String model;
    private double maxSpeed;
    private double currentMileage;

    //constructor
    public Vehicle(String id, String model, double maxSpeed, double currentMileage) {
        if (id != null && !id.isEmpty()) {
            this.id = id;
            this.model = model;
            this.maxSpeed = maxSpeed;
            this.currentMileage = currentMileage;
        }
        else {
            throw new IllegalArgumentException("id is null or empty");
        }
    }

    //comparable for sorting
    @Override
    public int compareTo(Vehicle v) {
        if (this.calculateFuelEfficiency() > v.calculateFuelEfficiency()) {
            return 1;
        }
        else if (this.calculateFuelEfficiency() < v.calculateFuelEfficiency()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    //abstract functions
    public abstract void move(double distance) throws InvalidOperationException;
    public abstract double calculateFuelEfficiency();
    public abstract double estimateJourneyTime(double distance) throws InvalidOperationException;
    //function to convert to csv for persistence
    public abstract String toCSV();

    //concrete methods & getter/setter methods
    public void displayInfo(){
        System.out.printf("Vehicle ID: %s | Model: %s | Current Mileage: %.2f | Maximum Speed: %.2f\n", id, model, currentMileage, maxSpeed);
    }

    public double getCurrentMileage() {
        return currentMileage;
    }

    void setCurrentMileage(double currentMileage) {
        if (currentMileage < 0){
            throw new IllegalArgumentException("currentMileage is negative");
        }
        this.currentMileage = currentMileage;
    }

    public String getId() {
        return id;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public String getModel() {
        return model;
    }

    //currently no requirement to reset maxspeed,model,id so no setter method
}
