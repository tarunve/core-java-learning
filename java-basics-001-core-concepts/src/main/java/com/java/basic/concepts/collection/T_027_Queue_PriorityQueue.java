package com.java.basic.concepts.collection;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *	->	If we want to represent a group of individual objects prior to processing according to
 *		some priority then we should go for PriorityQueue.
 *	->	Priority can be either DNSO or customized sorting order defined by comparator.
 *	->	Insertion order is not preserved and it is based on priority.
 *	->	Duplicate objects are not allowed.
 *	->	Null is not allowed even as the first element.
 *	->	If we are depending on DNSO, Objects need to be homogeneous and comparable otherwise we
 *		will get RE:ClassCastException. If customized sorting order, then objects need not to be
 *		Homogeneous and comparable.
 *
 *	Constructor:
 *	===========
 *	1.	PriorityQueue queue = new PriorityQueue();									: intialCapacity-11 , DNSO
 *	2.	PriorityQueue queue = new PriorityQueue(int initialCapacity);				: DNSO
 *	3.	PriorityQueue queue = new PriorityQueue(int initialCapacity, Comparator c);	: specified
 *	4.	PriorityQueue queue = new PriorityQueue(SortedSet s);						: cap-11,specified
 *	5.	PriorityQueue queue = new PriorityQueue(Collection c);						: inter-conversion
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_027_Queue_PriorityQueue {

	/*
	 * using DNSO
	 */
	static class PriorityClass1 {
		public static void main(String[] args) {
			PriorityQueue queue = new PriorityQueue();
			System.out.println(queue.peek()); //null
			//System.out.println(queue.element()); // RE : NoSuchElementException
			for (int i = 0; i <= 10; i++) {
				queue.offer(i);
			}
			System.out.println(queue);
			System.out.println(queue.poll());
			System.out.println(queue);
		}
	}

	/*
	 * using customized sorting order
	 */
	static class MyComparator1 implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			String str1 = (String) o1;
			String str2 = (String) o2;
			return str2.compareTo(str1);
		}

	}

	static class PriorityClass2 {
		public static void main(String[] args) {
			PriorityQueue queue = new PriorityQueue(15, new MyComparator1());
			queue.offer("A");
			queue.offer("Z");
			queue.offer("L");
			queue.offer("B");
			System.out.println(queue);
		}
	}
}
