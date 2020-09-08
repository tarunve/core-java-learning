package com.java.basic.concepts.multithreading;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ProblemForkJoinParallelMergeSort extends RecursiveAction {

	private static final long serialVersionUID = 1L;
	protected int[] nums;
	
	public ProblemForkJoinParallelMergeSort(int[] nums) {
		this.nums = nums;
	}

	public void mergeSort(int[] a) {

		if (a.length <= 1)
			return;

		int mid = a.length / 2;

		int[] left = Arrays.copyOfRange(a, 0, mid);
		int[] right = Arrays.copyOfRange(a, mid, a.length);

		mergeSort(left);
		mergeSort(right);

		merge(left, right, a);
	}

	private void merge(int[] leftSubarray, int[] rightSubarray, int[] originalArray) {
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < leftSubarray.length && j < rightSubarray.length) {
			if (leftSubarray[i] < rightSubarray[j])
				originalArray[k++] = leftSubarray[i++];
			else
				originalArray[k++] = rightSubarray[j++];
		}

		while (i < leftSubarray.length)
			originalArray[k++] = leftSubarray[i++];

		while (j < rightSubarray.length)
			originalArray[k++] = rightSubarray[j++];
	}
	
	@Override
	protected void compute() {
		if (nums.length <= 10) {
			mergeSort(nums);
			return;
		}
		int middleIndex = nums.length / 2;
		int[] leftSubArray = Arrays.copyOfRange(nums, 0, middleIndex);
		int[] rightSubArray = Arrays.copyOfRange(nums, middleIndex, nums.length);

		ProblemForkJoinParallelMergeSort leftTask = new ProblemForkJoinParallelMergeSort(leftSubArray);
		ProblemForkJoinParallelMergeSort rightTask = new ProblemForkJoinParallelMergeSort(rightSubArray);
		
		invokeAll(leftTask, rightTask);
		merge(leftSubArray, rightSubArray, nums);
	}

	public static void main(String[] args) {
		int[] nums = initializeNums(10000000);
		
		ProblemForkJoinParallelMergeSort seqMerge = new ProblemForkJoinParallelMergeSort(nums);
		long start = System.currentTimeMillis();
		seqMerge.mergeSort(nums);
		long end = System.currentTimeMillis();
		System.out.println("Time Taken Sequential : " + (end - start) + "ms");

		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		ProblemForkJoinParallelMergeSort parallelTasks = new ProblemForkJoinParallelMergeSort(nums);
		long start1 = System.currentTimeMillis();
		pool.invoke(parallelTasks);
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
