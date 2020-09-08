package com.java.basic.concepts.multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * 	->	This framework helps to make an algorithm parallel.
 * 	->	We don't have to bother about low level synchronization or locks.
 * 	->	Based on divide and conquer algorithm.
 * 	->	A larger task - it can be divided into smaller ones + the sub-solutions can be combined.
 * 	->	Subtasks have to be independent in order to be executed in parallel.
 * 	->	Ex.	Parallel merge sort, parallel maximum finding.
 *
 * 	RecursiveTask<T>
 * 	----------------
 * 	->	It will return a T type.
 * 	->	All the tasks we want to execute in parallel is a subclass of this class. We will
 * 		have to override the compute() method that will return the solution of sub-problem.
 *
 * 	RecursiveAction
 * 	---------------
 * 	->	it is a task, but without any return value.
 *
 * 	ForkJoinPool
 * 	------------
 * 	->	Basically it is a thread pool for executing fork-join tasks.
 * 	-> 	work-stealing a task is not equivalent to a thread !!
 * 		->	Tasks are light-weight threads - so fork-join will be efficient even when there
 * 			are a huge number of tasks.
 * 	->	So fork-join creates a fixed number of threads - usually the number of CPU cores.
 * 	->	These threads are executing the tasks but if a thread has no task : it can "steal"
 * 		a task from more busy threads. Tasks are distributed to all threads in thread pool.
 *
 * 	Methods:
 * 	-------
 * 	1.	fork():	asynchronously execute the given task in the pool. We can call this on
 * 				RecursiveAction or RecursiveTask<T>
 * 	2.	join():	returns the result of the computation when it is done.
 * 	3.	invoke():	execute the given task + return its result upon computation.
 */
public class T_022_ForkJoinFramework {

	/*
	 * 	Simple RecursiveAction Example
	 */
	static class SimpleRecusiveAction1 extends RecursiveAction {
		
		private static final long serialVersionUID = 3456L;
		private final int simulatedTask;

		public SimpleRecusiveAction1(int simulatedWork) {
			this.simulatedTask = simulatedWork;
		}
		
		@Override
		protected void compute() {
			if (simulatedTask > 100) {
				System.out.println("Parallel execution  and split task.... " + simulatedTask);
				SimpleRecusiveAction1 task1 = new SimpleRecusiveAction1(simulatedTask / 2);
				SimpleRecusiveAction1 task2 = new SimpleRecusiveAction1(simulatedTask / 2);
				task1.fork();
				task2.fork();
			}
			else {
				System.out.println("No need for parallel execution, sequential algorithm is OK... " + simulatedTask);
			}
		}
	}

	/*
	 * 	Simple RecursiveTask Example
	 */
	static class SimpleRecusiveTask1 extends RecursiveTask<Integer> {
		
		private static final long serialVersionUID = 3456L;
		protected int simulatedTask;

		public SimpleRecusiveTask1(int simulatedWork) {
			this.simulatedTask = simulatedWork;
		}
		
		@Override
		protected Integer compute() {
			if (simulatedTask > 10) {
				System.out.println("Parallel execution  and split task.... " + simulatedTask);
				SimpleRecusiveTask1 task1 = new SimpleRecusiveTask1(simulatedTask / 2);
				SimpleRecusiveTask1 task2 = new SimpleRecusiveTask1(simulatedTask / 2);
				task1.fork();
				task2.fork();
				int solution = 0;
				solution += task1.join();
				solution += task2.join();
				return solution;
			}
			else {
				System.out.println("No need for parallel execution, sequential algorithm is OK... " + simulatedTask);
				return 2 * simulatedTask;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("===========ForkJoinAction============");
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		SimpleRecusiveAction1 simpleRecusiveAction1 = new SimpleRecusiveAction1(120);
		pool.invoke(simpleRecusiveAction1);
		Thread.sleep(1000);
		System.out.println("===========ForkJoinTask============");
		ForkJoinPool pool1 = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		SimpleRecusiveTask1 simpleRecusiveTask1 = new SimpleRecusiveTask1(120);
		Integer testInt = pool1.invoke(simpleRecusiveTask1);
		System.out.println(testInt);
	}
}
