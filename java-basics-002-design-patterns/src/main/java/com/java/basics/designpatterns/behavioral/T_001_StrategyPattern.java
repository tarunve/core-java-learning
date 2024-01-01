package com.java.basics.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/*
 * 	->	We creates a Strategy Class and its strategies child classes and use this strategy class as
 * 		a HAS-A relation in the main class (via constructor/method)
 *  ->	Defines a family of algorithms, encapsulate each one, and make them interchangeable. Strategy
 * 		lets the algorithm vary independently from clients that use it.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To switch out different implementations for different situations.
 * 	2.	To support different variants of the algorithm.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Too many conditional statements can be avoided with different strategy classes
 * 	2.	Allows runtime selection of algorithms from the same algorithm family.
 * 	3.	Improves extensibility with 3rd Party implementations of the algorithms.
 * 	4.	Improves readability by avoiding too many if/else or switch statements.
 * 	5.	Enforces Open/Close principle.
 *
 * 	Drawbacks:
 * 	---------
 * 	1.	May increase the number of classes as each strategy needs to be defined in its own class.
 *
 * 	Real World Examples:
 * 	-------------------
 * 	1.	Choose a game strategy(attack/defend) based on the opponent.
 *
 * 	Software examples:
 * 	-----------------
 * 	1.	Sorting (which sort to use to sort numbers - BubbleSort, BrickSort, Insertion etc.)
 * 	2.	Games (We want player to walk or run when he walks but maybe in future - fly, swim etc.)
 * 	3.	Outputting (We need to output X as a plain String, but later maybe as CSV, XML, Json etc.)
 *
 */
public class T_001_StrategyPattern {

	/*
	 * Define the interface of an interchangeable family of algorithms/
	 */
	interface PaymentStrategy {
		void pay();
	}
	
	static class CardPayment implements PaymentStrategy {
		public String cardType;
		public String issuer;
		public double amount;

		public CardPayment(String cardType, String issuer, double amount) {
			this.cardType = cardType;
			this.issuer = issuer;
			this.amount = amount;
		}
		
		@Override
		public void pay() {
			System.out.println(issuer + " - " + cardType + " - " + amount + "$");
		}
	}

	static class CashPayment implements PaymentStrategy {
		public double amount;

		public CashPayment(double amount) {
			this.amount = amount;
		}
		
		@Override
		public void pay() {
			System.out.println("Cash - " + amount + "$");
		}
	}

	/*
	 * Interface method is used to invoke the algorithm
	 */
	static class Item {
		private final String name;
		private final double price;

		public Item(String name, double price) {
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}
		public double getPrice() {
			return price;
		}
		
	}
	
	static class Order {
		List<Item> cart = new ArrayList<>();
		List<PaymentStrategy> payments = new ArrayList<>();
		private static final String FORMAT = "%-20s %s";

		public void addItem(Item item) {
			cart.add(item);
			System.out.println(String.format(FORMAT, item.getName(), item.getPrice()));
		}
		
		public void makePayment(PaymentStrategy pm) {
			payments.add(pm);
			pm.pay();
		}
	}

	/*
	 * Client code - chooses the algorithm at runtime
	 */
	static class StrategyClient {

		public static void main(String[] args) {
			Order order = new Order();
			order.addItem(new Item("Italian Pizza", 6.99));
			order.addItem(new Item("wine", 9.99));
			order.addItem(new Item("beer", 5.99));
			order.addItem(new Item("Red Apple", 1.49));
			order.addItem(new Item("Almonds", 11.99));
			System.out.println("--------------------------------------");
			order.makePayment(new CashPayment(20.00));
			order.makePayment(new CardPayment("CREDIT", "AMEX", 10.00));
			order.makePayment(new CardPayment("DEBIT", "VISA", 10.00));
			System.out.println("--------------------------------------");
		}
	}
	
}
