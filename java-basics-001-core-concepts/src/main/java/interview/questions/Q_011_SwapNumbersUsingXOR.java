package interview.questions;

public class Q_011_SwapNumbersUsingXOR {
	/*
	 * How to swap 2 numbers using bitwise XOR operator.
	 */
	public static class SwapNumbersXOR {
		
		public static void main(String[] args) {
			Integer number1 = 5;
			Integer number2 = 10;
			System.out.println("Number1=" + number1 + ", Number2=" + number2);
			number1 = number1 ^ number2;
			number2 = number1 ^ number2;
			number1 = number1 ^ number2;
			System.out.println("Number1=" + number1 + ", Number2=" + number2);
			
			System.out.println(-5 >> 1);
		}
	}

}
