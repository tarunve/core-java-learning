package narsimhak.practice08.sorting;

import java.util.Arrays;

/**
 * 	->	Quick sort is an example of a divide-and-conquer algorithmic technique. It is also called partition 
 * 		exchange sort. It uses recursive calls for sorting the elements, and it is one of the famous algorithms 
 * 		among comparison-based sorting algorithms.
 * 	->	Divide: The array A[low ...high] is partitioned into two non-empty sub arrays A[low ...q] and A[q+ 1... high], 
 * 				such that each element of A[low ... high] is less than or equal to each element of A[q+ 1... high]. 
 * 				The index q is computed as part of this partitioning procedure.
 * 		Conquer: The two sub arrays A[low ...q] and A[q + 1 ...high] are sorted by recursive calls to Quick sort.
 * 
 * 	->	The recursive algorithm consists of four steps:
 * 		1.	If there are one or no elements in the array to be sorted, return.
 * 		2.	Pick an element in the array to serve as the �pivot� point. (Usually the left-most element in the array)
 * 		3.	Split the array into two parts � one with elements larger than the pivot and the other with elements 
 * 			smaller than the pivot.
 * 		4.	Recursively repeat the algorithm for both halves of the original array.
 * 
 * 	Worst case complexity : O(n2)
 * 	Best case complexity (Improved version) : O(nlogn)
 * 	Average case complexity (Basic version) : O(nlogn)
 * 	Worst case space complexity : O(1) auxiliary
 */
public class T_007_QuickSort {
	
	private static void quickSort(int[] arr, int low, int high) {
		if(low < high){
			int partitionIndex = partition(arr, low, high);
			quickSort(arr, low, partitionIndex-1);
			quickSort(arr, partitionIndex+1, high);
		}
	}
	
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low-1);
		for(int j=low; j<high; j++){
			if(arr[j] < pivot){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp;
		return i+1;
	}

	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7, 90}; 
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println("Sorted array is"); 
        System.out.println(Arrays.toString(arr));
	}
}
