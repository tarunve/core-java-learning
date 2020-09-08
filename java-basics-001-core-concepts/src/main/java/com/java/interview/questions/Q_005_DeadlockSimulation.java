package com.java.interview.questions;

/**
 * 	->	Deadlock occurs in software program due to circular dependencies on shared resources
 * 		by multiple threads.
 *
 *	Ways to detect Deadlock
 *	-----------------------
 *	1.	JConsole
 *	2.	JVisualVM
 *
 * 	Useful commands(JConsole way)
 * 	-----------------------------
 * 	1.	jps.Jps -l -m
 * 		->	We will get pid using this command
 * 	2.	jstack pid
 * 		->	print all details of the deadlock
 *
 */
public class Q_005_DeadlockSimulation {
	
	public static void main(String[] args) {
		final String resource1 = "Tarun";
		final String resource2 = "Verma";
		
		Thread t1 = new Thread("Thread_1") {
			@Override
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread 1 locked : resource1");
					try {
						Thread.sleep(200);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}

					synchronized (resource2) {
						System.out.println("Thread 1 locked : resource2");
					}
				}
			};
		};
		
		Thread t2 = new Thread("Thread_2") {
			@Override
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread 2 locked : resource2");
					try {
						Thread.sleep(200);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}

					synchronized (resource1) {
						System.out.println("Thread 2 locked : resource1");
					}
				}
			};
		};
		t1.start();
		t2.start();
	}
}
