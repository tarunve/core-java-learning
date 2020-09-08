package com.java.basic.concepts.multithreading;

import java.util.Arrays;
import java.util.Random;

public class ProblemParallelMergeSort {
	int[] num;
	int[] tempArray;
	
	public ProblemParallelMergeSort(int[] array) {
		this.num = array;
	}

	private Thread mergeSortThread(final int[] numbers, final int numOfThreads) {
		
		return new Thread() {
			@Override
			public void run() {
				parallelMergeSort(numbers, numOfThreads / 2);
			}
		};
	}

	public void parallelMergeSort(int[] numbers, int numOfThreads) {
		
		if (numOfThreads <= 1) {
			mergeSort(numbers);
			return;
		}

		int middleIndex = numbers.length / 2;

		int[] leftSubarray = Arrays.copyOfRange(numbers, 0, middleIndex);
		int[] rightSubarray = Arrays.copyOfRange(numbers, middleIndex, numbers.length);

		Thread leftSorter = mergeSortThread(leftSubarray, numOfThreads);
		Thread rightSorter = mergeSortThread(rightSubarray, numOfThreads);

		leftSorter.start();
		rightSorter.start();

		try {
			leftSorter.join();
			rightSorter.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		merge(leftSubarray, rightSubarray, numbers);
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
	
	public void showResult() {
		System.out.println("Sorted array :: ");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}

	static class MyTestMergeSort {
		public static Random random = new Random();

		public static void main(String[] args) throws Throwable {
			int numOfThreads = Runtime.getRuntime().availableProcessors();

			System.out.println("Number of threads/cores: " + numOfThreads);
			
			int[] numbers = createRandomArray(10000000);
			ProblemParallelMergeSort mergeSort = new ProblemParallelMergeSort(numbers);
			
			long startTime1 = System.currentTimeMillis();
			mergeSort.parallelMergeSort(numbers, numOfThreads);
			long endTime1 = System.currentTimeMillis();
			//mergeSort.showResult();
			System.out.printf("Time taken for 100 000 000 elements parallel =>  %6d ms \n", endTime1 - startTime1);
			System.out.println("");
			
			startTime1 = System.currentTimeMillis();
			mergeSort.mergeSort(numbers);
			endTime1 = System.currentTimeMillis();
			System.out.printf("Time taken for 100 000 000 elements sequential =>  %6d ms \n", endTime1 - startTime1);
			
		}

		public static int[] createRandomArray(int length) {
			int[] a = new int[length];
			for (int i = 0; i < length; i++) {
				a[i] = random.nextInt(10000);
			}
			return a;
		}
	}
}

class MergeSort {
	private final int[] nums;
	private final int[] tempArray;

	public MergeSort(int[] nums) {
		this.nums = nums;
		tempArray = new int[nums.length];
	}

	public void mergeSort(int low, int high) {

		if (low >= high) {
			return;
		}

		int middle = (low + high) / 2;

		mergeSort(low, middle);
		mergeSort(middle + 1, high);
		merge(low, middle, high);
	}

	public void showResult() {
		for (int i = 0; i < nums.length; ++i) {
			System.out.print(nums[i] + " ");
		}
	}

	private void merge(int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			tempArray[i] = nums[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;

		while ((i <= middle) && (j <= high)) {
			if (tempArray[i] <= tempArray[j]) {
				nums[k] = tempArray[i];
				i++;
			}
			else {
				nums[k] = tempArray[j];
				j++;
			}

			k++;
		}

		while (i <= middle) {
			nums[k] = tempArray[i];
			k++;
			i++;
		}
	}
}
