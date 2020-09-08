package com.java.basics.designpatterns.behavioral;

/*
 * 	->	Define the skeleton of an algorithm in an operation, deferring some steps to subclasses.
 * 		Template Method lets subclasses redefine certain steps of an algorithm without changing
 * 		the algorith'm structure.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To define a skeleton of an algorithm or an operation. Allow the subclasses to re-define
 * 		part of the logic.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Avoids code duplication.
 * 	2.	Subclasses can define how to implement steps in an algorithm.
 * 	3.	Steps of the algorithm or the operation can be changed without changes in subclasses.
 *
 * 	Drawbacks:
 * 	---------
 * 	1.	Inadequate documentation may confuse developers about the flow in Template Method.
 *
 * 	Software Example
 * 	----------------
 * 	1.	Most of the software frameworks define template methods. Framework make call backs into
 * 		methods implemented in child classes.
 *
 * 	Java SDK examples
 * 	-----------------
 * 	1.	All non-abstract methods of java.io.InputStream, OutputStream, Reader, Writer.
 * 	2.	All non-abstract methods of java.util.AbstractList, AbstractSet, AbstractMap.
 */
public class T_004_TemplatePattern {
	
	/*
	 * Create an abstract base class that defines the template method. Note that the method is
	 * declared as "final" to avoid the subclasses from overriding and changing the logic. Provide
	 * default implementations and also the abstract methods for the steps to be overriden.
	 */
	public static abstract class Pizza {
		public final void preparePizza() {
			selectCrust();
			addIngredients();
			addToppings();
			cook();
		}
		
		public abstract void selectCrust();
		public abstract void addIngredients();
		
		public void addToppings() {
			System.out.println("Selected default crust");
		}
		
		public void cook() {
			System.out.println("Cooked for 5 minutes");
		}
	}

	/*
	 * Create subclasses that redefines certain steps of the algorithm.
	 */
	public static class MeatPizza extends Pizza {
		
		@Override
		public void selectCrust() {
			System.out.println("Added Meat Pizza Crust");
		}
		
		@Override
		public void addIngredients() {
			System.out.println("Added Meat Pizza Ingredients");
		}

		@Override
		public void cook() {
			System.out.println("Cooked for 15 minutes");
		}
	}

	public static class CheesePizza extends Pizza {
		
		@Override
		public void selectCrust() {
			System.out.println("Added Cheese Pizza Crust");
		}
		
		@Override
		public void addIngredients() {
			System.out.println("Added Cheese Pizza Ingredients");
		}

		@Override
		public void cook() {
			System.out.println("Cooked for 10 minutes");
		}
	}
	
	/*
	 * Client Code - Client implements appropriate subclass object & invokes the template method.
	 */
	public static class TemplateMethodClient {
		
		public static void main(String[] args) {
			System.out.println("Preparing a cheese Pizza");
			Pizza pizza1 = new CheesePizza();
			pizza1.preparePizza();
			System.out.println("===================");
			System.out.println("Preparing a Meat Pizza");
			Pizza pizza2 = new MeatPizza();
			pizza2.preparePizza();
		}
	}
}
