package com.java.basic.concepts.collection;

import java.util.TreeMap;

/**
 * ->	Child Interface of SortedMap.
 *	->	Introduced in 1.6 version.
 *
 *	Defines several methods for Navigation purposes:
 *	===============================================
 *	1.	Object floorKey(e)				: returns highest element which is <=e
 *	2.	Object lowerKey(e)				: returns highest element which is <e
 *	3.	Object ceilingKey(e)			: returns lowest element which is >=e
 *	4.	Object higherKey(e)				: returns lowest element which is >e
 *	5.	Object pollFirstEntry()			: remove and return first element
 *	6.	Object pollLastEntry()			: remove and return last element
 *	7.	NavigableMap descendingMap()	: returns NavigableMap in reverse order
 */
public class T_022_Map_NavigableMap {
	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<>();
		map.put("b", "banana");
		map.put("c", "cat");
		map.put("a", "apple");
		map.put("d", "dog");
		map.put("g", "gun");

		System.out.println(map);
		System.out.println(map.ceilingKey("c"));
		System.out.println(map.higherKey("e"));
		System.out.println(map.floorKey("e"));
		System.out.println(map.lowerKey("e"));
		System.out.println(map.pollFirstEntry());
		System.out.println(map.pollLastEntry());
		System.out.println(map.descendingMap());
		System.out.println(map);
	}
}
