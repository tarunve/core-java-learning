package com.java.basic.concepts.string;

/**
 * 	Constructors:
 * 	------------
 * 	1.	String s = new String();
 * 		-> creates an empty String object on the heap area.
 * 	2.	String s = new String(String literal);
 * 	3.	String s = new String(StringBuffer sb);
 * 		->	for given StringBuffer object, equivalent String object will be created
 * 	4.	String s = new String(StringBuilder sb);
 * 		->	for given StringBuilder object, equivalent String object will be created
 * 	5.	String s = new String(char[] ch)
 * 	6.	String s = new String(byte[] b)
 *
 * 	Methods:
 * 	-------
 * 	1.	public char charAt(int index)
 * 	2.	public String concat(String s)
 * 	3.	public boolean equals(Object s)
 * 		->	To check equality of String object
 * 	4.	public boolean equalsIgnoreCase(String s)
 * 	5.	public boolean isEmpty()
 * 	6.	public int length()
 * 	7.	public String replace(char old, char old)
 * 	8.	public String substring(int beginIndex)
 * 	9.	public String substring(int beginIndex, int endIndex)
 * 		->	return String from beginIndex to endIndex-1 .
 * 	10.	public int indexOf(char ch)
 * 		->	returns index of first occurrence of specified character.
 * 	11.	public int lastIndexOf(char ch)
 * 		->	returns index of last occurrence of specified character.
 * 	12.	public String toLowerCase()
 * 	13.	public String toUpperCase()
 * 	14.	public String trim()
 * 		->	To remove all the blank spaces at beginning or end of String.
 */
public class T_004_StringClass {
	
	/*
	 * Constructors
	 */
	public static class ExampleClass1 {
		
		public static void main(String[] args) {
			String s1 = new String();
			String s2 = new String("Tarun");
			String s3 = new String(new StringBuffer("Object1"));
			String s4 = new String(new StringBuilder("Object2"));
			String s5 = new String(new char[] { 'j', 'a', 'v', 97 });
			String s6 = new String(new byte[] { 97, 98, 99, 100 });
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
			System.out.println(s4);
			System.out.println(s5);
			System.out.println(s6);
		}
	}
	
	/*
	 * Methods
	 */
	public static class ExampleClass2 {
		
		public static void main(String[] args) {
			String s1 = new String();
			String s2 = new String("Tarun");
			String s6 = new String("tarun");
			String s3 = new String(new StringBuffer("Object1"));
			String s4 = new String(new StringBuilder("Object2"));
			String s5 = new String("           Object2       ");
			String s7 = new String("ababbbbabbababababababab");
			System.out.println(s1.isEmpty() + " " + s2.isEmpty());
			System.out.println(s2.length());
			System.out.println(s3.replace('e', 'b'));
			System.out.println(s4.substring(2));
			System.out.println(s4.substring(2, 4));
			System.out.println(s4.indexOf('2'));
			System.out.println(s7.lastIndexOf('a'));
			System.out.println(s4.toLowerCase());
			System.out.println(s5.trim());
			System.out.println(s7.charAt(7));
			//System.out.println(s7.charAt(50)); //RE : java.lang.StringIndexOutOfBoundsException: String index out of range: 50
			System.out.println(s2.concat(" Verma"));
			System.out.println(s2.equals(s6));
			System.out.println(s2.equalsIgnoreCase(s6));
		}
	}
}
