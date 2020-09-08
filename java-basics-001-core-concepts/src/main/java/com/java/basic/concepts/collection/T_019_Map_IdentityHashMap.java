package com.java.basic.concepts.collection;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * ->	Child class of Map interface.
 * ->	Exactly same as HashMap except following difference:
 * 		1.	In HashMap, JVM uses equals() method to identify duplicate keys which is meant for content
 * 			comparison but in IdentityHashMap, JVM will use == operator which is for reference comparison.
 * 		2.	Introduced in 1.4 version.
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_019_Map_IdentityHashMap {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put(new Integer(10), "Element1");
		map.put(new Integer(10), "Element2");
		System.out.println(map);

		Map map1 = new IdentityHashMap();
		map1.put(new Integer(10), "Element1");
		map1.put(new Integer(10), "Element2");
		System.out.println(map1);
	}
}
