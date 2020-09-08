package com.java.basic.concepts.multithreading;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProblemDiningPhilosopher {

	static class Constants {
		
		private Constants() {
			
		}

		public static final int NUMBER_OF_PHILOSOPHERS = 5;
		public static final int NUMBER_OF_CHOPSTICS = 5;
		public static final int SIMULATION_RUNNING_TIME = 10000;
	}

	static class Chopstic {
		
		protected int id;
		protected Lock lock;
		
		public Chopstic(int id) {
			this.id = id;
			this.lock = new ReentrantLock();
		}
		
		public boolean pickUp(Philosopher philosopher, State state) throws InterruptedException {
			if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
				System.out.println(philosopher + " picked up " + state.toString() + " " + this);
				return true;
			}
			return false;
		}
		
		public void putDown(Philosopher philosopher, State state) throws InterruptedException {
			lock.unlock();
			System.out.println(philosopher + " put down " + this);
		}
		
		@Override
		public String toString() {
			return "Chopstic " + id;
		}

	}

	static class Philosopher implements Runnable {

		protected int id;
		private final Chopstic leftChopstic;
		private final Chopstic rightChopstic;
		protected Random random;
		protected int eatingCounter;
		private volatile boolean isFull = false;
		
		public Philosopher(int id, Chopstic left, Chopstic right) {
			this.id = id;
			this.leftChopstic = left;
			this.random = new Random();
			this.rightChopstic = right;
		}
		
		@Override
		public void run() {
			try {
				while (!isFull) {
					think();
					if (leftChopstic.pickUp(this, State.LEFT)) {
						if (rightChopstic.pickUp(this, State.RIGHT)) {
							eat();
							rightChopstic.putDown(this, State.RIGHT);
						}
						leftChopstic.putDown(this, State.LEFT);
					}
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		private void think() throws InterruptedException {
			System.out.println(this + " is thinking ...");
			Thread.sleep(random.nextInt(1000));
		}

		private void eat() throws InterruptedException {
			System.out.println(this + " is eating ...");
			this.eatingCounter++;
			Thread.sleep(random.nextInt(1000));
		}
		
		public void setFull(boolean isFull) {
			this.isFull = isFull;
		}
		
		@Override
		public String toString() {
			return "Philosopher " + id;
		}
	}

	static enum State {
		LEFT, RIGHT;
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = null;
		Philosopher[] philosophers = null;

		try {
			philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHERS];
			Chopstic[] chopstics = new Chopstic[Constants.NUMBER_OF_CHOPSTICS];

			for (int i = 0; i < Constants.NUMBER_OF_CHOPSTICS; i++) {
				chopstics[i] = new Chopstic(i);
			}

			executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);

			for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHERS; i++) {
				philosophers[i] = new Philosopher(i, chopstics[i], chopstics[(i + 1) % Constants.NUMBER_OF_CHOPSTICS]);
				executorService.execute(philosophers[i]);
			}
			Thread.sleep(Constants.SIMULATION_RUNNING_TIME);

			for (Philosopher p : philosophers) {
				p.setFull(true);
			}
		}
		finally {
			executorService.shutdown();

			while (!executorService.isTerminated()) {
				Thread.sleep(1000);
			}

			for (Philosopher p : philosophers) {
				System.out.println(p + " eats " + p.eatingCounter);
			}
		}
	}
}
