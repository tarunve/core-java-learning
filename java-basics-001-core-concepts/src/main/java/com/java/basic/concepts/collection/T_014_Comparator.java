package com.java.basic.concepts.collection;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * ->	present in java.util package.
 * -> 	Meant for customized sorting order.
 * -> 	Objects need not to be Homogeneous and Comparable for natural sorting order.
 * 		If we are depending on customized sorting order, objects need not to be homogeneous
 * 		and Comparable.
 *
 * 	Methods:
 * 	=======
 * 	1.	public int compare(Object obj1, Object obj2)
 * 					-> return -ive if obj1 has to come before obj2
 * 					-> return +ive if obj1 has to come after obj2
 * 					-> return 0 if obj1 and obj2 are equal.
 * 	2.	public boolean equals(Object o)
 *
 * ->	Whenever we are implementing Comparator interface, Compulsory we should implement
 * 		compare method but equals method need not to be implemented because it is already
 * 		present in Object class.
 *
 * 	Possible implementation of compare method:
 * 	-----------------------------------------
 * 			Integer I1 = (Integer)obj1;
 * 			Integer I2 = (Integer)obj2;
 * 	1.	return I1.compareTo(I2)   	: Default Natural Sorting Order
 * 	2.	return -I1.compareTo(I2)	: Descending Order (Reverse)
 * 	3.	return I2.compareTo(I1)		: Descending Order (Reverse)
 * 	4.	return -I2.compareTo(I1)	: Default Natural Sorting Order
 * 	5.	return +1					: Insertion Order
 * 	6.	return -1					: Reverse of insertion order
 * 	7. 	return 0					: Only first element will be inserted and all remaining will be duplicated.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_014_Comparator {
	
	/*
	 * Write a program to insert integer objects into TreeSet where sorting order - descending sorting order.
	 */
	static class MyComparator1 implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			Integer I1 = (Integer) o1;
			Integer I2 = (Integer) o2;
			if (I1 < I2)
				return 1;
			else if (I1 > I2)
				return -1;
			else
				return 0;
		}
		
	}

	static class ComparatorClass1 {
		public static void main(String[] args) {
			TreeSet set = new TreeSet(new MyComparator1());
			set.add(10);
			set.add(0);
			set.add(15);
			set.add(5);
			set.add(20);
			set.add(20);
			System.out.println(set);
		}
	}
	
	/*
	 * Write a program to insert String objects into TreeSet where sorting order - reverse alphabetical order.
	 */
	static class MyComparator2 implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			String str1 = (String) o1;
			String str2 = (String) o2;
			return str2.compareTo(str1); // we could use -str1.compareTo(str2)
		}
		
	}

	static class ComparatorClass2 {
		public static void main(String[] args) {
			TreeSet set = new TreeSet(new MyComparator2());
			set.add("Roja");
			set.add("Shobha");
			set.add("Raja Kumari");
			set.add("Ganga");
			set.add("Anjali");
			set.add("Ramulamma");
			System.out.println(set);
		}
	}
	
	/*
	 * Write a program to insert StringBuffer objects into TreeSet where sorting order - alphabetical order.
	 *
	 * For StringBuffer, we will need to use the comparator as it doesn't implement the Comparable interface.
	 * Otherwise , it will throw RE : CalssCastException.
	 */
	static class MyComparator3 implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			String str1 = o1.toString();
			String str2 = o2.toString();
			return -str2.compareTo(str1);
		}
		
	}

	static class ComparatorClass3 {
		public static void main(String[] args) {
			TreeSet set = new TreeSet(new MyComparator3());
			set.add(new StringBuffer("Roja"));
			set.add(new StringBuffer("Shobha"));
			set.add(new StringBuffer("Raja Kumari"));
			set.add(new StringBuffer("Ganga"));
			set.add(new StringBuffer("Anjali"));
			set.add(new StringBuffer("Ramulamma"));
			System.out.println(set);
		}
	}

	/*
	 * Write a program to insert StringBuffer and String objects into TreeSet where sorting order
	 * is increasing length order . if same length, then consider alphabetical order.
	 */
	static class MyComparator4 implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			String str1 = o1.toString();
			String str2 = o2.toString();
			int l1 = str1.length();
			int l2 = str2.length();
			if (l1 < l2)
				return -1;
			else if (l1 > l2)
				return 1;
			return -str2.compareTo(str1);
		}
		
	}

	static class ComparatorClass4 {
		public static void main(String[] args) {
			TreeSet set = new TreeSet(new MyComparator4());
			set.add(new StringBuffer("Roja"));
			set.add(new StringBuffer("Shobha"));
			set.add(new StringBuffer("Raja Kumari"));
			set.add(new StringBuffer("Ganga"));
			set.add(new StringBuffer("Anjali"));
			set.add(new StringBuffer("Ramulamma"));
			System.out.println(set);
		}
	}
}
