package com.java.basic.concepts.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 	->	Main objective of Generics are:
 * 		1.	To provide Type-Safety.
 * 		2.	To resolve Type-Casting problems.
 *
 * 	Type-Safety
 * 	===========
 * 	->	Arrays are type safe i.e. we can give guarantee for the type of elements present in array.
 * 	->	But Collections are not type-safe i.e. we can't give guarantee for type of elements.
 *
 * 	Type-Casting
 * 	============
 * 	->	In case of arrays, at the time of retrieval, not required to perform type-casting.
 * 	->	But in case of collection, it is required to perform type-casting as there is no guarantee
 * 		for the type of elements in collection.
 *
 */
@SuppressWarnings({ "unused" })
public class T_001_GenericsConcept {

	/*
	 * Conclusion 1	:	Polymorphism concept is applicable only for Base type but not for parameter
	 * 					types.(Usage of Parent reference to hold child object is polymorphism)
	 */
	public void method1() {
		ArrayList<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();
		Collection<String> l3 = new ArrayList<String>();
		//ArrayList<Object> l4 = new ArrayList<String>(); //CE:Incompatible types
	}
	
	/*
	 * Conclusion 2	:	applicable only for Object type but not primitive types.
	 */
	public void method2() {
		//ArrayList<int> l1 = new ArrayList<int>();
	}
	
	public static void main(String[] args) {
		//Type-Safety
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		//list.add(10); //CE:Can't cast from int to String

		//Type-casting problem
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("Tarun");
		String name = list2.get(0);
		System.out.println(name);
	}
	
}
