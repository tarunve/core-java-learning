package com.java.basic.concepts.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 *	Problems with traditional synchronized method
 * 	=============================================
 * 	1.	No flexibility to try for a lock without waiting.
 * 	2.	There is no way to specify max waiting time for a thread to get lock so that
 * 		thread will wait until getting lock which may create performance problems
 * 		and may cause deadlocks.
 * 	3.	If a thread releases a lock, we are not having any control on which waiting
 * 		thread will get the lock.
 * 	4.	There is no API to list out all waiting threads.
 * 	5.	synchronized keyword compulsory we have to use either at method level or within the
 * 		method. Not possible to use it across multiple methods.
 *
 * 	->	To overcome above , java.util.concurrent.locks package was introduced in 1.5 version.
 *
 * 	Lock Interface:
 * 	==============
 * 	->	similar to implicit lock acquired by a thread to execute synchronized method or block.
 * 	->	Lock implementations provides more extensive operations than traditional implicit locks
 *
 * 	Important Methods:
 * 	-----------------
 * 	1.	void lock()
 * 		->	we can use this method to acquire a lock. If lock is already available then immediately,
 * 			current thread will get that lock. If lock is not available then it will wait until getting
 * 			the lock. It is exactly same behavior as traditional synchronized keyword.
 * 	2.	boolean tryLock()
 * 		->	to acquire the lock without waiting. If the lock is available then the thread acquired the lock
 * 			and returns true. If lock is not available, then this method returns false and can continue its
 * 			execution without waiting. In this case, thread never entered into waiting state.
 * 	3.	boolean tryLock(long time, TimeUnit units)
 * 		->	In this, if lock is not available, then it will wait until specified amount of time. If still not
 * 			get the lock , thread can continue its execution.
 * 	4.	void lockInteeruptibly()
 * 		->	acquires the lock if available and returns immediately. If lock not available, it will wait.
 * 			While waiting, if the thread is interrupted then thread won't get the lock.
 * 	5.	void unlock()
 * 		->	to release the lock. To call this method, compulsory, current thread should be owner of the lock.
 * 			Otherwise we will get RE- IllegalMonitorStateException.
 */
public class T_009_LockInterface_1 {
	/*
	 * Example
	 */
	static class MyTestThread1 extends Thread {
		static ReentrantLock l = new ReentrantLock();
		
		MyTestThread1(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			try {
				if (l.tryLock(2, TimeUnit.MILLISECONDS)) {
					System.out.println(Thread.currentThread().getName() + " gets lock");
					try {
						Thread.sleep(1000);
					}
					catch (InterruptedException e) {}
					System.out.println(Thread.currentThread().getName() + " releasing the lock");
					l.unlock();
				}
				else {
					System.out.println(Thread.currentThread().getName() + " unable to get lock");
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public static void main(String[] args) throws InterruptedException {
			MyTestThread1 thread = new MyTestThread1("FirstThread");
			MyTestThread1 thread2 = new MyTestThread1("SecondThread");
			thread.start();
			thread2.start();
		}
	}
}
