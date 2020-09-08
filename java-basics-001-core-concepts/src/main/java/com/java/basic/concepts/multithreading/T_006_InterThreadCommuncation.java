package com.java.basic.concepts.multithreading;

import java.util.ArrayList;
import java.util.List;

/**
 * Two threads communicate using below methods :
 * 	1.	wait() :	The method which is expecting updation is responsible to call wait() method.
 * 		=====		Then immediately, thread will enter into waiting state.
 * 		Method Signature:
 * 		----------------
 * 		1.	public final void wait() throws InterruptedException
 *		2.	public final native void wait(long ms) throws InterruptedException
 * 		3.	public final void wait(long ms, int ns) throws InterruptedException
 *
 * 	2.	notify() :	The thread which is responsible to perform updation, after performing updation,
 * 		=======		it is responsible to call notify() method. Then waiting thread will get notification
 * 		and continue its execution with those updated items.
 * 		Method Signature:
 * 		----------------
 * 		1.	public final native void notify()
 *
 * 	3.	notifyAll() :	This method is used to notify all the waiting threads.
 * 		===========
 * 		Method signature:
 * 		---------------
 * 		1.	public final native void notifyAll()
 *
 * 	->	wait(), notify(), notifyAll() are present in Object class but not in Thread class because
 * 		thread can call these methods on any object. So, it should be in Object class.
 * 	->	wait(), notify(), notifyAll() should be called from synchronized area only otherwise
 * 		RE is thrown - IllegalMonitorStateException.
 * 	->	To call these methods on any object, thread should be the owner of that object i.e. thread
 * 		should have lock on that object i.e. thread should in synchronized area.
 * 	->	Except these methods, there is no other method where thread releases the lock.
 * 
 * 	Why thread communication methods wait(), notify() and notifyAll() are in Object class?
 * 	=====================================================================================
 * 	->	In Java every Object has a monitor and wait, notify methods are used to wait for the Object 
 * 		monitor or to notify other threads that Object monitor is free now. There is no monitor on 
 * 		threads in java and synchronization can be used with any Object, that’s why it’s part of Object 
 * 		class so that every class in java has these essential methods for inter-thread communication.
 * 	
 * 	Why wait(), notify() and notifyAll() methods have to be called from synchronized method or block?
 * 	================================================================================================
 * 	->	When a Thread calls wait() on any Object, it must have the monitor on the Object that it will 
 * 		leave and goes in wait state until any other thread call notify() on this Object. Similarly when 
 * 		a thread calls notify() on any Object, it leaves the monitor on the Object and other waiting 
 * 		threads can get the monitor on the Object. Since all these methods require Thread to have the 
 * 		Object monitor, that can be achieved only by synchronization, they need to be called from 
 * 		synchronized method or block.
 */
public class T_006_InterThreadCommuncation {
	
	static class MyThread1 extends Thread {
		int total = 0;
		
		@Override
		public void run() {
			synchronized (this) {
				System.out.println("Child thread starts calculation...");
				for (int i = 1; i <= 100; i++) {
					total = total + i;
				}
				System.out.println("Child thread trying to give notification...");
				this.notify();
			}
		}
	}
	
	static class MyTestThread1 {
		public static void main(String[] args) throws InterruptedException {
			MyThread1 thread = new MyThread1();
			thread.start();
			synchronized (thread) {
				System.out.println("Main thread will call wait()");
				thread.wait();
				System.out.println("Main thread got notification");
				System.out.println(thread.total);
			}
		}
	}
	
	/*
	 * Producer-Consumer
	 */
	static class Processor {

		/*public void produce() throws InterruptedException {
			synchronized (this) {
				System.out.println("We are in the producer method");
				wait();
				System.out.println("Again producer method");
			}
		}

		public void consume() throws InterruptedException {
			Thread.sleep(1000);
			synchronized (this) {
				System.out.println("We are in consumer method");
				notify();
				notifyAll();
				Thread.sleep(3000);
			}
		}*/

		private final List<Integer> list = new ArrayList<>();
		private final int LIMIT = 5;
		private final int BOTTOM = 0;
		private final Object lock = new Object();
		private int value = 0;

		public void produce() throws InterruptedException {
			synchronized (lock) {
				while (true) {
					if (list.size() == LIMIT) {
						System.out.println("Waiting for removing  items from list...");
						lock.wait();
					}
					else {
						System.out.println("Adding : " + value);
						list.add(value);
						value++;
						lock.notify();
					}
					Thread.sleep(500);
				}
			}
		}
		
		public void consume() throws InterruptedException {
			synchronized (lock) {
				while (true) {
					if (list.size() == BOTTOM) {
						System.out.println("Waiting for adding items from list...");
						lock.wait();
					}
					else {
						System.out.println("Removed : " + list.remove(--value));
						lock.notify();
					}
					Thread.sleep(500);
				}
			}
		}
	}

	static class MyTestThread2 {
		public static void main(String[] args) {
			final Processor processor = new Processor();
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						processor.produce();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			
			Thread t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						processor.consume();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			
			t1.start();
			t2.start();
			try {
				t1.join();
				t2.join();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
