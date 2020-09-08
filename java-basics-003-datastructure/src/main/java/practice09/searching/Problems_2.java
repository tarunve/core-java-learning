package practice09.searching;

import java.util.Arrays;


public class Problems_2 {
	
	/*
	 * Find two elements whose sum is closest to zero: Given an array with both positive and 
	 * negative numbers, find the two elements such that their sum is closest to zero. For the 
	 * below array, algorithm should give -80 and 85. Example: 1 60 – 10 70 – 80 85.
	 * Time complexity: O(n^2). Space Complexity: O(1).
	 */
	public static void twoNumbersSumClosestToZero(int[] arr){
		int n = arr.length;
		if(n < 2){
			System.out.println("Input Invalid");
			return;
		}
		
		int min_i=0;
		int min_j=1;
		int min_sum = arr[0]+arr[1];
		int sum = 0;
		for(int i=0; i<n-1 ; i++){
			for(int j=i+1; j<n; j++){
				sum = arr[i] + arr[j];
				if(Math.abs(sum) < Math.abs(min_sum)){
					min_i=i;
					min_j=j;
					min_sum=sum;
				}
			}
		}
		System.out.println("Two numbers are : " + arr[min_i] +" " +arr[min_j]);
	}
	
	/*
	 * Given an array of n elements. Find three elements in the array such that their sum 
	 * is equal to given element K?
	 */
	//Complexity O(n^2) - using hashing
	//Complexity: O(n^3), -- Brute Force
	public static void threeElementsSumTargetBruteForce(int[] arr, int target){
		int n = arr.length;
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				for(int k=j+1; k<n; k++){
					if(arr[i]+arr[j]+arr[k] == target){
						System.out.println("Three numbers are : " + arr[i]+" "+arr[j]+" "+arr[k]);
						return;
					}
				}
			}
		}
		System.out.println("Numbers not found");
	}
	
	//Complexity: O(n^2), -- sorting
	public static void threeElementsSumTargetSorting(int[] arr, int target){
		int n = arr.length;
		Arrays.sort(arr);
		for(int i=0; i<n-1; i++){
			for(int j=i+1 , k=n-1; j<k;){
				if(arr[i]+arr[j]+arr[k] == target){
					System.out.println("Three numbers are : " + arr[i]+" "+arr[j]+" "+arr[k]);
					return;
				} else if(arr[i]+arr[j]+arr[k] < target){
					j++;
				} else{
					k--;
				}
					
			}
		}
		System.out.println("Numbers not found");
	}
	
	/*
	 * Given a sorted array of n integers that has been rotated an unknown number of times, give a 
	 * O(logn) algorithm that finds an element in the array. Example: Find 5 in array (15 16 19 20 25 
	 * 1 3 4 5 7 10 14) Output: 8 (the index of 5 in the array).
	 */
	//Time complexity: O(logn). Space complexity: O(logn) for recursive stack
	public int searchRotatedSortedArray(int[] arr, int left, int right, int element){
		if(left > right)
			return -1;
		int mid = (left+right)/2;
		if(element == arr[mid])
			return mid;
		else if(arr[left] <= arr[mid]){
			if(element >= arr[left] && element < arr[mid])
				return searchRotatedSortedArray(arr, left, mid-1, element);
			else
				return searchRotatedSortedArray(arr, mid+1, right, element);
		}else {
			if(element > arr[mid] && element <= arr[right])
				return searchRotatedSortedArray(arr, mid+1, right, element);
			else
				return searchRotatedSortedArray(arr, left, mid-1, element);
		}
	}
	
	public boolean searchRotatedSortedArrayWithoutRecursion(int[] arr, int element){
		int left =0, right = arr.length-1;
		while(left <= right){
			int mid = (left+right)/2;
			if(arr[mid] == element)
				return true;
			if(arr[left] < arr[mid]){
				if(arr[left] <= element && element <arr[mid])
					right = mid-1;
				else 
					left = mid+1;
			}else if(arr[left] > arr[mid]){
				if(arr[mid] < element && element <= arr[right])
					left = mid+1;
				else 
					right = mid-1;
			}else {
				left++;
			}
		}
		return false;
	}
	
	/*
	 * Sort an array of 0’s, 1’s and 2’s [or R’s, G’s and B’s]: Given an array A[] consisting of 0’s, 
	 * 1’s and 2’s, give an algorithm for sorting A[].The algorithm should put all 0’s first, then all 
	 * 1’s and finally all 2’s at the end. Example Input = {0,1,1,0,1,2,1,2,0,0,0,1}, Output = 
	 * {0,0,0,0,0,1,1,1,1,1,2,2}.
	 * Time Complexity: O(n). Space Complexity: O(1).
	 */
	public static void sort012DutchFlagProblem(int[] arr){
		int low=0, mid=0, high=arr.length-1;
		while(mid<=high){
			switch(arr[mid]){
				case 0:
					swap(arr[mid], arr[low]);
					low++;
					mid++;
					break;
				case 1:
					mid++;
					break;
				case 2:
					swap(arr[mid], arr[high]);
					high--;
					mid++;
					break;
			}
		}
	}
	private static void swap(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
	}
	
}
