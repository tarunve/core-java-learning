package practice08.sorting;

import java.util.Arrays;

/*
 * 	->	Similar to Counting sort and Bucket sort, this sorting algorithm also assumes some kind of
 * 		information about the input elements. Suppose that the input values to be sorted are from 
 * 		base d. That means all numbers are d-digit numbers.
 * 	->	In Radix sort, first sort the elements based on the last digit [the least significant digit]. 
 * 		These results are again sorted by second digit [the next to least significant digit]. Continue 
 * 		this process for all digits until we reach the most significant digits. Use some stable sort 
 * 		to sort them by last digit. Then stable sort them by the second least significant digit, then 
 * 		by the third, etc. 
 * 		->	If we use Counting sort as the stable sort, the total time is O(nd) ≈ O(n).
 * 	
 * 	Algorithm:
 * 		1.	Take the least significant digit of each element.
 * 		2.	Sort the list of elements based on that digit, but keep the order of elements with the 
 * 			same digit (this is the definition of a stable sort).
 * 		3.	Repeat the sort with each more significant digit.
 * 	
 * 	Time Complexity: O(nd) ≈ O(n), if d is small
 */
public class T_011_RadixSort {
	
	private static void radixsort(int[] arr, int n) {
		int m = max_value(arr);
		for(int exp=1; m/exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}
	
	private static void countSort(int[] arr, int n, int exp) {
		int[] count = new int[10];
		int[] output = new int[n];
		Arrays.fill(count, 0);
		
		for(int i=0; i<n; i++)
			count[(arr[i]/exp)%10]++;
		
		for(int i=1; i<10; i++)
			count[i] += count[i-1];
		
		for(int i=n-1 ; i>=0 ; i--){
			output[count[(arr[i]/exp)%10]-1] = arr[i];
			count[(arr[i]/exp)%10]--;
		}
		
		for(int i=0; i<n; i++)
			arr[i] = output[i];
	}

	private static int max_value(int[] nums) {
		int max_value = nums[0];
		for(int i=0; i< nums.length ; i++){
			if(nums[i] > max_value)
				max_value = nums[i];
		}
		return max_value;
	} 
	
	public static void main(String[] args) {
		int arr[] = {170, 45, 75, 90, 802, 24, 2, 66}; 
        int n = arr.length; 
        radixsort(arr, n); 
        System.out.println(Arrays.toString(arr));
	}
}
