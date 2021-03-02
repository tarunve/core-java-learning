package narsimhak.practice10.selection.alogo.median;

/*
 * ->	Similar to Quick Sort algorithm.
 * 
 * Worst-case performance O(n)
 * Best-case performance O(n)
 * Worst-case space complexity O(1) auxiliary
 */
public class T_003_LinearSelection_Median {
	public static int kthSmallestNum(int[] arr, int k){
		return orderStatisticIterative(arr, arr.length-k+1, 0, arr.length-1);
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
