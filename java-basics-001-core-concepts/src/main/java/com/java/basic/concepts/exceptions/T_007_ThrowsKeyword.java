package com.java.basic.concepts.exceptions;

/**
 * 	->	In our program, if there is possibility of raising checked exception. Then compulsory we should
 * 		handle it otherwise we will get CE: unreported exception: XX; must be caught or declared to be thrown.
 * 	->	We can handle these CE errors by 2 ways:
 * 		1.	try-catch block
 * 		2.	throws keyword
 *
 * 	Using throws keyword:
 * 	--------------------
 * 	->	We can use throws keyword to delegate responsibility of exception handling to the caller (It may
 * 		be another method or JVM). Then caller method is responsible to handle that exception.
 * 	->	throws keyword is required only for checked exceptions and usage of throws keyword for unchecked
 * 		exceptions , there is no use or impact.
 * 	->	throws keyword is required only to convince compiler and usage of throws keyword doesn't prevent
 * 		abnormal termination of program.
 */
public class T_007_ThrowsKeyword {

	/*
	 * throws keyword is use to delegate responsibility. If not defined , we will get
	 * CE:unreported exception:java.lang.IE; must be caught or declared to be thrown
	 */
	public static class ExampleClass1 {

		public static void main(String[] args) throws InterruptedException {
			doStuff();
		}

		private static void doStuff() throws InterruptedException {
			doMoreStuff();
		}

		private static void doMoreStuff() throws InterruptedException {
			Thread.sleep(1000);
		}
	}

	/*
	 * Case 1 : We can use throws keyword for methods & constructors but not for classes.
	 */
	public static class ExampleClass2 //throws Exception //Invalid : CE- Syntax error
	{
		public ExampleClass2() throws Exception {}
		public void m1() throws Exception {}
	}

	/*
	 * Case 2 : We can use throws keyword only for Throwable types. If we try to use it for normal
	 * 			java classes, we will get CE : incompatible types
	 */
	public static class ExampleClass3 {

		public static class Example1 {
			public void m1() //throws Example1 //CE: incompatible types
			{}
		}

		public static class Example2 {
			public void m1() throws RuntimeException {}
		}
	}

	/*
	 *  Case 3 : if any method throws checked exception. It should be caught using try-catch or throws
	 * 			 keyword. Otherwise CE: unreported exception:Exception;must be caught or thrown
	 */
	public static class ExampleClass4 {
		public static class Example1 {
			public static void main(String[] args) {
				//throw new Exception(); //CE:Unhandled exception type Exception (checked exception)
			}
		}

		public static class Example2 {
			public static void main(String[] args) {
				throw new Error(); //unchecked exception so no CE but RE
			}
		}
	}

	/*
	 *  Case 4 : Within the try block, if there is no chance of raising any exception then we can't
	 *  		 write catch block for that exception. Otherwise we will get CE: Exception XX is
	 *  		 never thrown in the body of corresponding statement.
	 *  ->	But this rule is applicable only for"fully checked exception"
	 */
	public static class ExampleClass5 {
		public static class Example1 {
			public static void main(String[] args) {
				try {
					System.out.println("Hello");
				}
				catch (ArithmeticException e) {
					//Unchecked exception so no CE
				}
			}
		}

		public static class Example2 {
			public static void main(String[] args) {
				try {
					System.out.println("Hello");
				}
				catch (Exception e) {
					//Partially checked exception so no CE
				}
			}
		}

		public static class Example3 {
			public static void main(String[] args) {
				try {
					System.out.println("Hello");
				}
				catch (Error e) {
					//Unchecked exception so no CE
				}
			}
		}

		public static class Example4 {
			public static void main(String[] args) {
				try {
					System.out.println("Hello");
				}
				catch (Exception e) {
					//catch (IOException e) {
					//checked exception so  CE
				}
			}
		}

		public static class Example5 {
			public static void main(String[] args) {
				try {
					System.out.println("Hello");
				}
				catch (Exception e) {
					//catch (InterruptedException e) {
					//checked exception so  CE
				}
			}
		}
	}
}
