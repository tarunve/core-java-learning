package com.java.enhancements;

/**
 *	What is functional interface
 *	============================
 *	->	Functional interfaces are new additions in java 8 which permit exactly one abstract method inside them. 
 *		These interfaces are also called Single Abstract Method interfaces (SAM Interfaces).	
 *	->	In Java 8, functional interfaces can be represented using lambda expressions, method reference and constructor 
 *		references as well.
 *	->	Java 8 introduces an annotation i.e. @FunctionalInterface too, which can be used for compiler level errors 
 *		when the interface you have annotated violates the contracts of exactly one abstract method.
 *
 *	->	only one abstract method is allowed in any functional interface.
 *	->	A functional interface is valid even if the @FunctionalInterface annotation would be omitted.
 *	->	Conceptually, a functional interface has exactly one abstract method. Since default methods have an implementation, 
 *		they are not abstract. Since default methods are not abstract you’re free to add default methods to your functional 
 *		interface as many as you like.
 *	->	If an interface declares an abstract method overriding one of the public methods of java.lang.Object, that also does 
 *		not count toward the interface’s abstract method count since any implementation of the interface will have an 
 *		implementation from java.lang.Object or elsewhere. e.g. Comparator is a functional interface even though it declared 
 *		two abstract methods. Why? Because one of these abstract methods “equals()” which has signature equal to public method 
 *		in Object class.
 *
 *	What are default methods in java 8?
 *	==================================
 *	->	Default methods enable you to add new functionality to the interfaces of your libraries and ensure binary compatibility 
 *		with code written for older versions of those interfaces.
 *	->	Static default methods: You can define static default methods in interface which will be available to all instances of
 * 								class which implement this interface. This makes it easier for you to organize helper methods
 *		in your libraries; you can keep static methods specific to an interface in the same interface rather than in a separate 
 *		class. This enables you to define methods out of your class and yet share with all child classes.
 *	->	They provide you an highly desired capability of adding a capability to number of classes without even touching their 
 *		code. Simply add a default method in interface which they all implement.
 *
 *	Why default methods were needed in java 8?
 *	=========================================
 *	->	Simplest answer is to enable the functionality of lambda expression in java. Lambda expression are essentially of type 
 *		of functional interface. 
 *	->	To support lambda expressions seamlessly, all core classes have to be modified. But these core classes like java.util.List 
 *		are implemented not only in JDK classes, but also in thousands of client code as well. Any incompatible change in core 
 *		classes will back fire for sure and will not be accepted at all.
 *	->	Default methods break this deadlock and allow adding support for functional interface in core classes. Example - Method which 
 *		has been added to java.lang.Iterable.
 *
 * 	Functional Interfaces:
 * 	=====================
 *	-	Consumer - Represents an operation that accepts a single input argument and returns no result.
 *			void accept(T t);		//Consumer<T>
 *			void accept(T t, U u);	//BiConsumer<T, U>
 *	-	Predicate - Represents a predicate (boolean-valued function) of one argument.
 *			boolean test(T t);		//Predicate<T>
 *			boolean test(T t, U u);	//BiPredicate<T, U>
 *	-	Function - Represents a function that accepts one argument and produces a result.
 *			R apply(T t);			//Function<T, T>
 *			R apply(T t, U u);		//BiFunction<T, U, R>
 */
public class E_001_FunctionalInterface {
	public static void main(String[] args) {
		Phone p = new AndroidPhone();
		p.call();
		p.price();
	}
}

@FunctionalInterface
interface Phone {
	void call();

	default void price() {
		System.out.println("2000 Rupees");
	}
}

class AndroidPhone implements Phone {

	public void call() {
		System.out.println("This is call method.");
	}
}

@FunctionalInterface
interface MyFirstFunctionalInterface {
	void firstWork();

	@Override
	String toString(); //Overridden from Object class

	@Override
	boolean equals(Object obj); //Overridden from Object class
}