package com.java.basic.concepts.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 	Latch - multiple threads can wait for each other.
 *
 *  CyclicBarrier : It is used in situations where you want to create a group of tasks to perform
 *  =============	work in parallel + wait until they are all finished before moving to next step.
 *  		->	Something like join
 *  		->	Something like CountDownLatch
 *
 *   CountDownLatch - one shot event
 *   CyclicBarrier - it can be reused over and over again + cyclic barrier has a barrier action : a
 *   				runnable, that will run automatically when count reaches to 0 !!!
 *
 *   new CyclicBarrier(N) -> N threads will wait for each other.
 *
 *    	WE CAN NOT REUSE LATCHES BUT WE CAN REUSE CyclicBarrier --> reset() !!!
 *
 */
public class T_017_CyclicBarrier {

	static class Worker implements Runnable {
		protected int id;
		protected CyclicBarrier cyclicBarrier;
		
		public Worker(int id, CyclicBarrier cyclicBarrier) {
			this.id = id;
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			System.out.println("Thread with id " + this.id + " starts working ...");
			while(true) {
				try {
					cyclicBarrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
			// Send signal to all the barrier threads at once.
		}
	}
	
	static class MyTestThread1 {
		public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
			ExecutorService executorService = Executors.newFixedThreadPool(4);
			CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
			for (int i = 0; i < 10; i++) {
				executorService.submit(new Worker(i + 1, cyclicBarrier));
			}
			System.out.println("All the pre-requisites are done...");
			executorService.shutdown();
		}
	}


}
