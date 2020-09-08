package com.java.basic.concepts.string;

/**
 * 	->	Every method present in StringBuilder is not synchronized.
 * 	->	At a time, multiple thread is allowed to operate on StringBuilder object. hence, it is not Thread safe.
 * 	->	Threads are not required to wait to operate on StringBuilder Object. Hence, relatively performance is high.
 * 	->	Introduced in 1.5 version.
 * 	->	All the methods and constructors are copy pasted in StringBuilder from StringBuffer but not synchronized.
 *
 * 	Method Chaining
 * 	--------------
 * 	->	 Since return type is same StringBuilder so multiple methods can be used at a time.
 */
public class T_007_StringBuilder {

	public static class ExampleClass1 {
		
		public static void main(String[] args) {
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.capacity());
			sb.append("sihifjowiewjweojsdj");
			System.out.println(sb.capacity());

			StringBuilder sb2 = new StringBuilder();
			sb2.append("Tarun").append(" ").append("Verma").append(007).reverse();
			System.out.println(sb2);
		}
	}

}
