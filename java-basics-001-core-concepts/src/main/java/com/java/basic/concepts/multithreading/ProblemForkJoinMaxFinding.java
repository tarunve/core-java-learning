package com.java.basic.concepts.multithreading;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ProblemForkJoinMaxFinding {
	
	static class SequentialMaxFinding {
		//Complexity : O(n)
		public int sequentialMaxFind(int[] nums, int highIndex) {
			int max = nums[0];
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] > max)
					max = nums[i];
			}
			return max;
		}
	}
	
	public static int THRESHOLD = 0;

	static class ParallelMaxFinding extends RecursiveTask<Integer> {

		private static final long serialVersionUID = 1L;
		protected int[] nums;
		protected int low;
		protected int high;

		public ParallelMaxFinding(int[] numbers, int low, int high) {
			this.nums = numbers;
			this.low = low;
			this.high = high;
		}

		private int sequentialMaxFind() {
			int max = nums[0];
			for (int i = low + 1; i < nums.length; i++) {
				if (nums[i] > max)
					max = nums[i];
			}
			return max;
		}
		
		@Override
		protected Integer compute() {
			if (high - low < ProblemForkJoinMaxFinding.THRESHOLD)
				return sequentialMaxFind();
			else {
				int mid = (low + high) / 2;
				ParallelMaxFinding task1 = new ParallelMaxFinding(nums, low, mid);
				ParallelMaxFinding task2 = new ParallelMaxFinding(nums, mid + 1, high);
				
				invokeAll(task1, task2);
				return Math.max(task1.join(), task2.join());
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = initializeNums(100000000);
		THRESHOLD = nums.length / Runtime.getRuntime().availableProcessors();

		SequentialMaxFinding sequential = new SequentialMaxFinding();
		long start = System.currentTimeMillis();
		System.out.println("Max: " + sequential.sequentialMaxFind(nums, nums.length));
		long end = System.currentTimeMillis();
		System.out.println("Time Taken Sequential : " + (end - start) + "ms");
		
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		ParallelMaxFinding parallel = new ParallelMaxFinding(nums, 0, nums.length);
		long start1 = System.currentTimeMillis();
		System.out.println("Max: " + pool.invoke(parallel));
		long end1 = System.currentTimeMillis();
		System.out.println("Time Taken Parallel : " + (end1 - start1) + "ms");

	}
	
	public static int[] initializeNums(int length) {
		Random random = new Random();
		int[] numbers = new int[length];
		for (int i = 0; i < length; i++) {
			numbers[i] = random.nextInt(10000);
		}
		return numbers;
	}
}
