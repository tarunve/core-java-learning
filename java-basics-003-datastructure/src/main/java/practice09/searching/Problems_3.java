package practice09.searching;

public class Problems_3 {
	
	/*
	 * Given a number n, give an algorithm for finding the number of trailing zeros in n!.
	 * Time Complexity: O(logn).
	 */
	public static int numTrailingZeros(int n){
		int i, count=0;
		if(n<0)
			return -1;
		for(i=5; n/i>0; i*=5)
			count += n/i;
		return count;
	}
	
	/*
	 * Given an array of 2n integers in the following format a1 a2 a3 ...an b1 b2 b3 ...bn. 
	 * Shuffle the array to a1 b1 a2 b2 a3 b3 ... an bn without any extra memory.
	 */
	//Complexity - O(n^2) -- Brute Force
	public static void shuffleArray(int[] arr){
		int n = arr.length;
		for(int i=0, j=1, k=n; i<n; i++, j++, k++){
			for(int m=k; m>i+j; m--){
				int temp = arr[m-1];
				arr[m-1] = arr[m];
				arr[m] = temp;
			}
		}
		for(int i=0; i<2*n; i++)
			System.out.println(arr[i]);
	}
	
	/*
	 * Given an array of elements, how do you check whether the list is pairwise sorted or not? 
	 * A list is considered pairwise sorted if each successive pair of numbers is in sorted (non-decreasing) order.
	 */
	public static boolean isPairWiseSorted(int[] arr){
		if(arr.length == 0 || arr.length==1)
			return true;
		for(int i=0; i<arr.length-1; i+=2){
			if(arr[i]>arr[i+1])
				return false;
		}
		return true;
	}
}
