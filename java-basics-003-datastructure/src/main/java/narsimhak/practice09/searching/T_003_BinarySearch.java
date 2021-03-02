package narsimhak.practice09.searching;

import java.util.Arrays;

/*
 * 	->	Let us consider the problem of searching a word in a dictionary. Typically, we directly go to
 * 		some approximate page [say, middle page] and start searching from that point. If the name that we
 * 		are searching is the same then the search is complete. If the page is before the selected pages then
 * 		apply the same process for the first half; otherwise apply the same process to the second half.
 * 		Binary search also works in the same way. The algorithm applying such a strategy is referred to
 * 		as binary search algorithm.
 * 			mid = low + (high - low)/2    or   mid = (low+high)/2
 * 
 * 	->	Time Complexity: O(logn). Space Complexity: O(1).
 */
public class T_003_BinarySearch {
		
	public static int binarySearchIterative(int[] arr, int key){
		int low = 0 , high = arr.length -1;
		while(low<high){
			int mid = (low+high)/2;
			if(arr[mid] == key)
				return mid;
			else if(arr[mid] < key)
				low = mid + 1;
			else 
				high = mid-1;
		}
		return -1;
	}
	
	public static int binarySearchRecursive(int[] arr, int low, int high , int key){
		int mid = (low+high)/2;
		if(low > high)
			return -1;
		if(arr[mid] == key)
			return mid;
		else if(arr[mid] < key)
			return binarySearchRecursive(arr, mid +1 , high, key);
		else 
			return binarySearchRecursive(arr, low, mid -1 , key);
	}
	
	public static void main(String[] args) {
		int[] arr = {2,45,66,2,13,56,7,88,34,56,99,123,4353,3232,23};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(binarySearchIterative(arr, 56));
		System.out.println(binarySearchIterative(arr, 2));
	}
}
