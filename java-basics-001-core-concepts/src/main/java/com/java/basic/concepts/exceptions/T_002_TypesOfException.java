package com.java.basic.concepts.exceptions;

/**
 * 	Checked Exceptions
 * 	------------------
 * 	->	The exceptions which are checked by compiler for smooth execution of program are called as
 * 		checked exceptions.
 * 		Ex.	FileNotFoundException, IOException etc.
 * 	->	In our program, if there is chance of raising checked exception then compulsory we should
 * 		handle that checked exception (by try/catch or throws keyword) otherwise we will get CE.
 *
 * 	Unchecked Exceptions
 * 	------------------
 * 	->	The exceptions which are not checked by compiler whether programmer is handling it or not.
 * 		Such type of exceptions are called unchecked exceptions.
 * 		Ex.	ArithmeticException, NullPointerException, ClassCastException etc.
 *
 * 	Fully checked exceptions
 * 	------------------------
 * 	->	Checked exceptions are said to be fully checked if and only if all its child classes are
 * 		also checked.
 * 		Ex.	IOException, InterruptedException etc.
 *
 * 	Partial checked exceptions
 * 	--------------------------
 * 	->	Checked exceptions are said to be partial checked if and only if some of its child classes
 * 		are unchecked.
 * 		Ex.	Exception, Throwable etc.
 *
 * 	NOTES:
 * 	=====
 * 	->	Whether it is checked or unchecked, every exception occurs at runtime. There is no chance
 * 		of occurring any exception at compile time.
 * 	->	RuntimeException & its child classes, Error and its child classes are unchecked. Except
 * 		these, remaining are checked exceptions.
 * 	->	The only possible partial checked exceptions are : Exception, Throwable.
 *
 * 	Examples:
 * 	--------
 * 		IOException				:	checked (fully)
 * 		RuntimeException		:	unchecked
 * 		InterruptedException	:	checked (fully)
 * 		Error					:	unchecked
 * 		Throwable				:	checked (partially)
 * 		ArithmeticException		:	unchecked
 * 		NullPointerException	:	unchecked
 * 		Exception				:	checked (partially)
 * 		FileNotFoundException	:	checked (fully)
 *
 */
public class T_002_TypesOfException {
	
}
