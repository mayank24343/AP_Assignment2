package FleetManagerMain;

import Exceptions.InvalidOperationException;
import Vehicles.*;

import java.security.InvalidParameterException;

public class VehicleFactory {
    VehicleFactory(){}

     public static Vehicle createFromCSV(String info){
        String[] attributes = info.split(",");
        Vehicle v = null;
        if (attributes.length == 10 || attributes.length == 12){
          if (attributes[0].trim().equals("Car")) {
               for (int i = 1; i < 10; i++){
                   if (attributes[i].trim().isEmpty()){
                       throw new InvalidOperationException("Empty Attributes.");
                   }
               }
               try {
                   v = new Car(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]), Integer.parseInt(attributes[5]), Double.parseDouble(attributes[6]), Integer.parseInt(attributes[7]), Integer.parseInt(attributes[8]));
               }
               catch (Exception e){
                   System.out.println("Invalid attributes while parsing file.\nError: " + e);
               }
          }
          else if (attributes[0].trim().equals("Bus")) {
              for (int i = 1; i < 12; i++){
                  if (attributes[i].trim().isEmpty()){
                      throw new InvalidOperationException("Empty Attributes.");
                  }
              }
              try {
                  v = new Bus(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]), Integer.parseInt(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[9]), Double.parseDouble(attributes[10]), Integer.parseInt(attributes[7]), Integer.parseInt(attributes[8]));
              }
              catch (Exception e){
                  System.out.println("Invalid attributes while parsing file.\nError: " + e);
              }

          }
          else if (attributes[0].trim().equals("Truck")) {
              for (int i = 1; i < 10; i++){
                  if (attributes[i].trim().isEmpty()){
                      throw new InvalidOperationException("Empty Attributes.");
                  }
              }
              try {
                  v = new Truck(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]), Integer.parseInt(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[7]), Double.parseDouble(attributes[8]));
              }
              catch (Exception e){
                System.out.println("Invalid attributes while parsing file.\nError: " + e);
            }
          }
          else if  (attributes[0].trim().equals("Cargoship")) {
              for (int i = 1; i < 10; i++){
                  if (attributes[i].trim().isEmpty()){
                      throw new InvalidOperationException("Empty Attributes.");
                  }
              }
              try {
                  v = new CargoShip(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]), Boolean.parseBoolean(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[7]), Double.parseDouble(attributes[8]));
              }
              catch (Exception e){
                  System.out.println("Invalid attributes while parsing file.\nError: " + e);
              }
          }
          else if (attributes[0].trim().equals("Airplane")) {
              for (int i = 1; i < 12; i++){
                  if (attributes[i].trim().isEmpty()){
                      throw new InvalidOperationException("Empty Attributes.");
                  }
              }
              try{
                  v = new Airplane(attributes[1], attributes[2], Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]), Double.parseDouble(attributes[5]), Double.parseDouble(attributes[6]), Double.parseDouble(attributes[9]), Double.parseDouble(attributes[10]), Integer.parseInt(attributes[7]), Integer.parseInt(attributes[8]));
              }
              catch (Exception e){
                  System.out.println("Invalid attributes while parsing file.\nError: " + e);
              }
          }
          else{
              throw new InvalidOperationException("Unknown Vehicle Type");
          }

        }
        else{
            throw new InvalidParameterException("Invalid Vehicle Information");
        }

        return v;
    }
}
