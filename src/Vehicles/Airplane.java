package Vehicles;

import Exceptions.InsufficientFuelException;
import Exceptions.InvalidOperationException;
import Exceptions.OverloadException;
import Interfaces.CargoCarrier;
import Interfaces.FuelConsumable;
import Interfaces.Maintainable;
import Interfaces.PassengerCarrier;

public class Airplane extends AirVehicle implements FuelConsumable, PassengerCarrier, CargoCarrier, Maintainable {
    private double fuelLevel = 0;
    private int passengerCapacity = 200;
    private int currentPassengers = 0;
    private double cargoCapacity = 10000;
    private double currentCargo = 0;
    private boolean maintenanceNeeded = false;

    //constructor
    public Airplane(String id, String model, double maxspeed, double currentMileage, double maxAltitude, double fuelLevel, double cargoCapacity, double currentCargo, int passengerCapacity, int currentPassengers) throws InvalidOperationException{
        super(id,model,maxspeed,currentMileage,maxAltitude);
        if (fuelLevel < 0 || maxspeed < 0 || currentCargo < 0 || cargoCapacity < 0  || maxAltitude <= 0 || currentMileage < 0 || passengerCapacity < 0 || currentPassengers < 0) {
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

    public Airplane(String id, String model, double maxspeed, double currentMileage, double maxAltitude, double cargoCapacity, int passengerCapacity) {
        super(id,model,maxspeed,currentMileage,maxAltitude);
        this.passengerCapacity = passengerCapacity;
        this.cargoCapacity = cargoCapacity;
        if (currentMileage > 10000) {
            scheduleMaintenance();
        }
    }

    public Airplane(String id, String model, double maxspeed, double currentMileage, double maxAltitude) {
        super(id,model,maxspeed,currentMileage,maxAltitude);
        if (currentMileage > 10000) {
            scheduleMaintenance();
        }
    }

    //concrete class - implement all abstract methods, interface methods
    @Override
    public void move(double distance) throws InvalidOperationException {
        if (distance < 0){
            throw new InvalidOperationException("Negative distance.");
        }
        consumeFuel(distance);
        setCurrentMileage(getCurrentMileage() + distance);
        System.out.println("Vehicle ID:"+this.getId()+": Flying at "+getMaxAltitude()+" ...");
        if (getCurrentMileage() > 10000){
            scheduleMaintenance();
        }
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
        if (amount > fuelLevel) {
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
        if (count > passengerCapacity - currentPassengers) {
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
    public double calculateFuelEfficiency() {
        return 5.0;
    }

    @Override
    public String toCSV(){
        return String.format("Airplane,%s,%s,%f,%f,%f,%f,%d,%d,%f,%f,%b\n",super.getId(),super.getModel(),super.getMaxSpeed(),super.getCurrentMileage(),super.getMaxAltitude(),fuelLevel,passengerCapacity,currentPassengers,cargoCapacity,currentCargo,maintenanceNeeded);//id,model,maxspeed,mileage,maxaltitude,fuellevel,passnegercapacity,currentpassengers,cargocapacity,currentcargo,maintenanceneeded
    }
}
