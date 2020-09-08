package com.java.enhancements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 	Lambda Expression:
 * 	=================
 *	->	A very new and exciting feature, Java 8 ship with it, is java lambda expressions.
 *	->	Lambda expression (or function) is just an anonymous function, i.e., a function with no name and without being bounded to an identifier.
 *	->	In other words, lambda expressions are nameless functions given as constant values, and written exactly in the place where it’s needed, 
 *		typically as a parameter to some other function.
 *	->	The most important features of Lambda Expressions is that they execute in the context of their appearance. So, a similar lambda 
 *		expression can be executed differently in some other context (i.e. logic will be same but results will be different based on different 
 *		parameters passed to function).
 *	->	A typical lambda expression syntax will be like this:
 *			(x, y) -> x + y  //This function takes two parameters and return their sum.
 *
 *	Features of Lambda Expressions
 *	==============================
 *	->	A lambda expression can have zero, one or more parameters.
 *	->	The type of the parameters can be explicitly declared or it can be inferred from the context
 *	->	Multiple parameters are enclosed in mandatory parentheses and separated by commas. Empty parentheses are used to represent an empty 
 *		set of parameters.
 *	->	When there is a single parameter, if its type is inferred, it is not mandatory to use parentheses. e.g. a -> return a*a.
 *	->	The body of the lambda expressions can contain zero, one or more statements.
 *	->	If body of lambda expression has single statement curly brackets are not mandatory and the return type of the anonymous function is 
 *		the same as that of the body expression. When there is more than one statement in body than these must be enclosed in curly brackets.
 */
interface A {
	void show();
}

/*class XYZ implements A {
	public void show() {
		System.out.println("Calling Show Method.");
	}
}*/

public class E_004_LambdaExpression {

	public static void main(String[] args) {
		A obj;
		/*obj = new A() {  //Anonymous inner class
			public void show() {
				System.out.println("Calling Show from Inner class");
			}
		};*/

		obj = () -> {
			System.out.println("Calling Show method from Lambda expression.");
		};

		obj.show();

		/*
		 * Iterating over a List and perform some operations
		 */
		List<String> pointList = new ArrayList<>();
		pointList.add("1");
		pointList.add("2");
		pointList.forEach(p -> {
			System.out.println(p);
		});

		/*
		 * Create a new runnable and pass it to thread
		 */
		new Thread(() -> System.out.println("My Runnable")).start();

		/*
		 * Sorting employees objects by their name
		 */
		Employee[] employees = { new Employee("David"), new Employee("Naveen"), new Employee("Alex"), new Employee("Richard") };
		System.out.println("Before Sorting Names: " + Arrays.toString(employees));
		Arrays.sort(employees, Employee::nameCompare);
		System.out.println("After Sorting Names " + Arrays.toString(employees));
	}

	static class Employee {
		String name;

		Employee(String name) {
			this.name = name;
		}

		public static int nameCompare(Employee a1, Employee a2) {
			return a1.name.compareTo(a2.name);
		}

		public String toString() {
			return name;
		}
	}
}
