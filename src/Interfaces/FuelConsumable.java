package Interfaces;

import Exceptions.InsufficientFuelException;

public interface FuelConsumable {
    void refuel(double amount) throws InsufficientFuelException;
    double getFuelLevel();
    double consumeFuel(double distance) throws InsufficientFuelException;

}
