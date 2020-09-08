package com.java.basic.concepts.collection;

/**
 * 	->	Child Interface of Collection(I).
 * 	->	If we want to represent a group of individual objects prior to processing then we
 * 		should go for Queue.
 * 		Ex. -> Before sending SMS, all mobile numbers we have to store in some DS. The order
 * 			   in which we added mobile numbers, in same order - messages will be delivered.
 * 	->	Usually queue follows FIFo order but based on our requirement, we can implement our
 * 		priority order also(Priority Queue).
 * 	->	LinkedList based Queue implementation always follows FIFO.
 * 	->	Introduced in 1.5 version.
 *
 * 	Queue specific methods:
 * 	======================
 * 	1.	boolean offer(Object o)	: To add an object to queue.
 * 	2.	Object peek()			: Return head element. If empty - then returns null.
 * 	3.	Object element()		: Return head element. If empty - RE : NoSuchElementException
 * 	4.	Object poll()			: Remove and return head element. If empty - returns null.
 * 	5.	Object remove()			: Remove and return head element. If empty - RE:NoSuchElementException.
 */
public class T_026_QueueInterface {
	
	public T_026_QueueInterface() {}
	
}
