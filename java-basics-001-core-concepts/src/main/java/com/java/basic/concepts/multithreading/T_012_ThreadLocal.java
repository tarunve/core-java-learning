package com.java.basic.concepts.multithreading;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * 	ThreadLocal:
 * 	===========
 * 	->	ThreadLocal class provides ThreadLocal variables.
 * 	->	ThreadLocal class maintains values per thread basis.
 * 	->	Each ThreadLocal object maintains a separate value like userId, transactionId etc
 * 		for each thread that accesses that object.
 * 	->	Thread can access its local value, can manipulate its value and even can remove
 * 		its value but can't access other thread's local variables.
 * 	->	 In every part of the code which is executed by thread, we can access  its local value.
 * 	->	It was introduced in 1.2 version and enhanced in 1.5 version.
 * 	->	ThreadLocal can be associated with Thread scope.
 * 	->	Once Thread entered into dead state, all its local variables are by default eligible for GC.
 *
 * 	Constructors:
 * 	------------
 * 	1.	ThreadLocal l = new ThreadLocal()
 *
 * 	Methods:
 * 	-------
 * 	1.	Object get()
 * 		->	return value of ThreadLocal variable associated with current thread.
 * 	2.	Object initialValue()
 * 		->	return initial value of ThreadLocal variable associated with current thread.
 * 		->	default implementation of this method returns null.
 *		-> to customize our own initial value, we have to override this method.
 * 	3.	void set(Object newValue)
 * 		->	set new value to a ThreadLocal variable.
 * 	4.	void remove()
 * 		->	remove value of ThreadLocal variable associated with current thread.
 * 		->	Added in 1.5 version.
 * 		->	After removal, if we are trying to access, it will be re-initialized once again by
 * 			invoking its intialValue method.
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class T_012_ThreadLocal {

	/*
	 * ThreadLocal
	 */
	static class MyTestThread1 {
		public static void main(String[] args) {
			ThreadLocal l = new ThreadLocal();
			System.out.println(l.get());
			l.set("Tarun");
			System.out.println(l.get());
			l.remove();
			System.out.println(l.get());
		}
	}
	
	/*
	 * Example
	 */
	static class MyThread2 extends Thread {
		
		public MyThread2() {}
		
		public MyThread2(String name) {
			super(name);
		}
		
	    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
	        @Override
	        protected SimpleDateFormat initialValue()
	        {
	            return new SimpleDateFormat("yyyyMMdd HHmm");
	        }
	    };
	    
	    public static void main(String[] args) throws InterruptedException {
	    	MyThread2 obj = new MyThread2();
	        for(int i=0 ; i<10; i++){
	            Thread t = new Thread(obj, ""+i);
	            Thread.sleep(new Random().nextInt(1000));
	            t.start();
	        }
	    }

	    @Override
	    public void run() {
	        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
	        try {
	            Thread.sleep(new Random().nextInt(1000));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        //formatter pattern is changed here by thread, but it won't reflect to other threads
	        formatter.set(new SimpleDateFormat());
	        
	        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
	    }

	}
	
	static class MyTestThread2 {
		public static void main(String[] args) {
			MyThread2 t1 = new MyThread2("Thread 1");
			MyThread2 t2 = new MyThread2("Thread 2");
			MyThread2 t3 = new MyThread2("Thread 3");
			MyThread2 t4 = new MyThread2("Thread 4");
			t1.start();
			t2.start();
			t3.start();
			t4.start();
		}
	}
}
