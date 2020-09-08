package com.java.random;

/**
 * 	->	Only applicable to integral types.
 *
 * 	Bitwise OR(|) :	This operator is binary operator, denoted by ‘|’. It returns bit by
 * 	------------	bit OR of input values, i.e, if either of the bits is 1, it gives 1,
 * 					else it gives 0.
 * 	Bitwise AND(&):	This operator is binary operator, denoted by ‘&’. It returns bit by
 * 	--------------	bit AND of input values, i.e, if both bits are 1, it gives 1, else
 * 					it gives 0
 * 	Bitwise XOR(^):	This operator is binary operator, denoted by ‘^’. It returns bit by
 * 	--------------	bit XOR of input values, i.e, if corresponding bits are different,
 * 					it gives 1, else it gives 0
 * 	Bitwise Complement (~):	This operator is unary operator, denoted by ‘~’. It returns
 * 	---------------------	the one’s compliment representation of the input value, i.e,
 * 							with all bits inverse, means it makes every 0 to 1, and every 1 to 0.
 * 	Note – Compiler will give 2’s complement of that number, i.e., 2’s compliment of 10 will be -6.
 * 	====
 * 	Signed Right shift operator (>>):	Shifts the bits of the number to the right and fills
 * 	-------------------------------		0 on voids left as a result. The leftmost bit depends
 * 										on the sign of initial number. Similar effect as of
 * 										dividing the number with some power of two.
 * 	Unsigned Right shift operator (>>>):	Shifts the bits of the number to the right and fills
 * 	-----------------------------------		0 on voids left as a result. The leftmost bit is set
 * 											to 0. (>>>) is unsigned-shift; it’ll insert 0. (>>)
 * 											is signed, and will extend the sign bit.
 * 	Left shift operator (<<):	Shifts the bits of the number to the left and fills 0 on voids
 * 	------------------------	right as a result. Similar effect as of multiplying the number
 * 								with some power of two.
 * 	Unsigned Left shift operator (<<<):	Unlike unsigned Right Shift, there is no “<<<" operator
 * 	---------------------------------	in Java, because the logical (<<) and arithmetic
 * 										left-shift (<<<) operations are identical.
 */
public class T_001_BitwiseOperators {
	
	static class BitWiseLogicalOperators {
		public static void main(String[] args) {
			//Initial values
			int a = 5;
			int b = 7;

			// bitwise and
			// 0101 & 0111=0101 = 5
			System.out.println("a&b = " + (a & b));

			// bitwise or
			// 0101 | 0111=0111 = 7
			System.out.println("a|b = " + (a | b));

			// bitwise xor
			// 0101 ^ 0111=0010 = 2
			System.out.println("a^b = " + (a ^ b));

			// if negation(~) - inversion is positive number , then result is written directly
			// if negation(~) - inversion is negation number , then result is 2's complement
			System.out.println("~c = " + ~(5));
			System.out.println("~c = " + ~(-11));
			System.out.println(Integer.toBinaryString(43));
			// can also be combined with
			// assignment operator to provide shorthand
			// assignment
			// a=a&b
			a &= b;
			System.out.println("a= " + a);
		}
	}

	static class BitWiseShiftOperators {
		public static void main(String[] args) {

			int a = 5;
			int b = -10;

			// left shift operator
			// 0000 0101<<2 =0001 0100(20)
			// similar to 5*(2^2)
			System.out.println("a<<2 = " + (a << 2));

			// right shift operator
			// 0000 0101 >> 2 =0000 0001(1)
			// similar to 5/(2^2)
			System.out.println("b>>2 = " + (a >> 2));

			// unsigned right shift operator
			System.out.println("b>>>2 = " + (b >>> 2));
		}
	}

}
