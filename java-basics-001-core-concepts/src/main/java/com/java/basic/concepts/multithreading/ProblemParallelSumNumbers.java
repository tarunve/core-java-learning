package com.java.basic.concepts.multithreading;

import java.util.Random;

public class ProblemParallelSumNumbers {
	
	static class SequentialSum {

		public int sum(int[] numbers) {
			int total = 0;
			for (int i = 0; i < numbers.length; i++) {
				total = total + numbers[i];
			}
			return total;
		}
	}
	
	static class ParallelSumWorkers extends Thread {
		
		private final int[] nums;
		private final int low;
		private final int high;
		private int partialSum;
		
		public ParallelSumWorkers(int[] nums, int low, int high) {
			this.nums = nums;
			this.low = low;
			this.high = high;
		}
		
		public int getPartialSum() {
			return this.partialSum;
		}
		
		@Override
		public void run() {
			partialSum = 0;
			for (int i = low; i < high; i++)
				partialSum = partialSum + nums[i];
		}
	}

	static class ParallelSum {
		private final ParallelSumWorkers[] sums;
		private final int numberOfThreads;
		
		public ParallelSum(int numOfThreads) {
			this.numberOfThreads = numOfThreads;
			this.sums = new ParallelSumWorkers[numOfThreads];
		}
		
		public int sum(int[] nums) {
			int steps = (int) Math.ceil(nums.length * 1.0 / numberOfThreads);
			for (int i = 0; i < numberOfThreads; i++) {
				sums[i] = new ParallelSumWorkers(nums, i * steps, (i + 1) * steps);
				sums[i].start();
			}
			try {
				for (ParallelSumWorkers worker : sums) {
					worker.join();
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			int total = 0;
			for (ParallelSumWorkers worker : sums) {
				total = total + worker.getPartialSum();
			}

			return total;
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		SequentialSum sumSeq = new SequentialSum();
		int numOfProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println("Available Processors :: " + numOfProcessors);

		int[] nums = new int[100000000];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(1000);
		}
		long start = System.currentTimeMillis();
		System.out.println(sumSeq.sum(nums));
		long end = System.currentTimeMillis();
		System.out.println("Sequential sum takes :: " + (end - start) + "ms");

		ParallelSum parallelSum = new ParallelSum(numOfProcessors);
		long start1 = System.currentTimeMillis();
		System.out.println(parallelSum.sum(nums));
		long end1 = System.currentTimeMillis();
		System.out.println("Parallel sum takes :: " + (end1 - start1) + "ms");
	}

}
