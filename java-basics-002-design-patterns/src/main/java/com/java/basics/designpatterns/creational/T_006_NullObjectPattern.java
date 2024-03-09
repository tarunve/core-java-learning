package com.java.basics.designpatterns.creational;

import java.util.Scanner;

/**
 *  Null Design Pattern is basically for the default implementation or handle the NULL case.
 */
public class T_006_NullObjectPattern {

    /*
     * Create an interface. Clients can code for this interface without worrying about the internal
     * 	implementation.
     */
    interface Vehicle {
        void design();
        void manufacture();
    }

    /*
     * Create a set of implementation subclasses. Constructors are protected to prohibit instantiations
     * 	in client modules using the "new" operator.
     */
    public static class Car implements Vehicle {
        @Override
        public void design() {
            System.out.println("Designing Car");
        }
        @Override
        public void manufacture() {
            System.out.println("Manufacturing Car");
        }
    }

    public static class Truck implements Vehicle {
        @Override
        public void design() {
            System.out.println("Designing Truck");
        }
        @Override
        public void manufacture() {
            System.out.println("Manufacturing Truck");
        }
    }

    public static class MotorCycle implements Vehicle {
        @Override
        public void design() {
            System.out.println("Designing MotorCycle");
        }
        @Override
        public void manufacture() {
            System.out.println("Manufacturing MotorCycle");
        }
    }

    public static class NullVehicle implements Vehicle {
        @Override
        public void design() {
            System.out.println("No Vehicle");
        }
        @Override
        public void manufacture() {
            System.out.println("No Vehicle");
        }
    }

    /*
     * Create a Factory class to get the Vehicles. Clients can use it to get instance.
     */
    static class VehicleFactory {

        public Vehicle getVehicle(String vehicleType) throws Exception {
            Vehicle vehicle;
            switch (vehicleType) {
                case "car":
                    vehicle = new Car();
                    break;
                case "truck":
                    vehicle = new Truck();
                    break;
                case "motorcycle":
                    vehicle = new MotorCycle();
                    break;
                default:
                    vehicle = new NullVehicle();
            }
            return vehicle;
        }
    }

    /*
     * Client Code - Client knows the factory method only . Client doesn't use "new", hence
     * decoupled from implementation.
     */
    static class FactoryMethodClient {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String vehicleType = scanner.nextLine().toLowerCase();
            VehicleFactory factory = new VehicleFactory();
            try {
                Vehicle vehicle = factory.getVehicle(vehicleType);
                vehicle.design();
                vehicle.manufacture();
            }
            catch (Exception e) {
                System.out.println("Invalid vehicle type entered...");
            }
            scanner.close();
        }
    }
}
