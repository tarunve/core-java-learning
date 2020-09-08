package com.java.basic.concepts.generics;

import java.util.Comparator;

/**
 * 	->	We can bound the Type parameter for a particular range by using extends keyword. Such types
 * 		are called as bounded types.
 *
 * 	Syntax for Bounded Types
 * 	------------------------
 * 		class Test<T extends X> {}
 * 	->	X can be either class or interface.
 * 	->	If X is a class then we can pass either X type or its child class.
 * 	->	If X is an interface then we can pass either X type or its implementation classes.
 */
@SuppressWarnings({ "unused", "rawtypes" })
public class T_003_BoundedTypes {

	/*
	 * Example Bounded Types
	 */
	static class BoundedTypeClass1 {
		static class BTInnerClass1<T extends Number> {}

		static class BTInnerClass2<T extends Runnable> {}

		static class BTInnerClass3<T extends Runnable & Comparable> {}

		static class BTInnerClass4<T extends Number & Runnable & Comparator> {}

		/*
		 *	The type Number is not an interface; it cannot be specified as a bounded parameter.
		 *	Class should come first and then interface.
		 */
		//static class BTInnerClass5<T extends Runnable & Number> {}

		/*
		 *	The type Number is not an interface; it cannot be specified as a bounded parameter.
		 *	We can't extends more than one class at a time.
		 */
		//static class BTInnerClass6<T extends Number & Thread> {}

		public static void main(String[] args) {
			BTInnerClass1<Integer> obj1 = new BTInnerClass1<Integer>();
			//CE:The type String is not a valid substitute for the bounded parameter <T extends Number>
			//BTInnerClass1<String> obj2 = new BTInnerClass1<String>();

			BTInnerClass2<Runnable> obj3 = new BTInnerClass2<Runnable>();
			BTInnerClass2<Thread> obj4 = new BTInnerClass2<Thread>();
			//CE:The type Integer is not a valid substitute for the bounded parameter <T extends Runnable>
			//BTInnerClass2<Integer> obj5 = new BTInnerClass2<Integer>();
		}
	}

	/*
	 * Conclusion 1 : We can define bounded types only by using extends keyword.
	 * 				  We can't user implements or super keywords but we can replace implements with extends.
	 */
	static class BoundedTypeClass2 {
		static class BTInnerClass1<T extends Number> {}

		//CE:we can't use implements
		//static class BTInnerClass2<T implements Runnable> {}
		static class BTInnerClass3<T extends Runnable> {}
		//CE:we can't use super
		//static class BTInnerClass4<T super String> {}
	}

	/*
	 * Conclusion 2 : As the Type parameter 'T', we can use any valid Java Identifier but it is convention to use 'T'.
	 */
	static class BoundedTypeClass3 {
		static class BTInnerClass1<T> {}
		
		static class BTInnerClass2<X> {}
		
		static class BTInnerClass3<A> {}
		
		static class BTInnerClass4<Tarun> {}
	}

	/*
	 * Conclusion 3 : As per requirement, we can declare any number of Type parameters.
	 * 				  All these parameters should be separated with ','.
	 * 	Ex. HashMap<K,V>
	 */
	static class BoundedTypeClass4 {
		static class BTInnerClass1<A, B> {}
		
		static class BTInnerClass2<X, Y, Z> {}
	}
	
	public static void main(String[] args) {

	}
}
