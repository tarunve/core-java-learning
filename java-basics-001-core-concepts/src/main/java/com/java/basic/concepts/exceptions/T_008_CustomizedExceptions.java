package com.java.basic.concepts.exceptions;

/**
 * 	->	Sometimes, to meet programming requirement, we can define our own exceptions. Such type of
 * 		exceptions are called customized or user-defined exceptions.
 * 		Ex.	TooYoungException, TooOldException etc.
 *
 * 	Conclusions:
 * 	-----------
 * 	->	throw keyword is best suitable for customized exceptions.
 * 	->	It is highly recommended to define customized exception as unchecked i.e. we have to extends
 * 		RuntimeException but not Exception.
 * 	->	To make description available to default exception handler, super(s) is required.
 */
public class T_008_CustomizedExceptions {

	public static class TooYoungException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		
		public TooYoungException(String s) {
			super(s);
		}
	}

	public static class TooOldException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		
		public TooOldException(String s) {
			super(s);
		}
	}
	
	public static class CustExceptionDemo {
		
		public static void main(String[] args) {
			int age = 90;
			if (age > 60) {
				throw new TooOldException("Your age is already crossed marriage age.. No chance of getting match");
			}
			else if (age < 18) {
				throw new TooYoungException("Plz wait some time...You will get best match soon.");
			}
			else {
				System.out.println("You will get match details soon in email.");
			}
		}
	}
}
