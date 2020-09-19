package practice09.searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problems_1 {
	
	/*
	 * 	Given an array of n numbers, give an algorithm for checking whether there are any duplicate elements 
	 * 	in the array or no?
	 */
	//Complexity - O(n^2)
	public boolean findDuplicatesBruteForce(int[] arr){
		for(int i=0; i<arr.length; i++){
			for(int j=i+1; j<arr.length; j++){
				if(arr[i] == arr[j])
					return true;
			}
		}
		return false;
	}
	
	//Complexity - O(nlogn)  -- After sort
	public boolean findDuplicatesSorting(int[] arr){
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++){
			if(arr[i] == arr[i+1])
				return true;
		}
		return false;
	}
	
	//Complexity - O(n) -- Using hash table
	public boolean findDuplicatesHashTable(int[] arr){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i< arr.length; i++){
			if(map.get(arr[i]) != null)
				return true;
			else 
				map.put(arr[i], 1);
		}
		return false;
	}
	
	//Complexity - O(n) -- using negation
	public boolean findDuplicatesNegation(int[] arr){
		for(int i=0; i<arr.length; i++){
			if(arr[Math.abs(arr[i])] < 0)
				return true;
			else
				arr[arr[i]] = -arr[arr[i]];
		}
		return false;
	}
	
	/*
	 * Given an array of n numbers. Give an algorithm for finding the element which appears the maximum 
	 * number of times in the array?
	 */
	//Complexity - O(n^2) -- Brute Force
	//Complexity - O(nlong) -- Using Sort
	//Complexity - O(n) -- Usin Hash Table
	public int maxRepititionBruteForce(int[] arr){
		int count = 0, max =0;
		for(int i=0; i<arr.length; i++){
			count = 0;
			for(int j=i+1; j<arr.length; i++){
				if(arr[i] == arr[j])
					count++;
			}
			if(count > max)
				max = count;
		}
		return max;
	}
	
	//Time Complexity: O(n).
	public int maxRepitition(int[] arr){
		int maxIndex = -1 , max = 0;
		int n = arr.length;
		for(int i=0; i<n; i++)
			arr[arr[i]%n] +=n;
		
		for(int i=0; i<n ; i++){
			if(arr[i]/n > max){
				max = arr[i]/n;
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	/*
	 * Finding the Missing Number: We are given a list of n – 1 integers and these integers are in the 
	 * range of 1 to n. There are no duplicates in the list. One of the integers is missing in the list. 
	 * Given an algorithm to find the missing integer. Example: I/P:[1,2,4,6,3,7,8] O/P: 5
	 */
	//Complexity - O(n^2) -- Brute Force
	//Complexity - O(nlong) -- Using Sort
	//Complexity - O(n) -- Usin Hash Table
	public int findMissingNumberBruteForce(int[] arr){
		int n = arr.length , found=0;
		for(int i=1; i<=n; i++){
			found=0;
			for(int j=0; j<n; j++){
				if(arr[j]==i)
					found=1;
			}
			if(found == 0)
				return i;
		}
		return -1;
	}
	
	//Complexity: O(n) -- Summation
	public int findMissingSummation(int[] arr){
		int n = arr.length , totalSum = ((n+1)*(n+2))/2;
		for(int i=0; i<n; i++){
			totalSum -= arr[i];
		}
		return totalSum;
	}
	
	//Summation can result into integer overflow - Solution is XOR
	public int findMissingXOR(int[] arr){
		int X = 0,Y = 0, n=arr.length;
		for(int i=1; i<=n; i++){
			X ^= i;
		}
		for(int i=0; i<n; i++){
			Y ^= arr[i];
		}
		return X^Y;
	}
	
	/*
	 * Given an array of integers, every element appears twice except for one. Find that single element.
	 * Time Complexity: O(n). Space Complexity: O(1).
	 */
	public int singleMissingNumber(int[] arr){
		int missingNum = arr[0];
		for(int i=0; i<arr.length; i++){
			missingNum ^= arr[i];
		}
		return missingNum;
	}
	
	/*
	 * Given an array of n elements. Find two elements in the array such that their sum is equal to 
	 * given element K?
	 */
	//Complexity - O(n^2)
	public void findTwoNumsTargetBruteForce(int[] arr, int target){
		for(int i=0; i<arr.length; i++){
			for(int j=i+1; j<arr.length; j++){
				if(arr[i] + arr[j] == target){
					System.out.println("Two Numbers are : " + arr[i] +" "+ arr[j]);
					return;
				}
			}
		}
		System.out.println("Numbers with Target not found");
	}
	
	//Complexity - O(n) -- Using HashTable
	public void findTwoNumsTargetHashTable(int[] arr, int target){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++){
			if(map.containsKey(target-arr[i])){
				System.out.println("Two numbers are at : " + i +" "+ map.get(target-arr[i]));
				return;
			} else{
				map.put(arr[i], i);
			}
		}
		System.out.println("Numbers not found");
	}
	
	public static void main(String[] args) {
		Problems_1 problems = new Problems_1();
		int[] arr= {35,45,2,3,398,67,11,1,91,9, 79};
		problems.findTwoNumsTargetHashTable(arr, 86);
	}
	 
}
