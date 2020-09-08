package com.java.basic.concepts.multithreading;

/**
 *  volatile keyword is used to force the Java to use the variable value from main
 *  memory instead of the cache.
 */
@SuppressWarnings("static-access")
public class T_014_Volatile {

	static class MyThread implements Runnable {
		private static volatile boolean isTerminated = false;

		@Override
		public void run() {
			while (!isTerminated) {
				System.out.println("Hello ...from worker class..");

				try {
					Thread.sleep(100);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		public static void setTerminated(boolean isTerminated) {
			MyThread.isTerminated = isTerminated;
		}
	}
	
	static class MyTestThread1 {
		
		public static void main(String[] args) {
			MyThread worker = new MyThread();
			Thread t = new Thread(worker);
			t.start();

			try {
				Thread.sleep(300);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			worker.setTerminated(true);
			System.out.println("Finished...");

		}
	}
	
}
