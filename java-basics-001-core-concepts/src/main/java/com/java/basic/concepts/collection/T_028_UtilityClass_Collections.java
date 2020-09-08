package com.java.basic.concepts.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 	-> Utility class - defines several methods for collection objects like sorting,searching,reversing etc.
 *
 * 	Methods:
 * 	=======
 * 	1.	public static void  sort(List l)
 * 			->	sorting based on DNSO
 * 			->	list should be of homogeneous and comparable objects else RE:ClassCastException
 * 			->	list should not contain Null else RE:NullPointerException
 * 	2.	public static void sort(List l, Comparator c)
 * 			-> sorting based on customized sorting order.
 * 	3.	public static int binarySearch(List l, Object target)
 * 			-> If list is sorted according to DNSO as sorting is necessary for binarySearch.
 * 			-> successful search returns index and unsuccessful search return insertion point.
 * 			-> insertion point is location where we can place the target element in sorted list.
 * 	4.	public static int binarySearch(List l, Object target, Comparator c)
 * 			-> If list is sorted according to customized sorting order.
 * 			-> successful search returns index and unsuccessful search return insertion point.
 * 	5.	public static void reverse(List l)
 * 			->	to reverse the elements of list.
 * 	6.	public static void reverseOrder()
 * 			-> provide the reversed Comparator.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_028_UtilityClass_Collections {
	
	/*
	 * Sorting methods
	 */
	static class CollectionsClass1 implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			String str1 = o1.toString();
			String str2 = o2.toString();
			return str2.compareTo(str1);
		}
		
		public static void main(String[] args) {
			ArrayList list = new ArrayList();
			list.add("Z");
			list.add("A");
			list.add("K");
			list.add("N");
			list.add(10); //RE:ClassCastException
			list.add(new Integer(10)); //RE:ClassCastException
			//list.add(null);  //RE:NullPointerException
			System.out.println("Before Sorting list 1 :: " + list);
			Collections.sort(list);
			System.out.println("After Sorting list 1 :: " + list);
			
			ArrayList list1 = new ArrayList();
			list1.add("Z");
			list1.add("A");
			list1.add("K");
			list1.add("N");
			list1.add(1000);
			System.out.println("Before Sorting list 2 :: " + list1);
			Collections.sort(list1, new CollectionsClass1());
			System.out.println("After Sorting list 2 :: " + list1);
		}
		
	}

	/*
	 * Searching methods
	 *
	 * Successful search range 		: 0 -> (n-1)
	 * unsuccessful search range	: -(n+1) -> -1
	 * total search range 			: -(n+1) -> (n-1)
	 */
	static class CollectionsClass2 implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			Integer I1 = (Integer) o1;
			Integer I2 = (Integer) o2;
			return I2.compareTo(I1);
		}
		
		public static void main(String[] args) {
			ArrayList list = new ArrayList();
			list.add("Z");
			list.add("A");
			list.add("K");
			list.add("N");
			list.add("a");
			System.out.println("Before Sorting list 1 :: " + list); // Z,A,K,N,a
			Collections.sort(list);
			System.out.println("After Sorting list 1 :: " + list); //A,K,N,Z,a
			System.out.println(Collections.binarySearch(list, "Z")); //3
			System.out.println(Collections.binarySearch(list, "J")); //-2

			ArrayList list1 = new ArrayList();
			list1.add(15);
			list1.add(0);
			list1.add(20);
			list1.add(10);
			list1.add(5);
			System.out.println("Before Sorting list 2 :: " + list1);
			Collections.sort(list1, new CollectionsClass2());
			System.out.println("After Sorting list 2 :: " + list1);
			System.out.println(Collections.binarySearch(list1, 10, new CollectionsClass2())); //2
			System.out.println(Collections.binarySearch(list1, 17)); //unpredictable output
			System.out.println(Collections.binarySearch(list1, 13, new CollectionsClass2())); //-3
			System.out.println(Collections.binarySearch(list1, 17, new CollectionsClass2())); //-2
		}
	}

	/*
	 * Reversing methods
	 *
	 * reverse() v/s reverseOrder()
	 * --------------------------
	 * reverse() will reverse the order of list while reverseOrder() will give the reversed Comparator.
	 */
	static class CollectionsClass3 {
		public static void main(String[] args) {
			ArrayList list = new ArrayList();
			list.add(15);
			list.add(0);
			list.add(20);
			list.add(10);
			list.add(5);
			System.out.println(list);
			Collections.reverse(list);
			System.out.println(list);
		}
	}
}
