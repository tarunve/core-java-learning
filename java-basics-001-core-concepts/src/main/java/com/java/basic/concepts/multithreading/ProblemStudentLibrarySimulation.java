package com.java.basic.concepts.multithreading;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProblemStudentLibrarySimulation {
	
	static class Constants {
		private Constants() {
			
		}
		
		public static final int NUMBER_OF_STUDENTS = 5;
		public static final int NUMBER_OF_BOOKS = 7;
	}
	
	static class Book {
		
		protected int id;
		private final Lock lock;
		
		public Book(int id) {
			this.id = id;
			this.lock = new ReentrantLock();
		}
		
		public void read(Student student) throws InterruptedException {
			//lock.tryLock(10, TimeUnit.MILLISECONDS);
			lock.lock();
			Thread.sleep(1000);
			System.out.println(student + " starts reading " + this);
			Thread.sleep(2000);
			lock.unlock();
			System.out.println(student + " has finished reading " + this);
		}
		
		@Override
		public String toString() {
			return " Book #" + id;
		}
		
	}
	
	static class Student implements Runnable {

		protected int id;
		private final Book[] books;

		public Student(int id, Book[] books) {
			this.id = id;
			this.books = books;
		}

		@Override
		public void run() {
			Random random = new Random();
			while (true) {
				int bookId = random.nextInt(Constants.NUMBER_OF_BOOKS);
				try {
					books[bookId].read(this);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public String toString() {
			return "Student #" + id;
		}
		
	}
	
	public static void main(String[] args) {
		Student[] students = null;
		Book[] books = null;
		ExecutorService executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_STUDENTS);
		try {
			books = new Book[Constants.NUMBER_OF_BOOKS];
			students = new Student[Constants.NUMBER_OF_STUDENTS];
			for (int i = 0; i < Constants.NUMBER_OF_BOOKS; i++) {
				books[i] = new Book(i);
			}
			for (int i = 0; i < Constants.NUMBER_OF_STUDENTS; i++) {
				students[i] = new Student(i, books);
				executorService.execute(students[i]);
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			executorService.shutdown();
		}
		finally {
			executorService.shutdown();
		}
	}
}
