package narsimhak.practice08.sorting;

import java.util.Arrays;

/**
 * 	->	Insertion sort is a simple and efficient comparison sort. In this algorithm, each iteration removes
 * 		an element from the input data and inserts it into the correct position in the list being sorted. The
 * 		choice of the element being removed from the input is random and this process is repeated until all 
 * 		input elements have gone through.
 * 	->	Practically more efficient than selection and bubble sorts, even though all of them have O(n2) worst 
 * 		case complexity.
 * 
 * 	Time Complexity - O(n^2)
 */
public class T_003_InsertionSort {
	
	private static void insertionSort(int[] arr) {
		int i, j, v;
		for(i=1; i<arr.length ; i++){
			v = arr[i];
			j=i;
			while(j>0 && arr[j-1] > v){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = v;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {23,1,234,3,80,9,45,67,3};
		insertionSort(arr);
		System.out.print("After insertion Sort: " + Arrays.toString(arr));
	}

	
}
