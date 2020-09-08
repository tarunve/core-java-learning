package com.java.enhancements;

/**
 *	->	Java 7 has improved number literal formatting in very pleasant manner through allowing underscore in number.
 *		It makes reading number easy and when we write numeric literals in application logs, they look good.
 *	->	For example, if we have to read a number “1000000“, then how much convenient it read in first sight. Not much, right??
 *	->	We have a habit of reading numbers in 10,00,000 format. Good news is that  java has started supporting to write 
 *		numbers in this format. Well, not exactly this but a matching format.
 *
 *	Notes:
 *	=====
 *	->	Underscores can be placed only between digits. We cannot put underscore next to decimal separator ‘dot’.
 *	->	Consecutive underscores are allowed. ’10___00′ is a valid number.
 *	->	To put underscore at the last of number is not allowed. ‘1000_’ is NOT a valid number. It will generate compile time error.
 *	->	In Java, underscore in front of variable name is allowed. Be careful, when you put a underscore in start of number. 
 *		It a variable, not a number.
 */
public class E_004_NumberFormatting {

	public static class ImprovedNumbersInJava7 {
		@SuppressWarnings("unused")
		public static void main(String[] args) {
			/**
			 * Supported in int
			 * */
			int improvedInt = 10_00_000;

			/**
			 * Supported in float
			 * */
			float improvedFloat = 10_00_000f;

			/**
			 * Supported in long
			 * */
			long improvedLong = 10_00_000l;

			/**
			 * Supported in double
			 * */
			double improvedDouble = 10_00_000D;
		}
	}
}
