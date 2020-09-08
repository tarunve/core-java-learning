package com.practice.junit;

/**
 *	Stub:
 *	====
 *	->	We can create the Stub Class to provide our dummy implementation for service for testing purpose.
 *	->	Stub class will implement the service we want to test.
 *	->	Disadvantage :- 
 *		->	If service is added with new method, we need to maintain the stub class as well.
 *		->	Dynamic Condition
 *
 *	Mockito:
 *	=======
 *	->	Mocking is creating objects that simulate the behavior of real objects. Unlike stubs, mocks can
 *		be dynamically created from code at runtime. Mocks offer more functionality than stubs. You can 
 *		verify method calls and a lot of other things. 
 *	-> 	We can create mock of class or interface.
 *	->	Instead of creating the stub, we can mock the service.
 *	->	Easier static imports.
 *	->	Argument Matcher - If we don't want to do any type checks i.e. to avoid casting in our code, we 
 *			can use it. Example - Mockito.anyInt()
 *		->	Mockito extends Matchers so to get access to all matchers just import Mockito class statically. 
 *		->	Mockito doesn't allow combination of matcher and hardcode value.
 *
 *	BDD:
 *	===
 *	->	Behavior Driven Development (BDD) is a software development process that originally emerged from 
 *		Test Driven Development (TDD). BDD uses examples to illustrate the behavior of the system that are 
 *		written in a readable and understandable language for everyone involved in the development.
 *	->	Given - When - Then
 *	->	Change in syntax only but in better readable format.
 *	->	Hamcrest Matchers : To use this matchers, we need to add dependency for "hamcrest-library".
 *			Using this, we can write test cases in very readable format. It provide many methods
 *			for match.
 *
 *	Spy:
 *	===
 *	->	We generally use mock when we have to completely mock the object behavior while using spy we 
 *		will be spying or stubbing specific methods of it.
 *	->	So mock achieves complete mocking while spy achieves partial mocking.
 *
 *	Difference between Mock and Spy:
 *	-------------------------------
 *	->	Mock object replace mocked class entirely, returning recorded or default values. You can create mock 
 *		out of "thin air". This is what is mostly used during unit testing.
 *	->	When spying, you take an existing object and "replace" only some methods. This is useful when you 
 *		have a huge class and only want to mock certain methods (partial mocking).
 *	->	You can create spies of real objects. When you use the spy then the real methods are called (unless a method was stubbed)
 *	->	Real spies should be used carefully and occasionally, for example when dealing with legacy code.
 */
public class T_001_JunitTerminologies {

}
