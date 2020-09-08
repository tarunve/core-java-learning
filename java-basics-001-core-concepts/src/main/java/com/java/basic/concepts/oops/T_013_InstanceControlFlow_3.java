package com.java.basic.concepts.oops;

/*
 * Mixed - Instance and static control flow
 */

public class T_013_InstanceControlFlow_3 {
	{
		System.out.println("First instance Block");
	}
	static {
		System.out.println("First Static Block");
	}

	T_013_InstanceControlFlow_3() {
		System.out.println("Instance Constructor");
	}
	
	public static void main(String[] args) {
		new T_013_InstanceControlFlow_3();
		System.out.println("main method");
		new T_013_InstanceControlFlow_3();
	}
	
	static {
		System.out.println("Second Static Block");
	}
	{
		System.out.println("Second instance Block");
	}
}
