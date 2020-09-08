package com.java.basic.concepts.exceptions;

/**
 * 	final
 * 	=====
 * 	->	It is a modifier and applicable for classes, methods and variables.
 * 	->	If a class declared as final then we can't override that class.
 * 	->	If a method declared as final then we can't override that method.
 * 	->	If a variable declared as final then we can't perform reassignment for that variable.
 *
 * 	finally{}
 * 	========
 * 	->	It is a block always associated with try-catch to maintain cleanup code associated with try block.
 * 	->	Specialty of finally block is - it will be executed always irrespective of whether the exception
 * 		is raised or not raised and whether exception is handled or not handled.
 *
 * 	finalize()
 * 	==========
 * 	->	It is a method always invoked by GC just before destroying an object to perform cleanup activities
 * 		associated with object. Once finalize() method completes, immediately GC destroys that object.
 *
 * 	Various possible combination of try, catch and finally
 * 	------------------------------------------------------
 * 	->	In try, catch, finally - order is important.
 * 	->	Whenever we are writing try, compulsory we should write either catch or finally otherwise we will
 * 		get CE i.e. try without catch or finally is invalid.
 * 	->	Whenever we write catch block, compulsory try block must be required i.e. catch without try is invalid
 * 	->	Whenever we write finally block, compulsory we should write try block i.e. finally without try is invalid
 * 	->	Inside try, catch, finally blocks we can declare try, catch, finally locks i.e. nesting of try, catch,
 * 		finally is allowed.
 * 	->	For try, catch & finally, curly braces({}) are mandatory.
 */
public class T_005_FinalFinallyFinalize {
	
	public static void main(String[] args) {
		System.out.println(method());
	}
	
	@SuppressWarnings("finally")
	public static int method(){
		int a=5;
		try {
			a = 10/0;
		}
		catch(Exception e){
			return 2;
		}
		finally{
			return a;
		}
	}

}
