package com.java.enhancements;

/**
 *	Improved catch block in Java 7
 *	==============================
 *	->	In this feature, now you can catch multiple exceptions in single catch block. Before Java 7, it was 
 *		restricted to catch only one exception per catch block.
 *	->	To specify the list of expected exceptions a pipe (‘|’) character is used.
 *
 *	Redundant throws clause in Java 7
 *	================================
 *	->	This feature liberate you from using throws clause in method declaration.
 */
public class E_006_ExceptionHandling {

	public static class MultipleExceptionsInCatchBlock {

		public static void main(String[] args) {
			sampleMethod();
		}

		public static void sampleMethod()
		//throws Throwable  //No need to do this
		{
			try {
				//Do some processing which throws NullPointerException; I am sending directly
				throw new NullPointerException();
			}
			//You can catch multiple exception added after 'pipe' character
			catch (NullPointerException | IndexOutOfBoundsException ex) {
				throw ex;
			}
			//Now method sampleMethod() do not need to have 'throws' clause
			catch (Throwable ex) {
				throw ex;
			}
		}
	}
}
