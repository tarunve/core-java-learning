package com.java.basic.concepts.oops;

/**
 * Below steps are executed:
 * 		1. 	Identification of static members(variables, methods, blocks) from top to bottom.
 * 		2.	Execution of static variables assignment and static blocks from top to bottom.
 * 		3. 	Execution of main method.
 *
 *  Expected output  for below StaticControlFlow_1 class :
 *  ----------------------------------------------------
 *  	Variable j :: 0
 *		First Static Block
 *		Second Static Block
 * 		Variable j :: 20
 *		main method
 *
 *	Direct Read :: If we are trying to read a variable in static block. That read operation
 *				   is called Direct Read
 *	InDirect Read :: If we are calling a method and within the method, if we are reading any
 *					 variable. That read operation is called InDirect Read
 *
 *	If a variable is just Identified by JVM and original value not yet assigned then variable
 *	is said to be in RIWO (Read Indirectly Write only) state. If variable is in RIWO state, then
 *	we can't perform Direct-Read but we can perform Indirect-Read. If we try to read directly, then
 *	we will get CE :: IllegalForwardReference.
 *
 *	Static Block :: Are executed at the time of class loading.
 *		Ex: After loading every DB driver class, we have to register driver class with DriverManager.
 *			But inside every DB driver class, there is a static block to perform this activity.
 */

public class T_012_StaticControlFlow_1 {

	static class StaticControlFlow_1 {
		static int i = 10;
		static {
			method();
			System.out.println("First Static Block");
		}
		
		public static void main(String[] args) {
			method();
			System.out.println("main method");
		}
		public static void method() {
			System.out.println("Variable j :: " + j);
		}
		
		static {
			System.out.println("Second Static Block");
		}
		static int j = 20;
	}
	
	static class StaticControlFlow_2 {
		static {
			//System.out.println(x); //CE :: IllegalForwardReference - can't reference field before it is defined
			System.out.println("Static Block :: StaticControlFlow_2");
		}
		static int x = 10;
	}
}
