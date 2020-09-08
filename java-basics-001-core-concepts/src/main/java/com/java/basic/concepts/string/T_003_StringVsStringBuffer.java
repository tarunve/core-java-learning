package com.java.basic.concepts.string;

/**
 * 	Differences
 * 	===========
 * 	->	String is immutable while StringBuffer is mutable i.e we can perform changes in already created
 * 		StringBuffer object.
 * 	->	In String class, equals() methods is meant for content comparison as it is overridden in String
 * 		class but in StringBuffer , it is meant for reference comparison as it is not overridden.
 */
public class T_003_StringVsStringBuffer {

	/*
	 *	Case 1 : String is immutable while StringBuffer is mutable.
	 */
	public static class ExampleClass1 {
		
		public static void main(String[] args) {
			String s = "Durga";
			s.concat(" Software Solutions");
			System.out.println(s);

			StringBuffer sb = new StringBuffer("Durga");
			sb.append(" Software Solutions");
			System.out.println(sb);
		}
	}

	/*
	 * 	Case 2 : Difference between String and StringBuffer "==" operation
	 */
	public static class ExampleClass2 {
		
		public static void main(String[] args) {
			String s1 = new String("Durga");
			String s2 = new String("Durga");
			System.out.println(s1 == s2);
			System.out.println(s1.equals(s2));

			StringBuffer sb1 = new StringBuffer("Durga");
			StringBuffer sb2 = new StringBuffer("Durga");
			System.out.println(sb1 == sb2);
			System.out.println(sb1.equals(sb2));
		}
	}
}
