package com.java.basic.concepts.oops;

/**
 * In static control flow , if we are creating an object then below steps are executed (When child object is created):
 * 		1. 	Identification of instance members(variables, methods, blocks) from parent to child.
 * 		2.	Execution of instance variables assignment and instance blocks Only in parent class.
 * 		3. 	Execution of constructor in parent class.
 * 		4.	Execution of instance variables assignment and instance blocks Only in child class.
 * 		5. 	Execution of constructor in child class.
 */

public class T_013_InstanceControlFlow_2 {

	static class ICFParentClass1 {
		int i = 10;
		{
			method();
			System.out.println("Parent First instance Block");
		}

		ICFParentClass1() {
			System.out.println("Parent Instance Constructor");
		}
		
		public static void main(String[] args) {
			ICFParentClass1 object = new ICFParentClass1();
			object.method();
			System.out.println("Parent main method");
		}
		public void method() {
			System.out.println("Variable j :: " + j);
		}

		int j = 20;
	}

	static class ICFChildClass1 extends ICFParentClass1 {
		int x = 10;
		{
			method();
			System.out.println("Child First instance Block");
		}

		ICFChildClass1() {
			System.out.println("Child Instance Constructor");
		}
		
		public static void main(String[] args) {
			ICFChildClass1 object = new ICFChildClass1();
			object.method();
			System.out.println("Child main method");
		}
		
		@Override
		public void method() {
			System.out.println("Variable y :: " + y);
		}
		
		{
			System.out.println("Child Second instance Block");
		}
		int y = 20;
	}
}
