package com.java.enhancements;

import static java.lang.System.err;

/**
 *	->	Suppressed exceptions, as name suggest, are exceptions thrown in the code but were ignored somehow. If you 
 *		remember try-catch-finally block execution sequence and how they return any value or exceptions, you will 
 *		recall that exceptions thrown in finally block are suppressed if an exception is thrown in try block also.
 *	->	Before java 7, we were informed about these exceptions by logging if implemented, but you didn’t have any 
 *		control over these types of exceptions once finally block is over. Well, with new features in Java 7, you 
 *		got control over these suppressed exceptions as well.
 *
 *	What are suppressed exceptions?
 *	==============================
 *	->	In Java 7, perhaps the most common use case for encountering suppressed exceptions is when a try-with-resources 
 *		statement. When we encounter an exception within the try block, application tries to close the resource. If it 
 *		encounters multiple exceptions which may occur while closing AutoCloseable resources, additional exceptions are 
 *		attached to a primary exception as suppressed exceptions.
 *	->	To support suppressed exceptions, a new constructor and two new methods were added to the Throwable class 
 *		(parent of Exception and Error classes) in JDK 7.
 *			Throwable.getSupressed(); // Returns Throwable[]
 *			Throwable.addSupressed(aThrowable);
 *
 *	Suppressed exception example
 *	============================
 *	->	For example while writing to output stream, an exception can be thrown from the try block, and up to two 
 *		exceptions can be thrown from the try-with-resources statement when it tries to close the stream.
 *	->	If an exception is thrown from the try block and one or more exceptions are thrown from the try-with-resources 
 *		statement, then those exceptions thrown from the try-with-resources statement are suppressed, and the exception 
 *		thrown by the block is the one that is thrown by the closeStream() method.
 *	->	You can retrieve these suppressed exceptions by calling the Throwable.getSuppressed() method from the exception 
 *		thrown by the try block.
 */
public class E_005_SuppressedExceptions {

	/*
	 * AutoCloseable Resource
	 */
	public static class DirtyResource implements AutoCloseable {
		/**
		 * Need to call this method if you want to access this resource
		 * @throws RuntimeException no matter how you call this method
		 * */
		public void accessResource() {
			throw new RuntimeException("I wanted to access this resource. Bad luck. Its dirty resource !!!");
		}

		/**
		 * The overridden closure method from AutoCloseable interface
		 * @throws Exception which is thrown during closure of this dirty resource
		 * */
		@Override
		public void close() throws Exception {
			throw new NullPointerException("Remember me. I am your worst nightmare !! I am Null pointer exception !!");
		}
	}

	/*
	 * Before Java 7, No way to see the Suppressed Exception.
	 */
	public static class SuppressedExceptionDemoWithTryFinallyBeforeJava7 {
		/**
		* Executable member function demonstrating suppressed exceptions
		* One exception is lost if not added in suppressed exceptions list
		*/
		public static void memberFunction() throws Exception {
			DirtyResource resource = new DirtyResource();
			try {
				resource.accessResource();
			} finally {
				resource.close();
			}
		}

		public static void main(String[] arguments) throws Exception {
			try {
				memberFunction();
			} catch (Exception ex) {
				err.println("Exception encountered: " + ex.toString());
				final Throwable[] suppressedExceptions = ex.getSuppressed();
				final int numSuppressed = suppressedExceptions.length;
				if (numSuppressed > 0) {
					err.println("\tThere are " + numSuppressed + " suppressed exceptions:");
					for (final Throwable exception : suppressedExceptions) {
						err.println("\t\t" + exception.toString());
					}
				}
			}
		}
	}

	/*
	 * 	After Java 7, We can get the suppressed exception using :
	 * 	->	Throwable.getSupressed(); // Returns Throwable[]
	 *	->	Throwable.addSupressed(aThrowable);
	 */
	public static class SuppressedExceptionDemoWithTryFinallyAfterJava7 {
		/**
		* Executable member function demonstrating suppressed exceptions
		* Suppressed expression is added back in primary exception
		*/
		public static void memberFunction() throws Exception {
			Throwable th = null;
			DirtyResource resource = new DirtyResource();
			try {
				resource.accessResource();
			} catch (Exception e) {
				th = e;
			} finally {
				try {
					resource.close();
				} catch (Exception e) {
					if (th != null) {
						e.addSuppressed(th); //Add to primary exception
						throw e;
					}
				}
			}
		}

		/**
		* Executable function demonstrating suppressed exceptions.
		*/
		public static void main(String[] arguments) throws Exception {
			try {
				memberFunction();
			} catch (Exception ex) {
				err.println("Exception encountered: " + ex.toString());
				final Throwable[] suppressedExceptions = ex.getSuppressed();
				final int numSuppressed = suppressedExceptions.length;
				if (numSuppressed > 0) {
					err.println("\tThere are " + numSuppressed + " suppressed exceptions:");
					for (final Throwable exception : suppressedExceptions) {
						err.println("\t\t" + exception.toString());
					}
				}
			}
		}
	}

	/*
	 * Get Suppressed Exception Using Try Catch block.
	 */
	public static class SuppressedExceptionDemoWithTryCatch {
		public static void memberFunction() throws Exception {
			try (DirtyResource resource = new DirtyResource()) {
				resource.accessResource();
			}
		}

		/**
		* Executable member function demonstrating suppressed exceptions using try-with-resources
		*/
		public static void main(String[] arguments) throws Exception {
			try {
				memberFunction();
			} catch (Exception ex) {
				err.println("Exception encountered: " + ex.toString());
				final Throwable[] suppressedExceptions = ex.getSuppressed();
				final int numSuppressed = suppressedExceptions.length;
				if (numSuppressed > 0) {
					err.println("tThere are " + numSuppressed + " suppressed exceptions:");
					for (final Throwable exception : suppressedExceptions) {
						err.println("tt" + exception.toString());
					}
				}
			}
		}
	}

	/*
	 * 	Suppressed Exception using new Try With Resource
	 */
	public static class SuppressedExceptionDemoWithTryWithResource {
		/**
		* Demonstrating suppressed exceptions using try-with-resources
		*/
		public static void main(String[] arguments) throws Exception {
			try (DirtyResource resource = new DirtyResource()) {
				resource.accessResource();
			}
		}
	}
}
