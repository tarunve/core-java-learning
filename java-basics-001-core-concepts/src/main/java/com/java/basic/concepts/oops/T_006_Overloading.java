package com.java.basic.concepts.oops;

/**
 *   Overloading - when methods have same name but different arguments.
 *   Method resolution is always taken care by compiler based on reference type. Hence, it is called as
 *   	compile-time polymorphism or static polymorphism or early-binding.
 *   In Overloading , we only concentrate on method signature (name+argument).
 *
 *   Advantages:
 *   	1. Overloading concept was not present in c but in Java it is there and reduces complexity of code
 *   	because programmer had to write new method with new name hence complex programs without it.
 *
 *   We will discuss the various loop-holes in this chapter.
 */

public class T_006_Overloading {
	
	/*
	 * Case 1 - primitive type automatic promotion when exact match not found.
	 * byte -> short -> int -> long -> float -> double
	 * char -> int -> long -> float -> double
	 */
	public void primitivePromotion(int i) {
		System.out.println("int-arg");
	}
	public void primitivePromotion(float i) {
		System.out.println("float-arg");
	}
	
	/*
	 * Case 2 - Child class will get more precedence for method resolution.
	 */
	public void childPrecedence(String s) {
		System.out.println("string-arg");
	}
	public void childPrecedence(Object s) {
		System.out.println("object-arg");
	}
	
	/*
	 * Case 3 - Classes with no relation
	 */
	public void sameLevelClasses(String s) {
		System.out.println("string-arg");
	}
	public void sameLevelClasses(StringBuffer s) {
		System.out.println("string-buffer-arg");
	}
	
	/*
	 * Case 4 - when the parameters can lead to ambiguity (int , float) , (float, int)
	 */
	public void ambiguousNatureParam(int i, float f) {
		System.out.println("int-float params");
	}
	public void ambiguousNatureParam(float f, int i) {
		System.out.println("float-int params");
	}
	
	/*
	 * Case 5 - var arg method In General, var-arg method will get least priority i.e. if no other
	 * match found. It is same as default case in switch.
	 */
	public void var_argCase(int i) {
		System.out.println("int-arg");
	}
	public void var_argCase(int... i) {
		System.out.println("var-arg");
	}
	
	/*
	 * Case 6 - When Parent reference is used with Child object i.e. polymorphism
	 */
	static class ParentCaseOL {}

	static class ChildCaseOL extends ParentCaseOL {}

	static class TestOL {
		public void method(ParentCaseOL p) {
			System.out.println("parent-ref-arg");
		}
		public void method(ChildCaseOL c) {
			System.out.println("child-ref-arg");
		}
	}
	
	public static void main(String[] args) {
		T_006_Overloading primitivePromotion = new T_006_Overloading();
		primitivePromotion.primitivePromotion(10);
		primitivePromotion.primitivePromotion(10.5f);
		primitivePromotion.primitivePromotion('a');
		primitivePromotion.primitivePromotion(10l);
		//primitivePromotion.primitivePromotion(10.5); // CE: can't resolve method primitivePromotion(double)
		
		T_006_Overloading childPrecedence = new T_006_Overloading();
		childPrecedence.childPrecedence(new Object());
		childPrecedence.childPrecedence("durga");
		childPrecedence.childPrecedence(null); //It will call method with string argument as String -> Object
		
		T_006_Overloading sameLevelClasses = new T_006_Overloading();
		sameLevelClasses.sameLevelClasses("durga");
		sameLevelClasses.sameLevelClasses(new StringBuffer("durga"));
		//sameLevelClasses.sameLevelClasses(null);  //CE : ambiguous method call
		
		T_006_Overloading ambiguousNatureParam = new T_006_Overloading();
		ambiguousNatureParam.ambiguousNatureParam(10, 10.5f);
		ambiguousNatureParam.ambiguousNatureParam(10.5f, 10);
		//ambiguousNatureParam.ambiguousNatureParam(10,10);  //CE : ambiguous method call
		//ambiguousNatureParam.ambiguousNatureParam(10.5f ,10.5f); //CE : can't resolve method ambiguousNatureParam(float,float);
		
		T_006_Overloading varArg = new T_006_Overloading();
		varArg.var_argCase();
		varArg.var_argCase(10, 20);
		varArg.var_argCase(10); //This will call method with int arg not var-arg
		
		TestOL testOL = new TestOL();
		ParentCaseOL parentCaseOL = new ParentCaseOL();
		testOL.method(parentCaseOL); // This will print "parent-ref-arg"
		ChildCaseOL childCaseOL = new ChildCaseOL();
		testOL.method(childCaseOL); // This will print "child-ref-arg"
		ParentCaseOL parentCaseOL1 = new ChildCaseOL();
		testOL.method(parentCaseOL1); // This will print "parent-ref-arg"
		
	}
}
