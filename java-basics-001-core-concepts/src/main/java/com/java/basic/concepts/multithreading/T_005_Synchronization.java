package com.java.basic.concepts.multithreading;

/**
 * 	Synchronized : This keyword is only applicable for methods and blocks but not for class and variables.
 * 	============
 * 	->	If multiple threads trying to operate on same java object then there maybe data inconsistency problem.
 * 		To overcome this problem, we should use synchronized.
 * 	->	If a method or block is declared as synchronized then only one thread is allowed to execute at a time.
 * 	->	Main advantage - resolve data inconsistency problem. Disadvantage - performance as waiting time increases.
 * 	->	Updating the non-synchronized area in program is worst kind of code practice.
 * 	->	Read operations can be performed in non-sync area.
 *
 * 	Internal working of synchronized:
 * 	--------------------------------
 * 	->	Internally, it acquires a lock on object and second thread will have to wait till first thread releases the lock.
 * 	->	The lock concept comes into the picture when synchronized keyword is used.
 * 	->	Acquiring and releasing the lock is internally taken care by JVM. Programmer is not responsible for it.
 *
 * 	Class level Lock:
 * 	----------------
 * 	->	If multiple threads operate on multiple object of same class, static synchronization will produce
 * 		regular output because static keyword makes the method to be executed on class level not object.
 * 	->	If thread wants to execute static synchronized method, then thread require class level lock.
 * 		Once thread gets lock, it can execute any static synchronized method. Once method execution is done
 *		it automatically releases lock.
 *
 *	synchronized block :
 *	==================
 *	->	when very few lines of code needs to be synchronized, then whole method need not to be made
 *		synchronized. Those few lines can be declared in synchronized block.
 *	->	Advantage is to reduce the waiting time of thread and increases performance.
 *	ways to declare synchronized block:
 *	----------------------------------
 *	1.	To get lock on current object : synchronized(this) {}
 *	2.	To get lock on particular obj : synchronized(object) {}
 *	3.	To get class level lock       : synchronized(MyClass class){}
 *
 *	-> 	Locks are for Object type or class type but not primitive type. Hence we can't pass
 *		primitive types to synchronized blocks otherwise CE.
 *
 */
@SuppressWarnings("static-access")
public class T_005_Synchronization {

	/*
	 * Case 1 - Synchronization is required if multiple threads operate on a single object.
	 * ->	It will produce irregular output if method is not synchronized
	 * ->	static synchronization helps for regular output.
	 */
	static class MyThread1 extends Thread {
		private static int counter = 0;

		public static synchronized void increment() {
			++counter;
		}

		public static void process() {
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 100; i++)
						increment();
				}
			});

			Thread t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 100; i++)
						increment();
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
		
		public static void main(String[] args) {
			process();
			System.out.println(counter);
		}
	}

	/*
	 *	Static synchronization - class level lock
	 */
	static class MyThread2 extends Thread {
		static synchronized void method1() {
			System.out.println("static synchronized void method1" + Thread.currentThread().getName());
		}
		static synchronized void method2() {
			System.out.println("static synchronized void method2" + Thread.currentThread().getName());
		}
		static void method3() {
			System.out.println("static void method3" + Thread.currentThread().getName());
		}
		synchronized void method4() {
			System.out.println("synchronized void method4" + Thread.currentThread().getName());
		}
		void method5() {
			System.out.println("void method5" + Thread.currentThread().getName());
		}
	}
	
	static class MyTestThread2 {
		public static void main(String[] args) {
			MyThread2 t1 = new MyThread2();
			t1.start();
			MyThread2 t2 = new MyThread2();
			t2.start();
			MyThread2 t3 = new MyThread2();
			t3.start();
			MyThread2 t4 = new MyThread2();
			t4.start();
			MyThread2 t5 = new MyThread2();
			t5.start();
			MyThread2 t6 = new MyThread2();
			t6.start();
			t1.method1();
			t2.method1();
			t3.method2();
			t4.method3();
			t5.method4();
			t6.method5();
		}
	}
	
	/*
	 * synchronized block
	 */
	static class MyTestThread3 {
		private static int count1 = 0;
		private static int count2 = 0;
		
		private static Object lock1 = new Object();
		private static Object lock2 = new Object();
		
		private static void compute() {
			for (int i = 0; i < 100; i++) {
				add();
				addAgain();
			}
			
		}
		
		private static void addAgain() {
			synchronized (lock1) {
				count1++;
			}
		}

		private static void add() {
			synchronized (lock2) {
				count2++;
			}
		}

		public static void main(String[] args) {
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					compute();
				}
			});
			
			Thread t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					compute();
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
			System.out.println("Count1=" + count1 + ", Count2=" + count2);
		}
	}

	/*
	 * Can a thread acquire multiple locks simultaneously? Yes
	 */
	static class MyTestThread4 {
		public synchronized void method1() {
			//lock of MyTestThread3
			Y y = new Y();
			synchronized (y) {
				//lock of MyTestThread3, Y
				Z z = new Z();
				synchronized (z) {
					//lock of MyTestThread3, Y, Z
				}
			}

		}

		static class Y {}
		
		static class Z {}
	}

}
