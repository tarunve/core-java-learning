package com.java.basic.concepts.string;

/**
 * 	->	String is immutable i.e. we can't perform any changes in already created string object.
 * 	->	If we try perform any operation (like concat(String)) , it will create another string object.
 *
 * 	FAQs
 * 	----
 * 	1.	Why SCP concept is available only for String object but not for StringBuffer?
 * 		-> String is the most commonly used object in Java. that's why special memory management is there.
 * 	2.	Why String objects are immutable  where as StringBuffer objects are mutable?
 * 		-> Because of SCP concept. If one reference tries to change the object, it may affect other references
 * 		   also. That's why String is immutable. For StringBuffer, SCP concept is not there so every time
 * 		   new object will be created. And hence StringBuffer is mutable because there will be no effect
 * 		   on other references.
 * 	3.	In addition to String objects, any other objects are immutable in Java?
 * 		->	All wrapper class objects also are immutable. Ex. Integer, Long, Byte, Short, Float, Double,
 * 			Character, Boolean, String etc.
 */
public class T_001_StringOverview {

	public static void main(String[] args) {
		String s = "Durga";
		s.concat(" Software Solutions");
		System.out.println(s);
		
		String str = s.concat(" Software Solutions");
		System.out.println(str);
	}
}
