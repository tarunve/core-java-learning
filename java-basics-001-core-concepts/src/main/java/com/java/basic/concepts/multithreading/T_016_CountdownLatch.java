package com.java.basic.concepts.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 	->	This is used to synchronize one or more tasks by forcing them to wait for the
 * 		completion of a set of operations being performed by other tasks.
 * 		->	You give an initial count to a CountDownLatch object, and any task that calls await()
 * 			on that object will block until the count reaches zero.
 * 		->	other task may call countDown() on the object to reduce the count, presumably when a
 * 			task finishes its job.
 * 		-> 	a CountDownLatch - the count cannot be reset !!!
 * 				If you need a version that resets the count, you can use a CyclicBarrier instead.
 * 		->	the tasks that call countDown() are not blocked when they make the call. Only the call to
 * 			await() is blocked until the count reaches to zero.
 */
public class T_016_CountdownLatch {

	static class Worker implements Runnable {
		protected int id;
		protected CountDownLatch countDownLatch;
		
		public Worker(int id, CountDownLatch countDownLatch) {
			this.id = id;
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {
			doWork();
			countDownLatch.countDown();
		}
		
		private void doWork() {
			System.out.println("Thread with id " + this.id + " starts working ..."+countDownLatch.getCount());
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread with id " + this.id + " finished");
		}
	}
	
	static class MyTestThread1 {
		public static void main(String[] args) throws InterruptedException {
			ExecutorService executorService = Executors.newSingleThreadExecutor();
			CountDownLatch countDownLatch = new CountDownLatch(5);
			for (int i = 0; i < 10; i++) {
				executorService.submit(new Worker(i + 1, countDownLatch));
			}
			countDownLatch.await();
			System.out.println("All the pre-requisites are done...");
			executorService.shutdown();
		}
	}

}
