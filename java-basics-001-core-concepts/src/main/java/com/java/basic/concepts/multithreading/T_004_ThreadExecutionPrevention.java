package com.java.basic.concepts.multithreading;

/**
 *	Three ways :
 *	1.	yield() :	yield() causes to pause the current executing thread to give the chance for waiting threads
 *		=======		of same priority.If there is no waiting thread or all waiting threads have low priority
 *		then same thread can continue its execution.
 *		->	If multiple threads are waiting with same priority then which waiting thread will get chance, we
 *			can't expect. It depends on Thread Scheduler.
 *		->  Method Signature :
 *			----------------
 *			1.	public static native void yield();
 *		->	Some platforms won't provide proper support for yield() method(OS level or processor level).
 *
 * 	2.	join() :	If any thread wants to wait until completing some other thread then we should use join().
 * 		======
 * 		->	Method Signature :
 * 			-----------------
 * 			1.	public final void join() throws IntruptedException
 * 			2.	public final void join(long milliSeconds) throws IntruptedException
 * 			3.	public final void join(long milliSeconds, int nanoSeconds) throws InterruptedException
 * 		->	After join() method, it will enter into waiting state and to come to runnable state, below are options:
 * 			a.	If T2 completes
 * 			b.	If time expires
 * 			c.	If waiting thread got interrupted.
 *
 * 3.	sleep() :	If temporarily pausing of the thread is required, we should use sleep(). If a thread don't
 * 		=======		want to perform any operation then sleep() is preferable.
 * 		->	Method Signature :
 * 			----------------
 * 			1.	public static native void sleep(long milliSeconds) throws InterruptedException
 * 			2.	public static void sleep(long milliSeconds, int nanoSeconds) throws InterruptedException
 * 		->	Every sleep() method throws IE, which is checked exception. Hence whenever we are using sleep()
 * 			method, compulsory, we should handle IE either by try/catch or throws keyword otherwise CE.
 * 		->	After sleep() method, it will enter into sleeping state and to come to runnable state, below are options:
 * 			a.	If time expires
 * 			b.	If sleeping thread got interrupted.
 *
 * 	->	To interrupt sleeping or waiting thread, below method can be used :
 * 		1.	public void interrupt()
 * 
 * 	Why Thread sleep() and yield() methods are static?
 * 	=================================================
 * 	->	Thread sleep() and yield() methods work on the currently executing thread. So there is no point in invoking 
 * 		these methods on some other threads that are in wait state. That’s why these methods are made static so that 
 * 		when this method is called statically, it works on the current executing thread and avoid confusion to the 
 * 		programmers who might think that they can invoke these methods on some non-running threads.
 */
public class T_004_ThreadExecutionPrevention {
	
	/*
	 *  join() - Case I - Main thread will wait until child completes.
	 */
	static class MyThread1 extends Thread {
		@Override
		public void run() {
			try {
				sleep(5000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Child Thread is running ...");
		}
	}
	
	static class MyTestThread1 {
		public static void main(String[] args) throws InterruptedException {
			MyThread1 thread = new MyThread1();
			thread.start();
			thread.join();
			System.out.println("Main thread is running ...");
		}
	}
	
	/*
	 *  join() - Case II - Child thread will wait until main completes.
	 */
	static class MyThread2 extends Thread {
		static Thread mt;

		@Override
		public void run() {
			try {
				mt.join();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Child Thread is running ...");
		}
	}
	
	static class MyTestThread2 {
		public static void main(String[] args) throws InterruptedException {
			MyThread2.mt = Thread.currentThread();
			MyThread2 thread = new MyThread2();
			thread.start();
			System.out.println("Main thread is running ...");
		}
	}

	/*
	 *  join() - Case III - Deadlock -  Child thread will wait until main completes and main waits for child.
	 */
	static class MyThread3 extends Thread {
		static Thread mt;

		@Override
		public void run() {
			try {
				mt.join();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Child Thread is running ...");
		}
	}
	
	static class MyTestThread3 {
		public static void main(String[] args) throws InterruptedException {
			MyThread3.mt = Thread.currentThread();
			MyThread3 thread = new MyThread3();
			thread.start();
			thread.join();
			System.out.println("Main thread is running ...");
		}
	}
	
	/*
	 *  join() - Case IV - Deadlock -  Main thread wants to wait until main completes.
	 */

	static class MyTestThread4 {
		public static void main(String[] args) throws InterruptedException {
			Thread.currentThread().join();
			System.out.println("Main thread is running ...");
		}
	}
}
