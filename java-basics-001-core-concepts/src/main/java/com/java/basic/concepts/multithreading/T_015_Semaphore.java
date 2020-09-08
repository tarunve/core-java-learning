package com.java.basic.concepts.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 	Semaphores:
 * 	==========
 * 	->	Invented by Dijkstra in 1962.
 * 	->	Semaphores are variables or ADT that are used for controlling access to a common resource.
 * 	->	Semaphores - is a record of how many units of a particular resource are available...wait
 * 		until a unit of the resource becomes available.
 * 	->	Counting semaphore - allows an arbitrary resource units.
 * 	-> 	Binary Semaphore - semaphores which are restricted to the values 0 and 1.
 * 	-> 	It tracks only how many resources are free, it doesn't keep track of which resources are free.
 * 	->	The Semaphore count may serve as a useful trigger  for a number of  different actions
 * 	->	Producer-Consumer problem can be implemented by using Semaphores.
 * 	-> 	It maintains a set of permits.
 * 		1.	acquire() -> if a permit is available then takes it
 * 		2.	release() -> adds a permit
 * 	->	Semaphore just keeps a count of the number of resource available.
 *
 * 	Constructor
 * 	-----------
 * 		Semaphore semaphore = new Semaphore(int permits, boolean fair)
 *
 * 	Mutex:
 * 	=====
 * 	->	A mutex is essentially the same thing as a binary semaphore.
 * 	->	While a binary semaphore may be used a mutex, a mutex is more specific use case.
 * 	->	Mutexes have a concept of an owner. Only the process that locked the mutex is supposed to unlock it.
 * 	-> 	Mutexes may provide priority inversion safety. If the mutex knows its current owner, it is possible to
 * 		promote the priority of the owner whenever a high priority task starts waiting on the mutex.
 * 	->	mutex can provide deletion safety.
 *
 */
public class T_015_Semaphore {
	
	enum Downloader {
		INSTANCE;

		private final Semaphore semaphore = new Semaphore(6, true);
		
		public void downloadData() {
			try {
				semaphore.acquire();
				download();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				semaphore.release();
			}
		}
		
		private void download() {
			System.out.println("Downloading data from the web..." + Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class MyTestThread1 {
		public static void main(String[] args) {
			ExecutorService service = Executors.newCachedThreadPool();
			for (int i = 0; i < 12; i++) {
				service.execute(new Runnable() {
					@Override
					public void run() {
						Downloader.INSTANCE.downloadData();
					}
				});
			}
			service.shutdown();
		}
	}
}
