package com.java.interview.questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * How to implement BlockingQueue using intrinsic locking mechanism.
 */
public class Q_006_BlockingQueueImpl<T> {

	/*
	 * Using Intrinsic lock mechanism or synchronized keyword.
	 */
	public static class BlockingQueueUsingSync<T> {
		private final Queue<T> queue = new LinkedList<T>();
		private final int capacity;
		
		public BlockingQueueUsingSync(int capacity) {
			super();
			this.capacity = capacity;
		}
		
		public synchronized void put(T element) throws InterruptedException {
			while (queue.size() == capacity) {
				wait();
			}
			queue.add(element);
			notify();
		}
		
		public synchronized T take() throws InterruptedException {
			while (queue.isEmpty()) {
				wait();
			}
			T element = queue.remove();
			notify();
			return element;
		}

		public static void main(String[] args) {
			BlockingQueueUsingSync<Integer> blockingQueue = new BlockingQueueUsingSync<>(2);
			Runnable producer = new Runnable() {
				Random random = new Random();
				
				@Override
				public void run() {
					int element;
					try {
						while (true) {
							element = random.nextInt(1000);
							blockingQueue.put(element);
							System.out.println("Produced :: " + element);
							Thread.sleep(2000);
						}
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			
			Runnable consumer = new Runnable() {
				@Override
				public void run() {
					try {
						while (true) {
							Integer element = blockingQueue.take();
							System.out.println("Consumed :: " + element);
						}
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};

			new Thread(producer).start();
			new Thread(consumer).start();
		}
	}

	/*
	 * Using Lock and Condition
	 */
	public static class BlockingQueueUsingLockCondition<T> {
		private final Queue<T> queue = new LinkedList<T>();
		private final int capacity;
		
		private final Lock lock = new ReentrantLock();
		private final Condition fullCondition = lock.newCondition();
		private final Condition emptyCondition = lock.newCondition();
		
		public BlockingQueueUsingLockCondition(int capacity) {
			this.capacity = capacity;
		}
		
		public void put(T element) throws InterruptedException {
			lock.lock();
			try {
				while (queue.size() == capacity) {
					fullCondition.await();
				}
				queue.add(element);
				emptyCondition.signal();
			}
			finally {
				lock.unlock();
			}
		}
		
		public T take() throws InterruptedException {
			lock.lock();
			try {
				while (queue.isEmpty()) {
					emptyCondition.await();
				}
				T item = queue.remove();
				fullCondition.signal();
				return item;
			}
			finally {
				lock.unlock();
			}
		}

		public static void main(String[] args) {
			BlockingQueueUsingLockCondition<Integer> blockingQueue = new BlockingQueueUsingLockCondition<>(2);
			Runnable producer = new Runnable() {
				Random random = new Random();
				
				@Override
				public void run() {
					int element;
					try {
						while (true) {
							element = random.nextInt(1000);
							blockingQueue.put(element);
							System.out.println("Produced :: " + element);
							Thread.sleep(200);
						}
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			
			Runnable consumer = new Runnable() {
				@Override
				public void run() {
					try {
						while (true) {
							Integer element = blockingQueue.take();
							System.out.println("Consumed :: " + element);
						}
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};

			new Thread(producer).start();
			new Thread(consumer).start();
		}

	}
}
