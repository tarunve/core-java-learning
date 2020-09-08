package com.java.basic.concepts.string;

/**
 * 	->	Once the String object is created ,we can't perform changes on the same object. If we try to
 * 		perform any change, a new object will be created in heap. If we are not performing any change
 * 		then new reference may refer the old object.
 *
 *	How to create a Immutable Class :
 *	-------------------------------
 * 	1.	Make your class final .
 *  2.	Make all instance variables private & final so that they are initialized once inside constructor
 *  	and never modified afterwards.
 *  3. 	Provide only getter methods , don't provide setter methods.
 *  4.  If your class holds mutable object , return a clone copy of field and never return the real object instance.
 * 
 *  ->	Do all properties of Immutable needs to be final ?
 *  	->	Yes, Once it is initialized in constructor . After that , nobody can change the value.
 *
 *  final v/s immutable concept
 *  ---------------------------
 *  ->	final - we can't re-assign the value simply. It talks about the variable/reference but not the object.
 *  ->	immutable - we can't change the value , if we try to change , a new object will be created. It talks
 *  				about the object but not the variable/reference.
 */
public class T_005_StringMutability {
	
	public static class ExampleClass1 {
		
		public static void main(String[] args) {
			String s1 = new String("tarun");
			String s2 = s1.toUpperCase();
			String s3 = s1.toLowerCase();
			System.out.println(s1 == s2); //false as new object will be created for the change
			System.out.println(s1 == s3); //true as it will refer existing object as no new change
			
			String s4 = "tarun";
			String s5 = s4.toString();
			String s6 = s4.toLowerCase();
			String s7 = s4.toUpperCase();
			System.out.println(s4 == s5);
			System.out.println(s4 == s6);
			System.out.println(s4 == s7);
		}
	}

	public static class ExampleClass2 {
		public static final class ImmutableClass1 {
			private final int i;
			
			public ImmutableClass1(int i) {
				this.i = i;
			}
			
			public ImmutableClass1 modify(int i) {
				if (this.i == i) {
					return this;
				}
				else {
					return new ImmutableClass1(i);
				}
			}
		}
		
		public static void main(String[] args) {
			ImmutableClass1 testObject = new ImmutableClass1(20);
			ImmutableClass1 newObject1 = testObject.modify(89);
			newObject1 = testObject.modify(100);
			ImmutableClass1 newObject2 = testObject.modify(20);
			System.out.println(testObject.i);
			System.out.println(newObject1.i);
			System.out.println(newObject2.i);
			System.out.println(testObject == newObject1);
			System.out.println(testObject == newObject2);
		}
	}
	
	/*
	 * Final v/s Immutable concept
	 */
	public static class ExampleClass3 {
		
		public static void main(String[] args) {
			final StringBuffer sb = new StringBuffer("durga");
			sb.append(" Software Soltions");
			System.out.println(sb.toString());
		}
	}
}
