package com.java.basics.designpatterns.structural;

/*
 * 	->	Attach additional responsibilities to an object dynamically. Decorators provide a flexible
 * 		alternative to sub-classes for extending functionality.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To dynamically change the functionality of an object at runtime without impacting the existing
 * 		functionality of the objects.
 * 	2.	To add functionalities that may be withdrawn later.
 * 	3.	To combine multiple functionalities where it is impractical to create a subclass for every
 * 		possible combination.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Decorators allows us to mix and match features instead of creating concrete implementations for
 * 		all possible combinations.
 * 	2.	Decorator allows us to modify an object in a much more modular and less fundamental way than
 * 		inheritance world.
 * 	3.	New functionalities can be easily supported.
 *
 * 	Drawbacks:
 * 	---------
 * 	1.	complexity is increased.
 * 	2.	Multiple small objects are created in the process of creating an object.
 *
 * 	Programming Examples:
 * 	--------------------
 * 	1.	File Stream implementations
 *
 * 	Java SDK examples:
 * 	------------------
 * 	1.	All subclasses of java.io.InputStream, OutputStream, Reader and Writer have a constructor of
 * 		taking an instance of same type.
 * 	2.	java.util.Collects, the checkedXXX(), synchronizedXXX(), and unmodifiableXXX() methods.
 * 	3.	javax.servlet.http.HttpServletRequestWrapper and HttpServletResponseWrapper.
 *
 */
public class T_001_DecoratorPattern {
	
	/*
	 * Define Item interface and create a Pizza class which is an implementation of Item interface.
	 */
	static interface Item {
		void prepare();
	}

	static class Pizaa implements Item {
		@Override
		public void prepare() {
			System.out.print("Pizza");
		}
	}

	/*
	 * Create an abstract Decorator class which implements the Item interface. This class contains
	 * the Item object which will be decorated with new functionalities.
	 */
	static abstract class PizzaDecorator implements Item {
		private final Item item;
		
		public PizzaDecorator(Item item) {
			this.item = item;
		}

		@Override
		public void prepare() {
			item.prepare();
		}
	}
	
	/*
	 * Create concrete decorators
	 */
	static class DeepFried extends PizzaDecorator {

		public DeepFried(Item item) {
			super(item);
		}
		
		@Override
		public void prepare() {
			super.prepare();
			System.out.print(" + Deep Fried");
		}
	}

	static class DoubleCheeze extends PizzaDecorator {

		public DoubleCheeze(Item item) {
			super(item);
		}
		
		@Override
		public void prepare() {
			super.prepare();
			System.out.print(" + Double Cheese");
		}
	}
	
	static class Spicy extends PizzaDecorator {
		
		public Spicy(Item item) {
			super(item);
		}
		
		@Override
		public void prepare() {
			super.prepare();
			System.out.print(" + Spicy");
		}
	}

	/*
	 * Client Code - Decorator pattern allows one to mix and match without needing to
	 * 	create a rigid hierarchy.
	 */
	static class DecoratorClient {
		public static void main(String[] args) {
			Item[] order = { new DeepFried(new Pizaa()), new DeepFried(new DoubleCheeze(new Pizaa())), new DoubleCheeze(new Spicy(new DeepFried(new Pizaa()))) };
			for (Item item : order) {
				item.prepare();
				System.out.println(" ");
			}
		}
	}
}
