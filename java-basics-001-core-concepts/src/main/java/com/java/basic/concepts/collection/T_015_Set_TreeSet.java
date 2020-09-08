package com.java.basic.concepts.collection;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * ->	Underlying DS is - Balanced Tree.
 * ->	Duplicates are not allowed. No compilation error, it will simply return false.
 * ->	Insertion Order is not preserved and it is based on sorting order(either DNSO or provided order).
 * ->	Heterogeneous objects are not allowed otherwise ClassCastException because comparison is required.
 * ->	Null insertion is not possible (Only once till 1.6 when TreeSet is empty but not from 1.7).
 * -> 	Implements Serializable and Cloneable but not RandomAccess.
 * ->	Non-synchronized and hence not thread safe. Hence relatively, performance is high.
 * -> 	Introduced in 1.2 version.
 *
 * 	Constructors:
 * 	============
 * 	1.	TreeSet set = new TreeSet();  				: Elements will be inserted according to DNSO.
 * 	2.	TreeSet set = new TreeSet(Comparator c); 	: Elements will be inserted according to customized sorting order(c).
 * 	3.	TreeSet set = new TreeSet(SortedSet s);		: Conversion of SortedSet to TreeSet.
 * 	4.	TreeSet set = new TreeSet(Collection c);	: Conversion of any collection to TreeSet, order - DNSO.
 *
 * 	Methods:
 * 	=======
 * 	No specific methods. All from Collection, Set, SortedSet interfaces.
 *
 * 	Use Case:
 *  ========
 *  ->	Best choice if our frequent operation is retrieval operation.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_015_Set_TreeSet {
	static class TreeSetClass1 {
		public static void main(String[] args) {
			TreeSet set = new TreeSet();
			set.add("a");
			set.add("Z");
			set.add("L");
			set.add("X");
			set.add("A");
			//set.add(new Integer(10)); // RE : ClassCastException
			//set.add(null); //RE : NullPointerException
			//System.out.println(set.add(10)); // RE : ClassCastException
			System.out.println(set);
			
			TreeSet set1 = new TreeSet();
			//set1.add(new StringBuffer("A")); //ClassCastException : StringBuffer doesn't implement Comparable
			//set1.add(new StringBuffer("Z"));
			System.out.println(set1);
		}
	}
	
	/*
	 * Customized Example for use case - when Comparable is best suited and when Comparator.
	 * The person who writes the class should take care of sorting order using Comparable.
	 * The person who is using the class can customize the order as per requirement using Comparator.
	 */
	
	static class ExampleObject1 implements Comparable {
		String name;
		int id;
		
		public ExampleObject1(String name, int id) {
			this.name = name;
			this.id = id;
		}
		
		@Override
		public String toString() {
			return id + "---" + name;
		}
		
		@Override
		public int compareTo(Object o) {
			int id1 = this.id;
			ExampleObject1 obj2 = (ExampleObject1) o;
			int id2 = obj2.id;
			if (id1 < id2)
				return -1;
			else if (id1 > id2)
				return 1;
			else
				return 0;
		}
		
	}
	
	static class MyComparator1 implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			ExampleObject1 obj1 = (ExampleObject1) o1;
			ExampleObject1 obj2 = (ExampleObject1) o2;
			String str1 = obj1.name;
			String str2 = obj2.name;
			return str1.compareTo(str2);
		}
		
	}
	
	static class TreeSetClass2 {
		public static void main(String[] args) {
			ExampleObject1 e1 = new ExampleObject1("Nagarjun", 100);
			ExampleObject1 e2 = new ExampleObject1("Balaiah", 200);
			ExampleObject1 e3 = new ExampleObject1("Chiru", 50);
			ExampleObject1 e4 = new ExampleObject1("Venki", 150);
			ExampleObject1 e5 = new ExampleObject1("Nagarjun", 100);
			
			TreeSet set = new TreeSet();
			set.add(e1);
			set.add(e2);
			set.add(e3);
			set.add(e4);
			set.add(e5);
			System.out.println(set);
			
			TreeSet set1 = new TreeSet(new MyComparator1());
			set1.add(e1);
			set1.add(e2);
			set1.add(e3);
			set1.add(e4);
			set1.add(e5);
			System.out.println(set1);
		}
	}
}
