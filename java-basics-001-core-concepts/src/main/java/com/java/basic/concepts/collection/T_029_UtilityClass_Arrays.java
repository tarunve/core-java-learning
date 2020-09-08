package com.java.basic.concepts.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * -> Utility class - defines several methods for Array objects like sorting,searching etc.
 *
 * Methods:
 * =======
 * 	1.	public static void sort(primitive[] p)
 * 	2.	public static void sort(Object[] o)
 * 	3.	public static void sort(Object[] o, Comparator c)
 * 	4.	public static int binarySearch(primitive[] p, primitive target)
 * 	5.	public static int binarySearch(Object[] o, Object target)
 * 	6.	public static int binarySearch(Object[] o, Object target, Comparator c)
 * 	7.	public static List asList(Object[] o)
 * 			->	This method won't create an independent list object. For the existing array object,
 * 		 		we will list view.
 *			->	By using if we perform any change, automatically it will be reflected to list & vice-versa.
 * 			->	By list reference we can't perform any operation which varies the size else RE:UnSupportedOperationException.
 * 			->	By list reference we are not allowed replace with heterogeneous objects else RE: ArrayStoreException.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_029_UtilityClass_Arrays {
	
	/*
	 * Sorting methods
	 */
	static class ArraysClass1 implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			String s1 = o1.toString();
			String s2 = o2.toString();
			return s2.compareTo(s1);
		}
		
		public static void main(String[] args) {
			int[] array = { 10, 5, 20, 11, 6 };
			System.out.print("Primitive Array before sorting :: ");
			for (int a : array) {
				System.out.print(a + " ");
			}
			System.out.println();
			Arrays.sort(array);
			System.out.print("Primitive Array after sorting :: ");
			for (int a : array) {
				System.out.print(a + " ");
			}
			System.out.println();
			
			String[] strArray = { "A", "Z", "B" };
			System.out.print("String Array before sorting :: ");
			for (String a : strArray) {
				System.out.print(a + " ");
			}
			System.out.println();
			Arrays.sort(strArray);
			System.out.print("String Array after sorting :: ");
			for (String a : strArray) {
				System.out.print(a + " ");
			}
			System.out.println();

			Arrays.sort(strArray, new ArraysClass1());
			System.out.print("Object Array after sorting by comparator :: ");
			for (String a : strArray) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
		
	}

	/*
	 * Searching methods
	 */
	static class ArraysClass2 implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			String s1 = o1.toString();
			String s2 = o2.toString();
			return s2.compareTo(s1);
		}
		
		public static void main(String[] args) {
			int[] array = { 10, 5, 20, 11, 6 };
			Arrays.sort(array);
			System.out.println(Arrays.binarySearch(array, 6)); //1
			System.out.println(Arrays.binarySearch(array, 14)); //-5
			
			String[] strArray = { "A", "Z", "B" };
			Arrays.sort(strArray);
			System.out.println(Arrays.binarySearch(strArray, "Z")); //2
			System.out.println(Arrays.binarySearch(strArray, "S")); //-3
			
			Arrays.sort(strArray, new ArraysClass2());
			System.out.println(Arrays.binarySearch(strArray, "Z", new ArraysClass2())); //0
			System.out.println(Arrays.binarySearch(strArray, "S", new ArraysClass2())); //-2
			System.out.println(Arrays.binarySearch(strArray, "N")); //-4 unpredictable
		}
	}
	
	/*
	 * 	Conversion of Array to List
	 * 	public static List asList(Object[] o)
	 *
	 */
	static class ArraysClass3 {
		public static void main(String[] args) {
			String[] str = { "A", "Z", "B" };
			List list = Arrays.asList(str);
			System.out.println(list);
			str[0] = "tarun";
			System.out.println(list);
			list.set(1, "L");
			for (String s1 : str) {
				System.out.println(s1);
			}
			//list.add("test"); //RE:UnSupportedOperationException
			//list.remove(2); //RE:UnSupportedOperationException
			//list.set(1, new Integer(45)); //RE:ArrayStoreException
		}
	}
}
