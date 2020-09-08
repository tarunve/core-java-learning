package com.java.basic.concepts.oops;

/*
 * Static Control Flow in Parent-Child Relationship
 * ================================================
 *
 * Below steps are executed (when child class is run):
 * 		1. 	Identification of static members(variables, methods, blocks) from parent to child.
 * 		2.	Execution of static variables assignment and static blocks from parent to child.
 * 		3. 	Execution of child class main method.
 */
public class T_012_StaticControlFlow_2 {
	static class SCFParent1 {
		static int i = 10;
		static {
			method();
			System.out.println("Base First Static Block");
		}
		
		public static void main(String[] args) {
			method();
			System.out.println("Base Main method");
		}
		public static void method() {
			System.out.println("Variable j :: " + j);
		}

		static int j = 20;
	}

	static class SCFChild1 extends SCFParent1 {
		static int x = 10;
		static {
			method();
			System.out.println("Child First Static Block");
		}
		
		public static void main(String[] args) {
			method();
			System.out.println("Child Main method");
		}
		public static void method() {
			System.out.println("Variable k :: " + k);
		}
		
		static {
			System.out.println("Child Second Static Block");
		}
		static int k = 20;
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		new SCFChild1().main(null);
		//new SCFParent1().main(null);
	}
	
}
