package com.java.interview.questions;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 	->	2 ways
 * 		1.	Configure default common pool
 * 			->	It is documented that parallel() method utilizes the common pool available per class loader
 * 				per JVM, and we have a mechanism to control the configuration of that default common pool
 * 				using below property:
 * 					 java.util.concurrent.ForkJoinPool.common.parallelism - level, a non-negative interger.
 * 		2.	Run the parallel() operation inside a custom ForkJoinPool.
 */
public class Q_009_CustomThreadPoolForStreamParallelism {
	
	/*
	 * 	parallel() method usage
	 */
	public static class CustomSizedThereadPool {
		
		public static void main(String[] args) {
			long start = System.currentTimeMillis();
			IntStream intStream = IntStream.range(0, 20);
			System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5");
			intStream.parallel().forEach(i -> {
				try {
					Thread.sleep(1000);
					System.out.println("Thread Name :: " + Thread.currentThread().getName());
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				long end = System.currentTimeMillis();
				System.out.println(end - start + " MilliSeconds");
				System.out.println("--------------------------");
			});
		}
	}
	
	public static class CustomSizedThereadPool2 {
		
		public static void main(String[] args) throws InterruptedException, ExecutionException {
			ForkJoinPool forkJoinPool = new ForkJoinPool(5);
			List<Integer> list = forkJoinPool.submit(() -> IntStream.range(1, 1_000_00).parallel().filter(CustomSizedThereadPool2::isPrime).boxed().collect(Collectors.toList())).get();
			list.forEach(i -> System.out.println(i));
			forkJoinPool.shutdown();
		}

		public static boolean isPrime(long number) {
			return number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(divisor -> number % divisor == 0);
		}
	}

}
