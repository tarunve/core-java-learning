package com.java.basic.concepts.exceptions;

/**
 * 	->	An unwanted, unexpected event that disturbs normal flow of the program is called Exception.
 * 		Ex.	FileNotFoundException.
 * 	->	It is highly recommended to handle exceptions and main objective of exception handling is
 * 		graceful termination of program.
 * 	->	Exception handling doesn't mean repairing an exception. We have to provide alternative way
 * 		to continue with the rest of the program normally - is the concept of exception handling.
 * 	->	For every thread, JVM will create a runtime stack. Each entry of method call in stack is
 * 		called StackFrame or activation record. After completing all method calls, stack will become
 * 		empty and it will be destroyed by JVM just before termination.
 *
 * 	Default Exception Handler:
 * 	-------------------------
 * 	->	Inside a method, if any exception occurs, the method in which it is raised is responsible to
 * 		create Exception object by including the following info:
 * 		->	Name of Exception
 * 		->	Description of exception
 * 		->	location at which exception occurred.
 * 	->	After creating the exception object, method hand over that object to JVM. JVM will check if
 * 		any handling is done in methods else it hand over responsibility of exception handling to
 * 		default exception handler.
 * 	->	Default Exception handler prints exception information in below format to console & terminate
 * 		program abnormally.
 * 			->	Exception in thread "XX" "Name of Exception": Description (StackTrace below)
 *
 *  Java Exception Hierarchy:
 *  ------------------------
 *  ->	Throwable class acts as root for Java Exception Hierarchy.
 *  ->	Throwable class defines 2 child classes :
 *  	1.	Exception:	Most of the time, exceptions are caused by our program and these are recoverable.
 *  		---------	Ex.	FileNotFoundException. If it occurs, we can provide local file & continue.
 *
 *  	2.	Error:	Most of the times, Errors are not caused by our program and these are due to lack
 *  		-----	of system resources. Errors are non-recoverable.
 *  				Ex.	OutOfMemoryError.
 */
public class T_001_ExceptionsOverview {

	public static void main(String[] args) {
		doStuff();
	}
	
	private static void doStuff() {
		doMoreStuff();
	}
	
	private static void doMoreStuff() {
		System.out.println(10 / 0);
	}

}
