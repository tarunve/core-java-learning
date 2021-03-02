package narsimhak.practice10.selection.alogo.median;

/*
 * 	->	This method is similar to Quick Sort.
 * 	
 * 	Algorithm
 * 	---------
 * 	1. 	Choose a pivot from the array.
 * 	2. 	Partition the array so that: A[low...pivotpoint � 1] <= pivotpoint <= A[pivotpoint +1..high].
 * 	3. 	if k < pivotpoint then it must be on the left of the pivot, so do the same method recursively on the left part.
 * 	4. 	if k = pivotpoint then it must be the pivot and print all the elements from low to pivotpoint.
 * 	5. 	if k > pivotpoint then it must be on the right of pivot, so do the same method recursively on the right part.
 * 	   	The top-level call would be kthSmallest = Selection(1, n, k).
 * 
 * 	Time Complexity: O(n^2) in worst case as similar to QuickSort. Although the worst case is the same as that of Quicksort, 
 * 	this performs much better on the average [O(nlogk) � Average case].
 */
public class T_002_SelectionByPartition {
	
	public static int kthSmallestNum(int[] arr, int k){
		return orderStatisticIterative(arr, k, 0, arr.length-1);
	}

	private static int orderStatisticIterative(int[] arr, int k, int start, int end) {
		int pivotPosition = partition(arr, start, end);
		while(pivotPosition != k-1){
			if(k-1 < pivotPosition) 
				end = pivotPosition-1;
			else 
				start = pivotPosition+1;
			pivotPosition = partition(arr, start, end);
		}
		return arr[k-1];
	}
	
	@SuppressWarnings("unused")
	private static int orderStatisticIterativeRecursive(int[] arr, int k, int start, int end) {
		int pivotPosition = partition(arr, start, end);
		if(k-1 == pivotPosition)
			return arr[k-1];
		else if(k-1 < pivotPosition)
			return orderStatisticIterativeRecursive(arr, k, start, pivotPosition-1);
		else
			return orderStatisticIterativeRecursive(arr, k, pivotPosition+1, end);
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[start];
		int pivotPosition = start++;
		while(start <= end){
			while(start <= end && arr[start] < pivot)
				start++;
			while(end>=start && arr[end]>=pivot)
				end--;
			if(start > end){
				swap(arr, pivotPosition, end);
			} else {
				swap(arr, start, end);
			}
		}
		return end;
	}

	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {23,65,11,99,88,56,10,8,9,3,1};
		System.out.println(kthSmallestNum(arr, 4));
	}
}
