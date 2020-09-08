package com.java.basics.designpatterns.structural;

/*
 * 	->	Provides a unified interface to a set of interfaces in a subsystem. Facade defines a
 * 		higher-level interface that makes the subsystem easier to use.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To provide a simplified interface to the overall functionality of a complex subsystem.
 * 	2.	To promote subsystem independence and portability.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Number of objects the client interact with is minimal which reduces the complexity.
 * 	2.	Promotes loose coupling.
 * 	3.	Facade still allows the client to use the subsystem interface.
 *
 * 	Drawbacks:
 * 	---------
 * 	1.	One more layer is introduced in the system which may impact the performance.
 *
 * 	Real World Examples:
 * 	--------------------
 * 	1.	Customer Support Desk which hides all the complexities of system that involves various
 * 		department.
 * 	2.	Event planner who does everything including like making reservations, organizing activities.
 *
 * 	Java SDK examples:
 * 	------------------
 * 	1.	javax.faces.context.ExternalContext, which internally uses ServletContext, HttpSession,
 * 		HttpServletresponse, HttpServletReuest etc.
 */
public class T_003_FacadePattern {

	/*
	 * A typical example for Facade pattern is the wedding planner who hides from you the complexity
	 * of a large system. The wedding planner organizes everything for you.
	 */
	public static class Hall {
		public void book() {
			System.out.println("Book Marriage Hall");
		}
	}

	public static class Restaurant {
		public void placeOrder() {
			System.out.println("Order food");
		}
	}

	public static class Photographer {
		public void book() {
			System.out.println("Book Photographer");
		}
	}

	public static class Vehicle {
		public void reserve() {
			System.out.println("Reserve vehicle");
		}
	}

	public static class WeddingPlanner {
		protected Hall hall;
		protected Restaurant restaurant;
		protected Photographer photographer;
		protected Vehicle limousine;

		public WeddingPlanner() {
			hall = new Hall();
			restaurant = new Restaurant();
			photographer = new Photographer();
			limousine = new Vehicle();
		}
		
		public void organize() {
			hall.book();
			restaurant.placeOrder();
			photographer.book();
			limousine.reserve();
		}
	}

	/*
	 * Client code- Client contacts the facade class to perform the required operation.
	 */
	public static class FacadeClient {

		public static void main(String[] args) {
			WeddingPlanner planner = new WeddingPlanner();
			planner.organize();
		}
	}
}
