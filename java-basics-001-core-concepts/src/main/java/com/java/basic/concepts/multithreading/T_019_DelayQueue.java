package com.java.basic.concepts.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 	->	This is an unbounded BlockingQueue of objects that implements the Delayed interface.
 * 	->	DelayedQueue keeps the element internally until the certain delay has expired.
 * 		->	An object can only be taken from queue when its delay has expired !!!
 * 	->	We can not place NULL items in the queue - The queue is sorted so that the object at the head
 * 		has a delay that has expired for the longest time.
 * 		->	If no delay has expired, then there is no head element and poll() will return null.
 * 	->	size() returns the count of both expired and un-expired items!!
 */
public class T_019_DelayQueue {
	
	static class DelayedWorker implements Delayed {
		private long duration;
		private String message;
		
		public DelayedWorker(long duration, String message) {
			this.duration = System.currentTimeMillis() + duration;
			this.message = message;
		}
		
		@Override
		public int compareTo(Delayed o) {
			if (this.duration < ((DelayedWorker) o).duration)
				return -1;
			else if (this.duration > ((DelayedWorker) o).duration)
				return 1;
			return 0;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			return unit.convert(duration - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
		}
		
		public long getDuration() {
			return duration;
		}
		
		public void setDuration(long duration) {
			this.duration = duration;
		}
		
		public String getMessage() {
			return message;
		}
		
		public void setMessage(String message) {
			this.message = message;
		}

		@Override
		public String toString() {
			return this.message;
		}
	}

	static class MyTestThread {
		public static void main(String[] args) {
			BlockingQueue<DelayedWorker> queue = new DelayQueue<>();
			try {
				queue.put(new DelayedWorker(1000, "This is the first messgae..."));
				queue.put(new DelayedWorker(10000, "This is the second messgae..."));
				queue.put(new DelayedWorker(4000, "This is the third messgae..."));
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while (!queue.isEmpty()) {
				try {
					System.out.println(queue.take());
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
