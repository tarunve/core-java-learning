package com.java.basic.concepts.collection;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 	->	Thread-Safe version of Set.
 *	->	Internally implemented by CopyOnWriteArrayList.
 *	->	It is costly to use because for every update operation, a cloned copy will be created. hence it is
 *		best choice if several read operation & less number of write operation are required to perform.
 *	->	Insertion order is preserved.
 *	->	Duplicate objects are not allowed.
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
 *	1.	CopyOnWriteArraySet set = new CopyOnWriteArraySet();
 *	2.	CopyOnWriteArraySet set = new CopyOnWriteArraySet(Collection c);
 *
 *	Methods:
 *	=======
 *	No specific methods.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_033_CopyOnWriteArraySet {
	public static void main(String[] args) {
		CopyOnWriteArraySet set = new CopyOnWriteArraySet();
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("A");
		set.add(null);
		set.add(10);
		set.add("D");
		System.out.println(set);
	}
}
