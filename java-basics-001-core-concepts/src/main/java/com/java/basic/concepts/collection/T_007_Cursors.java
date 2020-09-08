package com.java.basic.concepts.collection;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

/**
 *-> 	If we want to get objects one by one, then we should go for cursors.
 *
 *	Types of Cursors:
 *	================
 *	1.	Enumeration :
 *		-----------
 *		->	We can use it for getting only the legacy objects.
 *		-> 	We can create it by using elements() method in Vector class.
 *		-> 	By using enumeration , we can perform read operation only.
 *		-> 	Introduced in 1.0 version.
 *		Methods:
 *		-------
 *		1.	public boolean hasMoreElements()
 *		2.	public Object nextElement()
 *
 *	2.	Iterator :
 *		--------
 *		->	We can use it for getting any Collection object. Hence , it is universal cursor.
 *		-> 	We can create it by using iterator() method in Collection interface.
 *		-> 	By using iterator , we can perform read and remove operation.
 *		-> 	Introduced in 1.2 version.
 *		Methods: 
 *		-------
 *		1.	public boolean hasNext()
 *		2.	public Object next()
 *		3.	public void remove()
 *
 *	3.	ListIterator :
 *		------------
 *		-> We can move either move in forward or backward direction. Hence, it is bi-directional.
 *		->	We can use it for getting only List object.
 *		-> 	We can create it by using listIterator() method in List interface.
 *		-> 	By using iterator , we can perform read, remove, add, update operation.
 *		-> 	Introduced in 1.2 version.
 *		Methods:
 *		-------
 *		1.	public boolean hasNext()
 *		2.	public Object next()
 *		3. 	public int nextIndex()
 *		4.	public boolean hasPrevious()
 *		5.	public Object previous()
 *		6. 	public int previousIndex()
 *		7.	public void remove()
 *		8.	public void add(Object o)
 *		9.	public void set(Object o)
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_007_Cursors {

	static class CursorEnumeration {
		public static void main(String[] args) {
			Vector vector = new Vector();
			vector.addElement("Element1");
			vector.addElement(new StringBuffer("Element2"));
			vector.addElement(30);
			vector.addElement(null);
			System.out.println(vector);
			
			Enumeration enumeration = vector.elements();
			System.out.println(enumeration.getClass().getCanonicalName());
			System.out.print("The elements in Vector Object :: {");
			while (enumeration.hasMoreElements()) {
				System.out.print(enumeration.nextElement() + " ");
			}
			
		}
	}

	static class CursorIterator {
		public static void main(String[] args) {
			ArrayList arrayList = new ArrayList();
			arrayList.add("Element1");
			arrayList.add(new StringBuffer("Element2"));
			arrayList.add(30);
			arrayList.add(null);
			System.out.println(arrayList);

			Iterator iterator = arrayList.iterator();
			System.out.println(iterator.getClass().getCanonicalName());
			System.out.print("The elements in ArrayList Object :: ");
			while (iterator.hasNext()) {
				Object obj = iterator.next();
				if (obj == null)
					iterator.remove();
				else
					System.out.print(obj + " ");
			}
		}
	}

	static class CursorListIterator {
		public static void main(String[] args) {
			List linkedList = new LinkedList();
			linkedList.add("Element1");
			linkedList.add(new StringBuffer("Element2"));
			linkedList.add(30);
			linkedList.add(null);
			System.out.println(linkedList);

			ListIterator listIterator = linkedList.listIterator();
			System.out.println(listIterator.getClass().getCanonicalName());
			System.out.print("The elements in LinkedList Object in forward direction :: ");
			while (listIterator.hasNext()) {
				System.out.print(listIterator.next() + " ");
			}
			System.out.println();
			System.out.print("The elements in LinkedList Object in backward direction :: ");
			while (listIterator.hasPrevious()) {
				System.out.print(listIterator.previous() + " ");
			}
			System.out.println();
			listIterator.add(678);
			System.out.println(linkedList);
		}
	}
	
}
