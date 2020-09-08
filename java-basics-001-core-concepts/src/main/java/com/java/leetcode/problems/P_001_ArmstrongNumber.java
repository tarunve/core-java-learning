package com.java.leetcode.problems;

public class P_001_ArmstrongNumber {

	public int power(int k, int n) {
		if (n == 0)
			return 1;
		else if (n % 2 == 0)
			return power(k, n / 2) * power(k, n / 2);
		else
			return k * power(k, n / 2) * power(k, n / 2);
	}

	public int digits(int k) {
		int n = 0;
		while (k != 0) {
			n++;
			k = k / 10;
		}
		return n;
	}

	public boolean isArmstrong(int k) {
		int n = digits(k);
		int sum = 0, temp = k;
		while (temp != 0) {
			int r = temp % 10;
			sum = sum + power(r, n);
			temp = temp / 10;
		}

		return (sum == k);
	}

	public static void main(String[] args) {
		P_001_ArmstrongNumber obj = new P_001_ArmstrongNumber();
		System.out.println(obj.isArmstrong(153));

	}
}
