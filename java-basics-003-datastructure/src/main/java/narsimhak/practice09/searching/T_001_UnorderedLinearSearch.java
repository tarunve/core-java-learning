package practice09.searching;

/*
 * 	->	Let us assume we are given an array where the order of the elements is not known. That means the
 * 		elements of the array are not sorted. In this case, to search for an element we have to scan the
 * 		complete array and see if the element is there in the given list or not.
 * 	->	Time complexity: O(n), in the worst case we need to scan the complete array.
 * 		Space complexity: O(1).
 */
public class T_001_UnorderedLinearSearch {
	
	public static int unorderedLinearSearch(int[] arr, int key){
		for(int i=0; i<arr.length ; i++){
			if(arr[i] == key)
				return i;
		}
		return -1;
	}
}
