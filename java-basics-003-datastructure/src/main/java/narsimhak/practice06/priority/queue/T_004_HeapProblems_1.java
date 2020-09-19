package practice06.priority.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class T_004_HeapProblems_1 {
	
	/*
	 * Give an algorithm for deleting the ith indexed element in a given min-heap
	 */
	public int delete(T_003_BinaryHeap.Heap h, int i){
		int key;
		if(h.count < i){
			System.out.println("Wrong position...");
			return -1;
		}
		key = h.array[i];
		h.array[i] = h.array[h.count - 1];
		h.count--;
		h.perlocateDown(i);
		return key;
	}
	
	/*
	 * Maximum sum in sliding window: Given array A[] with sliding window of size w which is moving 
	 * from the very left of the array to the very right. Assume that we can only see the w numbers 
	 * in the window. Each time the sliding window moves rightwards by one position. 
	 * For example: The array is [1 3 -1 -3 5 3 6 7], and w is 3.
	 */
	public static int[] maxSumSlidingWindow(int[] nums , int k){
		if(nums==null||nums.length==0)
	        return new int[0];
	    int[] result = new int[nums.length-k+1];
	    LinkedList<Integer> deque = new LinkedList<Integer>();
	    for(int i=0; i<nums.length; i++){
	        if(!deque.isEmpty()&&deque.peekFirst()==i-k) 
	            deque.poll();
	        while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
	            deque.removeLast();
	        }    
	        deque.offer(i);
	        if(i+1>=k)
	            result[i+1-k]=nums[deque.peek()];
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		 
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.print("arr[]: {");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
		System.out.println(" }");
		int windowSize = scn.nextInt();
		int[] array = maxSumSlidingWindow(arr, windowSize);
		System.out.println(Arrays.toString(array));
		scn.close();
	}
}
