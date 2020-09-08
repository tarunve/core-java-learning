package com.java.basic.concepts.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 	->	Thread-Safe version of ArrayList.
 *	->	As the name indicates, it creates a cloned copy of underlying ArrayList for every update
 *		operation. At certain point, both will synchronized automatically which is taken care by JVM.
 *	->	As update operation will be performed on cloned copy, there is no effect for the Threads which
 *		perform read operations.
 *	->	It is costly to use because for every update operation, a cloned copy will be created. hence it is
 *		best choice if several read operation & less number of write operation are required to perform.
 *	->	Insertion order is preserved.
 *	->	Duplicate objects are allowed.
 *	->	Heterogeneous objects are allowed.
 *	->	Null insertion is possible.
 *	->	Implements Serializable, Cloneable and RandomAccess interfaces.
 *	->	While one thread iterating CopyOnWriteArrayList, the remaining threads are allowed to modify and we
 *		won't get ConcurrentModificationException i.e. iterators are Fail-Safe.
 *	->	Iterator of Array can perform remove operation but iterator of CopyOnWriteArrayList can't perform
 *		remove operation otherwise we will get RE: UnSupportedOperationException.
 *	-> 	Introduced in 1.5 version.
 *
 *	Constructors:
 *	============
 *	1.	CopyOnWriteArrayList List = new CopyOnWriteArrayList();
 *	2.	CopyOnWriteArrayList list = new CopyOnWriteArrayList(Collection c);
 *	3.	CopyOnWriteArrayList list = new CopyOnWriteArrayList(Object[] o);
 *
 *	Methods:
 *	=======
 *	1.	boolean addIfAbsent(Object o) :	element will be added if and only if not present in list.
 *	2.	int addAllAbsent(Collection c):	elements will be added if it is absent & return the count of elements added.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_032_CopyOnWriteArrayList {
	/*
	 * Simple example
	 */
	static class COWALClass1 {
		public static void main(String[] args) {
			ArrayList list1 = new ArrayList();
			list1.add("A");
			list1.add("B");
			CopyOnWriteArrayList list2 = new CopyOnWriteArrayList();
			list2.add("A");
			list2.add("C");
			System.out.println(list2);
			list2.addAll(list1);
			System.out.println(list2);

			ArrayList list3 = new ArrayList();
			list3.add("A");
			list3.add("D");
			list2.addAllAbsent(list3);
			System.out.println(list2);
		}
	}
	
	/*
	 * If one thread iteration, remaining threads can perform modification and it will
	 * not throw ConcurrentModificationException.
	 */
	static class COWALClass2 extends Thread {
		static CopyOnWriteArrayList list = new CopyOnWriteArrayList();

		@Override
		public void run() {
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException ex) {}
			System.out.println("Child Thread updating list.");
			list.add("C");
		}
		
		public static void main(String[] args) throws InterruptedException {
			list.add("A");
			list.add("B");
			COWALClass2 thread = new COWALClass2();
			Iterator iterator = list.iterator();
			thread.start();
			while (iterator.hasNext()) {
				String str = (String) iterator.next();
				System.out.println("Main thread iterating and current entry is :: " + str);
				Thread.sleep(3000);
			}
			System.out.println(list);
		}
	}
	
	/*
	 * Iterator of COWAL can't perform remove operation.
	 */
	static class COWALClass3 {
		public static void main(String[] args) {
			CopyOnWriteArrayList list = new CopyOnWriteArrayList();
			list.add("A");
			list.add("B");
			list.add("C");
			list.add("D");
			list.add("E");
			System.out.println(list);
			Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				String str = (String) iterator.next();
				if (str.equals("C")) {
					iterator.remove(); //RE:java.lang.UnsupportedOperationException
				}
			}
			System.out.println(list);
		}
	}
}
