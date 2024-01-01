package com.java.basics.designpatterns.creational;

import java.util.Scanner;

/*
 * 	->	Provides an interface for creating families of related or dependent objects without
 * 		specifying their concrete classes.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To support families of related or dependent objects.
 * 	2.	To encapsulate platform dependencies to make an application portable.
 * 	3.	TO prevent client code from using the "new" operator.
 * 	4.	To easily swap the underlying platform with minimal changes.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Loosely coupling code.
 * 	2.	Abstract Factory provides a single point of access for all products in a family.
 * 	3.	New product family can be easily supported.
 *
 * 	Drawbacks:
 * 	---------
 * 	1.	More layers of abstraction increases complexity.
 * 	2.	If there are any changes to any underlying detail of one factory, the interface might need
 * 		to modified for all the factories.
 *
 * 	Real World Examples:
 * 	--------------------
 * 	1.	Providing Data access to two different data source(Ex.	A SQL database and a XML file). You have two
 * 		different data access classes(a gateway to the datastore).Both inherit from a base class that defines
 * 		the common methods to be implemented(Ex. Load, Save, delete). Which data source shall be used shouldn't
 * 		change the way client code retrieves its data access class. Your abstract factory knows which data
 * 		source shall be used and returns an appropriate instance on request. The factory returns this instance
 * 		of base type.
 *
 *	Software Examples:
 *	-----------------
 *	1.	Dependency Injection
 *
 * 	Java SDK examples:
 * 	------------------
 * 	1.	java.xml.parsers.DocumentBuiilderFactory.newInstance()
 * 	2.	java.xml.transform.TransformerFactory.newInstance()
 * 	3.	java.xml.xpath.XPathFactory.newInstance()
 *
 */
public class T_002_AbstractFactoryPattern {
	/*
	 * Define interfaces for different type of products/objects.Each family will have all these parts.
	 */
	public interface Engine {
		void design();
		void manufacture();
		void test();
	}
	
	public interface Tyre {
		void design();
		void manufacture();
	}
	
	/*
	 * Create sets of implementation subclasses for the above interfaces. Classes are access protected
	 * 	to prohibit instantiations in client modules using the new operator.
	 */
	public static class CarEngine implements Engine {
		@Override
		public void design() {
			System.out.println("Designing Car Engine");
		}
		@Override
		public void manufacture() {
			System.out.println("Manufacturing Car Engine");
		}
		@Override
		public void test() {
			System.out.println("Testing Car Engine");
		}
	}
	
	public static class TruckEngine implements Engine {
		@Override
		public void design() {
			System.out.println("Designing Truck Engine");
		}
		@Override
		public void manufacture() {
			System.out.println("Manufacturing Truck Engine");
		}
		@Override
		public void test() {
			System.out.println("Testing Truck Engine");
		}
	}
	
	public static class CarTyre implements Tyre {
		@Override
		public void design() {
			System.out.println("Designing Car Tyre");
		}
		@Override
		public void manufacture() {
			System.out.println("Manufacturing Car Tyre");
		}
	}
	
	public static class TruckTyre implements Tyre {
		@Override
		public void design() {
			System.out.println("Designing Truck Tyre");
		}
		@Override
		public void manufacture() {
			System.out.println("Manufacturing Truck Tyre");
		}
	}
	
	/*
	 * Create the abstract factory class with factory method "getFactory()". Clients will
	 * use this method to get the instance of required Factory.
	 */
	public static abstract class Factory {
		
		private static Factory carFactory = null;
		private static Factory truckFactory = null;
		
		public abstract Engine getEngine();
		public abstract Tyre getTyre();

		public static Factory getFactry(String vehicleType) throws Exception {
			if (vehicleType == null) {
				return null;
			}
			Factory factory;
			switch (vehicleType) {
				case "car":
					if (carFactory == null)
						carFactory = new CarFactory();
					factory = carFactory;
					break;
				case "truck":
					if (truckFactory == null)
						truckFactory = new TruckFactory();
					factory = truckFactory;
					break;
				default:
					throw new Exception("Vehicle Type not found.");
			}
			return factory;
		}
	}

	/*
	 * Factory implementations.
	 */
	public static class CarFactory extends Factory {
		@Override
		public Engine getEngine() {
			return new CarEngine();
		}
		@Override
		public Tyre getTyre() {
			return new CarTyre();
		}
	}
	
	public static class TruckFactory extends Factory {
		@Override
		public Engine getEngine() {
			return new TruckEngine();
		}
		@Override
		public Tyre getTyre() {
			return new TruckTyre();
		}
	}

	/*
	 * Client Code - Client is exposed to only the abstract factory class and the interfaces.
	 */
	public static class AbstractFactoryClient {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			String vehicleType = scanner.nextLine().toLowerCase();
			Factory factory;
			try {
				factory = Factory.getFactry(vehicleType);
				Engine engine = factory.getEngine();
				engine.design();
				engine.manufacture();
				engine.test();
				Tyre tyre = factory.getTyre();
				tyre.design();
				tyre.manufacture();
			}
			catch (Exception e) {
				System.out.println("Invalid vehicle type entered...");
			}
			scanner.close();
		}
	}
}
