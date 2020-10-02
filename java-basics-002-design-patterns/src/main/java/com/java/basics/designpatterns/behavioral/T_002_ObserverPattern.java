package com.java.basics.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/*
 *	->	Define a one-to-many dependency between objects so that when one object changes state,
 *		all its dependents are notified and updated automatically.
 *
 * 	When to use:
 * 	-----------
 * 	1.	When there is one to many relationship between objects such as if one object is notified,
 * 		its dependent objects are to be notified automatically & corresponding changes are done
 * 		to all dependent objects.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Loose coupling between Subject and Observer allows you vary subjects & observers independently.
 * 	2.	Supports broadcast communication.
 *
 * 	Real World Examples:
 * 	-------------------
 * 	1.	Auction - The bidders act as observers and raise the paddle to accept the bid. When it is
 * 		accepted, the others are notified by the auctioneer.
 *
 * 	Java SDK examples:
 * 	-----------------
 * 	1.	java.util.Observer, java.util.Observable (rarely used in real world though)
 * 	2.	All implementations of java.util.EventListener (practically all over Swing thus)
 */
public class T_002_ObserverPattern {
	
	/*
	 * 	Create a Observer Interface and its concrete implementations.
	 * 	These Observers subscribe to specific topics(subjects) so that it can display the updates.
	 */
	abstract static class Observer {
		public abstract void update(String str);
	}

	static class CustomerDisplay extends Observer {
		
		@Override
		public void update(String str) {
			System.out.println("[CustomerDisplay] " + str + "\t");
		}
	}

	static class CashierDisplay extends Observer {
		
		@Override
		public void update(String str) {
			System.out.print("[CashierDisplay] " + str + "\t");
		}
	}
	
	/*
	 * 	Create an interface for the subject and its concrete implementations. These subjects
	 * 	contain lists to keep track of subscribed observes that need to be notified.
	 */
	public interface Topic {
		void register(Observer obj);
		void notifyObservers(String str);
	}
	
	static class AddItemTopic implements Topic {
		private final List<Observer> addItemObservers = new ArrayList<>();
		
		@Override
		public void register(Observer observer) {
			addItemObservers.add(observer);
		}
		@Override
		public void notifyObservers(String line) {
			for (Observer o : addItemObservers) {
				o.update(line);
			}
		}
	}

	static class AddPaymentTopic implements Topic {
		private final List<Observer> addPaymentObservers = new ArrayList<>();
		
		@Override
		public void register(Observer observer) {
			addPaymentObservers.add(observer);
		}
		@Override
		public void notifyObservers(String line) {
			for (Observer o : addPaymentObservers) {
				o.update(line);
			}
		}
	}

	static class CompleteOrderTopic implements Topic {
		private final List<Observer> completeOrderObservers = new ArrayList<>();
		
		@Override
		public void register(Observer observer) {
			completeOrderObservers.add(observer);
		}
		@Override
		public void notifyObservers(String line) {
			for (Observer o : completeOrderObservers) {
				o.update(line);
			}
		}
	}
	
	/*
	 * 	Create item , payment and Order classes. The observers subscribe to various subjects(topics)
	 * 	in the Order class constructor.
	 */
	static class Item {
		public String name;
		public double price;
		
		public Item(String name, double price) {
			this.name = name;
			this.price = price;
		}
	}

	static class Payment {
		public String type;
		public double amount;
		
		public Payment(String type, double amount) {
			this.type = type;
			this.amount = amount;
		}
	}

	static class Order {
		List<Item> cart = new ArrayList<>();
		List<Payment> payments = new ArrayList<>();
		public Topic addItemTopic;
		public Topic addPaymentTopic;
		public Topic completeOrderTopic;

		public Order() {
			Observer cashierDisplay = new CashierDisplay();
			Observer customerDisplay = new CustomerDisplay();

			addItemTopic = new AddItemTopic();
			addPaymentTopic = new AddPaymentTopic();
			completeOrderTopic = new CompleteOrderTopic();

			addItemTopic.register(cashierDisplay);
			addItemTopic.register(customerDisplay);
			addPaymentTopic.register(cashierDisplay);
			addPaymentTopic.register(customerDisplay);
			completeOrderTopic.register(cashierDisplay);
			completeOrderTopic.register(customerDisplay);
		}

		public void addItem(Item item) {
			cart.add(item);
			String line = item.name + " $" + item.price;
			addItemTopic.notifyObservers(line);
		}
		
		public void makePayment(Payment payment) {
			payments.add(payment);
			String line = payment.type + " $" + payment.amount;
			addPaymentTopic.notifyObservers(line);
		}

		public void completeOrder() {
			String line = "Order Completed...";
			completeOrderTopic.notifyObservers(line);
		}
	}
	
	/*
	 * 	The client code - When an item or payment is added to the order , the corresponding
	 * 	topic notifies its observers.
	 */
	public static class ObserverClient {
		public static void main(String[] args) {
			Order order = new Order();
			order.addItem(new Item("Pizza", 6.99));
			order.addItem(new Item("Wine", 9.99));
			order.addItem(new Item("Beer", 5.99));
			order.addItem(new Item("Apple", 1.49));
			System.out.println("--------------------------------------");
			order.makePayment(new Payment("CASH", 20.00));
			order.makePayment(new Payment("CREDIT", 10.00));
			order.makePayment(new Payment("DEBIT", 10.00));
			System.out.println("--------------------------------------");
		}
	}
}
