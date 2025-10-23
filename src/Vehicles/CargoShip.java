package Vehicles;

import Exceptions.InsufficientFuelException;
import Exceptions.InvalidOperationException;
import Exceptions.OverloadException;
import Interfaces.CargoCarrier;
import Interfaces.FuelConsumable;
import Interfaces.Maintainable;


public class CargoShip extends WaterVehicle implements CargoCarrier, Maintainable, FuelConsumable {
    private double currentCargo = 0;
    private double cargoCapacity = 50000;
    private boolean maintenanceNeeded = false;
    private double fuelLevel = 0;

    //constructor
    public CargoShip(String id, String model, double maxspeed, double currentMileage, boolean hasSail, double fuelLevel, double cargoCapacity, double currentCargo) throws InvalidOperationException {
        super(id,model,maxspeed,currentMileage,hasSail);
        if (fuelLevel < 0 || maxspeed < 0 || currentCargo < 0 || cargoCapacity < 0  || currentMileage < 0) {
            throw new InvalidOperationException("Invalid parameters");
        }
        this.cargoCapacity = cargoCapacity;
        this.currentCargo = currentCargo;
        if (currentMileage > 10000) {
            scheduleMaintenance();
        }
        this.fuelLevel = fuelLevel;
    }

    public CargoShip(String id, String model, double maxspeed, double currentMileage, boolean hasSail, double cargoCapacity) {
        super(id,model,maxspeed,currentMileage,hasSail);
        this.cargoCapacity = cargoCapacity;
        if (currentMileage > 10000) {
            scheduleMaintenance();
        }
    }

    public CargoShip(String id, String model, double maxspeed, double currentMileage, boolean hasSail) {
        super(id,model,maxspeed,currentMileage,hasSail);
        if (currentMileage > 10000) {
            scheduleMaintenance();
        }
    }

    //concrete class - implement all abstract methods, interface methods

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
        if  (weight > currentCargo) {
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
    public void refuel(double amount) throws InsufficientFuelException, InvalidOperationException {
        if (!getHasSail()){
            if (amount <= 0){
                throw new InsufficientFuelException("Refuel amount must be greater than 0.");
            }
            fuelLevel += amount;
        }
        else{
            throw new InvalidOperationException("Ship doesn't use fuel. Uses sail.");
        }
    }

    @Override
    public double getFuelLevel() throws InvalidOperationException {
        if (getHasSail()){
            throw new InvalidOperationException("Ship doesn't use fuel. Uses sail.");
        }
        return fuelLevel;
    }

    @Override
    public double consumeFuel(double distance) throws InsufficientFuelException, InvalidOperationException {
        if (getHasSail()){
            throw new InvalidOperationException("Ship doesn't use fuel. Uses sail.");
        }

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
    public void move(double distance) throws InvalidOperationException {
        if (distance < 0){
            throw new InvalidOperationException("Negative distance.");
        }
        if (!getHasSail()){
            consumeFuel(distance);
        }

        setCurrentMileage(getCurrentMileage() + distance);
        if (getCurrentMileage() > 10000){
            scheduleMaintenance();
        }
        System.out.println("Vehicle ID:"+this.getId()+": Sailing with cargo.");
    }

    @Override
    public double calculateFuelEfficiency() {
        if (getHasSail()){
            return 0;
        }
        return 4.0;
    }

    @Override
    public String toCSV(){
        return String.format("Cargoship,%s,%s,%f,%f,%b,%f,%f,%f,%b\n",super.getId(),super.getModel(),super.getMaxSpeed(),super.getCurrentMileage(),getHasSail(),fuelLevel,cargoCapacity,currentCargo,maintenanceNeeded);//id,model,maxspeed,mileage,hasSail,fuellevel,cargocapacity,currentcargo,maintenanceneeded
    }
}
