package com.java.basics.designpatterns.structural;

/*
 * 	->	Decouple an abstraction from its implementation so that the two can vary independently.
 *
 * 	When to use:
 * 	-----------
 * 	1.	When runtime binding of implementation is required.
 * 	2.	To share an implementation among multiple objects and to map orthogonal class hierarchies.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Decoupling allows us to choose the implementations at runtime.
 * 	2.	Compile-time dependencies on the implementation are eliminated.
 * 	3.	Improved extensibility and flexibility.
 *
 * 	Drawbacks:
 * 	---------
 * 	1.	Delegation from entities to the Behaviors can delegate performance.
 *
 * 	Real World Examples:
 * 	--------------------
 * 	1.	The display of different image formats on different OS is a good example of it. You might
 * 		have different image abstractions for both jpeg and png images. The image structure is the
 * 		same across all OS, but how it's viewed  is different on each OS. This is the type of
 * 		decoupling that Bridge pattern allows.
 *
 * 	Software Example
 * 	----------------
 * 	1.	UnifiedPOS or UPOS that provides vendor-neutral APIs for numerous point of sales peripherals.
 * 	2.	OS specific Device Driver interfaces that define common standards for various devices.
 */
public class T_005_BridgePattern {

	/*
	 * Design a color-oriented interface that is minimal, necessary and sufficient. Its goal is to
	 * decouple the abstraction from the color. Define a derived class of that interface for each color.
	 */
	public interface Color {
		void applyColor();
	}

	/*
	 * Define a derived class of that interface for each color.
	 */
	public static class Red implements Color {
		
		@Override
		public void applyColor() {
			System.out.println("Red");
		}

	}
	
	public static class Green implements Color {
		
		@Override
		public void applyColor() {
			System.out.println("Green");
		}
	}

	/*
	 * Create the abstraction base class that "has a" color object and delegates the color-oriented
	 * functionality to it.
	 */
	public static abstract class Shape {

		protected Color color;

		public Shape(Color color) {
			this.color = color;
		}
		
		public abstract void draw();
	}

	/*
	 * Define specializations of the abstraction class.
	 */
	public static class Circle extends Shape {
		
		public Circle(Color color) {
			super(color);
		}

		@Override
		public void draw() {
			System.out.print("Draw circle in ");
			color.applyColor();
		}
	}

	public static class Rectangle extends Shape {
		
		public Rectangle(Color color) {
			super(color);
		}

		@Override
		public void draw() {
			System.out.print("Draw Rectangle in ");
			color.applyColor();
		}
	}
	
	public static class Square extends Shape {
		
		public Square(Color color) {
			super(color);
		}

		@Override
		public void draw() {
			System.out.print("Draw Square in ");
			color.applyColor();
		}
	}
	
	/*
	 * Client Code - The bridge pattern allows one to mix and match without needing to
	 * create a rigid hierarchy.
	 */
	public static class BridgeClient {

		public static void main(String[] args) {
			Shape[] shapes = { new Circle(new Red()), new Rectangle(new Green()), new Square(new Red()) };
			for (Shape shape : shapes) {
				shape.draw();
			}
		}
	}
}
