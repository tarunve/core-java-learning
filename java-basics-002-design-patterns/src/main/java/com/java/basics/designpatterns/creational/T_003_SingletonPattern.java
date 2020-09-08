package com.java.basics.designpatterns.creational;

/*
 * 	->	Ensure a class has only one instance, and provides a global point of access to it.
 *
 * 	When to use:
 * 	-----------
 * 	1.	Application needs "only one instance" of a class.
 * 	2.	To have complete control over the instance creation.
 *
 * 	Benefits:
 * 	--------
 * 	1.	Controlled instantiation.
 * 	2.	supports both EAGER and LAZY initialization.
 * 	3.	Singletons can be converted to Multitons(to support limited no. of instances identified by keys).
 *
 * 	Drawbacks:
 * 	---------
 * 	1.	Singleton is often seen as "not-so-good" design as it resembles global variables.
 * 	2.	Special handling is required if the singleton object needs to be deleted.
 * 	3.	Singletons that maintain global state may cause issues.
 *
 * 	Real World Examples:
 * 	--------------------
 * 	1.	The office of the President(There can be only one president at a time)
 *
 *
 *	Software Examples:
 *	-----------------
 *	1.	Logger classes.
 *	2.	Window Manager
 *
 * 	Java SDK examples:
 * 	------------------
 * 	1.	java.lang.Runtime.getRuntime()
 * 	2.	java.util.logging.LogManager.getLogManager()
 * 	3.	java.lang.System#getSecurityManager()
 *
 */
public class T_003_SingletonPattern {

	public static class SingletonClass {
		private static SingletonClass instance = null;

		private SingletonClass() {}
		
		public static SingletonClass getInstance() {
			if (instance == null) {
				synchronized (SingletonClass.class) {
					if (instance == null)
						instance = new SingletonClass();
				}
			}
			return instance;
		}
		
		public void printObject() {
			System.out.println("Unique Id of Object :: " + System.identityHashCode(this));
		}
	}

	public static void main(String[] args) {
		SingletonClass instance1 = SingletonClass.getInstance();
		System.out.println(instance1);
		instance1.printObject();
		SingletonClass instance2 = SingletonClass.getInstance();
		System.out.println(instance2);
		instance2.printObject();
	}
}
