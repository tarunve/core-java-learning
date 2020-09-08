package practice09.searching;

import java.util.Arrays;

/*
 * 	->	The Interpolation Search is an improvement over Binary Search for instances, where the values 
 * 		in a sorted array are uniformly distributed. Binary Search always goes to the middle element 
 * 		to check. On the other hand, interpolation search may go to different locations according to 
 * 		the value of the key being searched. For example, if the value of the key is closer to the 
 * 		last element, interpolation search is likely to start search toward the end side.
 * 	->	To find the position to be searched, it uses following formula.
 * 		pos = pos = low + [((high-low) / (arr[high]-arr[low]))*(key-arr[low])];
 * 			arr[] ==> Array where elements need to be searched
 * 			x     ==> Element to be searched
 * 			low   ==> Starting index in arr[]
 * 			high  ==> Ending index in arr[]
 */
public class T_004_InterpolationSearch {
	
	public static int interpolationSearch(int[] arr, int key){
		int low = 0 , high = arr.length -1;
		while(low<=high && key>=arr[low] && key<=arr[high]){
			if(low == high){
				if(arr[low] == key)
					return low;
				return -1;
			}
				
			int pos = low + (((high-low) / (arr[high]-arr[low]))*(key-arr[low]));
			if(arr[pos] == key)
				return pos;
			if(arr[pos] < key)
				low = pos + 1;
			else 
				high = pos-1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,45,66,2,13,56,7,88,34,56,99,123,4353,3232,23,0};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(interpolationSearch(arr, 56));
	}
}
