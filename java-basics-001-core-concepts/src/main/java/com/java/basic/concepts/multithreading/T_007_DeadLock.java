package com.java.basic.concepts.multithreading;

/**
 * 	Race Condition:	A race condition occurs when two or more threads can access shared data and they 
 * 	==============	try to change it at the same time. Because the thread scheduling algorithm can 
 * 	swap between threads at any time, you don't know the order in which the threads will attempt to 
 * 	access the shared data. Therefore, the result of the change in data is dependent on the thread 
 * 	scheduling algorithm, i.e. both threads are "racing" to access/change the data.
 * 	->	A "race condition" exists when multi threaded (or otherwise parallel) code that would access 
 * 		a shared resource could do so in such a way as to cause unexpected results.
 * 	Deadlock:	If two threads are waiting for each other forever. Such type of infinite waiting is
 * 	========	called deadlock.
 * 	->	synchronized keyword is the only reason for a program to enter into deadlock state. Thats why
 * 		we should use it only in case of specific requirement.
 *
 * 	Starvation:	Long waiting of a thread where waiting ends at a certain point is called starvation.
 * 	----------	Ex.	Threads will lowest priority will get the chance in last to execute.
 *
 * 	Daemon Thread:	The threads which are executing in background are called daemon threads.
 * 	-------------	Ex. Garbage Collector, Signal dispatcher, attach listener etc.
 * 	->	Main objective is to provide support for non-daemon threads(main thread).
 * 		Ex. If main thread runs with low memory then JVM runs GC to destroy useless objects so that
 * 			no. of bytes of free memory will be improved and main thread can run with it.
 * 	->	Usually daemon threads are having low priority but based on requirement, can run on high priority.
 * 	->	We can check daemon nature by using method - public boolean isDaemon()
 * 	->	We can change the daemon nature using method - public void setDaemon(boolean nature).
 * 		But changing the daemon nature is possible before the thread starts otherwise RE is thrown -
 * 		IllegalThreadStartException.
 * 	->	It is impossible to change daemon nature of main thread as JVM has already started it.
 * 	->	When last non-daemon thread terminates, automatically, all daemon threads will be terminated.
 *
 *  Java multi-threading concept is implemented using 2 models:
 *  1.	Green Thread Model:	The thread which is managed completely by JVM without taking underlying
 *  	------------------	OS support is called green model.
 *  	->	Very few OS like Sun Solaris provide support for Green Thread Model.
 *  	->	Green Thread Model is deprecated and not recommended to use.
 *  2.	Native OS Model:	The thread which is managed by JVM with the help of underlying OS is
 *  	---------------		called native OS model.
 *  	->	All windows based OS provide support for native OS model.
 *
 *  To stop Thread :
 *  --------------
 *  ->	We can stop the thread by using method :
 *  	1.	public void stop()
 *  ->	Immediately, thread will enter into dead state. It is deprecated and not recommended to use.
 *
 *  To suspend Thread:
 *  -----------------
 *  ->	We can suspend the thread by using method :
 *  	1.	public void suspend()
 *  ->	Immediately, thread will enter into suspend state.It is deprecated and not recommended to use.
 *
 *  To resume Thread:
 *  -----------------
 *  ->	We can resume the thread by using method :
 *  	1.	public void resume()
 *  ->	Immediately, thread will resume from suspend state.It is deprecated and not recommended to use.
 *
 */
public class T_007_DeadLock {

	/*
	 * Deadlock
	 */
	static class MyThread1 extends Thread {
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

	static class MyTestThread1 {
		public static void main(String[] args) throws InterruptedException {
			MyThread1.mt = Thread.currentThread();
			MyThread1 thread = new MyThread1();
			thread.start();
			thread.join();
			System.out.println("Main thread is running ...");
		}
	}

	/*
	 * Daemon Thread
	 * ->	Daemon thread will get terminate as soon as main thread completes.
	 */
	static class MyThread2 extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				System.out.println("Child..."+i);
				try {
					Thread.sleep((long)0.09);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class MyTestThread2 {
		public static void main(String[] args) throws InterruptedException {
			MyThread2 thread = new MyThread2();
			thread.setDaemon(true);
			thread.start();
			//thread.join();
			System.out.println("Main...");
		}
	}
}
