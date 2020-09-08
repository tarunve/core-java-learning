package com.java.basic.concepts.collection;

import java.util.HashMap;
import java.util.Map;

/**
 *	->  Map is not a Child interface of Collection Interface.
 *	-> 	If we want to represent a group of objects as Key-Value pairs then we should use Map.
 *	->	Both Keys and Values can be Objects only. Each Key-Value pair is called as Entity.
 *	->	Introduced in 1.2 version
 *
 *	Map specific methods:
 *	---------------------
 *	1.	Object put(Object key, Object value) :
 *			->	If key is already present then old value will be replaced and it returns old value.
 *			->	If key is not present, value will be added and null will be returned.
 *	2.	void putAll(Map m)
 *	3.	Object get(Object key)
 *	4.	Object remove(Object key)
 *	5.	boolean containsKey(Object key)
 *	6.	boolean containsValue(Object value)
 *	7.	boolean isEmpty()
 *	8.	int size()
 *	9.	void clear()
 *	Collection views of Map:
 *	-----------------------
 *	10.	Set keySet()
 *	11.	Collection values()
 *	12.	Set entrySet()
 *
 *	Entry: Without existing Map object, there is no chance of existing Entry object. Hence, Entry interface
 *	----- 	is defined inside Map interface.
 *
 *		interface Map {
 *			interface Entry {
 *				Object getKey();
 *				Object getValue();
 *				Object setValue(Object obj);
 *			}
 *		}
 *
 *	Implemented Interfaces : SortedMap, NavigableMap
 *	----------------------
 *	Implementation Classes : HashMap, LinkedHashMap, IdentityHashMap, WeakHashMap, TreeMap, Hashtable, Properties
 *	----------------------
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_016_MapInterface {
	public static void main(String[] args) {
		Map map = new HashMap();
		System.out.println(map.put(101, "Element1"));
		System.out.println(map.put(102, "Element2"));
		System.out.println(map.put(101, "Element3"));
		System.out.println(map);
		
		Map map2 = new HashMap();
		map2.put(300, "Element4");
		map2.put(301, new StringBuffer("Element4"));
		map2.put(302, null);
		map2.put(303, 60);
		map2.put(null, 70);
		map2.put(null, "Element5"); //It will override earlier value
		map.putAll(map2);
		System.out.println(map);

		System.out.println(map.get(null));

		map.remove(302);
		System.out.println(map);

		System.out.println(map.containsKey(null));

		System.out.println(map.containsValue(null));
		
		System.out.println(map.isEmpty());
		
		System.out.println(map.size());

		System.out.println(map.keySet());

		System.out.println(map.values());

		System.out.println(map.entrySet());

		map.clear();
		System.out.println(map);
	}
}
