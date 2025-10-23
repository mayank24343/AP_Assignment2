package FleetManagerMain;

import Exceptions.InvalidOperationException;
import Exceptions.OverloadException;
import Interfaces.CargoCarrier;
import Interfaces.FuelConsumable;
import Interfaces.Maintainable;
import Interfaces.PassengerCarrier;
import Vehicles.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FleetManager {
    //arraylist to store vehicles, and to sort by speed, efficiency, name etc.
    private ArrayList<Vehicle> fleet = new ArrayList<>();
    //treeset to ensure unique ids and sort by id
    private TreeSet<Vehicle> fleetset = new TreeSet<>((v1,v2) -> v1.getId().compareTo(v2.getId()));

    //constructor
    public FleetManager() {}

    public void addVehicle(Vehicle v) throws InvalidOperationException{
        if (fleetset.add(v)) {
            //fleetset will return true if vehicle id not already in set, added to set, now add to arraylist
            fleet.add(v);
        }
        else{
            //fleetset returned false as id was already in set, set was not changed
            throw new InvalidOperationException("Vehicle with this ID already exists.");
        }
    }

    public void removeVehicle(String id) throws InvalidOperationException{
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().compareTo(id) == 0){
                fleet.remove(vehicle);
                fleetset.remove(vehicle);
                return;
            }
        }

        throw new InvalidOperationException("Vehicle with this ID has not been found.");
    }

    public void maintainAll(){
        for (Vehicle v : fleet) {
            if (((Maintainable) v).needsMaintenance()){
                ((Maintainable) v).performMaintenance();
            }
        }
    }

    public void startAllJourneys(double distance){
        for (Vehicle v : fleet) {
            v.move(distance);
        }
    }

    public double getTotalFuelConsumption(double distance){
        double totalFuelConsumption = 0;
        for (Vehicle v : fleet) {
            if ((v instanceof CargoShip) && ((CargoShip) v).getHasSail()) {
                continue;
            }
            totalFuelConsumption += ((FuelConsumable) v).consumeFuel(distance);
        }

        return totalFuelConsumption;
    }

    public List<Vehicle> searchByType( Class<?> type){
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : fleet) {
            if (type.isInstance(v)){
                vehicles.add(v);
            }
        }
        return vehicles;
    }

    public void sortFleetByEfficiency(){
        Collections.sort(fleet);
        System.out.print("Sorted Fleet By Efficiency: ");
        for (Vehicle v : fleet){
            v.displayInfo();
        }
    }

    public void sortFleetBySpeed(){
        Collections.sort(fleet, Comparator.comparingDouble(Vehicle::getMaxSpeed));
        System.out.print("Sorted Fleet By Max Speed: ");
        for (Vehicle v : fleet){
            v.displayInfo();
        }
    }

    public void sortFleetByModel(){
        Collections.sort(fleet, (v1,v2) -> v1.getModel().compareTo(v2.getModel()));
        System.out.print("Sorted Fleet By Max Speed: ");
        for (Vehicle v : fleet){
            v.displayInfo();
        }
    }

    public void sortFleetById(){
        System.out.print("Sorted Fleet By Id: ");
        for (Vehicle v : fleetset){
            v.displayInfo();
        }
    }

    public String generateReport(){
        String report = "";
        int totalvehicles = fleet.size();
        int totalCars=0, totalTrucks=0, totalBusses=0, totalAirplanes=0, totalCargoships=0;
        double totalMileage=0, efficiencySum=0;
        int needMaintenance=0;
        TreeSet<String> modelSet = new TreeSet<>();
        for (Vehicle v : fleet) {
            modelSet.add(v.getModel());
            if (v instanceof CargoShip){
                totalCargoships++;
            }
            else if  (v instanceof Airplane){
                totalAirplanes++;
            }
            else if (v instanceof Bus){
                totalBusses++;
            }
            else if (v instanceof Truck){
                totalTrucks++;
            }
            else if (v instanceof Car){
                totalCars++;
            }

            totalMileage+= v.getCurrentMileage();
            efficiencySum+= v.calculateFuelEfficiency();
            if (((Maintainable) v).needsMaintenance()){
                needMaintenance++;
            }
        }

        try {
            Vehicle fastestVehicle = Collections.max(fleet, Comparator.comparingDouble(Vehicle::getMaxSpeed));
            Vehicle slowestVehicle = Collections.min(fleet, Comparator.comparingDouble(Vehicle::getMaxSpeed));
            report = String.format("Total Vehicles: %d\nTotal Cars: %d\nTotal Trucks: %d\nTotal Busses: %d\nTotal Airplanes: %d\nTotal Cargo Ships: %d\nAverage Fuel Efficiency: %f\nTotal Mileage: %f\nTotal Vehicles Needing Maintenance: %d\nTotal Distinct Models: %d\nFastest Vehicle: %s | Speed: %.2f\nSlowest Vehicle: %s | Speed: %.2f", totalvehicles, totalCars, totalTrucks, totalBusses, totalAirplanes, totalCargoships, (totalvehicles > 0) ? efficiencySum/totalvehicles : 0, totalMileage,  needMaintenance, modelSet.size() , fastestVehicle.getId(), fastestVehicle.getMaxSpeed(), slowestVehicle.getId(), slowestVehicle.getMaxSpeed());
        }
        catch (Exception e){
            report = String.format("Total Vehicles: %d\nTotal Cars: %d\nTotal Trucks: %d\nTotal Busses: %d\nTotal Airplanes: %d\nTotal Cargo Ships: %d\nAverage Fuel Efficiency: %f\nTotal Mileage: %f\nTotal Vehicles Needing Maintenance: %d\nTotal Distinct Models: %d", totalvehicles, totalCars, totalTrucks, totalBusses, totalAirplanes, totalCargoships, (totalvehicles > 0) ? efficiencySum/totalvehicles : 0, totalMileage,  needMaintenance, modelSet.size());
        }

        //report = String.format("Total Vehicles: %d\nTotal Cars: %d\nTotal Trucks: %d\nTotal Busses: %d\nTotal Airplanes: %d\nTotal Cargo Ships: %d\nAverage Fuel Efficiency: %f\nTotal Mileage: %f\nTotal Vehicles Needing Maintenance: %d\nTotal Distinct Models: %d\nFastest Vehicle: %s | Speed: %.2f\nSlowest Vehicle: %s | Speed: %.2f", totalvehicles, totalCars, totalTrucks, totalBusses, totalAirplanes, totalCargoships, (totalvehicles > 0) ? efficiencySum/totalvehicles : 0, totalMileage,  needMaintenance, modelSet.size() , fastestVehicle.getId(), fastestVehicle.getMaxSpeed(), slowestVehicle.getId(), slowestVehicle.getMaxSpeed());

        return report;
    }

    public List<Vehicle> getVehiclesNeedingMaintenance(){
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle v : fleet) {
            if (((Maintainable) v).needsMaintenance()){
                vehicles.add(v);
            }
        }

        return vehicles;
    }

    public void saveToFile(String filename){
        try (FileWriter fw = new FileWriter(filename)){
            try {
                for (Vehicle v : fleetset) {
                    fw.write(v.toCSV());
                }
                System.out.printf("Saved Fleet Information to File %s%n",filename);
            }
            catch (Exception e){
                System.out.println("Error writing to file");
            }
            finally {
                fw.close();
            }

        }
        catch (IOException e){
            System.out.println("Error writing to file");
        }

    }

    public void loadFromFile(String filename){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String l = br.readLine();
            try {
                while (l != null) {
                    //create vehicle using factory method
                    try {
                        Vehicle v = VehicleFactory.createFromCSV(l);
                        addVehicle(v);
                        l = br.readLine();
                    } catch (Exception e) {
                        l = br.readLine();
                        System.out.println("Error reading from file-Data incorrect/not arranged as expected.\nError: " + e + "\n");
                    }
                }
            }
            catch (Exception e){
                System.out.println("Error reading from file.");
            }
            finally {
                br.close();
            }
        }
        catch (IOException e){
            System.out.println("Error in loading file");
        }

    }

    public void refuelAll(double amount){
        for (Vehicle v : fleet) {
            if (v instanceof FuelConsumable){
                ((FuelConsumable) v).refuel(amount);
            }
        }
    }

    public void boardPassengers(String id, int passengers) throws InvalidOperationException, OverloadException{
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().compareTo(id) == 0){
                if (vehicle instanceof PassengerCarrier){
                    if (passengers >= 0) {
                        ((PassengerCarrier) vehicle).boardPassengers(passengers);
                    }
                    else{
                        throw new InvalidOperationException("Cannot have negative passengers.");
                    }
                }
                else{
                    throw new  InvalidOperationException("Vehicle does not support passengers.");
                };
                return;
            }
        }

        throw new InvalidOperationException("Vehicle with this ID has not been found.");
    }

    public void disembarkPassengers(String id, int passengers) throws InvalidOperationException{
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().compareTo(id) == 0){
                if (vehicle instanceof PassengerCarrier){
                    if (passengers >= 0) {
                        ((PassengerCarrier) vehicle).disembarkPassengers(passengers);
                    }
                    else{
                        throw new InvalidOperationException("Cannot have negative passengers.");
                    }
                }
                else{
                    throw new  InvalidOperationException("Vehicle does not support passengers.");
                };
                return;
            }
        }

        throw new InvalidOperationException("Vehicle with this ID has not been found.");
    }

    public void loadCargo(String id, double cargo) throws  InvalidOperationException, OverloadException{
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().compareTo(id) == 0){
                if (vehicle instanceof CargoCarrier){
                    if (cargo >= 0) {
                        ((CargoCarrier) vehicle).loadCargo(cargo);
                    }
                    else{
                        throw new InvalidOperationException("Cannot have negative cargo.");
                    }
                }
                else{
                    throw new  InvalidOperationException("Vehicle does not support cargo.");
                };
                return;
            }
        }

        throw new InvalidOperationException("Vehicle with this ID has not been found.");
    }

    public void unloadCargo(String id, double cargo) throws  InvalidOperationException{
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().compareTo(id) == 0){
                if (vehicle instanceof CargoCarrier){
                    if (cargo >= 0) {
                        ((CargoCarrier) vehicle).unloadCargo(cargo);
                    }
                    else{
                        throw new InvalidOperationException("Cannot have negative cargo.");
                    }
                }
                else{
                    throw new  InvalidOperationException("Vehicle does not support cargo.");
                };
                return;
            }
        }

        throw new InvalidOperationException("Vehicle with this ID has not been found.");
    }

    public double estimateJourneyTime(String id, double distance) throws InvalidOperationException{
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().compareTo(id) == 0){
                return vehicle.estimateJourneyTime(distance);
            }
        }

        throw new InvalidOperationException("Vehicle with this ID has not been found.");


    }

}
