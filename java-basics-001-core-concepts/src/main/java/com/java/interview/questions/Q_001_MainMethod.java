package com.java.interview.questions;

public class Q_001_MainMethod extends ParentClass {

	/*
	 * 1. Can we overload main method ?
	 *  --> Yes but JVM will only call the method with exact signature - public static void main(String [] args)
	 *
	 * 2. Can we override main method ?
	 *  --> No because it is static method. If we don't remove @Override , we will get compile time error.
	 *
	 * 3. Can we make main method as final?
	 *  --> Yes , no issue
	 *
	 * 4. How to call a non-static method from main in Java.
	 *  --> By creating an instance of that class but not directly
	 *
	 * 5. Can we make main method synchronized in Java?
	 *  --> Yes, No issue.
	 *
	 *  6. Why main method is public static ?
	 *  --> JVM will not be able to call main method without instantiating class.
	 *
	 *  7. what will happen if we declare main() method  as non-static?
	 *  --> Compilation - no issue but Runtime error - no main method is found in class.
	 *
	 *  8. Can we define a class without main method?
	 *  --> With 7 or above , we can't run a class without main method. But prior to version 6 , we can define
	 *  	static initializers/block to run it.
	 *
	 *  9. Can we declare main() method with different access modifier other than public?
	 *  --> Compilation - no issue but Runtime error - no main method found in class.
	 *
	 *  10. Can we change return type of main method?
	 *  --> Compilation - no issue but Runtime error - Main method must return a value of type void.
	 */

	public Q_001_MainMethod() {}

	/*public static void main(String[] args) {
		System.out.println("Main method");
	}*/

	//@Override
	public final synchronized static void main(String... args) {
		System.out.println("Main method using variable arguments...");
		main("Tarun");
		main("Deepak", 25);
	}

	public static void main(String name) {
		System.out.println("Main method with name as argument ...." + name);
	}

	public static void main(String name, int age) {
		System.out.println("Main method with name  and age as argument ...." + name + " :: " + age);
	}
}

class ParentClass {

	public void instanceMethod() {
		System.out.println("Instance Method from ParentClass...");
	}

	public static void main(String name) {
		System.out.println("ParentClass method with name as argument ...." + name);
	}

	public static void main(String... args) {
		System.out.println("Main method using from ParentClass");
		ParentClass parentClass = new ParentClass();
		parentClass.instanceMethod();
	}
}
