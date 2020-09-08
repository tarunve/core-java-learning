package com.java.basic.concepts.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * ->	Underlying DS is - Hashtable.
 * ->	Duplicates are not allowed. No compilation error, it will simply return false.
 * ->	Insertion Order is not preserved and it is based on hashcode of objects.
 * ->	Heterogeneous objects are allowed.
 * ->	Null insertion is possible (only once).
 * -> 	Default Initial Capacity 16 and default load factor(fill ratio) is 0.75
 * -> 	Implements Serializable and Cloneable but not RandomAccess.
 * ->	Non-synchronized and hence not thread safe. Hence relatively, performance is high.
 * -> 	Introduced in 1.2 version.
 *
 * 	Constructors:
 * 	============
 * 	1.	HashSet set = new HashSet();  // Default Capacity - 16, default load factor - 0.75
 * 	2.	HashSet set = new HashSet(int initialCapacity); // default fill ratio - 0.75
 * 	3.	HashSet set = new HashSet(int initialCapacity, int fillRatio);
 * 	4.	HashSet set = new HashSet(Collection c);
 *
 * 	Methods:
 * 	=======
 * 	No specific methods. All from collection interfaces.
 *
 * 	Use Case:
 *  ========
 *  ->	Best choice if our frequent operation is retrieval operation.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_009_Set_HashSet {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("Element1");
		set.add("Element2");
		set.add(new StringBuffer("Element3"));
		set.add(10);
		set.add(null);
		set.add(null);
		System.out.println(set.add(null));
		System.out.println(set);
		
		Set set1 = new HashSet(3);
		set1.add("Element1");
		set1.add("Element2");
		set1.add(new StringBuffer("Element3"));
		set1.add(10);
		set1.add(null);
		set1.add(null);
		System.out.println(set.add(null));
		System.out.println(set1);
		
		Set set2 = new HashSet(3, 0.5f);
		set2.add("Element1");
		set2.add("Element2");
		set2.add(new StringBuffer("Element3"));
		set2.add(10);
		set2.add(null);
		set2.add(null);
		System.out.println(set.add(null));
		System.out.println(set2);
		
		Set set3 = new HashSet(set2);
		set3.add(null);
		System.out.println(set.add(null));
		System.out.println(set3);
	}
}
