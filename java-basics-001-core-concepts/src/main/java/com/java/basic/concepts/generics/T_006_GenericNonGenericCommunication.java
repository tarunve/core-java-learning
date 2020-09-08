package com.java.basic.concepts.generics;

import java.util.ArrayList;

/**
 * 	->	If we send Generic object to Non-Generic area then it starts behaving like Non-Generic Object.
 * 		Similarly, If we send Non-Generic to Generic area, it starts behaving like Generic object.
 */
@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class T_006_GenericNonGenericCommunication {
	/*
	 * Communication from Generic->Non-Generic , Non-Generic->Generic
	 */
	static class CommClass1 {

		public static void main(String[] args) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("A");
			list.add("B");
			//list.add(10); //CE: Incompatible Types
			method(list);
			System.out.println(list);
			//list.add(10.5); //CE: Incompatible Types
		}
		
		private static void method(ArrayList list) {
			list.add(10);
			list.add(10.5);
			list.add(true);
		}
	}
	
	/*
	 * At the time of compilation as the last step , Generic syntax will be removed and hence
	 * for the JVM , generic syntax won't be available.
	 *
	 * At Compile time :
	 * ===============
	 * 	->	Compile code normally by considering Generic syntax.
	 * 	->	Remove Generic syntax
	 * 	->	Compile once again resultant code.
	 */
	static class CommClass2 {
		public static void main(String[] args) {
			//Both are equal declarations
			ArrayList<String> list = new ArrayList<String>();
			ArrayList<String> list1 = new ArrayList();
			
			ArrayList list3 = new ArrayList<String>();
			list3.add(10);
			list3.add(10.5);
			list3.add(true);
			list3.add("A");
			System.out.println(list3);
		}
	}
	
}
