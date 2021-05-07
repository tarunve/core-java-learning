package com.java.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 	Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 	You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * 	Example:
 * 		Given nums = [2, 7, 11, 15], target = 9,
 * 		Because nums[0] + nums[1] = 2 + 7 = 9,
 * 		return [0, 1].
 */
public class P_003_TwoSumPair {
	
	//Brute Force  - O(n^2)
    public static int[] twoSumBruteForce(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
    
    //One-pass Hash Table - O(n)
    public static int[] twoSumHashTable(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length ; i++){
            Integer numFound = map.get(target-nums[i]);
            if(numFound == null){
                map.put(nums[i] , i);
            }
            else {
                result[1] = i;
                result[0] = Integer.valueOf(numFound);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		long start = System.nanoTime();
		System.out.println(Arrays.toString(twoSumBruteForce(nums, 9)));
		System.out.println("Time taken by Brute Force :: " + (System.nanoTime() - start));
		
		long start1 = System.nanoTime();
		System.out.println(Arrays.toString(twoSumHashTable(nums, 9)));
		System.out.println("Time taken by One Pass Hash Table :: " + (System.nanoTime() - start1));
	}
}
