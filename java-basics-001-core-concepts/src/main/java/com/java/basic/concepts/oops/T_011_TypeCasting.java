package com.java.basic.concepts.oops;

/**s
 * 	We can use Parent reference to hold child objects.
 * 		Ex. 	Object o = new String("Test");
 *
 * 	We can use interface to hold child implementation class objects.
 * 		Ex. 	Runnable r = new Thread();
 *
 * 		A b = (C)d;
 * 			A - can be Class or interface
 * 			b - name of reference variable
 * 			C - Class or interface
 * 			d - reference variable
 * 	Three Mantras for Type-Casting check:
 * 	====================================
 * 	1.	Compile Time checking I :: The type of 'd' and 'C' must have some relation
 * 									either parent->child or child->parent.
 * 									Else - CE :: Inconvertible Types
 * 	2. 	Compile Time checking II :: 'C' must be either same or derived type of 'A'.
 * 									Else - CE :: Incompatible Types
 * 	3. 	Runtime Checking :: Runtime object type of 'd' must be either same or derived
 * 							type of 'C'
 *
 *
 * 	Through Type-casting, we are not creating any new Object. We just create new reference for existing object.
 */

public class T_011_TypeCasting {

	static class TCParentClass1 {}
	
	static class TCParentClass2 {}
	
	static class TCChildClass1 extends TCParentClass1 {}
	
	static class TCChildClass2 extends TCParentClass1 {}
	
	static class TCChildClass3 extends TCParentClass2 {}
	
	static class TCChildClass4 extends TCParentClass2 {}

	/*
	 * 	Case 1 ::  A extends B extends C
	 * 		Parent reference - Child Reference
	 */
	static class TCParentCase1 {
		public void method1() {}
	}
	
	static class TCChildCase1 extends TCParentCase1 {
		public void method2() {}
	}
	
	/*
	 * 	Case 2 ::  A extends B extends C
	 * 		Overriding Concept
	 */
	static class TCParentCase2 {
		public void method() {
			System.out.println("TCParentCase2");
		}
	}
	
	static class TCChildCase2 extends TCParentCase2 {
		@Override
		public void method() {
			System.out.println("TCChildCase2");
		}
	}

	static class TCChildCase2_1 extends TCChildCase2 {
		@Override
		public void method() {
			System.out.println("TCChildCase2_1");
		}
	}
	
	/*
	 * 	Case 3 ::  A extends B extends C
	 * 		Method Hiding concept
	 */
	static class TCParentCase3 {
		public static void method() {
			System.out.println("TCParentCase3");
		}
	}
	
	static class TCChildCase3 extends TCParentCase3 {
		public static void method() {
			System.out.println("TCChildCase3");
		}
	}

	static class TCChildCase3_1 extends TCChildCase3 {
		public static void method() {
			System.out.println("TCChildCase3_1");
		}
	}
	
	/*
	 * 	Case 4 ::  A extends B extends C
	 * 		Variable scenario
	 */
	static class TCParentCase4 {
		int x= 999;
	}
	
	static class TCChildCase4 extends TCParentCase4 {
		static int x = 777;
	}

	static class TCChildCase4_1 extends TCChildCase4 {
		static int x = 666;
	}
	
	@SuppressWarnings({ "unused", "static-access" })
	public static void main(String[] args) {
		TCParentClass2 base2 = new TCChildClass4();
		
		Object o1 = base2;
		//TCChildClass1 o2 = (TCParentClass1) base2; //CE : Inconvertible types
		//TCChildClass3 o3 = (TCChildClass3) base2; // RE : ClassCastException
		//TCParentClass2 b1 = (TCParentClass1) base2; //CE : Inconvertible types
		//TCParentClass1 b2 = (TCChildClass4) base2; //CE : Incompatible types
		//TCParentClass1 b3 = (TCChildClass1) base2; //CE : Inconvertible types
		
		//Case 1
		TCChildCase1 child1 = new TCChildCase1();
		child1.method1();
		child1.method2();
		((TCParentCase1) child1).method1();
		//((TCParentCase1)child1).method2(); //CE : Can't find symbol method2() in class TCParentCase1
		
		//Case 2
		TCChildCase2_1 tcChildCase2_1 = new TCChildCase2_1();
		tcChildCase2_1.method();
		((TCChildCase2) tcChildCase2_1).method();
		((TCParentCase2)((TCParentCase2) (tcChildCase2_1))).method();

		//Case 3
		TCChildCase3_1 tcChildCase3_1 = new TCChildCase3_1();
		tcChildCase3_1.method();
		((TCChildCase3) tcChildCase3_1).method();
		((TCParentCase3)((TCChildCase3) (tcChildCase3_1))).method();
		
		//Case 3
		TCChildCase4_1 tcChildCase4_1 = new TCChildCase4_1();
		System.out.println(tcChildCase4_1.x);
		System.out.println(((TCChildCase4) tcChildCase4_1).x);
		System.out.println(((TCParentCase4)((TCChildCase4) (tcChildCase4_1))).x);

	}
}
