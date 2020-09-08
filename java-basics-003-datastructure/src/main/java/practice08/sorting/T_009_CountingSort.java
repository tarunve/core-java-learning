package practice08.sorting;

import java.util.Arrays;

/*
 *	->	Counting sort is not a comparison sort algorithm and gives O(n) complexity for sorting. To 
 *		achieve O(n) complexity, counting sort assumes that each of the elements is an integer in the
 *		range 1 to K, for some integer K. When K = O(n), the counting sort runs in O(n) time. The basic
 *		idea of Counting sort is to determine, for each input element X, the number of elements less than
 *		X. This information can be used to place it directly into its correct position. For example, if 
 *		10 elements are less than X, then X belongs to position 11 in the output.
 *	->	Total Complexity: O(K) + O(n) + O(K) + O(n) = O(n) if K =O(n). Space Complexity: O(n) if K=O(n).
 */
public class T_009_CountingSort {
	
	public static void countSort(int[] arr, int K){
		int n = arr.length;
		int count[] = new int[K];
		int[] output = new int[n];
		for(int i=0; i<K ; i++)
			count[i] = 0;
		
		for(int i=0; i<n ;i++)
			++count[arr[i]];
		
		for(int i=1; i<K ;i++)
			count[i] = count[i] + count[i-1];
		
		for(int i = (n-1) ; i>=0 ; i--){
			output[count[arr[i]] - 1] = arr[i];
			--count[arr[i]];
		}
		
		for(int i=0; i<n ; i++)
			arr[i] = output[i];
	}
	
	public static void main(String[] args) {
		int[] arr = {23,1,93,3,80,9,45,67,3};
		countSort(arr, 99);
		System.out.print("After merge Sort: " + Arrays.toString(arr));
	}	
}
