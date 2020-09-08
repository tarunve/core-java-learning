package com.java.basic.concepts.generics;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings({ "unused" })
public class T_004_WildCardCharcter {
	/*
	 * 	1.	m1(ArrayList<String> list)
	 * 		->	We can call this method by passing ArrayList of only String Type.
	 * 		->	But within the method, we can add only String type of objects to list.
	 * 			By mistake, if we try other type, we will get compile time error.
	 */
	static class WCClass1 {
		public void method(Collection<String> list) {
			list.add("A");
			list.add(null);
			//list.add(10); //CE:The method add(int, String) in the type ArrayList<String> is not applicable for the arguments (int)
		}
	}
	
	/*
	 * 	2.	m1(ArrayList<?> list)
	 * 		->	We can call this method by passing ArrayList of any Type.
	 * 		->	But within the method, we can't add anything except null as we don't know exact type.
	 * 			Null is allowed as it is valid object for any type.
	 * 		->	This type of methods are best suitable for read-only operations.
	 */
	static class WCClass2 {
		public void method(Collection<?> list) {
			//The method add(capture#1-of ?) in the type ArrayList<capture#1-of ?> is not applicable for the arguments (String)
			//list.add("A");
			list.add(null);
		}
	}

	/*
	 * 	3.	m1(ArrayList<? extends X> list)
	 * 		->	X can be either class or interface.
	 *		->	If X is a class then we can pass either X type or its child class.
	 * 		->	If X is an interface then we can pass either X type or its implementation classes.
	 * 		->	But within the method, we can't add anything except null as we don't know exact type.
	 * 			Null is allowed as it is valid object for any type.
	 * 		->	This type of methods are best suitable for read-only operations.
	 */
	static class WCClass3 {
		public void method(Collection<? extends Number> list) {
			list.add(null);
			//CE:The method add(int, capture#3-of ? extends Number) in the type ArrayList<capture#3-of ? extends Number> 
			//is not applicable for the arguments (int)
			//list.add(10);
		}
	}
	
	/*
	 * 	4.	m1(ArrayList<? super X> list)
	 * 		->	X can be either class or interface.
	 *		->	If X is a class then we can pass either X type or its super class.
	 * 		->	If X is an interface then we can pass either X type or super class of implementation class of X.
	 * 		->	But within the method, we can add X Type of Objects and null to the list.
	 */
	static class WCClass4 {
		public void method(Collection<? super Runnable> list) {
			list.add(null);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> l1 = new ArrayList<String>();
		ArrayList<?> l2 = new ArrayList<String>();
		ArrayList<?> l3 = new ArrayList<Integer>();
		ArrayList<? extends Number> l4 = new ArrayList<Integer>();
		//CE: Type mismatch: cannot convert from ArrayList<String> to ArrayList<? extends Number>
		//ArrayList<? extends Number> l5 = new ArrayList<String>();
		ArrayList<? super String> l6 = new ArrayList<Object>();
		//CE: Cannot instantiate the type ArrayList<?>
		//ArrayList<?> l7 = new ArrayList<?>();

		//Cannot instantiate the type ArrayList<? extends Number>
		//ArrayList<?> l8 = new ArrayList<? extends Number>();
	}
}
