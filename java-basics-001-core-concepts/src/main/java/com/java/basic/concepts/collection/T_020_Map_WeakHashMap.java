package com.java.basic.concepts.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 *->	Child class of Map interface.
 * ->	Exactly same as HashMap except following difference:
 * 		1.	In HashMap, even though object doesn't have any reference, It is not eligible for GC i.e.
 * 			HashMap dominates GC. But in WeakHashMap, If object doesn't contain any references, It is
 * 			eligible for GC i.e. GC dominated WeakHashmap.
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_020_Map_WeakHashMap {
	
	static class WeakHashMapObject1 {
		@Override
		public String toString() {
			return "WeakHashMapObject1";
		}
		@Override
		public void finalize() {
			System.out.println("Finalize method called.");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Map map = new HashMap();
		WeakHashMapObject1 object1 = new WeakHashMapObject1();
		map.put(object1, "Element1");
		System.out.println(map);
		object1 = null;
		System.gc();
		Thread.sleep(5000);
		System.out.println(map);

		System.out.println("=========================");

		Map map1 = new WeakHashMap();
		WeakHashMapObject1 object2 = new WeakHashMapObject1();
		map1.put(object2, "Element1");
		System.out.println(map1);
		object2 = null;
		System.gc();
		Thread.sleep(5000);
		System.out.println(map1);
	}
}
