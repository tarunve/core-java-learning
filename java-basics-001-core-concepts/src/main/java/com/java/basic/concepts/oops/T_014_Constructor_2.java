package com.java.basic.concepts.oops;

import java.io.IOException;

/**
 * Constructor Overloading :
 * 		Overloading concept is applicable for Constructors.
 * 		Overriding and Inheritance concept is not applicable.
 *
 * Including abstract class, every class in Java can contain constructor but not interface.
 *
 *
 */
public class T_014_Constructor_2 {

	static abstract class ConstructorClass1 {
		ConstructorClass1() {
			System.out.println("Tarun");
		}
	}
	
	static class ConstructorClass2 extends ConstructorClass1 {
		public static void main(String[] args) {
			new ConstructorClass2(); // It will print abstract class constructor
		}
	}

	/*
	 * Case 1 :
	 *  		Recursive method calls results into StackOverflowError.
	 *  		But in case of constructors , code will not compile
	 */
	static class ConstructorClass3 {
		public static void method1() {
			method2();
		}
		public static void method2() {
			method1();
		}
		public static void main(String[] args) {
			method1();
			System.out.println("Hello");
		}
	}
	
	static class ConstructorClass4 {
		ConstructorClass4() {
			this(10);
		}
		ConstructorClass4(int i) {
			//this(); //CE : Recursive constructor invocation
		}
		
	}

	/*
	 * Case 2 : If parent class constructor contains any arg constructor then we need to
	 * 			take special care while writing child classes
	 *
	 * Whenever we write any arg constructor, it is highly recommended to write no-arg constructor.
	 */
	static class ConstructorClass5 {
		ConstructorClass5(int i) {}
	}
	
	static class ConstructorClass6 extends ConstructorClass5 {
		// CE : Implicit super constructor Constructor_14_2.ConstructorClass5() is undefined for default constructor. Must define an explicit constructor
		//So, we need to write constructor
		ConstructorClass6(int i) {
			super(i);
		}
	}

	/*
	 * Case 3 : If Parent class constructor throws any checked exception
	 * 			Child class constructor should throw same or its parent.
	 *
	 * There is no rule for Un-checked exceptions
	 */
	static class ConstructorClass7 {
		ConstructorClass7() throws IOException {}
		ConstructorClass7(int i) throws NullPointerException, ArithmeticException, ClassCastException {}
	}
	
	static class ConstructorClass8 extends ConstructorClass7 {
		//ConstructorClass8() {} //CE : Un-handled exception type IOException
		ConstructorClass8() throws IOException, Exception, Throwable {}
		ConstructorClass8(int i) {
			super(i);
		}
	}
}
