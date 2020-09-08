package com.java.basic.concepts.multithreading;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 	BlockingQueue:
 * 	=============
 * 	->	An interface that represents a queue that is thread safe . Put items or take items from it.
 * 	->	Ex. one thread is putting items into the queue and another thread in taking items from it
 * 			at the same time. We can do it with producer-consumer pattern.
 * 	->	put() - putting items to queue.
 * 	->	take() - take items from the queue.
 * 
 * 	1.	ArrayBlockingQueue:
 * 		------------------
 * 		->	A bounded {@linkplain BlockingQueue blocking queue} backed by an array.  
 * 		->	This queue orders elements FIFO (first-in-first-out).  
 * 		->	The head of the queue is that element that has been on the queue the longest time.  
 * 		->	The tail of the queue is that element that has been on the queue the shortest time. 
 * 		->	New elements are inserted at the tail of the queue, and the queue retrieval 
 * 			operations obtain elements at the head of the queue.
 * 		->	This is a classic "bounded buffer", in which a fixed-sized array holds elements 
 * 			inserted by producers and extracted by consumers. Once created, the capacity cannot 
 * 			be changed.  Attempts to {@code put} an element into a full queue will result in the 
 * 			operation blocking, attempts to {@code take} an element from an empty queue will 
 * 			similarly block.
 * 
 * 	2.	LinkedBlockingQueue:
 * 		-------------------
 * 		->	An optionally-bounded {@linkplain BlockingQueue blocking queue} based on linked nodes.
 * 		->	This queue orders elements FIFO (first-in-first-out). 
 * 		->	The head of the queue is that element that has been on the queue the longest time.
 * 		->	The tail of the queue is that element that has been on the queue the shortest time. 
 * 		->	New elements are inserted at the tail of the queue, and the queue retrieval operations 
 * 			obtain elements at the head of the queue.
 * 		->	Linked queues typically have higher throughput than array-based queues but less predictable 
 * 			performance in most concurrent applications.
 * 
 * 	3.	ProrityBlockingQueue:
 * 		--------------------
 * 		->	An unbounded {@linkplain BlockingQueue blocking queue} that uses the same ordering rules 
 * 			as class {@link PriorityQueue} and supplies blocking retrieval operations.  
 * 		->	While this queue is logically unbounded, attempted additions may fail due to resource 
 * 			exhaustion (causing {@code OutOfMemoryError}). 
 * 		->	This class does not permit {@code null} elements.  A priority queue relying on {@linkplain 
 * 			Comparable natural ordering} also does not permit insertion of non-comparable objects 
 * 			(doing so results in {@code ClassCastException}).
 * 		->	Operations on this class make no guarantees about the ordering of elements with equal 
 * 			priority. If you need to enforce an ordering, you can define custom classes or 
 * 			comparators that use a secondary key to break ties in primary priority values. 
 * 
 * 	4.	DelayQueue:
 * 		----------
 * 		->	An unbounded {@linkplain BlockingQueue blocking queue} of {@code Delayed} elements, in 
 * 			which an element can only be taken when its delay has expired.  
 * 		->	The head of the queue is that {@code Delayed} element whose delay expired furthest in the 
 * 			past.  If no delay has expired there is no head and {@code poll} will return {@code null}. 
 * 		->	Expiration occurs when an element's {@code getDelay(TimeUnit.NANOSECONDS)} method returns 
 * 			a value less than or equal to zero.  Even though unexpired elements cannot be removed using 
 * 			{@code take} or {@code poll}, they are otherwise treated as normal elements. 
 * 			->	For example, the {@code size} method returns the count of both expired and unexpired 
 * 				elements.
 * 		->	This queue does not permit null elements.
 */
public class T_018_BlockingQueue {
	
	static class FirstWorker implements Runnable {
		
		private final BlockingQueue<Integer> blockingQueue;
		
		FirstWorker(BlockingQueue<Integer> queue) {
			this.blockingQueue = queue;
		}

		@Override
		public void run() {
			int counter = 0;
			while (true) {
				try {
					blockingQueue.put(counter);
					System.out.println("Putting item to the queue " + counter);
					counter++;
					Thread.sleep(500);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	static class SecondWorker implements Runnable {
		
		private final BlockingQueue<Integer> blockingQueue;
		
		SecondWorker(BlockingQueue<Integer> queue) {
			this.blockingQueue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					int number = blockingQueue.take();
					System.out.println("Taking item to the queue " + number);
					Thread.sleep(2000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class MyTestThread {
		public static void main(String[] args) {
			BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
			FirstWorker firstWorker = new FirstWorker(blockingQueue);
			SecondWorker secondWorker = new SecondWorker(blockingQueue);
			new Thread(firstWorker).start();
			new Thread(secondWorker).start();
		}
	}
	
}
