package com.java.basic.concepts.exceptions;

/**
 * 	->	We can create Exception object explicitly and can hand over to JVM manually. FOr this we have
 * 		to use "throw" keyword.
 * 		Ex.	throw new ArithmeticException("/ by zero");
 *	->	Hence, the main objective of throw keyword is to hand over our created Exception object to JVM.
 *	->	The best use of "throw" keyword is for user-defined or customized exceptions.
 *
 */
public class T_006_ThrowKeyword {
	/*
	 * Case 1 : If exception(e) refers null then we will get NPE
	 */
	public static class ExampleClass1 {

		static ArithmeticException e;

		public static void main(String[] args) {
			throw e;
		}
	}
	
	/*
	 * Case 2 : After throw statement we are not allowed to write any statement directly. Otherwise we
	 * 			will get CE: unreachable statement.
	 */
	public static class ExampleClass2 {

		public static void main(String[] args) {
			throw new ArithmeticException("/ by zero");
			//System.out.println("Hi");        //CE: unreachable statement
		}
	}

	/*
	 * Case 3 : We can use throw keyword only for Throwable types. If we are trying to use it for normal
	 * 			Java object, we will get CE: incompatible types.
	 */
	public static class ExampleClass3 {

		public static void main(String[] args) {
			//throw new ExampleClass3();  //CE: ExampleClass3 must be subclass of Throwbale.
		}
	}
}
