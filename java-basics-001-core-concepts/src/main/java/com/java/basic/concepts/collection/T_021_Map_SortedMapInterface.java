package com.java.basic.concepts.collection;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * ->	Child interface of Map Interface.
 *	-> 	If we want to represent a group of objects as Key-Value pairs according to some
 *		sorting order then we should use Map.
 *	->	Sorting is based on keys not on values.
 *	->	Introduced in 1.2 version
 *
 *	SortedMap specific methods:
 *	---------------------
 *	1.	Object firstKey()
 *	2.	Object lastKey()
 *	3.	SortedMap headMap(Object key)
 *	4.	SortedMap tailMap(Object key)
 *	5.	SortedMap subMap(Object key1, Object key2)
 *	6.	Comparator comparator()
 *
 *	Implemented Interfaces : SortedMap, NavigableMap
 *	----------------------
 *	Implementation Classes : HashMap, LinkedHashMap, IdentityHashMap, WeakHashMap, TreeSet, Hashtable, Properties
 *	----------------------
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_021_Map_SortedMapInterface {
	public static void main(String[] args) {
		SortedMap map = new TreeMap();
		map.put(101, "X");
		map.put(106, "A");
		map.put(110, "Z");
		map.put(102, "E");
		map.put(104, "M");
		map.put(105, "O");

		System.out.println(map);
		
		System.out.println(map.firstKey());
		
		System.out.println(map.lastKey());
		
		System.out.println(map.headMap(104));

		System.out.println(map.tailMap(101));

		System.out.println(map.subMap(102, 106));
	}
}
