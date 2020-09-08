package com.java.basic.concepts.generics;
import java.util.ArrayList;
import java.util.List;

/**
 * 	Can we use List<T> instead of List<?> in method arguments? What is the difference?
 * 	->	When using List<T>, while instantiating the list object, T will be replaced with some class. 
 * 		Hence we would be able to use only that class. 
 * 	->	When using List<?> we can pass any type to this method and it will be a generic method.  
 */
public class TestClass {
	
	static class A<T>{
		void method(List<?> obj){
			System.out.println(obj);
		}
	}
	
	public static void main(String[] args) {
		A<Object> str = new A<Object>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(123);
		str.method(list);
	}

}
