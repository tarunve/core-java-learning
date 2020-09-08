package com.java.basic.concepts.collection;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * ->	Underlying DS is - Red Black Tree.
 * ->	Duplicates keys are not allowed but values can be duplicated.
 * ->	Insertion Order is not preserved and it is based on sorting order(either DNSO or provided order).
 * ->	If we are depending on DNSO, Keys should be Homogeneous and comparable otherwise we will get
 * 		RE : ClassCastException. No restrictions for values.
 * ->	Null insertion is not possible (Only once till 1.6 when TreeSet is empty but not from 1.7).
 * -> 	Implements Serializable and Cloneable but not RandomAccess.
 * ->	Non-synchronized and hence not thread safe. Hence relatively, performance is high.
 * -> 	Introduced in 1.2 version.
 *
 * 	Constructors:
 * 	============
 * 	1.	TreeMap map = new TreeMap();  				: Elements will be inserted according to DNSO.
 * 	2.	TreeMap map = new TreeMap(Comparator c); 	: Elements will be inserted according to customized sorting order(c).
 * 	3.	TreeMap map = new TreeMap(SortedMap s);		: Conversion of SortedSet to TreeMap.
 * 	4.	TreeMap map = new TreeMap(Map m);			: Conversion of any Map to TreeMap, order - DNSO.
 *
 * 	Methods:
 * 	=======
 * 	No specific methods. All from Collection, Map, SortedMap interfaces.
 *
 * 	Use Case:
 *  ========
 *  ->	Best choice if our frequent operation is retrieval operation.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_023_Map_TreeMap {
	/*
	 * Using default natural sorting order
	 */
	static class TreeMapClass1 {
		public static void main(String[] args) {
			TreeMap map = new TreeMap();
			map.put(100, "ZZZ");
			map.put(103, "YYY");
			map.put(101, "XXX");
			map.put(104, 106);
			//map.put("FFF", "ZZZ"); //RE : ClassCastException
			//map.put(null, "ZZZ");	 //RE : NullPointerException
			System.out.println(map);
		}
	}

	/*
	 * Using customized sorting order
	 */
	static class MyComparator1 implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			String str1 = o1.toString();
			String str2 = o2.toString();
			return str2.compareTo(str1);
		}
	}

	static class TreeMapClass2 {
		public static void main(String[] args) {
			TreeMap map = new TreeMap(new MyComparator1());
			map.put("ZZZ", 30);
			map.put("AAA", 980);
			map.put("MMM", "XXX");
			map.put("CCC", 106);
			System.out.println(map);
		}
	}
}
