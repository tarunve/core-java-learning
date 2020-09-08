package com.java.basic.concepts.oops;

/*
 *	Overriding with respect to static methods
 *
 *  We can't override :
 *  	static method -> non-static method
 *  	non-static method -> static method
 *
 *  If both parent and child class methods are static then it is not overriding but method-hiding.
 */
public class T_007_Overriding_2 {
	/*
	 * Overriding with respect to static methods
	 */
	static class ORParentCase9 {
		public static void method1() {}
		public void method2() {}
		public static void method3() {
			System.out.println("parent-static-method");
		}
	}

	static class ORChildCase9 extends ORParentCase9 {
		//public void method1(){}           //CE : Instance method can't override static method
		//public static void method2(){}    //CE : Static method can't override instance method
		public static void method3() { // Method-hiding but not overriding
			System.out.println("child-static-method");
		}
	}

	/*
	 * Overriding with respect to var-arg methods
	 *
	 * It is not overriding but overloading because argument types are different.
	 */
	static class ORParentCase10 {
		public void method(int... x) {
			System.out.println("parent-var-arg-method");
		}
	}

	static class ORChildCase10 extends ORParentCase10 {
		public void method(int x) {
			System.out.println("child-var-arg-method");
		}
	}
	
	/*
	 * Overriding with respect to variables
	 *
	 * Variable resolution is always taken care by Compiler based on reference type irrespective of
	 * - whether it is static or non-static i.e. Overriding concept is applicable for methods not
	 * for variables.
	 */
	static class ORParentCase11 {
		int x = 888;
	}

	static class ORChildCase11 extends ORParentCase11 {
		static int x = 999;
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		ORParentCase9.method3();
		ORChildCase9.method3();
		ORParentCase9 orParentCase9 = new ORChildCase9();
		orParentCase9.method3();

		ORParentCase10 orParentCase10 = new ORParentCase10();
		orParentCase10.method(10);
		ORChildCase10 orChildCase10 = new ORChildCase10();
		orChildCase10.method(10);
		ORParentCase10 orParentCase10_1 = new ORChildCase10();
		orParentCase10_1.method(10);

		ORParentCase11 orParentCase11 = new ORParentCase11();
		System.out.println("Variable x :: " + orParentCase11.x);
		System.out.println("Variable x :: " + ORChildCase11.x);
		ORParentCase11 orParentCase11_1 = new ORChildCase11();
		System.out.println("Variable x :: " + orParentCase11_1.x);
	}
}
