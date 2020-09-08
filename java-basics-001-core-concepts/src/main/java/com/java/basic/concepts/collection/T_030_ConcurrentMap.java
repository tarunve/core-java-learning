package com.java.basic.concepts.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 	Concurrent API(Collection) concept came to overcome below problems:
 * 	1.	Most of the traditional collections (90%) are not Thread safe.
 * 	2.	Some are Thread-Safe(Vector, Hashtable, synchronizedList(), synchronizedMap(), synchronizedSet())
 * 		but only one thread can perform operation at a time so degrade performance.
 * 	3.	While one thread iterating collection object, remaining threads are not allowed to perform operation
 * 		otherwise we will get ConcurrentModificationException.
 *
 * 	ConcurrentMap specific methods:
 * 	==============================
 * 	1.	Object putIfAbsent(Object key, Object value)
 * 	2.	boolean remove(Object key, Object value)
 * 	3.	boolean replace(Object key, Object oldValue, Object newValue)
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_030_ConcurrentMap {
	
	public static void main(String[] args) {
		ConcurrentMap map = new ConcurrentHashMap();
		map.put(101, "A");
		map.put(102, "B");

		System.out.println(map.putIfAbsent(103, "C"));

		System.out.println(map.putIfAbsent(101, "D"));

		map.remove(101, "D");

		map.replace(102, "B", "E");
		System.out.println(map);
	}
}
