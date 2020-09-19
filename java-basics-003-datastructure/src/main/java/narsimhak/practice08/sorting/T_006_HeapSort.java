package practice08.sorting;

/*
 * 	->	HeapSort is a comparison-based sorting algorithm and is part of the selection sort family. Although 
 * 		somewhat slower in practice on most machines than a good implementation of Quick sort, it has the 
 * 		advantage of a more favorable worst-case Θ(nlogn) runtime. HeapSort is an in-place algorithm but is 
 * 		not a stable sort.
 * 
 * 	Worst case performance: Θ(nlogn)
 *  Best case performance: Θ(nlogn) 
 *  Average case performance: Θ(nlogn)
 *  Worst case space complexity: Θ(n) total, Θ(1) auxiliary
 */
import java.util.Arrays;

public class T_006_HeapSort {
	
	public static void sort(int[] arr, int n){
		for(int i=n/2-1 ; i>=0 ; i--)
			heapify(arr, n, i);
		System.out.println(Arrays.toString(arr));
		for(int i=n-1; i>=0 ; i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public static void heapify(int arr[], int n, int i){
		int largest = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		if(left < n && arr[left] > arr[largest])
			largest =left;
		if(right < n && arr[right] > arr[largest])
			largest = right;
		if(largest != i){
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, n, largest);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7, 90}; 
        int n = arr.length; 
        System.out.println(Arrays.toString(arr));
        sort(arr, n);
        System.out.println("Sorted array is"); 
        System.out.println(Arrays.toString(arr));
	}
}
