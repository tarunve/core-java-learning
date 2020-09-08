package com.java.basic.concepts.oops;

/**
 * When we create any object, initialization is necessary which happens in constructor.
 * It is not necessary but good programming practice rather than writing it in instance block.
 *
 * Rules for Constructor:
 * ---------------------
 * 	1.	Name of class and constructor must be same.
 * 	2.	Return type concept is not applicable for constructor. We won't get any CE error but
 * 		it will be treated as method not constructor.
 * 	3.	Only applicable modifier for constructor - public, private, protected, default.
 *
 * Default Constructor :
 * ===================
 * Compiler is responsible to generate default constructor (not JVM) if and only if we are not
 * creating any constructor in our class.
 *
 * Prototype for default constructor
 * --------------------------------
 * 	1.	Always no-arg constructor.
 * 	2. 	The access modifier of default constructor is exactly same as of class. Since class
 * 		can't be protected and private. So default constructor can be public/default.
 * 	3.	It contains only one line - super(); :: No arg call to super constructor.
 *
 * The first line for every constructor should be either super() or this(). If we are not writing
 * it then compiler will always place super().
 *
 * We can use super(), this() in constructors only not in methods.
 *
 */
public class T_014_Constructor_1 {
	
	/*
	 * Case 1 : super() is not first line
	 */
	public T_014_Constructor_1() {
		System.out.println("no-arg-constructor");
		//super(); // CE : Constructor call must be the first statement in a constructor
	}
	
	/*
	 * Case 2 : super() or this() - we can use only one and once
	 */
	public T_014_Constructor_1(int i) {
		super();
		//this(); // CE : Constructor call must be the first statement in a constructor
		System.out.println("int-arg-constructor");
	}

	/*
	 * Case 3 : super(), this() can be used only inside constructors
	 */
	public void method() {
		//super(); // CE : Constructor call must be the first statement in a constructor
		System.out.println("method");
	}
}
