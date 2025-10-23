package Vehicles;

import Exceptions.InsufficientFuelException;
import Exceptions.InvalidOperationException;
import Exceptions.OverloadException;
import Interfaces.CargoCarrier;
import Interfaces.FuelConsumable;
import Interfaces.Maintainable;
import Interfaces.PassengerCarrier;

public class Bus extends LandVehicle implements FuelConsumable, PassengerCarrier, CargoCarrier, Maintainable {
    //properties
    private double fuelLevel = 0;
    private int passengerCapacity = 50;
    private int currentPassengers = 0;
    private double cargoCapacity = 500;
    private double currentCargo = 0;
    private boolean maintenanceNeeded = false;

    //constructor
    public Bus(String id, String model, double maxSpeed, double currentMileage, int numWheels, double fuelLevel, double cargoCapacity, double currentCargo, int passengerCapacity, int currentPassengers) throws InvalidOperationException{
        super(id, model, maxSpeed, currentMileage, numWheels);
        if (fuelLevel < 0 || maxSpeed < 0 || currentCargo < 0 || cargoCapacity < 0  || numWheels < 4 || currentMileage < 0 || passengerCapacity < 0 || currentPassengers < 0) {
            throw new InvalidOperationException("Invalid parameters");
        }
        this.fuelLevel = fuelLevel;
        this.passengerCapacity = passengerCapacity;
        this.currentPassengers = currentPassengers;
        this.cargoCapacity = cargoCapacity;
        this.currentCargo = currentCargo;
        if (currentMileage > 10000) {
            scheduleMaintenance();
        }
    }

    public Bus(String id, String model, double maxSpeed, double currentMileage, int numWheels, double cargoCapacity, int passengerCapacity) {
        super(id, model, maxSpeed, currentMileage, numWheels);
        this.passengerCapacity = passengerCapacity;
        this.cargoCapacity = cargoCapacity;
        if (currentMileage > 10000) {
            scheduleMaintenance();
        }
    }

    public Bus(String id, String model, double maxSpeed, double currentMileage, int numWheels) {
        super(id, model, maxSpeed, currentMileage, numWheels);
        if (currentMileage > 10000) {
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
        if (getCurrentMileage() > 10000){
            scheduleMaintenance();
        }
        System.out.println("Vehicle ID:"+this.getId()+": Transporting passengers and cargo ...");
    }

    @Override
    public double calculateFuelEfficiency() {
        return 10.0;
    }

    //CargoCarrier Interface
    @Override
    public void loadCargo(double weight) throws OverloadException {
        if (weight > cargoCapacity-currentCargo) {
            throw new OverloadException("Cargo weight limit exceeded.");
        }
        currentCargo += weight;
    }

    @Override
    public void unloadCargo(double weight) throws InvalidOperationException {
        if (weight > currentCargo) {
            throw new InvalidOperationException("Insufficient cargo to unload.");
        }

        currentCargo -= weight;
    }

    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public double getCurrentCargo() {
        return currentCargo;
    }

    //Fuel Consumable Interface
    @Override
    public void refuel(double amount) throws InsufficientFuelException {
        if (amount <= 0){
            throw new InsufficientFuelException("Refuel amount must be greater than 0.");
        }

        fuelLevel += amount;
    }

    @Override
    public double getFuelLevel() {
        return fuelLevel;
    }

    @Override
    public double consumeFuel(double distance) throws InsufficientFuelException {
        double amount = distance/calculateFuelEfficiency();
        if (fuelLevel < amount) {
            throw new InsufficientFuelException("Insufficient fuel.");
        }

        fuelLevel -= amount;
        return amount;
    }

    //Maintainable Interface
    @Override
    public void scheduleMaintenance() {
        maintenanceNeeded = true;
        System.out.println("Vehicle ID:"+this.getId()+": Maintenance scheduled.");
    }

    @Override
    public boolean needsMaintenance() {
        return (getCurrentMileage() > 10000);
    }

    @Override
    public void performMaintenance() {
        maintenanceNeeded = false;
        setCurrentMileage(0);
        System.out.println("Vehicle ID:"+this.getId()+": Maintenance performed.");
    }

    //Passenger Carrier Interface
    @Override
    public void boardPassengers(int count) throws OverloadException {
        if (count > passengerCapacity-currentPassengers) {
            throw new OverloadException("Passenger Limit Exceeded.");
        }
        currentPassengers += count;
    }

    @Override
    public void disembarkPassengers(int count) throws InvalidOperationException {
        if (count > currentPassengers) {
            throw new InvalidOperationException("Insufficient passengers to disembark.");
        }

        currentPassengers -= count;
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
        return String.format("Bus,%s,%s,%f,%f,%d,%f,%d,%d,%f,%f,%b\n",super.getId(),super.getModel(),super.getMaxSpeed(),super.getCurrentMileage(),super.getNumWheels(),fuelLevel,passengerCapacity,currentPassengers,cargoCapacity,currentCargo,maintenanceNeeded);//id,model,maxspeed,mileage,numwheels,fuellevel,passnegercapacity,currentpassengers,cargocapacity,currentcargo,maintenanceneeded
    }
}
