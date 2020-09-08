package com.java.basic.concepts.collection;

import java.util.Hashtable;

/**
 * ->	Underlying DS is - Hashtable only.
 * ->	Duplicate keys are not allowed but values can be duplicated.
 * ->	Insertion Order is not preserved and it is based on hashcode of keys.
 * ->	Heterogeneous objects are allowed for both keys and values.
 * ->	Null insertion is not possible for both keys and values.
 * -> 	Implements Serializable and Cloneable but not RandomAccess.
 * ->	Every method is synchronized and hence thread safe. Hence relatively, performance is low.
 * -> 	Introduced in 1.0 version.
 *
 * 	Constructors:
 * 	============
 * 	1.	Hashtable map = new Hashtable();
 * 	2.	Hashtable map = new Hashtable(int initialCapacity);
 * 	3.	Hashtable map = new Hashtable(int initialCapacity, int fillRatio);
 * 	4.	Hashtable map = new Hashtable(Map m);
 *
 * 	Methods:
 * 	=======
 * 	No specific methods. All from Map interfaces.
 *
 * 	Use Case:
 *  ========
 *  ->	Best choice if our frequent operation is retrieval operation.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_024_Map_HashTable {
	
	static class HashTableObject1 {
		int i;
		
		public HashTableObject1(int i) {
			this.i = i;
		}
		
		@Override
		public int hashCode() {
			//If hashcode changed to below , output will be -{16=F, 15=D, 6=C, 23=E, 5=A, 2=B}
			//return i % 9;
			return i;
		}

		@Override
		public String toString() {
			return i + "";
		}
	}

	public static void main(String[] args) {
		Hashtable hashtable = new Hashtable();
		hashtable.put(new HashTableObject1(5), "A");
		hashtable.put(new HashTableObject1(2), "B");
		hashtable.put(new HashTableObject1(6), "C");
		hashtable.put(new HashTableObject1(15), "D");
		hashtable.put(new HashTableObject1(23), "E");
		hashtable.put(new HashTableObject1(16), "F");
		//hashtable.put("Test", null); //RE : NullPointerException
		System.out.println(hashtable);
	}
}
