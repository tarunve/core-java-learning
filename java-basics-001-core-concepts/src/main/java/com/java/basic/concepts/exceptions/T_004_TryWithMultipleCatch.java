package com.java.basic.concepts.exceptions;

/**
 * 	->	The way of handling an exception is varied from exception to exception. Hence, for every exception
 * 		type, it is highly recommended to take separate catch block i.e. try with multiple catch block is
 * 		always possible and recommended to use.
 * 	->	If try with multiple catch block present then the order of catch block is important. We have to
 * 		take child first and then parent. Otherwise we will get CE:	Exception XX has already been caught.
 * 	->	We can't declare 2 catch blocks for the same exception otherwise we will get CE: same as above.
 */
public class T_004_TryWithMultipleCatch {
	
	/*
	 * try with multiple catch block : best practice
	 */
	public static class ExampleClass1 {

		public static void main(String[] args) {
			try {
				System.out.println(10 / 0);
			}
			catch (ArrayIndexOutOfBoundsException e) {}
			catch (ArithmeticException e) {}
			catch (Exception e) {}
		}
	}

	/*
	 * in catch block order child should come first.
	 */
	public static class ExampleClass2 {

		public static void main(String[] args) {
			try {
				System.out.println(10 / 0);
			}
			//catch (Exception e) {} //CE:	Exception XX has already been caught.
			catch (ArrayIndexOutOfBoundsException e) {}
			catch (ArithmeticException e) {}
			catch (Exception e) {}
		}
	}

	/*
	 * in catch block order we can't declare same exception 2 times.
	 */
	public static class ExampleClass3 {

		public static void main(String[] args) {
			try {
				System.out.println(10 / 0);
			}
			//catch (ArrayIndexOutOfBoundsException e) {} //CE:	Exception XX has already been caught.
			catch (ArrayIndexOutOfBoundsException e) {}
			catch (ArithmeticException e) {}
			catch (Exception e) {}
		}
	}
}
