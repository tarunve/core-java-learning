package narsimhak.practice08.sorting;

import java.util.Arrays;

/*
 * 	->	Shell sort (also called diminishing increment sort) was invented by Donald Shell. This sorting
 * 		algorithm is a generalization of insertion sort. Insertion sort works efficiently on input that is
 * 		already almost sorted. Shell sort is also known as n-gap insertion sort. Instead of comparing only
 * 		the adjacent pair, shell sort makes several passes and uses various gaps between adjacent elements 
 * 		(ending with the gap of 1 or classical insertion sort).
 * 	->	ShellSort is actually a simple extension for insertion sort. The primary difference is its capability
 * 		of exchanging elements that are far apart, making it considerably faster for elements to get to
 * 		where they should be.
 * 	->	Shell sort uses a sequence h1,h2, ...,ht called the increment sequence. Any increment sequence is
 * 		fine as long as h1 = 1, and some choices are better than others. Shell sort makes multiple passes
 * 		through the input list and sorts a number of equally sized sets using the insertion sort. Shell sort
 * 		improves the efficiency of insertion sort by quickly shifting values to their destination.
 * 	->	Shell sort is efficient for medium size lists. For bigger lists, the algorithm is not the best choice. It
 * 		is the fastest of all O(n2) sorting algorithms.
 * 	->	The disadvantage of Shell sort is that it is a complex algorithm and not nearly as efficient as the
 * 		merge, heap, and quick sorts. Shell sort is significantly slower than the merge, heap, and quick sorts, 
 * 		but is a relatively simple algorithm, which makes it a good choice for sorting lists of less than 5000 
 * 		items unless speed is important. It is also a good choice for repetitive sorting of smaller lists.
 * 
 * 	Worst case complexity depends on gap sequence. Best known: O(nlog2n)
 * 	Best case complexity: O(n)
 * 	Worst case space complexity: O(n)	
 */
public class T_004_ShellSort {
	
	private static void shellSort(int[] arr) {
		int n = arr.length;
		for(int gap=n/2; gap>0 ; gap/=2){
			for(int i=gap ; i<n; i++){
				int temp = arr[i];
				int j = i;
				while(j>=gap && arr[j-gap] > temp){
					arr[j] = arr[j-gap];
					j = j-gap;
				}
				arr[j] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {23,1,234,3,80,9,45,67,3};
		shellSort(arr);
		System.out.print("After shell Sort: " + Arrays.toString(arr));
	}
}
