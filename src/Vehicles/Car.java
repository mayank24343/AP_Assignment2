package Vehicles;

import Exceptions.InsufficientFuelException;
import Exceptions.InvalidOperationException;
import Exceptions.OverloadException;
import Interfaces.FuelConsumable;
import Interfaces.Maintainable;
import Interfaces.PassengerCarrier;

public class Car extends LandVehicle implements FuelConsumable, PassengerCarrier, Maintainable {
    //properties
    private double fuelLevel = 0;
    private int passengerCapacity = 5;
    private int currentPassengers = 0;
    private boolean maintenanceNeeded = false;

    //constructor
    public Car(String id, String model, double maxSpeed, double currentMileage, int numWheels, double fuelLevel, int passengerCapacity, int currentPassengers) throws InvalidOperationException {
        super(id,model,maxSpeed,currentMileage,numWheels);
        if (fuelLevel < 0 || maxSpeed < 0 || numWheels < 4 || currentMileage < 0 || passengerCapacity < 0 || currentPassengers < 0) {
            throw new InvalidOperationException("Invalid parameters");
        }
        this.fuelLevel = fuelLevel;
        this.passengerCapacity = passengerCapacity;
        this.currentPassengers = currentPassengers;
        if (currentMileage > 10000){
            scheduleMaintenance();
        }
    }

    //constructor if passengers and fuel level not provided - these can default to zero, and be changed by refuel, and board/deboard methods
    public Car(String id, String model, double maxSpeed, double currentMileage, int numWheels, int passengerCapacity){
        super(id,model,maxSpeed,currentMileage,numWheels);
        this.passengerCapacity = passengerCapacity;
        if (currentMileage > 10000){
            scheduleMaintenance();
        }
    }

    public Car(String id, String model, double maxSpeed, double currentMileage, int numWheels){
        super(id,model,maxSpeed,currentMileage,numWheels);
        if (currentMileage > 10000){
            scheduleMaintenance();
        }
    }

    //concrete class - implement all abstract methods, interface methods
    @Override
    public void move(double distance) throws InvalidOperationException {
        if (distance < 0) {
            throw new InvalidOperationException("Negative distance.");
        }
        consumeFuel(distance);

        setCurrentMileage(getCurrentMileage()+distance);
        System.out.println("Vehicle ID:"+this.getId()+": Driving on road ...");
        if (getCurrentMileage() > 10000){
            scheduleMaintenance();
        }

    }

    @Override
    public double calculateFuelEfficiency() {
        return 15.0;
    }

    //FuelConsumable Interface
    @Override
    public void refuel(double amount) throws InvalidOperationException {
        if (amount <= 0){
            throw new InvalidOperationException("Refuel amount must be greater than 0.");
        }
        fuelLevel += amount;
    }

    @Override
    public double getFuelLevel(){
        return fuelLevel;
    }

    @Override
    public double consumeFuel(double distance) throws InsufficientFuelException {
        double amountConsumed = distance/calculateFuelEfficiency();
        if (fuelLevel < amountConsumed){
            throw new InsufficientFuelException("Insufficient fuel.");
        }
        fuelLevel -= amountConsumed;
        return amountConsumed;
    }

    //Maintenance Interface
    @Override
    public void scheduleMaintenance() {
        maintenanceNeeded = true;
        System.out.println("Vehicle ID: "+getId()+"| Maintenance is scheduled.");
    }

    @Override
    public boolean needsMaintenance() {
        if (getCurrentMileage() > 10000){
            maintenanceNeeded = true;
        };
        return maintenanceNeeded;
    }

    @Override
    public void performMaintenance() {
        maintenanceNeeded = false;
        setCurrentMileage(0);
        System.out.println("Vehicle ID: "+getId()+"| Maintenance is performed.");
    }

    //PassengerCarrier Interface
    @Override
    public void boardPassengers(int count) throws OverloadException {
        if (count + currentPassengers > passengerCapacity){
            throw new OverloadException("Passenger Limit Exceeded.");
        }
        currentPassengers += count;
    }

    @Override
    public void disembarkPassengers(int count) throws InvalidOperationException {
        if (count > currentPassengers) {
            throw new InvalidOperationException("Insufficient passengers to disembark.");
        }
        currentPassengers-=count;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public int getCurrentPassengers() {
        return currentPassengers;
    }

    @Override
    public String toCSV(){
        return String.format("Car,%s,%s,%f,%f,%d,%f,%d,%d,%b\n",super.getId(),super.getModel(),super.getMaxSpeed(),super.getCurrentMileage(),super.getNumWheels(),fuelLevel,passengerCapacity,currentPassengers,maintenanceNeeded);//id,model,maxspeed,mileage,numwheels,fuellevel,passengercapacity,passengercargo,maintenanceneeded
    }
}
