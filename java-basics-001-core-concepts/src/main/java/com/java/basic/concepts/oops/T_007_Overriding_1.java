package com.java.basic.concepts.oops;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *	->	Parent class methods are by defaults available to Child class.
 *	->	Method resolution is always taken care by JVM based on runtime object.
 *	->	Also Called as Runtime polymorphism or Dynamic Polymorphism or Late binding.
 *	->	We will discuss various rules for Overriding in this chapter
 *  	Rule 1 - Method name and argument types must be matched
 */
public class T_007_Overriding_1 {

	/*
	 * Rule 2 - Return type must be same till 1.4. From 1.5 version, co-variant return types are
	 * allowed. Ex. If Number in parent then in Child - Number, Integer, Long, Double etc allowed.
	 *
	 * Co-variant types are allowed only for Object types but not primitive types.
	 */
	static class ORParentCase1 {
		public Object method() {
			return "parent-case1";
		}
	}

	static class ORChildCase1 extends ORParentCase1 {
		@Override
		public String method() {
			return "child-case1";
		}
	}

	/*
	 * Rule 3 - Private methods can't be overridden. We can define same private method in parent and
	 * 			child class but it is not overriding.
	 */
	static class ORParentCase2 {
		private void method() {
			System.out.println("parent-private-method");
		}
	}

	static class ORChildCase2 extends ORParentCase2 {
		private void method() {
			System.out.println("child-private-method");
		}
	}

	/*
	 * Rule 4 - Parent final methods can't be overridden.
	 */
	static class ORParentCase3 {
		public final void method() {}
	}

	static class ORChildCase3 extends ORParentCase3 {
		//public void method(){} // CE: Overridden method is final.
	}

	/*
	 * Rule 5 - abstract class methods, we must override.
	 */
	static abstract class ORParentCase4 {
		public abstract void method();
	}

	static class ORChildCase4 extends ORParentCase4 {
		@Override
		public void method() {} // If not defined -> CE : must implement abstract methods
	}

	/*
	 * Rule 6 - we can override non-abstract methods as abstract.
	 *
	 * Advantage: We can stop availability of parent method to next level child classes.
	 */
	static class ORParentCase5 {
		public void method() {}
	}

	static abstract class ORChildCase5 extends ORParentCase5 {
		@Override
		public abstract void method();
	}

	/*
	 * Rule 7 - Following modifiers won't keep any restriction
	 * 			final -> non-final --Not Possible
	 * 			non-final -> final --Possible
	 * 			abstract -> non-abstract -- Possible
	 * 			non-abstract -> abstract --Possible
	 * 			synchronized -> non-synchronized--Possible
	 * 			non-synchronized -> synchronized--Possible
	 * 			native -> non-native --Possible
	 * 			non-native -> native --Possible
	 * 			strictfp -> non-strictfp --Possible
	 * 			non-strictfp -> strictfp --Possible
	 */
	static class ORParentCase6 {
		public native void method();
		public void method1() {}
		public strictfp void method2() {}
	}

	static class ORChildCase6 extends ORParentCase6 {
		@Override
		public void method() {}
		@Override
		public synchronized final void method1() {}
		@Override
		public void method2() {}
	}

	/*
	 * Rule 8 - We can't reduce the scope of access modifier in Overriding.
	 * 			private < default < protected < public
	 */
	static class ORParentCase7 {
		void method() {}
		void method1() {}
	}

	static abstract class ORChildCase7 extends ORParentCase7 {
		//private void method(){} //CE: attempting to assign weaker access
		@Override
		protected void method() {}
		@Override
		public void method1() {}
	}

	/*
	 * Rule 9 - If child class methods throw any checked exception then Parent class methods must
	 * throw same checked exception or its parent class There is no rule for unchecked exceptions
	 */
	static class ORParentCase8 {
		void method1() throws Exception {}
		void method2() {}
		void method3() throws IOException {}
		void method4() throws IOException {}
		void method5() throws IOException {}
		void method6() throws IOException {}
		void method7() {}
	}

	static abstract class ORChildCase8 extends ORParentCase8 {
		@Override
		void method1() {}
		//void method2() throws Exception{} //CE : overridden method doesn't throw 'java.lang.Exception'
		@Override
		void method3() throws IOException {}
		//void method4() throws Exception{} //CE : overridden method doesn't throw 'java.lang.Exception'
		@Override
		void method5() throws FileNotFoundException, EOFException {}
		//void method6() throws EOFException, InterruptedException{} //CE : overridden method doesn't throw 'java.lang.InterruptedException'
		@Override
		void method7() throws ArithmeticException, NullPointerException, ClassCastException {}
	}

	public static void main(String[] args) {
		ORChildCase1 orChildCase1 = new ORChildCase1();
		System.out.println(orChildCase1.method());
		ORParentCase1 orParentCase1 = new ORParentCase1();
		System.out.println(orParentCase1.method());
		ORParentCase1 orParentChildCase1 = new ORChildCase1();
		System.out.println(orParentChildCase1.method());

		ORChildCase2 orChildCase2 = new ORChildCase2();
		orChildCase2.method();
		ORParentCase2 orParentCase2 = new ORParentCase2();
		orParentCase2.method();
		ORParentCase2 orParentChildCase2 = new ORChildCase2();
		orParentChildCase2.method(); //It will call parent private method
	}
}
