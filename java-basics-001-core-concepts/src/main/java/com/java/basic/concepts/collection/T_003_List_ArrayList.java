package com.java.basic.concepts.collection;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * ->	Underlying DS is - Resize-able array or Grow-able array.
 * ->	Duplicates are allowed.
 * ->	Insertion Order is preserved.
 * ->	Heterogeneous objects are allowed. Except TreeSet & TreeMap, Heterogeneous objects are allowed in all 
 * 		Collection objects.
 * ->	Null insertion is possible.
 * -> 	Default Initial Capacity 10.
 * -> 	Implements Serializable and Cloneable( to hold and transfer objects from one container to another) and
 * 		RandomAccess(For Quick Access). All are Marker interface so required ability will be provided by JVM.
 * ->	Non-synchronized and hence not thread safe. Hence relatively, performance is high.
 * -> 	Introduced in 1.2 version.
 *
 * 	Constructors:
 * 	============
 * 	1.	ArrayList list = new ArrayList();  // Default Capacity - 10
 * 	2.	ArrayList list = new ArrayList(int initialCapacity); //Formula to calculate : (current capacity*3/2) +1
 * 	3.	ArrayList list = new ArrayList(Collection c);
 *
 * 	Methods:
 * 	=======
 * 	No specific methods. All from List and collection interfaces.
 *
 * 	Use Case:
 *  =========
 *  ->	Best choice if our frequent operation is retrieval operation.
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class T_003_List_ArrayList {
	public static void main(String[] args) throws Exception {
		ArrayList list = new ArrayList();
		list.add("Element1");
		list.add("Element2");
		list.add("Element3");
		list.add("Element4");
		list.add("Element5");
		list.add("Element6");
		list.add("Element1");
		list.add(new StringBuffer("Element7"));
		list.add(new Integer(90));
		list.add(80);
		list.add(null);
		System.out.println(getCapacity(list));
		System.out.println(list.lastIndexOf("Element"));

		ArrayList list1 = new ArrayList(2);
		list1.add("Element1");
		list1.add("Element2");
		System.out.println(getCapacity(list1));
		list1.add("Element3");
		System.out.println(getCapacity(list1));
		list1.add("Element2");
		System.out.println(getCapacity(list1));
		list1.add("Element3");
		System.out.println(getCapacity(list1));
		list1.add(null);
		System.out.println(getCapacity(list1));
		list1.add(null);
		System.out.println(getCapacity(list1));

		ArrayList list2 = new ArrayList(list1);
		System.out.println(list2);
		System.out.println(getCapacity(list2));
	}
	
	static int getCapacity(ArrayList l) throws Exception {
		Field dataField = ArrayList.class.getDeclaredField("elementData");
		dataField.setAccessible(true);
		return ((Object[]) dataField.get(l)).length;
	}
}
