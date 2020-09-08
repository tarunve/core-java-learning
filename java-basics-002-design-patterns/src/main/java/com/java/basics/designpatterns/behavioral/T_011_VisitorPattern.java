package com.java.basics.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/*
 * 	->	Represents an operation to be performed on the elements of an object structure.
 * 		Visitor lets you define a new operation without changing the classes of elements
 * 		on which it operates.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To perform similar operations on objects of different types grouped in a structure.
 * 	2.	To perform distinct and unrelated operations on objects without polluting their
 * 		classes with these operations.
 * 	3.	To run different methods based on concrete type without instanceof or typeof operators.
 * 	4.	To perform double dispatching.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Separate data structures from the operations on them.
 * 	2.	New operations can be added easily by creating a new visitor.
 *
 * 	DrawBack:
 * 	--------
 * 	1.	Adding a new type to the type hierarchy requires changes to all visitors.
 * 	2.	Encapsulation principle is broken as we need to provide setter methods which
 * 		allows access to the object's internal state.
 *
 * 	Real World Examples:
 * 	-------------------
 * 	1.	Tax consultants visiting a campus to assist employees in tax filing.
 *
 * 	Java SDK Examples
 * 	-----------------
 * 	1.	javax.lang.model.element Element and ElementVisitor.
 * 	2.	java.nio.file FileVisitor and SimpleFileVisitor
 */
public class T_011_VisitorPattern {
	/*
	 * create a Visitable interface and the concrete classes that implement this.
	 */
	public static interface Visitable {
		public void apply(Visitor visitor);
		public double getPrice();
	}

	public static class FoodItem implements Visitable {
		
		public int id;
		public String name;
		public double price;
		
		public FoodItem(int id, String name, double price) {
			this.id = id;
			this.name = name;
			this.price = price;
		}
		
		@Override
		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public void apply(Visitor visitor) {
			visitor.visit(this);
		}
	}

	public static class LiquorItem implements Visitable {
		
		public int id;
		public String name;
		public double price;
		
		public LiquorItem(int id, String name, double price) {
			this.id = id;
			this.name = name;
			this.price = price;
		}
		
		@Override
		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public void apply(Visitor visitor) {
			visitor.visit(this);
		}
	}
	
	/*
	 * create a Visitor interface and the concrete classes that implement this.
	 */
	public static interface Visitor {
		void visit(FoodItem foodItem);
		void visit(LiquorItem foodItem);
	}

	public static class DiscountVisitor implements Visitor {

		private double totalDiscount;
		
		@Override
		public void visit(FoodItem foodItem) {
			double discount = foodItem.getPrice() * 0.3;
			totalDiscount += discount;
			foodItem.setPrice(foodItem.getPrice() - discount);
		}
		
		@Override
		public void visit(LiquorItem liquorItem) {
			double discount = liquorItem.getPrice() * 0.1;
			totalDiscount += discount;
			liquorItem.setPrice(liquorItem.getPrice() - discount);
		}

		public double getTotalDiscount() {
			return totalDiscount;
		}
	}

	public static class TaxVisitor implements Visitor {

		private double totalTax;
		
		@Override
		public void visit(FoodItem foodItem) {
			double tax = foodItem.getPrice() * 0.02;
			totalTax += tax;
			foodItem.setPrice(foodItem.getPrice() + tax);
		}
		
		@Override
		public void visit(LiquorItem liquorItem) {
			double tax = liquorItem.getPrice() * 0.2;
			totalTax += tax;
			liquorItem.setPrice(liquorItem.getPrice() + tax);
		}

		public double getTotalTax() {
			return totalTax;
		}
	}
	
	/*
	 * Client code - With this approach, new operations can be performed easily by adding
	 * only the Visitor class without changing the signature of Visitable concrete classes.
	 */
	public static class VisitorClient {

		public static void main(String[] args) {
			List<Visitable> order = new ArrayList<>();
			order.add(new FoodItem(1, "Italian Pizza", 6.99));
			order.add(new LiquorItem(1, "Wine", 9.99));
			order.add(new LiquorItem(1, "Beer", 5.99));
			order.add(new FoodItem(1, "Red Apple", 1.49));
			order.add(new FoodItem(1, "Almonds", 11.99));

			DiscountVisitor discountVisitor = new DiscountVisitor();
			TaxVisitor taxVisitor = new TaxVisitor();

			double totalAmount = 0.0;
			for (Visitable item : order) {
				totalAmount += item.getPrice();
				item.apply(discountVisitor);
				item.apply(taxVisitor);
			}

			System.out.println("Total Discount = " + discountVisitor.getTotalDiscount());
			System.out.println("Total Tax = " + taxVisitor.getTotalTax());
			System.out.println("Total Bill = " + (totalAmount - discountVisitor.getTotalDiscount() + taxVisitor.getTotalTax()));
		}
	}
}
