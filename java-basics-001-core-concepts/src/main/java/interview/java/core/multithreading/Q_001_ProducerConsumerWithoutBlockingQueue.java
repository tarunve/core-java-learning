package interview.java.core.multithreading;

import java.util.LinkedList;

/**
 *  Write producer consumer problem without using Blocking Queue.
 */
public class Q_001_ProducerConsumerWithoutBlockingQueue {

    public static class ProducerConsumerClass{
        private final LinkedList<Integer> list = new LinkedList<>();
        private static final int LIMIT = 5;

        public void produce() throws InterruptedException{
            int value = 0;
            while(true){
                synchronized (this){
                    while(list.size() == LIMIT){
                        wait();
                    }
                    System.out.println("Producer produced - "+ value);
                    list.add(value++);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException{
            while(true){
                synchronized (this){
                    while(list.isEmpty()){
                        wait();
                    }
                    int value = list.removeFirst();
                    System.out.println("Consumer consumed - "+ value);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerClass pc = new ProducerConsumerClass();
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    pc.produce();
                } catch(InterruptedException e) {
                    System.out.println("Error while producing.");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    System.out.println("Error while consuming.");
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
