package practice14.divide.conquer.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problems_1 {
	/*
	 * 	Given an infinite array in which the first n cells contain integers in sorted order
	 * 	and the rest of the cells are filled with some special symbol (say, $). Assume we do not
	 * 	know the n value. Give an algorithm that takes an integer K as input and finds a position 
	 * 	in the array containing K, if such a position exists, in O(logn) time.
	 */
	public static int findNInInfiniteSeries(int[] arr, int key){
		int low = 0,high = 1;
		int val = arr[0];
		while(val<key){
			low = high;
			if(2*high < arr.length-1)
				high=2*high;
			else
				high = arr.length-1;
			val=arr[high];
		}
		return binarySearch(arr, low, high, key);
	}

	private static int binarySearch(int[] arr, int l, int r, int key) {
		while(r>=1){
			int mid = l+(r-l)/2;
			if(arr[mid] == key){
				return mid;
			}
			if(arr[mid] > key)
				return binarySearch(arr, l, mid-1, key);
			else
				return binarySearch(arr, mid+1, r, key);
		}
		return -1;
	}
	
	/*
	 * 	Stock Pricing Problem: Consider the stock price of CareerMonk.com in n consecutive days. 
	 * 	That means the input consists of an array with stock prices of the company. We know that 
	 * 	the stock price will not be the same on all the days. In the input stock prices there may 
	 * 	be dates where the stock is high when we can sell the current holdings, and there may be 
	 * 	days when we can buy the stock. Now our problem is to find the day on which we can buy the 
	 * 	stock and the day on which we can sell the stock so that we can make maximum profit.
	 */
	static class Interval { 
	    int buy, sell; 
	} 
	public static void maxProfit(int[] price, int n){
		if (n == 1) 
			return; 
	    int count = 0; 
        ArrayList<Interval> sol = new ArrayList<Interval>(); 
        int i = 0; 
        while (i < n - 1) { 
            while ((i < n - 1) && (price[i + 1] <= price[i])) 
                i++; 
            if (i == n - 1) 
                break; 
  
            Interval e = new Interval(); 
            e.buy = i++; 
            while ((i < n) && (price[i] >= price[i - 1])) 
                i++; 
            e.sell = i - 1; 
            sol.add(e); 
            count++; 
        } 
        if (count == 0) 
            System.out.println("There is no day when buying the stock will make profit"); 
        else
            for (int j = 0; j < count; j++) 
                System.out.println("Buy on day: " + sol.get(j).buy+" , Sell on day : " + sol.get(j).sell); 
  
        return; 
	}
	
	/*
	 * Given an array of 2n integers in the following format a1 a2 a3 ...an b1 b2 b3...bn. 
	 * Shuffle the array to a1 b1 a2 b2 a3 b3 ... an bn without any extra memory [MA].
	 */
	//Time Complexity: O(n^2)  -- Brute Force
	public static int[] shuffleArrayBruteForce(int[] arr, int n){
		for(int i=0, q=1, k=n; i<n; i++,q++,k++){
			for(int j=k; j>i+q; j--){
				int temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
			}
		}
		return arr;
	}
	
	//Time Complexity: O(nlogn)  -- D & C
	public static void shuffleArrayDivideConquer(int[] arr, int startIndex, int endIndex){
		if(startIndex > endIndex)
			return;
		if(endIndex-startIndex == 1)
			return;
		int mid = (startIndex+endIndex)/2;
		int temp = mid+1;
		int mmid= (startIndex+mid)/2;
		for(int i=mmid+1; i<=mid; i++){
			int temp1 = arr[i];
			arr[i] = arr[temp];
			arr[temp] = temp1;
			temp++;
		}
		shuffleArrayDivideConquer(arr, startIndex, mid);
		shuffleArrayDivideConquer(arr, mid+1, endIndex);
	}
	
	/*
	 * The Skyline Problem: Given the exact locations and shapes of n rectangular buildings in a 
	 * 2-dimensional city. There is no particular order for these rectangular buildings. Assume 
	 * that the bottom of all buildings lie on a fixed horizontal line (bottom edges are collinear). 
	 * The input is a list of triples; one per building. A building Bi is represented by the triple 
	 * (li, hi, ri) where li denote the x-position of the left edge and ri denote the x-position of 
	 * the right edge, and hi denotes the building’s height. Give an algorithm that computes the 
	 * skyline (in 2 dimensions) of these buildings, eliminating hidden lines. In the diagram below 
	 * there are 8 buildings, represented from left to right by the triplets (1, 14, 7), (3, 9, 10), 
	 * (5, 17, 12), (14, 11, 18), (15, 6, 27), (20, 19, 22), (23, 15,30) and (26, 14, 29).
	 */
	private static List<int[]> maxIncreasedKeepingSkyline(int i, int j, int[][] buildings) {
		return null;
	}

	public static void main(String[] args) {
		int[] arr={23,4,56,7,8,9,23,4556,77,998,0,34,1225,7,768778,88,986,5,54,56,343};
		//System.out.println(findNInInfiniteSeries(arr, 1225));
		maxProfit(arr, arr.length);
		
		int[] arr1 = shuffleArrayBruteForce(arr, arr.length/2);
		System.out.println(Arrays.toString(arr1));
		
		/*shuffleArrayDivideConquer(arr1, 0, arr.length-1);
		System.out.println(Arrays.toString(arr1));*/
		
		int buildings[][] = {{1, 14, 7}, {3, 9, 10}, {5, 17, 12}, {14, 11, 18}, {15, 6, 27}, {20, 19, 22}, {23, 15,30} ,{26, 14, 29}};
		List<int[]> skyLineOutput = maxIncreasedKeepingSkyline(0,0,buildings);
		System.out.println(skyLineOutput);
	}

	
}
