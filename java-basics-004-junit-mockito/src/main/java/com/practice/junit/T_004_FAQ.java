package com.practice.junit;

/**
 * 	Why does Mockito not allow stubbing final and private methods:
 * 	-------------------------------------------------------------
 * 	->	Firstly, we are not dogmatic about mocking private methods. We just don't care about private 
 * 		methods because from the standpoint of testing, private methods don't exist. Here are a couple 
 * 		of reasons Mockito doesn't mock private methods:
 * 		->	It requires hacking of class loaders that is never bullet proof and it changes the API 
 * 			(you must use custom test runner, annotate the class, etc.).
 * 		->	It is very easy to work around - just change the visibility of method from private to 
 * 			package-protected (or protected).
 * 		->	It requires the team to spend time implementing & maintaining it. And it does not make 
 * 			sense given point (2) and a fact that it is already implemented in different tool (powermock).
 * 		->	Finally... Mocking private methods is a hint that there is something wrong with Object 
 * 			Oriented understanding. In OO you want objects (or roles) to collaborate, not methods. Forget 
 * 			about pascal & procedural code. Think in objects.
 * 
 * 	Is it really a mocking framework?
 * 	--------------------------------
 * 	->	There is a bit of confusion around the vocabulary. Technically speaking, Mockito is a Test Spy 
 * 		framework. Usually developers use Mockito instead of a mocking framework. Test Spy framework 
 * 		allows to verify behaviour (like mocks) and stub methods (like good old hand-crafted stubs).
 * 
 * 	What are the limitations of Mockito
 * 	-----------------------------------
 * 	->	Mockito 2.x specific limitations
 * 		->	Requires Java 6+
 * 		->	Cannot mock static methods
 * 		->	Cannot mock constructors
 * 		->	Cannot mock equals(), hashCode(). Firstly, you should not mock those methods. Secondly, Mockito 
 * 			defines and depends upon a specific implementation of these methods. Redefining them might break Mockito.
 * 		->	Mocking is only possible on VMs that are supported by Objenesis. Don't worry, most VMs 
 * 			should work just fine.
 * 		->	Spying on real methods where real implementation references outer Class via OuterClass.
 * 			this is impossible. Don't worry, this is extremely rare case.
 * 	->	Mockito 1.x Specific limitations
 * 		->	Needs Java 5+
 * 		->	Cannot mock final classes
 * 		->	Cannot mock final methods - their real behavior is executed without any exception. Mockito 
 * 			cannot warn you about mocking final methods so be vigilant.
 * 		->	Cannot mock static methods
 * 		->	Cannot mock constructors
 * 		->	Cannot mock equals(), hashCode(). Firstly, you should not mock those methods. Secondly, 
 * 			Mockito defines and depends upon a specific implementation of these methods. Redefining 
 * 			them might break Mockito.
 * 		->	Mocking is only possible on VMs that are supported by Objenesis (Note Objenesis is 
 * 			in version 2.1). Don't worry, most VMs should work just fine.
 * 		->	Spying on real methods where real implementation references outer Class via OuterClass.
 * 			this is impossible. Don't worry, this is extremely rare case.
 * 
 * 	Can I mock static methods?
 * 	-------------------------
 * 	->	No. Mockito prefers object orientation and dependency injection over static, procedural code 
 * 		that is hard to understand & change. If you deal with scary legacy code you can use JMockit 
 * 		or Powermock to mock static methods.
 * 
 * 	Can I mock private methods?
 * 	---------------------------
 * 	->	No. From the standpoint of testing... private methods don't exist.
 *
 * 	Can we mock final methods?
 * 	-------------------------
 * 	->  Mockito 2.x now supports final method and final class stubbing.
 * 	->  Mocking of final classes and methods is an incubating, opt-in feature. This feature has to be
 * 	    explicitly activated by creating the file src/test/resources/mockito-extensions/org.mockito.plugins.MockMaker
 * 	    containing a single line:
 * 	        mock-maker-inline
 * 	->  After you create this file you can do:
 *
 *          final class FinalClass {
 *              final String finalMethod() { return "something"; }
 *          }
 *
 *          FinalClass concrete = new FinalClass();
 *          FinalClass mock = mock(FinalClass.class);
 *          given(mock.finalMethod()).willReturn("not anymore");
 *          assertThat(mock.finalMethod()).isNotEqualTo(concrete.finalMethod());
 * 
 * 	Is Mockito thread-safe?
 * 	-----------------------
 * 	->	For healthy scenarios Mockito plays nicely with threads. For instance, you can run tests in 
 * 		parallel to speed up the build. Also, you can let multiple threads call methods on a shared 
 * 		mock to test in concurrent conditions. Check out a timeout() feature for testing concurrency.
 * 	->	However Mockito is only thread-safe in healthy tests, that is tests without multiple threads 
 * 		stubbing/verifying a shared mock. Stubbing or verification of a shared mock from different 
 * 		threads is NOT the proper way of testing because it will always lead to intermittent behavior. 
 * 		In general, mutable state + assertions in multi-threaded environment lead to random results. 
 * 		If you do stub/verify a shared mock across threads you will face occasional exceptions like: 
 * 		WrongTypeOfReturnValue, etc.
 * 
 * 	Can I verify toString()?
 * 	-----------------------
 * 	->	No. You can stub it, though. Verification of toString() is not implemented mainly because:
 * 		->	When debugging, IDE calls toString() on objects to print local variables and their 
 * 			content, etc. After debugging, the verification of toString() will most likely fail.
 * 		->	toString() is used for logging or during string concatenation. Those invocations are 
 * 			usually irrelevant but they will change the outcome of verification.
 * 
 * 	Why does Mockito keep ThreadLocal state?
 * 	---------------------------------------
 * 	->	Mockito uses ThreadLocal state to implement a gorgeous mocking syntax in a language full of 
 * 		constraints (yes, it's java). Fortunately, every time you interact with Mockito framework it 
 * 		validates the ThreadLocal state in case you misused the api.
 * 
 * 	
 */
public class T_004_FAQ {

}
