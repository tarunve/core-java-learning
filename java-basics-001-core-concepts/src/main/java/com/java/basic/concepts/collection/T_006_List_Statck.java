package com.java.basic.concepts.collection;

import java.util.Stack;

/**
 * ->	Child class of Vector
 * ->	Specially designed for LIFO order.
 *
 * 	Constructors:
 * 	============
 * 	1.	Stack s = new Stack();
 *
 * 	Stack specific methods:
 * 	=======================
 * 	1.	public Object push(Object o)			:to insert an object into Stack.
 * 	2.	public synchronized Object pop()		:to remove and return top element of stack.
 * 	3.	public synchronized Object peek()		:to return top element of stack.
 * 	4.	public synchronized int search(Object o):returns offset if element is found else returns -1
 * 	5.	public boolean empty()					:returns true if stack is empty.
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class T_006_List_Statck {
	
	public static void main(String[] args) {
		Stack stack = new Stack<>();
		stack.push("Element1");
		stack.push("Element2");
		stack.push(new StringBuffer("Element3"));
		System.out.println(stack.push(10));
		stack.push(null);
		
		System.out.println(stack);
		System.out.println(stack.peek());
		System.out.println(stack.search(10));
		System.out.println(stack.empty());

		stack.pop();
		System.out.println(stack);
	}

}
