package com.java.basics.designpatterns.structural;

import java.util.ArrayList;
import java.util.List;

/*
 * 	->	Convert the interface of a class into another interface clients expect. Adapter lets classes
 * 		work together that couldn't otherwise because of incompatible interfaces.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To wrap an existing class with a new interface.
 * 	2.	To perform impedance matching.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Class adapter can override adaptee's behavior.
 * 	2.	Objects adapter allows a single adapter to work with many adaptee's.
 * 	3.	Helps achieve re-usability and flexibility.
 * 	4.	Client class is not complicated by having to use a different interface and can use
 * 		polymorphism to swap between different implementations of adapters.
 *
 * 	Drawbacks:
 * 	---------
 * 	1.	Object adapter involves an extra level of indirection.
 *
 * 	Real World Examples:
 * 	--------------------
 * 	1.	Power adapters.
 * 	2.	Memory and adapters.
 *
 * 	Software Example
 * 	----------------
 * 	1.	Wrappers used to adopt 3rd party libraries and framework.
 *
 * 	Java SDK examples:
 * 	------------------
 * 	1.	java.util.Arrays.asList()
 * 	2.	java.util.Collections.list() , java.uil.Collections.enumeration()
 *
 */
public class T_002_AdapterPattern {

	/*
	 * Code that uses the LegacyOMS.
	 */
	public static class Item {
		protected String name;
		protected double price;

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

	public static class Payment {
		protected String type;
		protected double price;

		public Payment(String type, double price) {
			super();
			this.type = type;
			this.price = price;
		}
		
		public void pay() {
			System.out.println(type + " " + price + "$");
		}
	}
	
	public static class LegacyOMS {
		protected List<Item> cart = new ArrayList<>();
		protected List<Payment> payments = new ArrayList<>();

		public void addItem(Item item) {
			cart.add(item);
			System.out.println(item.getName() + " " + item.getPrice());
		}
		
		public void makePayment(Payment payment) {
			payments.add(payment);
			payment.pay();
		}
	}

	/*
	 * Client code
	 */
	public static class AdapterClient {
		public static void main(String[] args) {
			LegacyOMS oms = new LegacyOMS();
			oms.addItem(new Item("Pizza", 6.99));
			oms.addItem(new Item("Wine", 7.99));
			oms.addItem(new Item("Beer", 2.99));
			oms.addItem(new Item("Almonds", 11.49));
			System.out.println("---------------------");
			oms.makePayment(new Payment("CASH", 20.00));
			oms.makePayment(new Payment("CREDIT", 4.46));
			oms.makePayment(new Payment("DEBIT", 5.00));
		}
	}

	/*
	 * When OMS needs to be swapped, you can simply create an Adapter class with same
	 * interface that the client uses. This adapter/wrapper class "maps" the client
	 * interface to the adaptee's(new OMS) interface.
	 */
	public static class NewOMS {
		protected List<Item> cart = new ArrayList<>();
		protected List<Payment> payments = new ArrayList<>();

		public void addToBasket(Item itemJson) {
			cart.add(itemJson);
			System.out.println(itemJson.getName() + " " + itemJson.getPrice());
		}
		
		public void pay(Payment paymentJson) {
			payments.add(paymentJson);
			paymentJson.pay();
		}
	}

	public static class OMSAdapter {

		protected NewOMS newOMS;

		public OMSAdapter() {
			newOMS = new NewOMS();
		}

		public void addItem(Item item) {
			convertXmlToJson();
			newOMS.addToBasket(item);
		}
		
		public void makePayment(Payment payment) {
			convertXmlToJson();
			newOMS.pay(payment);
		}
		
		private void convertXmlToJson() {
			System.out.println("Converted from XML to JSON");
		}
	}
	
	/*
	 * New Client will interact the same way as before.
	 */
	public static class AdapterNewClient {
		public static void main(String[] args) {
			OMSAdapter oms = new OMSAdapter();
			oms.addItem(new Item("Pizza", 6.99));
			oms.addItem(new Item("Wine", 7.99));
			oms.addItem(new Item("Beer", 2.99));
			oms.addItem(new Item("Almonds", 11.49));
			System.out.println("---------------------");
			oms.makePayment(new Payment("CASH", 20.00));
			oms.makePayment(new Payment("CREDIT", 4.46));
			oms.makePayment(new Payment("DEBIT", 5.00));
		}
	}
}
