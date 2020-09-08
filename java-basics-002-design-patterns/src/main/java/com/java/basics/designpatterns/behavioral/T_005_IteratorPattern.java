package com.java.basics.designpatterns.behavioral;

import com.java.basics.designpatterns.behavioral.T_005_IteratorPattern.LinkedList.Node;

/*
 * 	->	Provide a way to access the elements of aggregate object sequentially without
 * 		exposing its underlying representation.
 *
 * 	When to use:
 * 	-----------
 * 	1.	To provide a standard way to traverse through collections of similar objects.
 * 	2.	To expose a single interface to the client by hiding the complexities of traversal.
 * 	3.	to provide a uniform interface for traversing different aggregate structures.
 *
 * 	Benefits:
 * 	--------
 * 	1.	The iterator class can be extended to add new functionalities without having to alter
 * 		the actual object it iterates over.
 * 	2.	The original class need not to be cluttered with interfaces that are specific to traversal.
 * 	3.	Iterator can support multiple traversals because it keeps track of its own traversal state.
 *
 * 	Real World Examples:
 * 	--------------------
 * 	1.	Television remote control. User can access the required channel by pressing the "next"
 * 		or "previous" button. User doesn't need to know about the internal details of the channel
 * 		like frequency, band etc. Remote Control provides a simplified interface to iterate
 * 		through the channels.
 *
 * 	Software Example
 * 	----------------
 * 	1.	Iterators provided for various types of collections in SDKs.
 *
 * 	Java SDK Examples
 * 	-----------------
 * 	1.	All implementations of java.util.Iterator.
 * 	2.	All implementations of java.util.Enumeration.
 */
public class T_005_IteratorPattern {
	/*
	 *Create an interface for the collection and its concrete implementations. The implementations
	 *will have getIterator() method that returns the iterator for the underlying collection of objects.
	 */
	public static interface Collection {
		public Iterator getIterator();
		public void insert(int value);
	}
	
	public static class Array implements Collection {
		
		int[] array;
		int length;
		
		public Array(int size) {
			array = new int[size];
			length = 0;
		}
		
		@Override
		public Iterator getIterator() {
			return new ArrayIterator(array, length);
		}
		
		@Override
		public void insert(int value) {
			array[length++] = value;
		}
	}
	
	public static class LinkedList implements Collection {
		
		Node head;
		Node current;
		
		@Override
		public Iterator getIterator() {
			return new ListIterator(head);
		}
		
		@Override
		public void insert(int value) {
			Node newNode = new Node(value);
			if (current == null) {
				head = newNode;
				current = newNode;
			}
			else {
				current.next = newNode;
				current = newNode;
			}
		}
		
		static class Node {
			int data;
			Node next;
			
			public Node(int data) {
				this.data = data;
			}
		}
	}
	
	/*
	 * Design an "iterator" interface and its concrete implementations that can encapsulate
	 * traversal of the "collection" class.
	 */
	public static interface Iterator {
		public int next();
		public boolean hasNext();
	}
	
	public static class ArrayIterator implements Iterator {
		
		int[] arr;
		int pos, length;
		
		public ArrayIterator(int[] arr, int length) {
			this.arr = arr;
			this.length = length;
			pos = -1;
		}
		
		@Override
		public int next() {
			return arr[++pos];
		}
		
		@Override
		public boolean hasNext() {
			return (pos + 1) < length;
		}
	}
	
	public static class ListIterator implements Iterator {
		
		Node current;
		
		public ListIterator(Node head) {
			this.current = head;
		}
		
		@Override
		public int next() {
			int value = current.data;
			current = current.next;
			return value;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
	}
	
	/*
	 * Client code - Client uses iterator methods to access the elements of collection class.
	 */
	public static class IteratorClient {
		
		public static void main(String[] args) {
			Collection arr = new Array(4);
			arr.insert(1);
			arr.insert(2);
			arr.insert(3);
			arr.insert(4);
			iterate(arr.getIterator());
			
			Collection list = new LinkedList();
			list.insert(11);
			list.insert(23);
			list.insert(34);
			list.insert(45);
			iterate(list.getIterator());
			
		}
		
		private static void iterate(Iterator iterator) {
			while (iterator.hasNext()) {
				System.out.print(iterator.next() + " ");
			}
			System.out.println();
		}
	}
}
