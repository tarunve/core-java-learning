package com.java.basic.concepts.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 	->	It implements the BlockingQueue interface.
 * 	->	It is an unbounded concurrent queue.
 * 	->	It uses the same ordering rules as the java.util.PriorityQueue class - have to implement
 * 		Comparable interface which will decide the order in the queue.
 * 	->	The priority can be the same " compare() == 0" case.
 * 	->	No null items as it has to be compared for ordering.
 */
public class T_020_PriorityBlockingQueue {

	static class FirstWorker implements Runnable {
		private final BlockingQueue<Person> blockingQueue;

		public FirstWorker(BlockingQueue<Person> queue) {
			this.blockingQueue = queue;
		}

		@Override
		public void run() {
			try {
				blockingQueue.put(new Person(30, "Tarun"));
				blockingQueue.put(new Person(23, "Deepak"));
				blockingQueue.put(new Person(43, "Aakash"));
				Thread.sleep(1000);
				blockingQueue.put(new Person(27, "Ridhi"));
				blockingQueue.put(new Person(18, "Ruchika"));
				Thread.sleep(1000);
				blockingQueue.put(new Person(26, "Achint"));
				Thread.sleep(1000);
				blockingQueue.put(new Person(27, "Achint"));
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	static class SecondWorker implements Runnable {
		private final BlockingQueue<Person> blockingQueue;

		public SecondWorker(BlockingQueue<Person> queue) {
			this.blockingQueue = queue;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				System.out.println(blockingQueue.take());
				Thread.sleep(1000);
				System.out.println(blockingQueue.take());
				Thread.sleep(1000);
				System.out.println(blockingQueue.take());
				Thread.sleep(1000);
				System.out.println(blockingQueue.take());
				Thread.sleep(1000);
				System.out.println(blockingQueue.take());
				Thread.sleep(1000);
				System.out.println(blockingQueue.take());
				System.out.println(blockingQueue.take());
				System.out.println(blockingQueue.take());
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	static class Person implements Comparable<Person> {
		
		private String name;
		private int age;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			//return name.compareTo(o.getName());
			return Integer.compare(age, o.getAge());
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
		@Override
		public String toString() {
			return this.name + "--" + this.age;
		}

	}

	static class MyTestThread {
		public static void main(String[] args) {
			BlockingQueue<Person> blockingQueue = new PriorityBlockingQueue<>();
			new Thread(new FirstWorker(blockingQueue)).start();
			new Thread(new SecondWorker(blockingQueue)).start();
		}
	}
	
}
