package com.java.basic.concepts.multithreading;

/**
 * 	ThreadGroup:
 * 	===========
 * 	->	Group of threads or sub thread-group.
 * 	-> 	Main advantage is - we can perform common operation easily.
 * 	->	Every thread in Java belongs to some group. Main thread belongs to "Main" group.
 * 	->	Every ThreadGroup in java is child group of "System" group either directly or indirectly.
 * 		Hence System acts as root for all. "System" group contains several system level threads
 * 		like finalize(GC), reference handler, signal dispatcher, attach listener etc.
 * 	->	ThreadGroup class is present in java.lang package and it is direct child of Object class.
 *
 * 	Constructors:
 * 	------------
 * 	1.	ThreadGroup g = new ThreadGroup(String groupName)
 * 		->	Parent of this ThreadGroup is the thread group of currently executing thread.
 * 	2.	ThreadGroup g = new ThreadGroup(ThreadGroup parentGroup, String name)
 * 		->	Parent of this ThreadGroup is specified parentGroup.
 *
 * 	Important Methods:
 * 	-----------------
 * 	1.	int getMaxPriority()
 * 		-> return max priority of ThreadGroup.
 * 	2.	String getName()
 * 		->	return name of the group.
 * 	3.	void setMaxPriority(int prority)
 * 		->	to set max priority of ThreadGroup. Default is 10.
 * 	4.	ThreadGroup getParent()
 * 		->	return the parent group of current thread
 * 	5.	void list()
 * 		->	prints information about thread group to console.
 * 	6.	int activeCount()
 * 		->	return no. of active threads in ThreadGroup.
 * 	7.	int activeGroupCount()
 * 		->	return no. of active groups in ThreadGroup.
 * 	8.	int enumerate(Thread[] t)
 * 		->	copy all the active threads to this ThreadGroup into provided thread array. In this
 * 			case, sub group threads will not be considered.
 * 	9.	int enumerate(ThreadGroup[] g)
 * 		->	to copy all the sub thread group into thread group array.
 * 	10.	boolean isDaemon()
 * 		->	 to check where thread group is daemon or not.
 * 	11.	void setDaemon(boolean b)
 * 		->	to change the nature of daemon.
 * 	12.	void interrupt()
 * 		-> to interrupt all the waiting or sleeping threads present in thread group.
 * 	13.	void destroy()
 * 		->	to destroy thread group and its sub thread groups.
 * 
 * 	What is Thread Group? Why it’s advised not to use it?
 * 	=====================================================
 * 	->	ThreadGroup is a class which was intended to provide information about a thread group. ThreadGroup 
 * 		API is weak and it doesn’t have any functionality that is not provided by Thread. It has two main 
 * 		features – to get the list of active threads in a thread group and to set the uncaught exception 
 * 		handler for the thread. 
 * 	->	But Java 1.5 has added setUncaughtExceptionHandler(UncaughtExceptionHandler eh) method using which 
 * 		we can add uncaught exception handler to the thread. So ThreadGroup is obsolete and hence not advised 
 * 		to use anymore.
 */
public class T_008_ThreadGroup {

	/*
	 * ThreadGroup
	 */
	static class MyThread1 extends Thread {
		MyThread1(ThreadGroup g, String name) {
			super(g, name);
		}
		@Override
		public void run() {
			System.out.println("Child ...");
			try {
				Thread.sleep(5000);
			}
			catch (InterruptedException e) {}
		}
	}

	static class MyTestThread1 {
		public static void main(String[] args) throws InterruptedException {
			ThreadGroup g1 = new ThreadGroup("ParentGroup");
			ThreadGroup g2 = new ThreadGroup(g1, "ChildGroup");
			MyThread1 t1 = new MyThread1(g1, "ChildThread1");
			MyThread1 t2 = new MyThread1(g1, "ChildThread2");
			MyThread1 t3 = new MyThread1(g2, "ChildThread1");
			MyThread1 t4 = new MyThread1(g2, "ChildThread2");
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			System.out.println("Active Thread count g1 :: " + g1.activeCount());
			System.out.println("Active Thread Group count g1 :: " + g1.activeGroupCount());
			g1.list();
			Thread.sleep(2000);
			System.out.println("Active Thread count g2 :: " + g2.activeCount());
			System.out.println("Active Thread Group count g2 :: " + g2.activeGroupCount());
			g2.list();
		}
	}
	
	/*
	 * Print all the Thread names present in System ThreadGroup
	 */
	static class MyTestThread2 {
		public static void main(String[] args) {
			ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
			Thread[] t = new Thread[system.activeCount()];
			system.enumerate(t);
			for (Thread t1 : t) {
				System.out.println(t1.getName() + "----" + t1.isDaemon());
			}
		}
	}
}
