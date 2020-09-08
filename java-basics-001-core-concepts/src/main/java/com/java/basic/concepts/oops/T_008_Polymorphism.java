package com.java.basic.concepts.oops;

/**
 * 	Polymorphism - one name but multiple forms.
 *
 * 	1. Method name is same but different type of arguments  - Overloading.
 * 	2. Method Signature is same but in parent one implementation & other in child.
 * 	3. Usage of parent reference to child object is concept of polymorphism.
 * 		When we don't know the runtime object then we should go for parent reference.
 */
public class T_008_Polymorphism {

	/*
	 * Overloading
	 */
	public void method(float f) {}
	public void method(int a) {}
	public void method(long l) {}

	/*
	 * Overriding
	 */
	static class PMParentCase1 {
		void method() {
			System.out.println("parent-method");
		}
	}
	
	static class PMChildCase1 extends PMParentCase1 {
		@Override
		void method() {
			System.out.println("child-method");
		}
	}

	/*
	 * Usage of Parent reference
	 *
	 * When we don't know the runtime object, it is helpful.
	 * 	Ex. List list = new ArrayList();
	 * 		Object object = list.get(0);
	 */
	static class PMParentCase2 {
		void method1() {
			System.out.println("parent-method");
		}
	}
	
	static class PMChildCase2 extends PMParentCase2 {
		void method2() {
			System.out.println("child-method");
		}
	}

	public static void main(String[] args) {
		PMParentCase2 parentObject = new PMChildCase2();
		parentObject.method1();
		//parentObject.method2(); //CE : method2 is undefined in parent class.

		PMParentCase1 object = new PMChildCase1();
		object.method();
	}

}
