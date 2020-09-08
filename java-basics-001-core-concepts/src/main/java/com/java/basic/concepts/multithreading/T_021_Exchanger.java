package com.java.basic.concepts.multithreading;

import java.util.concurrent.Exchanger;

/**
 * 	->	With the help of Exchanger -> two threads can exchange objects.
 * 	->	exchange() -> exchanging objects is done via one of the 2 exchange methods.
 * 	->	Ex.	Genetic Algorithms, training neural networks.
 */
public class T_021_Exchanger {

	static class FirstWorker implements Runnable {
		private int counter;
		private final Exchanger<Integer> exchanger;
		
		public FirstWorker(Exchanger<Integer> exchange) {
			this.exchanger = exchange;
		}

		@Override
		public void run() {
			while (true) {
				counter = counter + 1;
				System.out.println("FirstThread incremented the counter " + counter);
				try {
					counter = exchanger.exchange(counter);
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

	static class SecondWorker implements Runnable {
		private int counter;
		private final Exchanger<Integer> exchanger;
		
		public SecondWorker(Exchanger<Integer> exchange) {
			this.exchanger = exchange;
		}

		@Override
		public void run() {
			while (true) {
				counter = counter - 1;
				System.out.println("SecondThread decremented the counter " + counter);
				try {
					counter = exchanger.exchange(counter);
					Thread.sleep(3000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	static class MyTestThread {
		public static void main(String[] args) {
			Exchanger<Integer> exchanger = new Exchanger<>();
			new Thread(new FirstWorker(exchanger)).start();
			new Thread(new SecondWorker(exchanger)).start();
		}
	}

}
