package interview.questions;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *	What is atomic operation? What are atomic classes in Java Concurrency API?
 *	=========================================================================
 *	->	Atomic operations are performed in a single unit of task without interference from other operations. 
 *		Atomic operations are necessity in multi-threaded environment to avoid data inconsistency.
 *	->	int++ is not an atomic operation. So by the time one thread read its value and increment it by one, 
 *		another thread has read the older value leading to the wrong result.
 *	->	To solve this issue, we will have to make sure that increment operation on count is atomic, we can 
 *		do that using Synchronization but Java 5 java.util.concurrent.atomic provides wrapper classes for int 
 *		and long that can be used to achieve this atomically without the usage of Synchronization.
 */
public class Q_014_AtomicClass {

	static class JavaAtomic {

	    public static void main(String[] args) throws InterruptedException {

	        ProcessingThread pt = new ProcessingThread();
	        Thread t1 = new Thread(pt, "t1");
	        t1.start();
	        Thread t2 = new Thread(pt, "t2");
	        t2.start();
	        t1.join();
	        t2.join();
	        System.out.println("Processing count=" + pt.getCount());
	    }
	}

	static class ProcessingThread implements Runnable {
	    private AtomicInteger count = new AtomicInteger();

	    @Override
	    public void run() {
	        for (int i = 1; i < 5; i++) {
	            processSomething(i);
	            count.incrementAndGet();
	        }
	    }

	    public int getCount() {
	        return this.count.get();
	    }

	    private void processSomething(int i) {
	        // processing some job
	        try {
	            Thread.sleep(i * 1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	}
}
