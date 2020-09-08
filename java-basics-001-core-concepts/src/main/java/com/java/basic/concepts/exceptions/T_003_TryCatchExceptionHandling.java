package com.java.basic.concepts.exceptions;

/**
 * 	->	It is highly recommended to handle exceptions.
 * 	->	The code which may raise an exception is called risky code and we have to define that code
 * 		inside try block & corresponding handling code in catch block.
 * 	->	Within the try block, if anywhere an exception is raised then rest of the try block will
 * 		not be executed even though we handled that exception. Hence, we should write only risky
 * 		code inside try block.
 * 	->	If any statement which is not in try block & raises an exception, it is always abnormal
 * 		termination.
 *
 * 	Methods to print exception information:
 * 	--------------------------------------
 * 	->	Throwable class defines following methods to print information of exception:
 * 	1.	printStackTrace()	:	Name of exception: Description (StackTrace below)
 * 	2.	toString()			:	Name of exception: Description
 * 	3.	getMessage()		:	Description
 *
 * 	->	Internally default exception handler uses printStackTrace() method to print information.
 */
public class T_003_TryCatchExceptionHandling {

	/*
	 * Handling with try-catch - Normal termination
	 */
	public static class ExampleClass1 {

		public static void main(String[] args) {
			System.out.println("Program starts...");
			try {
				System.out.println(10 / 0);
			}
			catch (ArithmeticException e) {
				System.out.println(10 / 2);
			}
			System.out.println("Program ends...");
		}
	}

	/*
	 * Control flow in try-catch
	 * Case 1 : If there is no exception : Normal Termination
	 */
	public static class ExampleClass2 {

		public static void main(String[] args) {
			System.out.println("Program starts...");
			try {
				System.out.println(10 / 5);
			}
			catch (ArithmeticException e) {
				System.out.println(10 / 2);
			}
			System.out.println("Program ends...");
		}
	}
	
	/*
	 * Control flow in try-catch
	 * Case 2 : If there is exception raised in try block and corresponding catch block matched
	 * 			Normal Termination
	 */
	public static class ExampleClass3 {

		public static void main(String[] args) {
			System.out.println("Program starts...");
			try {
				System.out.println(10 / 0);
			}
			catch (ArithmeticException e) {
				System.out.println(10 / 2);
			}
			System.out.println("Program ends...");
		}
	}
	
	/*
	 * Control flow in try-catch
	 * Case 3 : If there is exception raised in try block and corresponding catch block not matched
	 * 			Abnormal Termination
	 */
	public static class ExampleClass4 {

		public static void main(String[] args) {
			System.out.println("Program starts...");
			try {
				System.out.println(10 / 0);
			}
			catch (NullPointerException e) {
				System.out.println(10 / 2);
			}
			System.out.println("Program ends...");
		}
	}

	/*
	 * Control flow in try-catch
	 * Case 4 : If there is exception raised in catch block or outside try-catch : Abnormal Termination
	 */
	public static class ExampleClass5 {

		public static void main(String[] args) {
			System.out.println("Program starts...");
			try {
				System.out.println(10 / 0);
			}
			catch (ArithmeticException e) {
				throw new NullPointerException();
			}
			System.out.println("Program ends...");
		}
	}

	/*
	 * Methods to print information
	 */
	public static class ExampleClass6 {

		public static void main(String[] args) {
			System.out.println("Program starts...");
			try {
				System.out.println(10 / 0);
			}
			catch (ArithmeticException e) {
				System.out.println(e.getMessage());
				System.out.println(e.toString());
				e.printStackTrace();
			}
			System.out.println("Program ends...");
		}
	}
}
