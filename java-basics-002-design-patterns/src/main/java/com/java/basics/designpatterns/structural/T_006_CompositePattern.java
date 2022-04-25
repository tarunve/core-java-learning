package com.java.basics.designpatterns.structural;

import java.util.ArrayList;
import java.util.List;

/*
 * 	->	Compose objects into tree structure to represent part-whole hierarchies. Composite
 * 		lets' client treats individual objects and composition of objects uniformly.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To have a hierarchical collection of primitive and composite entities.
 * 	2.	TO create a structure in a way that the objects in a structure can be treated the same way.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Simplifies the representation of part-whole hierarchies.
 * 	2.	Clients can treat all objects in the composition structure uniformly.
 *
 * 	Drawbacks:
 * 	---------
 * 	1.	Strict restrictions need to be enforced otherwise free structure may become overly generalized.
 *
 * 	Real World Examples:
 * 	--------------------
 * 	1.	Organization structure with manager and reporters. The reporters could be managers who
 * 		may have their own reporters.
 *
 * 	Software Example
 * 	----------------
 * 	1.	File System
 *
 * 	Java SDK Examples
 * 	-----------------
 * 	1.	java..awt.Container#add(Component) (practically all over Swing thus).
 * 	2.	javax.faces.component UIComponent#getChildren() (practically all over JSF UI thus)
 */
public class T_006_CompositePattern {

	/*
	 * Create a common interface which declares a method to print the item.
	 */
	public interface Item {
		void print(int level);
	}
	
	/*
	 * Create the leaf object that implement the interface.
	 */
	public static class Product implements Item {
		
		protected int id;
		
		public Product(int id) {
			this.id = id;
		}
		
		@Override
		public void print(int level) {
			for (int i = 0; i < level; i++) {
				System.out.print(" ");
			}
			System.out.println("Product" + id);
		}
	}
	
	/*
	 * Create the composite object that implements the interface.
	 */
	public static class Box implements Item {
		
		protected int id;
		protected List<Item> items = new ArrayList<>();
		
		public Box(int id) {
			this.id = id;
		}
		
		@Override
		public void print(int level) {
			for (int i = 0; i < level; i++) {
				System.out.print(" ");
			}
			System.out.println("Box" + id);
			for (Item item : items) {
				item.print(level + 1);
			}
		}

		public void add(Item item) {
			items.add(item);
		}

	}
	
	/*
	 * Client Code - Client creates a leaf elements and composite elements and interact
	 * with then using the common interface.
	 */
	public static class CompositeClient {

		public static void main(String[] args) {
			Product product1 = new Product(1);
			Product product2 = new Product(2);
			Product product3 = new Product(3);
			Product product4 = new Product(4);
			Box box1 = new Box(1);
			Box box2 = new Box(2);
			Box box3 = new Box(3);
			box1.add(product1);
			box1.add(product2);
			box1.add(product3);

			box2.add(product4);
			
			box3.add(box1);
			box3.add(box2);

			box3.print(0);
		}
	}
}
