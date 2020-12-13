package interview.questions;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 	->	AtomicInteger class stores the value field in a volatile variable, thus it is decorator over
 * 		traditional volatile variable, but it provides unique non-blocking mechanism for updating the
 * 		value after requiring the hardware level support for CAS(compare and set).
 * 	->	Atomic updated provides higher throughput compared to synchronized blocking increment operation.
 * 	->	The most common use of AtomicInteger  is to handle the counter that is accessed by different threads
 * 		simultaneously.
 */
public class Q_008_AtomicInteger {

	public static class CounterThread implements Runnable {
		
		private AtomicInteger couter = null;
		
		public CounterThread(AtomicInteger counter) {
			this.couter = counter;
		}

		@Override
		public void run() {
			System.out.println("Value - " + couter.getAndIncrement() + " for " + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		new Thread(new CounterThread(atomicInteger)).start();
		new Thread(new CounterThread(atomicInteger)).start();
		new Thread(new CounterThread(atomicInteger)).start();
		new Thread(new CounterThread(atomicInteger)).start();
		new Thread(new CounterThread(atomicInteger)).start();
		new Thread(new CounterThread(atomicInteger)).start();
		new Thread(new CounterThread(atomicInteger)).start();
		new Thread(new CounterThread(atomicInteger)).start();
		new Thread(new CounterThread(atomicInteger)).start();
		new Thread(new CounterThread(atomicInteger)).start();
	}
	
}
