package com.java.basic.concepts.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 	->	The following 2 concepts introduced:
 * 		1.	try with resources:
 * 			------------------
 * 			->	The main advantage of this enhancement is - whatever resource we opened as part of try block
 * 				will be closed automatically once control reaches end of try block either normally or
 * 				abnormally. Hence, we are not required to close explicitly so that complexity of program
 *				will be reduced.
 *			->	finally block need not be written(in case catch not present) so that length of code will be 
 *				reduced & readability improved.
 *
 *		Conclusions:
 *		-----------
 *		->	We can declare multiple resources but these resources should be separated by semicolon(;).
 *			Ex.	try(R1;R2;R3){}
 *		->	All resources should be AutoCloseable i.e. should implement AutoCloseable(I). All I/O resources
 *			and network related resources are already implemented with AutoCloseable(I). AutoCloseable came
 *			in 1.7 version and it contains only 1 method- public void close()
 *		->	All resources reference variables are implicitly final and hence within the try block, we can't
 *			perform re-assignment otherwise we will get CE: auto-close able resource may not be assigned.
 *
 *		2.	multi-catch block
 *			-----------------
 *			->	We can write a single catch block that can handle multiple different type of exception.
 *			->	Main advantage is - length of code will be reduced & readability will be increased.
 *			->	There should not be any relation between exception types in multi-catch block (either parent
 *				-> child, child->parent, same type). Otherwise CE: alternatives in a multi-catch statement
 *				can't be related to sub-classing.
 */
public class T_009_Java7Enhancements {

	/*
	 * try-with-resource
	 * We need not to write finally block
	 */
	public static class ExampleClass1 {

		public static void main(String[] args) {
			try (BufferedReader br = new BufferedReader(new FileReader(""))) {

			}
			catch (FileNotFoundException e) {}
			catch (IOException e) {}
		}
	}

	/*
	 * Conclusions
	 */
	public static class ExampleClass2 {
		
		public static class Resource1 implements AutoCloseable {

			@Override
			public void close() throws Exception {
				System.out.println("Close Method for Resource1");
			}
		}
		
		public static class Resource2 implements AutoCloseable {

			@Override
			public void close() throws Exception {
				System.out.println("Close Method for Resource1");
			}
		}
		
		public static class Resource3 implements AutoCloseable {

			@Override
			public void close() throws Exception {
				System.out.println("Close Method for Resource1");
			}
		}

		public static void main(String[] args) throws Exception {
			//1st, 2nd conclusion
			try (Resource1 r1 = new Resource1(); Resource2 r2 = new Resource2(); Resource3 r3 = new Resource3()) {}
			catch (Exception e) {}

			//3rd conclusion
			try (Resource1 r1 = new Resource1()) {
				//r1 = new Resource1(); //CE:The resource r1 of a try-with-resources statement cannot be assigned
			}
		}
	}
	
	/*
	 * multi-catch block
	 */
	public static class ExampleClass3 {

		public static void main(String[] args) {
			try (BufferedReader br = new BufferedReader(new FileReader(""))) {
				Thread.sleep(1000);
			}
			catch (IOException | InterruptedException e) {}
		}
	}
	
}
