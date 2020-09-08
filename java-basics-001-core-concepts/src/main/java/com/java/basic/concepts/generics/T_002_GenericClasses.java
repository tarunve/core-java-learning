package com.java.basic.concepts.generics;

/**
 *	->	In generics, we are associating a type parameter to the class. Such type of parameterized classes
 *		are nothing but Generic classes or Template classes.
 *	->	Based on our requirement, we can create our own generic classes
 *		Ex. 	class Account<T> {}
 *				Account<Gold> a1 = new Account<Gold>();
 *				Account<Platinum> a1 = new Account<Platinum>();
 *			At runtime, T will be replaced with our provided type
 */
public class T_002_GenericClasses {

	static class GenericClass1<T> {
		T object;
		
		GenericClass1(T obj) {
			this.object = obj;
		}
		public void show() {
			System.out.println("The type of object :: " + object.getClass().getName());
		}
		public T getObject() {
			return object;
		}
	}
	
	public static void main(String[] args) {
		GenericClass1<String> g1 = new GenericClass1<String>("Tarun");
		g1.show();
		System.out.println(g1.getObject());

		GenericClass1<Integer> g2 = new GenericClass1<Integer>(10);
		g2.show();
		System.out.println(g2.getObject());

		GenericClass1<Double> g3 = new GenericClass1<Double>(10.5);
		g3.show();
		System.out.println(g3.getObject());
	}
}
