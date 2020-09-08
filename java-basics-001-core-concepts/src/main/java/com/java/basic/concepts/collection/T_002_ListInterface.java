package com.java.basic.concepts.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 *	-> List is Child interface of Collection Interface.
 *	-> If we want to represent a group of individual object as single entity where
 *	   duplicates are allowed and insertion order must be preserved then go for List.
 *	-> We can preserve insertion order via index & can differentiate duplicate objects
 *	   via index. Hence index plays very important role in List.
 *
 *	List specific methods:
 *	---------------------
 *	1.	public void add(index i,  Object o) : add at index i
 *	2.	boolean addAll(index i, Collection c) : addAll from starting index i
 *	3.	Object get(index i) : get element at index i
 *	4.	Object remove(index i) : remove element at index i
 *	5.	Object set(index i, Object o) : update element at index i
 *	6.	int indexOf(Object o) : return first occurrence of element o
 *	7.	int lastIndexOf(Object o) : return last occurrence of element o
 *	8. 	ListIterator listIterator() : provides ListIterator for collection
 *
 *	Implementation Classes : ArrayList, LinkedList, vector, Stack
 *	----------------------
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class T_002_ListInterface {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(0, "Element1");
		list.add(1, "Element2");
		list.add(2, "Element3");
		System.out.println(list);
		
		Collection list2 = new ArrayList();
		list2.add("Element4");
		list2.add("Element6");
		list2.add("Element5");
		list.addAll(3, list2);
		System.out.println(list);
		
		System.out.println(list.get(5));
		
		list.set(5, "Element7");
		System.out.println(list);
		
		list.add(6, "Element8");
		System.out.println(list);
		list.remove(6);
		System.out.println(list);
		
		System.out.println(list.indexOf("Element3"));

		list.add(6, "Element3");
		System.out.println(list.lastIndexOf("Element3"));
		
		ListIterator listIterator = list.listIterator();
		System.out.print("ListIterator in Forward direction :: ");
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}
		System.out.println();
		System.out.print("ListIterator in Backward direction :: ");
		while (listIterator.hasPrevious()) {
			System.out.print(listIterator.previous() + " ");
		}
	}
}
