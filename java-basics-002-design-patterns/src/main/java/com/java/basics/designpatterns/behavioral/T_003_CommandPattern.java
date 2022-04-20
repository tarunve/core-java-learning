package com.java.basics.designpatterns.behavioral;

/*
 * 	->	Encapsulate a request as an object, thereby letting you parameterize clients with different
 * 		requests, queue or log requests, and support undo-able operations;
 *
 * 	When to use:
 * 	-----------
 * 	1.	When the executor of the command does not need to know anything at all about what the command
 * 		is, what context information it needs on or what it does.
 * 	2.	To register a callback when some event is triggered.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Decouples the object that invokes the operation from the one that know how to perform it.
 * 	2.	This platform helps in terms of extensible as we can add a new command without changing the
 * 		existing code.
 * 	3.	It allows you to create a sequence of commands named macro. To run the macro, create a list
 * 		of Command instances and call the execute method of all commands.
 * 	4.	Ability to undo/redo easily.
 *
 * 	Drawbacks:
 * 	---------
 * 	1.	increase in the number of classes for each individual command.
 *
 * 	Real World Examples:
 * 	--------------------
 * 	1.	Placing orders to the waiter in the restaurant.
 *
 * 	Java SDK examples:
 * 	------------------
 * 	1.	All implementations of java.lang.Runnable.
 * 	2.	All implementations of javax.swing.Action.
 *
 */
public class T_003_CommandPattern {
	
	/*
	 * 	Create the receiver objects for the commands.
	 */
	public static class MainDish {
		
		public String name;

		public MainDish(String name) {
			this.name = name;
		}
		
		public void order() {
			System.out.println("Main Dish (" + name + ") is ordered");
		}
		
		public void cancel() {
			System.out.println("Main Dish (" + name + ") is cancelled.");
		}
	}

	public static class Dessert {
		
		public String name;

		public Dessert(String name) {
			this.name = name;
		}
		
		public void order() {
			System.out.println("Dessert (" + name + ") is ordered");
		}
		
		public void cancel() {
			System.out.println("Dessert (" + name + ") is cancelled.");
		}
	}
	
	/*
	 * Create Command interface and its concrete implementations that represent various commands.
	 */
	public static interface Command {
		void execute();
	}

	public static class OrderMainDish implements Command {

		public MainDish item;

		public OrderMainDish(MainDish item) {
			this.item = item;
		}

		@Override
		public void execute() {
			item.order();
		}
	}
	
	public static class OrderDessert implements Command {

		public Dessert item;

		public OrderDessert(Dessert item) {
			this.item = item;
		}

		@Override
		public void execute() {
			item.order();
		}
	}
	
	public static class CancelMainDish implements Command {

		public MainDish item;

		public CancelMainDish(MainDish item) {
			this.item = item;
		}

		@Override
		public void execute() {
			item.cancel();
		}
	}
	
	public static class CancelDessert implements Command {

		public Dessert item;

		public CancelDessert(Dessert item) {
			this.item = item;
		}

		@Override
		public void execute() {
			item.cancel();
		}
	}
	
	/*
	 * Create the invoker class.
	 */
	public static class Waiter {
		
		public void execute(Command command) {
			command.execute();
		}
	}

	/*
	 * Client code - client creates the command and pass it on to the executor(waiter).
	 * The waiter does not need to know about the contents of the command.
	 */
	public static class CommandClient {

		public static void main(String[] args) {
			Waiter waiter = new Waiter();
			MainDish mainDish = new MainDish("Pizza");
			OrderMainDish orderPizza = new OrderMainDish(mainDish);
			waiter.execute(orderPizza);

			MainDish burger = new MainDish("Burger");
			OrderMainDish orderBurger = new OrderMainDish(burger);
			waiter.execute(orderBurger);

			CancelMainDish cancelMain = new CancelMainDish(burger);
			waiter.execute(cancelMain);

			Dessert dessert = new Dessert("Ice cream");
			OrderDessert orderDessert = new OrderDessert(dessert);
			waiter.execute(orderDessert);
		}
	}
}
