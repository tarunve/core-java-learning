package practice08.sorting;

import java.util.Arrays;

/*
 * 	->	Bucket sort is mainly useful when input is uniformly distributed over a range. For example, 
 * 		consider the following problem. Sort a large set of floating point numbers which are in range 
 * 		from 0.0 to 1.0 and are uniformly distributed across the range. How do we sort the numbers efficiently?
 * 	->	A simple way is to apply a comparison based sorting algorithm. The lower bound for Comparison based 
 * 		sorting algorithm (Merge Sort, Heap Sort, Quick-Sort .. etc) is Ω(n Log n), i.e., they cannot do better 
 * 		than nLogn. Can we sort the array in linear time? Counting sort can not be applied here as we use keys 
 * 		as index in counting sort. Here keys are floating point numbers. The idea is to use bucket sort.
 * 	->	Following is bucket algorithm.
 * 		1.	Create n empty buckets (Or lists).
 * 		2.	Do following for every array element arr[i].
 * 			a) Insert arr[i] into bucket[n*array[i]]
 * 		3.	Sort individual buckets using insertion sort.
 * 		4.	Concatenate all sorted buckets.
 * 
 * 	Worst Case Complexity : O(n^2)
 * 	Best Case Complexity  : O(n)
 * 	Space Complexity      :	O(n)
 */
public class T_010_BuckleSort {
	
	public static int[] buckleSort(int[] arr, int max_value){
		int[] bucket = new int[max_value+1];
		int[] sorted_arr = new int[arr.length];
		for(int i=0 ; i<arr.length; i++){
			bucket[arr[i]]++;
		}
		int outPos=0;
		for(int i=0; i<bucket.length ; i++){
			for(int j=0; j<bucket[i] ; j++){
				sorted_arr[outPos++] = i;
			}
		}
		return sorted_arr;
	}
	
	private static int max_value(int[] nums) {
		int max_value = nums[0];
		for(int i=0; i< nums.length ; i++){
			if(nums[i] > max_value)
				max_value = nums[i];
		}
		return max_value;
	} 
	
	public static void main(String args[]) {
        int nums[] = {7, 3, 2, 1, 0, 45};
        //Integer nums[] = {7, 3, 2, 1, 0, 45};
        //Collections.max(Arrays.asList(nums));
        int max_value = max_value(nums);
        System.out.print("Original Array:");
        System.out.println(Arrays.toString(nums));
        nums = buckleSort(nums, max_value);
        System.out.print("Sorted Array:");
        System.out.println(Arrays.toString(nums));
     }

}
