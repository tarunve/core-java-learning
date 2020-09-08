package com.java.basic.concepts.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *	->	 Underlying DS is Hashtable.
 *	->	ConcurrentHashMap(CHM) allows concurrent read operations and Thread-Safe update operations.
 *	->	To perform read operation, Thread won't require any lock but to perform update operation,
 *		Thread requires lock but it is the lock of only a particular part of Map(Segment lock/Bucket
 *		level lock) instead of Total Map lock.
 *	->	Concurrent updates achieved by internally dividing Map into smaller portions which is defined
 *		by Concurrency Level.
 *	->	The default concurrency level is 16.
 *	->	CHM allows any number of read operations but 16 update operations at a time by default.
 *	->	Null insertion is not possible for both Keys and Values.
 *	->	While one thread iteration, the remaining threads can perform update operation safely and CHM
 *		never throws ConcurrentModificationException i.e. Iterator is Fail-Safe.
 *	-> 	Introduced in 1.5 version.
 *
 *	Constructors:
 *	============
 *	1.	ConcurrentHashMap map = new ConcurrentHashMap();
 *			->	default Capacity - 16, default fillRatio - 0.75, default concurrencyLevel - 16
 *	2.	ConcurrentHashMap map = new ConcurrentHashMap(int initialCapacity);
 *			->	default fillRatio - 0.75, default concurrencyLevel - 16
 *	3.	ConcurrentHashMap map = new ConcurrentHashMap(int initialCapacity, float fillRatio);
 *			->  default concurrencyLevel - 16
 *	4.	ConcurrentHashMap map = new ConcurrentHashMap(int initialCapacity, float fillRatio, int concurrencyLevel);
 *	5.	ConcurrentHashMap map = new ConcurrentHashMap(Map m);
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_031_ConcurrentHashMap extends Thread {

	static ConcurrentHashMap map = new ConcurrentHashMap();

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException ex) {}
		System.out.println("Child thread updating map...");
		map.put(103, "C");
	}
	
	public static void main(String[] args) throws InterruptedException {
		map.put(101, "A");
		map.put(102, "B");
		T_031_ConcurrentHashMap thread = new T_031_ConcurrentHashMap();
		Set set = map.keySet();
		Iterator iterator = set.iterator();
		thread.start();
		while (iterator.hasNext()) {
			Integer I = (Integer) iterator.next();
			System.out.println("Main thread iterating and current entry is :: " + I + "----" + map.get(I));
			Thread.sleep(3000);
		}
		System.out.println(map);
	}
	
	/*
	 * Producer-Consumer
	 */
	static class FirstWorker implements Runnable {
		private final ConcurrentMap<String, Integer> concurrentMap;

		public FirstWorker(ConcurrentMap<String, Integer> queue) {
			this.concurrentMap = queue;
		}

		@Override
		public void run() {
			try {
				concurrentMap.put("B", 1);
				concurrentMap.put("V", 2);
				concurrentMap.put("F", 3);
				Thread.sleep(1000);
				concurrentMap.put("G", 4);
				concurrentMap.put("U", 5);
				Thread.sleep(1000);
				concurrentMap.put("N", 6);
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	static class SecondWorker implements Runnable {
		private final ConcurrentMap<String, Integer> concurrentMap;

		public SecondWorker(ConcurrentMap<String, Integer> queue) {
			this.concurrentMap = queue;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(2000);
				System.out.println(concurrentMap.get("F"));
				Thread.sleep(1000);
				System.out.println(concurrentMap.get("H"));
				Thread.sleep(1000);
				System.out.println(concurrentMap.get("B"));
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	static class MyTestConcurrentMap1 {
		public static void main(String[] args) {
			ConcurrentMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
			new Thread(new FirstWorker(concurrentMap)).start();
			new Thread(new SecondWorker(concurrentMap)).start();
		}
	}
	
}
