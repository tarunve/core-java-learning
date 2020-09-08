package com.java.basic.concepts.collection;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ->	Child class of HashSet
 * ->	Exactly same ad HashSet with below differences :
 * 		1.	Underlying DS is LinkedList + Hashtable.
 * 		2.	Insertion Order is preserved.
 * 		3.	Introduced in 1.4 version.
 *
 * 	UseCase:
 * 	=======
 * 	1.	We can use LinkedHashSet to develop cache based applications where duplicates
 * 		are not allowed and insertion order is preserved.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_010_Set_LinkedHashSet {
	public static void main(String[] args) {
		Set set = new LinkedHashSet();
		set.add("Element1");
		set.add("Element2");
		set.add(new StringBuffer("Element3"));
		set.add(10);
		set.add(null);
		set.add(null);
		System.out.println(set.add(null));
		System.out.println(set);

		Set set1 = new LinkedHashSet(3);
		set1.add("Element1");
		set1.add("Element2");
		set1.add(new StringBuffer("Element3"));
		set1.add(10);
		set1.add(null);
		set1.add(null);
		System.out.println(set.add(null));
		System.out.println(set1);

		Set set2 = new LinkedHashSet(3, 0.5f);
		set2.add("Element1");
		set2.add("Element2");
		set2.add(new StringBuffer("Element3"));
		set2.add(10);
		set2.add(null);
		set2.add(null);
		System.out.println(set.add(null));
		System.out.println(set2);

		Set set3 = new LinkedHashSet(set2);
		set3.add(null);
		System.out.println(set.add(null));
		System.out.println(set3);
	}

}
