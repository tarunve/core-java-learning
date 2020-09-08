package com.java.basic.concepts.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ->	Underlying DS is - Hashtable.
 * ->	Duplicates keys are not allowed but values can be duplicated.
 * ->	Insertion Order is not preserved and it is based on hashcode of objects.
 * ->	Heterogeneous objects are allowed for both keys and values.
 * ->	Null insertion is possible only once for keys but for values, any number of times.
 * -> 	Default Initial Capacity 16 and default load factor(fill ratio) is 0.75
 * -> 	Implements Serializable and Cloneable but not RandomAccess.
 * ->	Non-synchronized and hence not thread safe. Hence relatively, performance is high.
 * -> 	Introduced in 1.2 version.
 *
 * 	Constructors:
 * 	============
 * 	1.	HashMap set = new HashMap();  // Default Capacity - 16, default load factor - 0.75
 * 	2.	HashMap set = new HashMap(int initialCapacity); // default fill ratio - 0.75
 * 	3.	HashMap set = new HashMap(int initialCapacity, int fillRatio);
 * 	4.	HashMap set = new HashMap(Map c);
 *
 * 	Methods:
 * 	=======
 * 	No specific methods. All from Map interfaces.
 *
 * 	Use Case:
 *  ========
 *  ->	Best choice if our frequent operation is retrieval operation.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_017_Map_HashMap {
	public static void main(String[] args) {
		Map map = new HashMap();
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

		Map map1 = new HashMap(4);
		map1.put(101, "Element1");
		map1.put(102, "Element2");
		map1.put(103, new StringBuilder("Element1"));
		map1.put(104, null);
		map1.put(105, 40);
		map1.put(null, 70);
		System.out.println(map1);

		Map map2 = new HashMap(4, 0.5f);
		map2.put(101, "Element1");
		map2.put(102, "Element2");
		map2.put(103, new StringBuilder("Element1"));
		map2.put(104, null);
		map2.put(105, 40);
		map2.put(null, 70);
		System.out.println(map2);

		Map map3 = new HashMap(map2);
		System.out.println(map3);
	}
}
