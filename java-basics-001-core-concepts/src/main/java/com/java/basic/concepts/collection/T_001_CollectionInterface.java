package com.java.basic.concepts.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *  Limitation of Array :
 *  -------------------
 *  1.	Fixed in Size
 *  2.	Can hold only homogeneous data type elements
 *  3.	Not implemented based on any DS so ready-made method support not available.
 *  	Need to write code explicitly i.e. increases complexity.
 *
 *  Collection : If we want to represent a group of individual objects as a single entity
 *  ----------	 then we should go for collection.
 *  ->	It is an interface and introduced in 1.2 version.
 *  -> 	It defines common methods which are applicable for any collection object.
 *
 *	There is no concrete class which implement Collection interface directly.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_001_CollectionInterface {

	public static void main(String[] args) {
		Collection collection = new ArrayList();
		collection.add("Tarun");
		collection.add("Verma");
		Collection collection2 = new LinkedList();
		collection2.add("Test");
		collection2.add("Test2");

		collection.addAll(collection2);
		System.out.println(collection);

		System.out.println(collection.contains("Test"));

		System.out.println(collection.containsAll(collection2));

		System.out.println(collection.isEmpty());

		System.out.println(collection.size());

		System.out.println(Arrays.toString(collection.toArray()));

		Collection collection3 = new ArrayList();
		collection3.add("Test2");
		collection3.add("Test");
		collection3.add("Tarun");
		collection3.add("Tarun Verma");
		collection.retainAll(collection3);
		System.out.println(collection);

		collection.remove("Verma");
		collection.remove("Test2");
		System.out.println(collection);

		collection.add("RemoveAll");
		Collection collection4 = new ArrayList();
		collection4.add("RemoveAll");
		System.out.println(collection);
		collection.removeAll(collection4);
		System.out.println(collection);

		Iterator iterator = collection.iterator();
		System.out.print("Iterator result :: ");
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

		System.out.println();
		collection.clear();
		System.out.println(collection);
	}
}
