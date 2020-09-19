package practice08.sorting;

import java.util.Arrays;

/**
 * 	Merge Sort
 * 	----------
 * 	->	Merge sort is an example of the divide and conquer strategy.
 * 	->	Merging is the process of combining two sorted files to make one bigger sorted file.
 * 	->	Selection is the process of dividing a file into two parts: k smallest elements and n>k largest elements.
 * 	->	Selection and merging are opposite operations
 * 		->	selection splits a list into two lists
 * 		->	merging joins two files to make one file
 * 	->	Merge sort is Quick sort's complement
 * 	->	Merge sort accesses the data in a sequential manner.
 * 	->	This algorithm is used for sorting a linked list
 * 	->	Merge sort is insensitive to the initial order of its input.
 * 	->	In Quick sort most of the work is done before the recursive calls. Quick sort starts with the largest 
 * 		subfile and finishes with the small ones and as a result it needs stack. Moreover, this algorithm is 
 * 		not stable. Merge sort divides the list into two parts; then each part is conquered individually. 
 * 		Merge sort starts with the small subfiles and finishes with the largest one. As a result it doesn't 
 * 		need stack. This algorithm is stable.
 * 	->	The recurrence for the Merge Sort can be defined as:
 * 			T(n) = 2T(n/2) + Θ(n).
 * 		Using Master's theorem , T(n) = (nlogn) 
 * 
 * 	Worst case complexity : O(nlogn)
 * 	Best case complexity : Omega(nlogn)
 * 	Average case complexity : Θ(nlogn)
 * 	Worst case space complexity: O(n) auxiliary
 */
public class T_005_MergeSort {
	
	public static class MergeSort {
		private  int[] nums;
		private  int[] tempArray;

		public MergeSort(int[] num) {
			nums = num;
			tempArray = new int[nums.length];
		}

		public void mergeSort(int low, int high) {
			if (low >= high)
				return;
			int middle = (low + high) / 2;

			mergeSort(low, middle);
			mergeSort(middle + 1, high);
			merge(low, middle, high);
		}

		private void merge(int low, int middle, int high) {
			for (int i = low; i <= high; i++) {
				tempArray[i] = nums[i];
			}

			int i = low;
			int j = middle + 1;
			int k = low;

			while ((i <= middle) && (j <= high)) {
				if (tempArray[i] <= tempArray[j])
					nums[k++] = tempArray[i++];
				else
					nums[k++] = tempArray[j++];
			}

			while (i <= middle)
				nums[k++] = tempArray[i++];
			
			while (j <= high)
				nums[k++] = tempArray[j++];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {23,1,234,3,80,9,45,67,3};
		MergeSort sort = new  MergeSort(arr);
		sort.mergeSort(0, arr.length-1);
		System.out.print("After merge Sort: " + Arrays.toString(arr));
	}
}
