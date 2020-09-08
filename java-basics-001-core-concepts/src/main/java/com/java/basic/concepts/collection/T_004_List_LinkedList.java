package com.java.basic.concepts.collection;

import java.util.LinkedList;

/**
 * ->	Underlying DS is - Doubly Linked List.
 * ->	Duplicates are allowed.
 * ->	Insertion Order is preserved.
 * ->	Heterogeneous objects are allowed. Except TreeSet & TreeMap, Heterogeneous objects are allowed in all Collection objects.
 * ->	Null insertion is possible.
 * -> 	No concept of initial capacity.
 * -> 	Implements Serializable and Cloneable( to hold and transfer objects from one container to another) but not RandomAccess.
 * 		All are Marker interface so required ability will be provided by JVM.
 * ->	Non-synchronized and hence not thread safe. Hence relatively, performance is high.
 * -> 	Introduced in 1.2 version.
 *
 * 	Constructors:
 * 	============
 * 	1.	LinkedList list = new LinkedList();
 * 	2.	LinkedList list = new LinkedList(Collection c);
 *
 * 	Methods:
 * 	=======
 * 	We can use LinkedList to develop Queues and Stacks. To meet this requirement , LinkedList have following methods:
 * 	1.	void addFirst(Object o)
 * 	2.	void addLast(Object o)
 * 	3.	Object getFirst()
 * 	4.	Object getLast()
 * 	5. 	Object removeFirst()  // remove and return the Object element.
 * 	6. 	Object removeLast()	  // remove and return the Object element.
 *
 * 	Use Case:
 *  ========
 *  ->	Best choice if our frequent operation insertion/deletion in middle.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_004_List_LinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(0, "Element1");
		list.add(1, "Element2");
		list.add(2, new StringBuffer("Element3"));
		list.add(3, 30);
		list.add(4, null);
		System.out.println(list);
		
		list.set(2, new StringBuffer("Element4"));
		System.out.println(list);
		
		list.addFirst(000);
		System.out.println(list);

		list.addLast(999);
		System.out.println(list);

		System.out.println(list.getFirst());
		System.out.println(list.getLast());

		System.out.println(list.removeFirst());
		System.out.println(list);
		
		System.out.println(list.removeLast());
		System.out.println(list);
		
	}

}
