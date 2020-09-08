package com.java.basic.concepts.oops;

/**
 * In static control flow , if we are creating an object then below steps are executed:
 * 		1. 	Identification of instance members(variables, methods, blocks) from top to bottom.
 * 		2.	Execution of instance variables assignment and instance blocks from top to bottom.
 * 		3. 	Execution of constructor.
 *
 * Static Control flow is one time activity which will be performed at the time of class loading.
 * But instance control flow will be performed for every object creation.
 */
public class T_013_InstanceControlFlow_1 {
	
	static class InstanceControlFlow_1 {
		int i = 10;
		{
			method();
			System.out.println("First instance Block");
		}
		
		InstanceControlFlow_1() {
			System.out.println("Instance Constructor");
		}

		public static void main(String[] args) {
			InstanceControlFlow_1 object = new InstanceControlFlow_1();
			object.method();
			System.out.println("main method");
		}
		public void method() {
			System.out.println("Variable j :: " + j);
		}

		{
			System.out.println("Second instance Block");
		}
		int j = 20;
	}
	
}
