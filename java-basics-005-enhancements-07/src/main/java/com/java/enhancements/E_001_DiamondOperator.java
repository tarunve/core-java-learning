package com.java.enhancements;

import java.util.ArrayList;
import java.util.List;

/**
 *	Before generics – raw type declarations
 *	=======================================
 *	->	If you have worked on early versions on Java (before 1.5), when generics were not a Java feature, developers have to use 
 *		raw types declarations and initializations. For example, given below is a HashMap declarations.
 *			Map params = new HashMap();
 *	->	The problem with this approach is that you can put any object type in key and value, and only in runtime you will get error 
 *		if object is not of desired type. There is no compile time safety which can warn developers, that which types are allowed 
 *		and which are not.
 *
 *	Generics – parameterized types
 *	==============================
 *	->	JDK 1.5 brought generics. It must much needed feature and completely changed the way developers write the code. It enabled 
 *		compile time safety. It helped in reducing runtime errors by great number.
 *			Map<String, Integer> params = new HashMap<String, Integer>();
 *	->	This syntax solves the problem of compile time type safety. In fact, above syntax is good for almost all use-cases. In above 
 *		example, if you try to add any key or value of different type, compiler will give you error.
 *
 *	Diamond operator
 *	================
 *	->	Parameterized types solves issues but seems heavy due to same repeated type information on both sides. We can reduce the syntax 
 *		if we can provide type information on one side, and other side can detect and apply the type information.
 *	->	Diamond operator in Java does exactly the same thing. It is also called Elvis operator. Look below at diamond operator syntax.
 *			Map<String, Integer> params = new HashMap<>();
 *	->	In above code, compiler is smart enough to identify that diamond operator infer to type defined on left hand side of declaration. 
 *		It apply the type information to right side object as well. It helps in adding type inference feature to Java.
 *
 *	Backward compatibility
 *	======================
 *	->	Raw types and parameterized types still exist for the sake of backward compatibility. But new compilers will warn if they see raw 
 *		types. If you compile raw types with Java 5 onward, you will get warning like this:
 *		->	ArrayList is a raw type. References to generic type ArrayList<E> should be parameterized.
 */
public class E_001_DiamondOperator {

	@SuppressWarnings({"rawtypes","unused"})
	public static void main(String[] args) {
		//With RawTypes
		List list = new ArrayList();
		
		//With Generics
		List<String> list2 = new ArrayList<String>();
		
		//With Diamond Operator
		List<String> list3 = new ArrayList<>();
	}
}
