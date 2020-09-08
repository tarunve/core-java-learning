package com.java.basic.concepts.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 	Thread Pool or Executer Framework
 * 	=================================
 * 	->	creating a new thread for every job create performance and memory problems. To overcome this,
 * 		we should use ThreadPool.
 * 	->	It is a pool of already created threads ready to do our job.
 * 	->	Introduced in 1.5 version (ThreadPool)
 * 	->	Also known as executer framework.
 * 	-> 	Default ThreadPool size is 60 for most of the servers.
 *
 * 	To create ThreadPool
 * 	-------------------
 * 	1.	ExecutorService service = Executors.newFixedThreadPool(3);
 * 		->	Creates a thread pool that reuses a fixed number of threads operating off a shared 
 * 			unbounded queue.  At any point, at most {@code nThreads} threads will be active 
 * 			processing tasks.
 * 		->	If additional tasks are submitted when all threads are active, they will wait in the 
 * 			queue until a thread is available.
 * 		->	If any thread terminates due to a failure during execution prior to shutdown, a new 
 * 			one will take its place if needed to execute subsequent tasks.  
 * 		->	The threads in the pool will exist until it is explicitly {@link ExecutorService#shutdown shutdown}.
 * 	2.	ExecutorService service = Executors.newCachedThreadPool();
 * 		->	Creates a thread pool that creates new threads as needed, but will reuse previously 
 * 			constructed threads when they are available.  
 * 		->	These pools will typically improve the performance of programs that execute many 
 * 			short-lived asynchronous tasks.
 * 		->	Calls to {@code execute} will reuse previously constructed threads if available. If no 
 * 			existing thread is available, a new thread will be created and added to the pool. 
 * 		->	Threads that have not been used for sixty seconds are terminated and removed from the cache. 
 * 			Thus, a pool that remains idle for long enough will not consume any resources. Note that 
 * 			pools with similar properties but different details (for example, timeout parameters) may 
 * 			be created using {@link ThreadPoolExecutor} constructors.
 * 	3.	ExecutorService service = Executors.newSingleThreadExecutor();
 * 		->	Creates an Executor that uses a single worker thread operating off an unbounded queue. 
 * 			(Note however that if this single thread terminates due to a failure during execution 
 * 			prior to shutdown, a new one will take its place if needed to execute subsequent tasks.)  
 * 		->	Tasks are guaranteed to execute sequentially, and no more than one task will be active at 
 * 			any given time. Unlike the otherwise equivalent {@code newFixedThreadPool(1)} the returned 
 * 			executor is guaranteed not to be reconfigurable to use additional threads.
 * 	4.	ExecutorService service = Executors.newWorkStealingPool();
 * 		->	Creates a work-stealing thread pool using all {@link Runtime#availableProcessors available processors}
 * 			as its target parallelism level.
 * 		->	Since 1.8 version.
 * 	5.	ExecutorService service = Executors.newScheduledThreadPool(int corePoolSize);
 * 		->	Creates a thread pool that can schedule commands to run after a given delay, or to execute periodically.
 *
 * 	To submit the job:	service.submit(job);
 * 	----------------
 * 	To shutdown the service:	service.shutdown()
 * 	-----------------------
 *
 */
public class T_010_ThreadPool {
	
	static class ThreadPoolJob1 implements Runnable {
		public ThreadPoolJob1(String name) {
			
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	static class MyTestThread1 {
		public static void main(String[] args) {
			ThreadPoolJob1[] jobs = { new ThreadPoolJob1("One"), new ThreadPoolJob1("Two"), new ThreadPoolJob1("Three"), new ThreadPoolJob1("Four"), new ThreadPoolJob1("FIve") };
			ExecutorService service = Executors.newFixedThreadPool(3);
			for (ThreadPoolJob1 job : jobs) {
				service.submit(job);
			}
			service.shutdown();
		}
	}

	/*
	 * Executor Service
	 */
	static class ThreadPoolJob2 implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.println(i);
				try {
					Thread.sleep(300);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class MyTestThread2 {
		public static void main(String[] args) {
			ExecutorService service = Executors.newFixedThreadPool(5);
			//ExecutorService service = Executors.newCachedThreadPool();
			//ExecutorService service = Executors.newSingleThreadExecutor();
			for (int i = 0; i < 5; i++) {
				service.submit(new ThreadPoolJob2());
			}
			service.shutdown();
		}
	}
}
