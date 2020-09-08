package com.java.basics.designpatterns.structural;

import java.util.Random;
import java.util.Vector;

/*
 * 	->	Use sharing to support large number of fine-grained objects efficiently.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To improve the performance when large number of objects need to be created.
 * 	2.	When most of the object attributes can be made external and shared.
 *
 * 	Benefits:
 * 	--------
 * 	1.	The total number of instances can be reduced.
 * 	2.	Objects sharing reduces the total memory used.
 *
 * 	DrawBack:
 * 	--------
 * 	1.	May introduce run-time costs associated with transferring, finding, and/or
 * 		computing extrinsic state, especially if it was formerly stored as intrinsic state.
 *
 * 	Java SDK Examples
 * 	-----------------
 * 	1.	java.lang.Integer valueOf(int)
 */
public class T_007_FlyWeightPattern {
	/*
	 * Create the vehicle class. Intrinsic and extrinsic characteristics are carefully chosen.
	 */
	public static class Vehicle {
		private final String name;
		//private final String task;
		private String type;
		private String color;
		private int speed;
		private boolean active;
		private int duration;
		
		public Vehicle(String name) {
			//task = "Obstruct the racers";
			this.name = name;
		}
		
		public void setProperties(String type, String color, int speed, int duration) {
			this.type = type;
			this.color = color;
			this.speed = speed;
			this.duration = duration;
		}
		
		public boolean isActive() {
			return active;
		}
		
		public void addToTraffic() {
			System.out.println("->" + name + "-" + type + "-" + color + "-" + speed + "mph-" + duration + "seconds");
			new java.util.Timer().schedule(new java.util.TimerTask() {
				
				@Override
				public void run() {
					active = false;
					System.out.println(name + "->out");
				}
				
			}, duration * 1000);
			active = true;
		}
	}
	
	/*
	 * Create the factory class.
	 */
	public static class VehicleFactory {
		private final Vector<Vehicle> pool = new Vector<>();
		
		public VehicleFactory() {
			for (int i = 0; i < 5; i++) {
				pool.add(new Vehicle("v" + (i + 1)));
			}
		}
		
		public Vehicle getVehicle(String type, String color, int speed, int duration) {
			for (Vehicle v : pool) {
				if (!v.isActive()) {
					v.setProperties(type, color, speed, duration);
					return v;
				}
			}
			return null;
		}
	}
	
	/*
	 * Client code
	 */
	public static class FlyWeightClient {
		static Random r = new Random();
		private static String[] types = { "bus", "car", "truck" };
		private static String[] colors = { "red", "green", "blue" };
		private static int[] speeds = { 50, 30, 80 };
		
		public static String getRandType() {
			return types[r.nextInt(types.length)];
		}
		
		public static String getRandColors() {
			return colors[r.nextInt(colors.length)];
		}
		
		public static int getRandSpeed() {
			return speeds[r.nextInt(speeds.length)];
		}
		
		public static void main(String[] args) throws InterruptedException {
			VehicleFactory factory = new VehicleFactory();
			
			for (int i = 0; i < 20; i++) {
				Vehicle v = factory.getVehicle(getRandType(), getRandColors(), getRandSpeed(), r.nextInt(5) + 1);
				if (v != null) {
					System.out.println("vehicle" + (i + 1));
					v.addToTraffic();
				}
				else {
					i--;
					Thread.sleep(1000);
				}
			}
		}
	}
}
