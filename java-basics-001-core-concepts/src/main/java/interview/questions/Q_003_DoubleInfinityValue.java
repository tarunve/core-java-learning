package interview.questions;

/*
 * 1) What happens when double is divided by 0.0. Integer (a/0) will throw exception - what about double.
 * 		It returns +Infinity , -Infinity , NaN (not a number). Same in the case of Float.
 *
 * 2) How to handle the above scenario .
 * 		Wrapper class provide methods - isInfinite(), isNaN() to check if it is infinite.
 */

public class Q_003_DoubleInfinityValue {

	public static void main(String[] args) {
		Double d = -100 / 0.0;
		System.out.println(d);

		Double d1 = 0.0 / 0.0;
		System.out.println(d1);

		double numArray[] = { 9.0, 34.0, 0.0, 125.0, 123 };
		for (double divisor : numArray) {
			double d2 = 125.0 / divisor;
			if (!Double.isInfinite(d2)) {
				double d3 = d2 * 100;
				System.out.print(d3 + " ");
			}
		}

		System.out.println();
		int i = 100 / 0;
		System.out.println(i);
	}
}
