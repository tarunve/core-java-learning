package narsimhak.practice08.sorting;

import java.util.Arrays;

/**
 * 	->	Selection sort is an in-place sorting algorithm. Selection sort works well for small files. It is used
 * 		for sorting the files with very large values and small keys. This is because selection is made based 
 * 		on keys and swaps are made only when required.
 * 	->	Algorithm
 * 		1.	Find the minimum value in the list
 * 		2.	Swap it with the value in the current position
 * 		3.  Repeat this process for all the elements until the entire array is sorted
 * 
 * 	Time Complexity - O(n^2)
 */
public class T_002_SelectionSort {
	
	private static void selectionSort(int[] arr) {
		int n = arr.length;
		int temp;
		for(int i=0 ; i<n ; i++){
			int min = i;
			for(int j=i+1; j<n ; j++){
				if(arr[j] < arr[min])
					min = j;
			}
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {23,1,234,3,80,9,45,67,3};
		selectionSort(arr);
		System.out.print("After selection Sort: " + Arrays.toString(arr));
	}
}
