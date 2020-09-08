package com.java.basic.concepts.string;

/**
 * 	Advantage of String Constant Pool
 * 	---------------------------------
 * 	->	String is most common type everywhere in real world so no need to create separate object , we can
 * 		share the same object created in SCP to other references.
 * 	->	Memory utilization is improved and performance will be increased.
 *
 * 	Disadvantage of SCP
 * 	-------------------
 * 	->	Since same object can be referenced from multiple references. If one reference tries to change the
 * 		value , it can affect all the references for the same object.
 * 		To resolve this problem, Sun people came up with immutability concept in String.
 */
public class T_002_StringConstantPoolExamples {
	
	/*
	 * String Objects Creation Heap and String Constant Pool (SCP) : Example 1
	 */
	public static class ExampleClass1 {

		public static void main(String[] args) {
			String s = new String("Spring");
			s.concat("Fall");
			String s2 = s.concat("Winter");
			s2.concat("Summer");
			System.out.println(s);
			System.out.println(s2);
		}
	}

	/*
	 * String Objects Creation Heap and String Constant Pool (SCP) : Example 2
	 * ->	If concatenation will happen between 2 constants, then it will happen at compile time.
	 * ->	If at least one is variable then concatenation will happen at Runtime.
	 */
	public static class ExampleClass2 {

		public static void main(String[] args) {
			String s1 = new String("You can't change me");
			String s2 = new String("You can't change me");
			System.out.println(s1 == s2); //false

			String s3 = "You can't change me";
			System.out.println(s1 == s3); //false

			String s4 = "You can't change me";
			System.out.println(s3 == s4); //true

			//Since both are constant so concatenation will happen at Compile time and it will be same as s3, s4
			String s5 = "You can't " + "change me";
			System.out.println(s4 == s5); //true
			
			//Since s6 is variable so concatenation will happen at Runtime
			String s6 = "You can't ";
			String s7 = s6 + "change me";
			System.out.println(s4 == s7); //false
			
			final String s8 = "You can't ";
			String s9 = s8 + "change me";
			System.out.println(s4 == s9); //true
		}
	}

}
