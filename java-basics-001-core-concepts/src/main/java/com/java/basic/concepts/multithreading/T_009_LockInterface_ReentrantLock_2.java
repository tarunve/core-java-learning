package com.java.basic.concepts.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 	->	Implementation of Lock interface and it is direct child of object class.
 * 	->	Reentrant means thread can acquire same lock multiple times without any issue. Internally, Reentrant
 * 		lock increments the thread's personal count whenever thread call lock() method and decrements the count
 * 		whenever thread calls unlock() method. Lock will be released when count reaches to 0.
 *
 * 	Constructors:
 * 	------------
 * 	1.	RenetrantLock l = new ReentrantLock()
 * 		->	creates an instance of ReentrantLock.
 * 	2.	ReentrantLock l = new ReentrantLock(boolean fairness)
 * 		->	creates Reentrant lock with given fairness policy.
 * 		->	If fairness is TRUE, then longest waiting thread can acquire lock if it is available i.e. it
 * 			follows first-come-first-serve policy.
 * 		->	it fairness is FALSE, then which waiting thread will get the chance , we can't expect.
 * 		-> default value of fairness is FLASE.
 *
 * 	Important Methods:
 * 	-----------------
 * 	1.	void lock()
 * 	2.	boolean tryLock()
 * 	3.	boolean tryLock(long l, TimeUnit t)
 * 	4.	void lockInterruptibly()
 * 	5.	void unlock()
 * 	6.	int getHoldCount()
 * 		->	return how many holds current thread has.
 * 	7.	boolean isHeldByCurrentThread()
 * 		->	return TRUE if and only if lock is hold by current Thread.
 * 	8.	int getQueueLength()
 * 		->	return number of threads waiting for the lock.
 * 	9.	Collection getQueuedThreads()
 * 		->	return collection of Threads which are waiting to get the lock.
 * 	10.	boolean hasQueuedThreads()
 * 		->	return TRUE if and only if any thread is waiting to get the lock.
 * 	11.	boolean isLocked()
 * 		-> 	return TRUE if and only if lock is acquired by some thread
 * 	12.	boolean isFair()
 * 		->	return TRUE if and only if fairness policy is set with TRUE value.
 * 	13.	Thread getOwner()
 * 		->	return the Thread which acquires the lock.
 */
public class T_009_LockInterface_ReentrantLock_2 {
	/*
	 * Reentrant Lock
	 */
	static class MyTestThread1 {
		public static void main(String[] args) {
			ReentrantLock l = new ReentrantLock();
			l.lock();
			l.lock();
			System.out.println(l.isLocked());
			System.out.println(l.isHeldByCurrentThread());
			System.out.println(l.getQueueLength());
			l.unlock();
			System.out.println(l.getHoldCount());
			System.out.println(l.isLocked());
			l.unlock();
			System.out.println(l.isLocked());
			System.out.println(l.isFair());
		}
	}
	
	/*
	 * Producer-Consumer
	 */
	static class Worker {
		private final Lock lock = new ReentrantLock();
		private final Condition condition = lock.newCondition();
		
		public void producer() throws InterruptedException {
			lock.lock();
			System.out.println("Producer method...");
			condition.await();
			System.out.println("Producer method again...");
			lock.unlock();
		}

		public void consumer() throws InterruptedException {
			lock.lock();
			Thread.sleep(2000);
			System.out.println("Consumer method...");
			condition.signal();
			lock.unlock();
		}
		
	}
	
	static class MyTestThread2 {

		public static void main(String[] args) {
			final Worker worker = new Worker();
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						worker.producer();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			
			Thread t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						worker.consumer();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			
			t1.start();
			t2.start();
			try {
				t1.join();
				t2.join();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
