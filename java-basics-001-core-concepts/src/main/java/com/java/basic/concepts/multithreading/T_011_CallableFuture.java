package com.java.basic.concepts.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *	->	In case of Runnable, Thread won't return anything after completing the job. If a
 *		thread has to required to return some result execution then we should use Callable.
 *	->	If we submit a callable object to executor , then after completing the job,
 *		thread returns an object of type Future i.e. Future object can be used to retrieve
 *		the result from callable job.
 *	-> It contains only one method :
 *		1.	public Object call() throws Exception
 */
public class T_011_CallableFuture {

	static class ThreadPoolJob1 implements Callable<Object> {
		int num;

		public ThreadPoolJob1(int num) {
			this.num = num;
		}
		
		@Override
		public Object call() throws Exception {
			System.out.println(Thread.currentThread().getName() + " is resposible to find sum of " + num + " numbers.");
			int sum = 0;
			for (int i = 0; i < num; i++) {
				sum = sum + i;
			}
			return sum;
		}
	}
	
	static class MyTestThread1 {
		public static void main(String[] args) throws InterruptedException, ExecutionException {
			ThreadPoolJob1[] jobs = { new ThreadPoolJob1(10), new ThreadPoolJob1(20), new ThreadPoolJob1(30), new ThreadPoolJob1(40), new ThreadPoolJob1(50) };
			ExecutorService service = Executors.newFixedThreadPool(3);
			for (ThreadPoolJob1 job : jobs) {
				Future<Object> future = service.submit(job);
				System.out.println(future.get());
			}
			service.shutdown();
		}
	}
}
