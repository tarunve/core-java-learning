package com.java.basic.concepts.generics;

/*
 * 	->	We can declare Type parameter either at class level or at method level.
 */
@SuppressWarnings({ "rawtypes" })
public class T_005_GenericMethods {

	/*
	 * Class level Type parameter
	 */
	static class GenericMethodClass1<T> {}
	
	/*
	 * Method level Type parameter
	 */
	static class GenericMethodClass2 {
		public <T> void method(T obj) {

		}
	}
	
	/*
	 * Method level Bounded Type parameter
	 */
	static class GenericMethodClass3 {
		public <T> void method(T obj) {}
		public <T extends Number> void method1(T obj) {}
		public <T extends Runnable> void method2(T obj) {}
		public <T extends Number & Runnable> void method3(T obj) {}
		public <T extends Comparable & Runnable> void method4(T obj) {}
		//Class should come first and then interface
		//public <T extends Runnable & Number> void method5(T obj) {}
		//can't extends more than one class
		//public <T extends Number & Thread> void method6(T obj) {}
	}
	
	static class NumRunnableClass extends Number implements Runnable, Comparable<Number> {

		private static final long serialVersionUID = 1L;

		@Override
		public void run() {}

		@Override
		public int intValue() {
			return 0;
		}

		@Override
		public long longValue() {
			return 0;
		}

		@Override
		public float floatValue() {
			return 0;
		}

		@Override
		public double doubleValue() {
			return 0;
		}

		@Override
		public int compareTo(Number o) {
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		GenericMethodClass3 object = new GenericMethodClass3();
		object.method(new Object());
		object.method1(new Integer(1));
		object.method2(new Thread());
		object.method3(new NumRunnableClass());
		object.method4(new NumRunnableClass());
	}

}
