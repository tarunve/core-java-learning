package com.java.interview.questions;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *	What is Java Timer Class? How to schedule a task to run after the specified interval?
 *	====================================================================================
 *	->	java.util.Timer is a utility class that can be used to schedule a thread to be executed at a certain time 
 *		in future. Java Timer class can be used to schedule a task to be run one-time or to be run at regular intervals.
 *	->	java.util.TimerTask is an abstract class that implements Runnable interface and we need to extend this class 
 *		to create our own TimerTask that can be scheduled using java Timer class.
 *
 *	->	Java Timer class is thread safe and multiple threads can share a single Timer object without need for external 
 *		synchronization. Timer class uses java.util.TaskQueue to add tasks at given regular interval and at any time 
 *		there can be only one thread running the TimerTask, for example if you are creating a Timer to run every 10 
 *		seconds but single thread execution takes 20 seconds, then Timer object will keep adding tasks to the queue 
 *		and as soon as one thread is finished, it will notify the queue and another thread will start executing.
 *	->	Java Timer class uses Object wait and notify methods to schedule the tasks.
 */
public class Q_013_TimerClass extends TimerTask {

	@Override
	public void run() {
		System.out.println("Timer task started at:" + new Date());
		completeTask();
		System.out.println("Timer task finished at:" + new Date());
	}

	private void completeTask() {
		try {
			// assuming it takes 20 secs to complete the task
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		TimerTask timerTask = new Q_013_TimerClass();
		// running timer task as daemon thread
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, 10 * 1000);
		System.out.println("TimerTask started");
		// cancel after sometime
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.cancel();
		System.out.println("TimerTask cancelled");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
