package com.java.basic.concepts.collection;

import java.util.TreeSet;

/**
 * ->	present in java.lang package.
 * -> 	Meant for default natural sorting order.
 * ->	String and all Wrapper classes implements Comparable interface.
 * -> 	Objects need to be Homogeneous and Comparable for natural sorting order.
 *
 * 	Methods:
 * 	=======
 * 	1.	public int compareTo(Object o)  => obj1.compareTo(obj2)
 * 											-> return -ive if obj1 has to come before obj2
 * 											-> return +ive if obj1 has to come after obj2
 * 											-> return 0 if obj1 and obj2 are equal.
 *
 * ->	If we are depending on natural sorting order then while adding objects into TreeSet,
 * 		JVM will call compareTo() method for comparison by default.
 *
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_013_Comparable {
	public static void main(String[] args) {
		System.out.println("A".compareTo("z")); // -ive
		System.out.println("Z".compareTo("X")); // +ive
		System.out.println("Z".compareTo("Z")); // 0
		//System.out.println("Z".compareTo(null)); // RE : NullPointerException

		//String by default implements Comparable
		TreeSet set = new TreeSet();
		set.add("A");
		set.add("z");
		set.add("L");
		set.add("B");
		System.out.println(set);
		
		//StringBuffer doesn't implement Comparable so RE : ClassCastException
		TreeSet set1 = new TreeSet();
		set1.add(new StringBuffer("A")); // RE : ClassCastException
		System.out.println(set1);
	}
}
