package com.java.basic.concepts.string;

/**
 * 	->	Every method present in StringBuffer is synchronized.
 * 	->	At a time, only one thread is allowed to operate on StringBuffer object. hence, it is Thread safe.
 * 	->	Threads are required to wait to operate on StringBuffer Object. Hence, relatively performance is slow.
 * 	->	Introduced in 1.0 version.
 *
 * 	Need of StringBuffer
 * 	--------------------
 * 	->	If content is always fixed and never going to change ,we can go for String. But if content is going to
 * 		change frequently , we should go for StringBuffer as no new object will be created in StringBuffer
 * 		rather append operation can be performed.
 * 		In case of StringBuffer , performance is going to be increased and memory efficient if the content is
 * 		going to change frequently.
 *
 * 	Constructors:
 * 	------------
 * 	1.	StringBuffer sb = new StringBuffer()
 * 		->	Empty string buffer with DEFAULT_CAPACITY = 16.
 * 		->	Once capacity is full, new object will be created with new capacity as below :
 * 				newCapacity = (currentCapacity + 1)*2
 * 	2.	StringBuffer sb = new StringBuffer(int initialCapacity);
 * 	3.	StringBuffer sb = new StringBuffer(String str)
 * 		->	String buffer with CAPACITY = DEFAULT_CAPACITY + str.length.
 * 	4.	StringBuffer sb = new StringBuffer(CharSequence seq)
 *
 * 	Methods
 * 	-------
 * 	1.	public int length()
 * 	2.	public int capacity()
 * 		->	how many character StringBuffer object can accommodate.
 * 	3.	public char charAt(int index)
 * 	4.	public void setCharAt(int index, char newChar)
 * 	5.	public StringBuffer append(String str)
 * 		->	append(Object o)
 * 		->	append(int i)
 * 		->	append(double d)
 * 		->	append(long l)
 * 		->	append(float f)
 * 		->	append(char[] ch)
 * 		->	append(boolean b)
 * 		and many more
 * 	6.`public StringBuffer insert(int index, String s)
 * 		->	insert(int index, Object s)
 * 		->	insert(int index, double s)
 * 		->	insert(int index, int s)
 *		->	insert(int index, long s)
 *		->	insert(int index, float s)
 *		->	insert(int index, ch s)
 *		->	insert(int index, char{} s)
 *		->	insert(int index, boolean s)
 *		->	insert(int index, String s)
 *		and some more
 *	7.	public String delete(int begin, int end)
 *		->	deleteChatAt(int index)
 *	8.	public void setLength(int length)
 *	9.	public void ensureCapacity(int capacity)
 *		->	if we want to increase capacity dynamicaaly
 *	10.
 */
public class T_006_StringBuffer {
	
	/*
	 * Constructors
	 */
	public static class ExampleClass1 {

		public static void main(String[] args) {
			StringBuffer sb = new StringBuffer();
			System.out.println(sb.capacity());
			sb.append("sihifjowiewjweojsdj");
			System.out.println(sb.capacity());

			StringBuffer sb1 = new StringBuffer(1000);
			System.out.println(sb1.capacity());
			
			StringBuffer sb2 = new StringBuffer(new String("Tarun"));
			System.out.println(sb2.capacity());
		}
	}
	
	/*
	 * Methods
	 */
	public static class ExampleClass2 {

		public static void main(String[] args) {
			StringBuffer sb = new StringBuffer();
			System.out.println(sb.capacity());
			sb.append("sihifjowiewjweojsdj");
			System.out.println(sb.length());
			System.out.println(sb.capacity());
			//System.out.println(sb.charAt(90)); // RE:StringOutOfBoundException
			sb.setCharAt(9, 'T');
			System.out.println(sb);
			sb.append(true);
			sb.append(3.14);
			sb.append(4646);
			sb.append(new char[] { 't', 'a', 'r', 'u', 'n' });
			sb.append("StringAppend");
			System.out.println(sb);

			sb.insert(3, "InsertAtIndex");
			sb.insert(16, true);
			sb.insert(20, 11111);
			sb.insert(25, 45.7636);
			sb.insert(33, 'c');
			System.out.println(sb);
			
			sb.delete(0, 3);
			sb.deleteCharAt(18);
			System.out.println(sb);
			
			StringBuffer sb2 = new StringBuffer("Tarun");
			sb2.reverse();
			System.out.println(sb2);
			
			StringBuffer sb3 = new StringBuffer("Tarun Verma");
			sb3.setLength(7);
			System.out.println(sb3);
			
			System.out.println(sb3.capacity());
			sb3.ensureCapacity(1000);
			System.out.println(sb3.capacity());

			StringBuffer sb4 = new StringBuffer();
			System.out.println(sb4.capacity());
			sb4.ensureCapacity(1000);
			System.out.println(sb4.capacity());
			sb4.trimToSize();
			System.out.println(sb4.capacity());
		}
	}
	
}
