package practice10.selection.alogo.median;


/*
 * 	->	Selection algorithm is an algorithm for finding the kth smallest/largest number in a list (also called 
 * 		as kth order statistic). This includes finding the minimum, maximum, and median elements. For finding 
 * 		the kth order statistic, there are multiple solutions which provide different complexities.
 * 
 *  Selection by Sorting
 *  --------------------
 *  ->	A selection problem can be converted to a sorting problem. In this method, we first sort the input
 *  	elements and then get the desired element. It is efficient if we want to perform many selections.
 *  ->	For example, let us say we want to get the minimum element. After sorting the input elements we can 
 *  	simply return the first element (assuming the array is sorted in ascending order). Now, if we want to 
 *  	find the second smallest element, we can simply return the second element from the sorted list.
 *  ->	That means, for the second smallest element we are not performing the sorting again. The same is
 *  	also the case with subsequent queries. Even if we want to get kth smallest element, just one scan
 *  	of the sorted list is enough to find the element (or we can return the kth-indexed value if the
 *  	elements are in the array).
 *  ->	From the above discussion what we can say is, with the initial sorting we can answer any query
 *  	in one scan, O(n). In general, this method requires O(nlogn) time (for sorting), where n is the length 
 *  	of the input list. Suppose we are performing n queries, then the average cost per operation is just 
 *  	nlogn/n = O(logn).This kind of analysis is called amortized analysis.
 */
public class T_001_SelectionBySorting {
	
}
