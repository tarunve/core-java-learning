package com.java.basic.concepts.multithreading;

/**
 * 	Two Approaches:
 * 	==============
 * 	1.	By extending Thread class:
 * 		=========================
 * 		->	start() method is used to start a new child thread which will run simultaneously to main thread.
 * 		->	Internally, start() method calls native start() method which internally calls run() method and
 * 			the job is done by child thread created.
 * 		Case Study:
 * 		==========
 * 		1.	Why run() method of Thread can't be run instead of start() method:
 * 			-----------------------------------------------------------------
 * 			->	Because start() is responsible for creating the Thread, registering it to Thread Scheduler and
 * 				many more activities before calling the run() method.
 * 			->	Program will treat it as a normal method call but no new child thread will be created.
 * 		2.	If run() method is overloaded in our Thread class:
 * 			-------------------------------------------------
 * 			->	start() method of Thread will only call the run() method with no arguments.
 * 			-> 	Similarly JVM searches  main method with String array argument.
 * 		3.	If run() method is not overridden in our Thread class:
 * 			-----------------------------------------------------
 * 			->	If we are not overriding run() method, Thread class run() method will be called which is empty
 * 				method. No point to use multi-threading concept.
 * 		4.	if start() method is overridden in our Thread(without super)
 * 			-----------------------------------------------------------
 * 			->	nothing happens then as it will be an empty call.
 *
 * 	2.	By implementing Runnable interface:
 * 		----------------------------------
 * 		->	We need to create Thread object first to call start() method.
 *
 * 	Thread Scheduler:
 * 	================
 * 	Used to allocate the processor to a thread. It depends on JVM, OS, hardware etc. that which algorithm
 * 	will be used by it. That's why, the output in multi-threaded program is not always same.
 *
 * 	Thread class constructors:
 * 	=========================
 * 	1.	Thread t = new Thread();
 * 	2.	Thread t = new Thread(Runnable r);
 * 	3.	Thread t = new Thread(String name);
 * 	4.	Thread t = new Thread(Runnable r, String name);
 * 	5.	Thread t = new Thread(ThreadGroup g, String name);
 * 	6.	Thread t = new Thread(ThreadGroup g, Runnable r);
 * 	7.	Thread t = new Thread(ThreadGroup g, Runnable r, String name);
 * 	8.	Thread t = new Thread(ThreadGroup g, Runnable r, String name, long stackSize);
 */
public class T_002_ThreadCreation {
	/*
	 * 	Approach 1 : By extending the Thread class.
	 */
	static class ThreadCreationClass1 extends Thread {
		@Override
		public void run() {
			System.out.println("Thread from class ThreadCreationClass1");
		}
		public static void main(String[] args) {
			ThreadCreationClass1 thread = new ThreadCreationClass1();
			thread.start();
		}
	}
	
	/*
	 * 	Approach 2 : By implementing the Runnable interface.
	 */
	static class ThreadCreationClass2 implements Runnable {
		@Override
		public void run() {
			System.out.println("Thread from class ThreadCreationClass2");
		}
		public static void main(String[] args) {
			Thread thread = new Thread(new ThreadCreationClass2());
			thread.start();
		}
	}
}
