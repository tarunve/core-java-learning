package com.java.leetcode.problems;

import java.util.Scanner;

/*
 * Given are the heights of certain Buildings which lie adjacent to each other.
 * Sunlight starts falling from left side of the buildings. If there is a building
 * of certain Height, all the buildings to the right side of it having lesser heights
 * cannot see the sun . The task is to find the total number of such buildings that
 * receive sunlight.
 * Input: First Line of input contains an integer T denoting the number of test cases.
 * 		  Then T test cases follow. Each test case consists of two lines. First line of
 * 		  each test case contains an integer N denoting the number of buildings. Second
 * 		  line contains N space separated integers H1, H2,...HN denoting heights of buildings.
 * Output: Corresponding to each test case, print the desired output in a new line
 *
 * Constraints:
 * 1<=T<=100
 * 1<=N<=100
 * 1<=Hi<=100
 */
public class P_002_SunlightBuildingProblem {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		while (num > 0) {
			int n = s.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = s.nextInt();
			}
			int min = a[0];
			int count = 1;
			for (int i = 1; i < n; i++) {
				if (a[i] >= min) {
					count += 1;
					min = a[i];
				}
			}
			System.out.println(count);
			num--;
		}
		s.close();
	}

}
