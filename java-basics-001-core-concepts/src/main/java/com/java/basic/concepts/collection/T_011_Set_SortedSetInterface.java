package com.java.basic.concepts.collection;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * ->	Child interface of Set interface.
 * ->	If we want to represent a group of individual objects according to some sorting order
 * 		without duplicates then we should go for SortedSet.
 *
 * 	Specific Methods related to SortedSet:
 * 	=====================================
 * 	1.	Object first()							: returns first element of SortedSet.
 * 	2.	Object last()							: returns last element of SortedSet.
 * 	3.	SortedSet headSet(Object o)				: returns SortedSet whose elements are < object.
 * 	4.	SortedSet tailSet(Object o)				: returns SortedSet whose elements are >= object.
 * 	5.	SortedSet subSet(Object o1,Object o2)	: returns SortedSet whose elements are >= o1 and < o2
 * 	6.	Comparator comparator()					: returns comparator that describes underlying sorting technique.
 * 												 If we are using Default natural sorting order, we will get null.
 *
 * 	We will see example in implementation (TreeSet).
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_011_Set_SortedSetInterface {
	public static void main(String[] args) {
		SortedSet set = new TreeSet();
		set.add("a");
		set.add("Z");
		set.add("L");
		set.add("X");
		set.add("A");
		System.out.println(set);

		System.out.println(set.first());
		
		System.out.println(set.last());
		
		System.out.println(set.headSet("X"));
		
		System.out.println(set.tailSet("a"));
		
		System.out.println(set.subSet("X", "b"));
	}
}
