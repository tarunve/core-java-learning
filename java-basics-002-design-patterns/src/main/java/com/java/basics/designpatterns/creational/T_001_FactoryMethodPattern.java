package com.java.basics.designpatterns.creational;

import java.util.Scanner;

/*
 * 	->	Defines an interface for creating an object but let subclasses decide which class to instantiate.
 * 		Factory method lets a class defer instantiation to subclasses.
 *
 * 	When to use:
 * 	-----------
 * 	1.	We need Factory Pattern when we want to create objects based on some condition.
 * 	2.	To enforce coding for interface rather than implementation.
 * 	3.	To transfer the responsibility of instantiation from client class to factory method.
 * 	4.	To couple the implementation from client program.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Loose coupling allows changing the internal without impacting customer code.
 * 	2.	Factory method provides a single point of control for multiple products.
 * 	3.	Number of instances and their re-usability can be controlled with Singleton or Multiton.
 *
 * 	Drawbacks:
 * 	---------
 * 	1.	An extra level of abstraction makes the code more difficult to read.
 *
 * 	Real World Examples:
 * 	--------------------
 * 	1.	Ola, Uber -Renting Vehicles, Customer needs to specify only the type of vehicle(car, truck etc)
 * 		that is needed. Customer need not know about the internal details of vehicle.
 *
 *	Software Examples:
 *	-----------------
 *	1.	Memcache 	2.	FileCache	3.	Code for SQL standard without worrying about underlying DB.
 *
 * 	Java SDK examples:
 * 	------------------
 * 	1.	java.util.Calender.getInstance()
 * 	2.	java.text.numberFormat.getInstance()
 * 	3.	java.util.EnumSet.of()
 *
 */
public class T_001_FactoryMethodPattern {
	
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
	static class Car implements Vehicle {
		public Car() {}

		@Override
		public void design() {
			System.out.println("Designing Car");
		}
		@Override
		public void manufacture() {
			System.out.println("Manufacturing Car");
		}
	}

	static class Truck implements Vehicle {
		public Truck() {}

		@Override
		public void design() {
			System.out.println("Designing Truck");
		}
		@Override
		public void manufacture() {
			System.out.println("Manufacturing Truck");
		}
	}
	
	static class MotorCycle implements Vehicle {
		public MotorCycle() {}
		
		@Override
		public void design() {
			System.out.println("Designing MotorCycle");
		}
		@Override
		public void manufacture() {
			System.out.println("Manufacturing MotorCycle");
		}
	}

	/*
	 * Create a Factory class to get the Vehicles. Clients can use it to get instance.
	 */
	static class VehicleFactory {

		public Vehicle getVehicle(String vehicleType) throws Exception {
			if (vehicleType == null) {
				return null;
			}
			Vehicle vehicle = null;
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
					throw new Exception("Vehicle Type not found.");
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
