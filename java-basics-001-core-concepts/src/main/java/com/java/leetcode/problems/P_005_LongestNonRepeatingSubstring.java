package com.java.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 	Longest Substring Without Repeating Characters
 * 	Given a string, find the length of the longest substring without repeating characters.
 * 
 * 	Example 1:
 * 		Input: "abcabcbb"
 * 		Output: 3
 * 		Explanation: The answer is "abc", with the length of 3. 
 */
public class P_005_LongestNonRepeatingSubstring {
	
	/*	Approach 1: Brute Force - O(n^3)
	 * 	Complexity Analysis
	 * 		Time complexity : O(n^3).
	 * 	To verify if characters within index range [i,j) are all unique, we need to scan 
	 * 	all of them. Thus, it costs O(j - i)O(j−i) time.
	 * 	For a given i, the sum of time costed by each j∈[i+1,n] is 
	 *		Space complexity : O(min(n,m)). We need O(k) space for checking a substring 
	 *	has no duplicate characters, where k is the size of the Set. The size of the Set 
	 *  is upper bounded by the size of the string n and the size of the char/alphabet m.
	 */
	public static int lengthOfLongestSubstringBruteForce(String s) {
        int n = s.length();
        int ans=0 ;
        for(int i=0; i<n; i++){
        	for(int j=i+1; j<n; j++){
        		if(allUnique(s, i, j)){
        			ans = Math.max(ans, j-i);
        		}
        	}
        }
		return ans;
	}
	
	private static boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for(int i=start; i<end; i++){
			Character ch = s.charAt(i);
			if(set.contains(ch))
				return false;
			set.add(ch);
		}
		return true;
	}
	
	/*
	 * Approach 2: Sliding Window
	 * Complexity Analysis
	 * 		Time complexity : O(2n)=O(n). In the worst case each character will be visited 
	 * 		twice by i and j.
	 * 		Space complexity : O(min(m, n)). Same as the previous approach. We need O(k) 
	 * 		space for the sliding window, where k is the size of the Set. The size of the Set 
	 * 		is upper bounded by the size of the string n and the size of the char/alphabet m.
	 */
	public static int lengthOfLongestSubstringSlidingWindow(String s) {
        int n = s.length();
        int ans=0, i=0, j=0;
        Set<Character> set = new HashSet<>();
        while(i<n && j<n){
        	if(!set.contains(s.charAt(j))){
        		set.add(s.charAt(j++));
        		ans = Math.max(ans, j-i);
        	} else{
        		set.remove(s.charAt(i++));
        	}
        }
		return ans;
	}
	
	/*
	 * Approach 3: Sliding Window Enhanced - using HashMap
	 * Complexity Analysis
	 * 		Time complexity : O(n). Index j will iterate n times.
	 * 		Space complexity (HashMap) : O(min(m, n)). Same as the previous approach.
	 */
	public static int lengthOfLongestSubstringSlidingWindowHashMap(String s) {
        int n = s.length(), ans=0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int j=0, i=0; j<n; j++){
        	if(map.containsKey(s.charAt(j))){
        		i = Math.max(map.get(s.charAt(j)), i);
        	}
        	ans = Math.max(ans, j-i+1);
        	map.put(s.charAt(j), j+1);	
        }
		return ans;
	}
	
	/*
	 * Approach 3: Sliding Window Enhanced - using Table
	 * Complexity Analysis
	 * 		Time complexity : O(n). Index j will iterate n times.
	 * 		Space complexity (Table): O(m). m is the size of the charset.
	 */
	public static int lengthOfLongestSubstringSlidingWindowTable(String s) {
        int size = s.length(), ans=0;
        int[] position = new int[256];
        for(int j=0, i=0; j<size; j++){
       		i = Math.max(position[s.charAt(j)], i);
        	ans = Math.max(ans, j-i+1);
        	position[s.charAt(j)] = j+1;	
        }
		return ans;
	}

	public static void main(String[] args) {
		String str = "abcabcbb";
		System.out.println(lengthOfLongestSubstringBruteForce(str));
		System.out.println(lengthOfLongestSubstringSlidingWindow(str));
		System.out.println(lengthOfLongestSubstringSlidingWindowHashMap(str));
		System.out.println(lengthOfLongestSubstringSlidingWindowTable(str));
	}
}
