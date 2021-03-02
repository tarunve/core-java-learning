package narsimhak.practice08.sorting;

import java.util.Arrays;

/**
 * 	->	Bubble sort is the simplest sorting algorithm. It works by iterating the input array from the first 
 * 		element to the last, comparing each pair of elements and swapping them if needed. Bubble sort continues 
 * 		its iterations until no more swaps are needed. The algorithm gets its name from the way smaller 
 * 		elements �bubble� to the top of the list. 
 * 	->	Generally, insertion sort has better performance than bubble sort. Some researchers suggest that we 
 * 		should not teach bubble sort because of its simplicity and high time complexity.
 * 	->	The only significant advantage that bubble sort has over other implementations is that it can detect 
 * 		whether the input list is already sorted or not.
 * 
 * 	Time Complexity - n^2
 */
public class T_001_BubbleSort {
	
	public static void bubbleSort(int[] arr){
		int n = arr.length;
		for(int i=0; i<n-1 ; i++){
			for(int j=0 ; j<n-i-1; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void bubbleSortRecursive(int[] arr, int n){
		if(n==1)
			return;
		for(int j=0 ; j<n-1; j++){
			if(arr[j] > arr[j+1]){
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
		bubbleSortRecursive(arr, n-1);
	}
	
	public static void main(String[] args) {
		int[] arr = {23,1,234,3,80,9,45,67,3};
		bubbleSort(arr);
		System.out.print("After Bubble Sort: " + Arrays.toString(arr));
		System.out.println();
		int[] arr1 = {23,1,234,3,80,9,45,67,3};
		bubbleSortRecursive(arr1, 9);
		System.out.print("After Bulle Sort Recursive: " + Arrays.toString(arr1));
	}
}
