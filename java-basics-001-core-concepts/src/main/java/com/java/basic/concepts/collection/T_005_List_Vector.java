package com.java.basic.concepts.collection;

import java.util.Enumeration;
import java.util.Vector;

/**
 * ->	Underlying DS is - Resize-able array or Grow-able array.
 * ->	Duplicates are allowed.
 * ->	Insertion Order is preserved.
 * ->	Heterogeneous objects are allowed. Except TreeSet & TreeMap, Heterogeneous objects are allowed in all Collection objects.
 * ->	Null insertion is possible.
 * -> 	Default Initial Capacity 10.
 * -> 	Implements Serializable and Cloneable( to hold and transfer objects from one container to another) and RandomAccess(For Quick Access).
 * 		All are Marker interface so required ability will be provided by JVM.
 * ->	Synchronized version of ArrayList and hence thread safe. Hence relatively, performance is low.
 * -> 	Introduced in 1.0 version. Hence, Legacy class.
 *
 * 	Constructors:
 * 	============
 * 	1.	Vector list = new Vector();  // Default Capacity - 10
 * 	2.	Vector list = new Vector(int initialCapacity); //Formula to calculate : (current capacity*2)
 * 	3.	Vector list = new Vector(int initialCapacity, int incrementalCapacity);
 * 	4.	Vector list = new Vector(Collection c);
 *
 * 	Vector specific Methods:
 * 	=======================
 * 	1.	public synchronized void addElement(Object o)
 * 	2.	public synchronized boolean removeElement(Object o)
 * 	3.	public synchronized void removeElementAt(int index)
 * 	4.	public synchronized void removeAllElements()
 * 	5. 	public synchronized Object elementAt(int index)
 * 	6. 	public synchronized Object firstElement()
 * 	7. 	public synchronized Object lastElement()
 * 	8. 	public synchronized void setElementAt(Object o, int index)
 * 	9. 	public synchronized int size()
 * 	10.	public synchronized int capacity()
 * 	11. public Enumeration<E> elements()
 *
 * 	Use Case:
 *  ========
 *  ->	Best choice if our frequent operation is retrieval operation.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_005_List_Vector {
	
	public static void main(String[] args) {
		Vector vector = new Vector(4, 3);
		vector.addElement("Element1");
		vector.addElement(new StringBuffer("Element2"));
		vector.addElement(30);
		vector.addElement(null);

		System.out.println(vector.size());
		System.out.println(vector.capacity());

		vector.add("New Element");
		System.out.println(vector.size());
		System.out.println(vector.capacity());

		System.out.println(vector.elementAt(4));
		System.out.println(vector.firstElement());
		System.out.println(vector.lastElement());
		
		Enumeration enumeration = vector.elements();
		System.out.print("The elements in Vector Object :: {");
		while (enumeration.hasMoreElements()) {
			System.out.print(enumeration.nextElement() + " ");
		}
		System.out.println("}");

		vector.removeElementAt(4);
		System.out.println(vector);

		vector.removeElement(null);
		System.out.println(vector);

		vector.removeAllElements();
		System.out.println(vector);
	}
	
}
