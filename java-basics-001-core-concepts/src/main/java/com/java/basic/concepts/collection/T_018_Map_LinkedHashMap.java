package com.java.basic.concepts.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ->	Child class of HashMap.
 * ->	Exactly same as HashMap except following difference:
 * 		1.	Underlying DS is LinkedList + Hashtable.
 * 		2.	Insertion Order is preserved.
 * 		3.	Introduced in 1.4 version.
 *
 * 	UseCase:
 * 	=======
 * 	LinkedHashSet and LinkedHashMap are commonly used for developing cache based applications.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_018_Map_LinkedHashMap {
	public static void main(String[] args) {
		Map map = new LinkedHashMap();
		map.put(101, "Element1");
		map.put(102, "Element2");
		map.put(103, new StringBuilder("Element1"));
		map.put(104, null);
		map.put(105, 40);
		map.put(null, 70);
		
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			System.out.print(entry.getKey() + "-----" + entry.getValue() + " ");
		}
		System.out.println();
		
		Map map1 = new LinkedHashMap(4);
		map1.put(101, "Element1");
		map1.put(102, "Element2");
		map1.put(103, new StringBuilder("Element1"));
		map1.put(104, null);
		map1.put(105, 40);
		map1.put(null, 70);
		System.out.println(map1);
		
		Map map2 = new LinkedHashMap(4, 0.5f);
		map2.put(101, "Element1");
		map2.put(102, "Element2");
		map2.put(103, new StringBuilder("Element1"));
		map2.put(104, null);
		map2.put(105, 40);
		map2.put(null, 70);
		System.out.println(map2);
		
		Map map3 = new LinkedHashMap(map2);
		System.out.println(map3);
	}
	
}
