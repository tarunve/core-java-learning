package com.java.basic.concepts.multithreading;

/**
 *	InheritableThreadLocal:
 *	=====================
 *	->	By default , parent thread ThreadLocal variables are not available to child thread. If we
 *		want to make parent thread's ThreadLocal variables available to child thread then we should
 *		go for InheritableThreadLocal class.
 *	->	By default, child thread's value is exactly same as parent thread's value but we can provide
 *		customized value for child thread by overriding childValue() method.
 *
 *	Constructor:
 *	-----------
 *	1.	InheritableThreadLocal tl = new InheritableThreadLocal();
 *
 *	Methods:
 *	-------
 *	1.	public Object childValue(Object parenValue)
 *		->	InheritableThreadLocal is child class of ThreadLocal and hence all methods present in
 *			ThreadLocal by default available to InheritableThreadLocal.
 *		->	In addition to these methods, it contains only one method (above).
 */
public class T_013_InheritableThreadLocal {
	
	static class MyThread1 extends Thread {
		
		public static InheritableThreadLocal<Object> tl = new InheritableThreadLocal<Object>() {
			@Override
			protected Object childValue(Object parentValue) {
				return "CC";
			}

			@Override
			protected Object initialValue() {
				return "PP";
			};
		};
		
		@Override
		public void run() {
			System.out.println("Parent Thread Value :: " + tl.get());
			MyThread2 ct = new MyThread2();
			ct.start();
		};
	}

	static class MyThread2 extends MyThread1 {

		@Override
		public void run() {
			System.out.println("Child Thread Value :: " + tl.get());
		}
	}
	
	static class MyTestThread1 {
		public static void main(String[] args) {
			MyThread1 thread = new MyThread1();
			thread.start();
		}
	}
}
