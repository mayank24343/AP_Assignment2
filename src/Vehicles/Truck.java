package Vehicles;

import Exceptions.InsufficientFuelException;
import Exceptions.InvalidOperationException;
import Exceptions.OverloadException;
import Interfaces.CargoCarrier;
import Interfaces.FuelConsumable;
import Interfaces.Maintainable;

public class Truck extends LandVehicle implements FuelConsumable, CargoCarrier, Maintainable {
    //properties
    private double fuelLevel = 0;
    private double cargoCapacity = 5000;
    private double currentCargo = 0;
    private boolean maintenanceNeeded = false;

    //constructor
    public Truck(String id, String model, double maxSpeed, double currentMileage, int numWheels, double fuelLevel, double cargoCapacity, double currentCargo) throws InvalidOperationException {
        super(id, model, maxSpeed, currentMileage, numWheels);
        if (fuelLevel < 0 || maxSpeed < 0 || currentCargo < 0 || cargoCapacity < 0  || numWheels < 4 || currentMileage < 0) {
            throw new InvalidOperationException("Invalid parameters");
        }
        this.fuelLevel = fuelLevel;
        this.cargoCapacity = cargoCapacity;
        this.currentCargo = currentCargo;
        if (getCurrentMileage() > 10000){
            scheduleMaintenance();
        }
    }

    public Truck(String id, String model, double maxSpeed, double currentMileage, int numWheels, double cargoCapacity) {
        super(id, model, maxSpeed, currentMileage, numWheels);
        this.cargoCapacity = cargoCapacity;
        if (getCurrentMileage() > 10000){
            scheduleMaintenance();
        }
    }

    public Truck(String id, String model, double maxSpeed, double currentMileage, int numWheels) {
        super(id, model, maxSpeed, currentMileage, numWheels);
        if (getCurrentMileage() > 10000){
            scheduleMaintenance();
        }
    }

    //concrete class - implement all abstract methods, interface methods
    @Override
    public void move (double distance) throws InvalidOperationException {
        if (distance < 0){
            throw new InvalidOperationException("Negative distance.");
        }

        consumeFuel(distance);
        setCurrentMileage(getCurrentMileage()+distance);
        System.out.println("Vehicle ID:"+this.getId()+": Hauling cargo ...");
        if (getCurrentMileage() > 10000){
            scheduleMaintenance();
        }
    }

    @Override
    public double calculateFuelEfficiency() {
        if (currentCargo/cargoCapacity > 0.5){
            return 8.0 - 0.1*8.0; //reduce efficiency by 10% in case of 50%+ cargo
        }
        return 8.0;
    }

    //CargoCarrier Interface
    @Override
    public void loadCargo(double weight) throws OverloadException {
        if (weight > cargoCapacity - currentCargo){
            throw new OverloadException("Cargo weight limit exceeded.");
        }
        currentCargo += weight;
    }

    @Override
    public void unloadCargo(double weight) throws InvalidOperationException {
        if (weight > currentCargo){
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

    //FuelConsumable Interface
    @Override
    public void refuel(double amount) throws InsufficientFuelException {
        if (amount <= 0) {
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
        if (amount > fuelLevel){
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

    @Override
    public String toCSV(){
        return String.format("Truck,%s,%s,%f,%f,%d,%f,%f,%f,%b\n",super.getId(),super.getModel(),super.getMaxSpeed(),super.getCurrentMileage(),super.getNumWheels(),fuelLevel,cargoCapacity,currentCargo,maintenanceNeeded);//id,model,maxspeed,mileage,numwheels,fuellevel,cargocapacity,currentcargo,maintenanceneeded
    }
}
