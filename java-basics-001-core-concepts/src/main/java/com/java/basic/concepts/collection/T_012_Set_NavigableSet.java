package com.java.basic.concepts.collection;

import java.util.TreeSet;

/**
 *	->	Child Interface of SortedSet.
 *	->	Introduced in 1.6 version.
 *
 *	Defines several methods for Navigation purposes:
 *	===============================================
 *	1.	Object floor(e)				: returns highest element which is <=e
 *	2.	Object lower(e)				: returns highest element which is <e
 *	3.	Object ceiling(e)			: returns lowest element which is >=e
 *	4.	Object higher(e)			: returns lowest element which is >e
 *	5.	Object pollFirst()			: remove and return first element
 *	6.	Object pollLast()			: remove and return last element
 *	7.	NavigableSet descendingSet(): returns NavigableSet in reverse order
 */
public class T_012_Set_NavigableSet {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		set.add(1000);
		set.add(2000);
		set.add(3000);
		set.add(4000);
		set.add(5000);
		System.out.println(set);
		System.out.println(set.ceiling(2000));
		System.out.println(set.higher(2000));
		System.out.println(set.floor(3000));
		System.out.println(set.lower(3000));
		System.out.println(set.pollFirst());
		System.out.println(set.pollLast());
		System.out.println(set.descendingSet());
		System.out.println(set);
	}
}
