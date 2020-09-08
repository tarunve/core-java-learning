package com.java.basic.concepts.oops;

/**
 * 	Degree of dependency between the components - Coupling.
 *
 * 	1. TIght Coupling - more dependency
 * 	2. Loose Coupling - less dependency
 *
 * 	Tight Coupling is not a good programming practice.
 * 	Disadvantages of Tight coupling :
 * 		1. Without affecting remaining components , we can't modify component. Enhancement becomes difficult.
 * 		2. Suppresses Re-Usability.
 * 		3. Reduces maintainability of application.
 */
public class T_009_Coupling {
	
	static class CouplingClass1 {
		static int i = CouplingClass2.j;
	}
	
	static class CouplingClass2 {
		static int j = CouplingClass3.k;
	}
	
	static class CouplingClass3 {
		static int k = CouplingClass4.method();
	}
	
	static class CouplingClass4 {
		public static int method() {
			return 10;
		}
	}
	
}
