package com.java.basics.designpatterns.solid;

/**
 *	->	The Interface Segregation Principle is the fourth SOLID design principle represented by the letter 
 *		“I” in the acronym. It was Robert C Martin who first defined the principle by stating that 
 *		“clients should not be forced to depend on methods they don’t use.” By clients, he means classes 
 *		that implement interfaces. In other words, interfaces shouldn’t include too many functionalities.
 *	->	The violation of Interface Segregation Principle harms code readability and forces programmers to 
 *		write dummy methods that do nothing. In a well-designed application, you should avoid interface 
 *		pollution (also called fat interfaces). The solution is to create smaller interfaces that you can 
 *		implement more flexibly.
 *	->	The best place to look for IS Principle examples is Java AWT event handlers for handling GUI events 
 *		fired from keyboard and mouse. It has different listener classes for each kind of event. We only need 
 *		to write handlers for events, we wish to handle. Nothing is mandatory. Some of the listeners are :
 *		->	FocusListener
 *		->	KeyListener
 *		->	MouseMotionListener	
 *		->	MouseWheelListener
 *		->	TextListener
 *		->	WindowFocusListener
 */
public class T_005_InterfaceSegregationPrinciple {
	
	/*
	 * IS principle is violated since some of the functions are not relevant/applicable to Waiter class.
	 */
	static class WithoutISPrinciple{
		interface RestaurantEmployee {
			void washDishes() throws Exception;
			void serveCustomers();
			void cookFood() throws Exception;
		}

		static class Waiter implements RestaurantEmployee {
			@Override
			public void washDishes() throws Exception {
				throw new Exception("Not my job");
			}

			@Override
			public void serveCustomers() {
				System.out.println("How may I help you, Sir!!!");
			}

			@Override
			public void cookFood() throws Exception {
				throw new Exception("Not my job");
			}
		}
	}
	
	/*
	 * IS principle is not violated
	 */
	static class WithISPrinciple{
		interface WaiterInterface {
			void serveCustomers();
			void takeOrder();
		}

		interface ChefInterface {
			void cookFood();
			void decideMenu();
		}

		static class Waiter implements WaiterInterface {
			@Override
			public void serveCustomers() {
				System.out.println("How may I help you, Sir!!!");
			}

			@Override
			public void takeOrder() {
				System.out.println("Adding it to order, Sir!!!");
			}
		}

		static class Chef implements ChefInterface {

			@Override
			public void cookFood() {
				System.out.println("Preparing the dish.");
			}

			@Override
			public void decideMenu() {
				System.out.println("Let's add all items to the Menu");
			}
		}
	}
}
