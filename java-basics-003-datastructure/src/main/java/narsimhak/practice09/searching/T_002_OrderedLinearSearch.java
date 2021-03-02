package narsimhak.practice09.searching;

/*
 * 	->	If the elements of the array are already sorted, then in many cases we don�t have to scan the
 * 		complete array to see if the element is there in the given array or not. In the algorithm below, it
 * 		can be seen that, at any point if the value at A[i] is greater than the data to be searched, then we
 * 		just return �1 without searching the remaining array.
 * 	->	Time complexity of this algorithm is O(n).This is because in the worst case we need to scan the
 * 		complete array. But in the average case it reduces the complexity even though the growth rate is
 * 		the same. Space complexity: O(1).
 */
public class T_002_OrderedLinearSearch {
	public static int orderedLinearSearch(int[] arr, int key){
		for(int i=0; i<arr.length ; i++){
			if(arr[i] == key)
				return i;
			else if(arr[i] > key)
				return -1;
		}
		return -1;
	}
}
