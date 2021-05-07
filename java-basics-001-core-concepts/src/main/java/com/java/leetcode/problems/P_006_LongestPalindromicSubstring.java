package com.java.leetcode.problems;


/*
 * Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * Example 1:	
 * 		Input: "babad"
 * 		Output: "bab"
 * 		Note: "aba" is also a valid answer.
 */
public class P_006_LongestPalindromicSubstring {
	
	//Brute Force - O(n^3)   :: Time limit exceeded
	public static String longestPalindromeBruteForce(String s) {
		int n = s.length();
		String subStr = "";
		if(n<2)
			return s;
        for(int i=0; i<n ; i++){
        	for(int j=i+1; j<n ; j++){
        		int start =i, end =j;
        		while(start<end){
        			if(s.charAt(start) != s.charAt(end))
        				break;
        			start++;
        			end--;
        		}
        		if(start>=end && j-i+1 > subStr.length())
        			subStr = s.substring(i, j+1);
        	}
        }
        if(subStr.equals(""))
        	subStr = s.substring(0,1);
        return subStr;
    }

	public static void main(String[] args) {
		String str = "tfccfttgbbgt";
		System.out.println(longestPalindromeBruteForce(str));
		System.out.println(longestPalindromeBruteForce("kdijiewjdweffffgggggffffdkw"));
		System.out.println(longestPalindromeBruteForce("yyyyyyyyyyyy"));
		System.out.println(longestPalindromeBruteForce("a"));
		System.out.println(longestPalindromeBruteForce("ac"));
	}
}
