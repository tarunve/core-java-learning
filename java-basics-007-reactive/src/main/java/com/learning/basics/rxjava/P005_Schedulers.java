package com.learning.basics.rxjava;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Random;
import java.util.concurrent.Executors;

/**
 *  -   Schedulers are used in multi-threading environment to work with Observable operators.
 *  -   As per the Reactive, Scheduler are used to schedule how chain of operators will apply to
 *      different threads.
 *  -   By default, an Observable and the chain of operators that you apply to it will do its work,
 *      and will notify its observers, on the same thread on which its Subscribe method is called.
 *      The SubscribeOn operator changes this behavior by specifying a different Scheduler on which
 *      the Observable should operate. The ObserveOn operator specifies a different Scheduler that
 *      the Observable will use to send notifications to its observers.
 *  -   There are following types of Schedulers available in RxJava −
 *      1.  Schedulers.computation()
 *          -   Creates and returns a Scheduler intended for computational work. Count of threads
 *              to be scheduled depends upon the CPUs present in the system. One thread is allowed
 *              per CPU. Best for event-loops or callback operations.
 *      2.  Schedulers.io()
 *          -   Creates and returns a Scheduler intended for IO-bound work. Thread pool may extend
 *              as needed.
 *      3.  Schedulers.newThread()
 *          -   Creates and returns a Scheduler that creates a new Thread for each unit of work.
 *      4.  Schedulers.trampoline()
 *          -   Creates and returns a Scheduler that queues work on the current thread to be
 *              executed after the current work completes.
 *      5.	Schedulers.from(java.util.concurrent.Executor executor)
 *          -   Converts an Executor into a new Scheduler instance.
 */
public class P005_Schedulers {

    public static class TrampolineScheduler  {
        public static void run() throws InterruptedException {
            Observable.just("A", "AB", "ABC")
                .flatMap(v -> getLengthWithDelay(v)
                    .doOnNext(s -> System.out.println("Processing Thread "
                        + Thread.currentThread().getName()))
                    .subscribeOn(Schedulers.trampoline()))
                    .subscribe(length -> System.out.println("Receiver Thread "
                        + Thread.currentThread().getName()
                        + ", Item length " + length));

            Thread.sleep(10000);
        }
        private static Observable<Integer> getLengthWithDelay(String v) {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(3) * 1000);
                return Observable.just(v.length());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static class NewThreadScheduler  {
        public static void run() throws InterruptedException {
            Observable.just("A", "AB", "ABC")
                .flatMap(v -> getLengthWithDelay(v)
                    .doOnNext(s -> System.out.println("Processing Thread "
                        + Thread.currentThread().getName()))
                    .subscribeOn(Schedulers.newThread()))
                    .subscribe(length -> System.out.println("Receiver Thread "
                        + Thread.currentThread().getName()
                        + ", Item length " + length));

            Thread.sleep(10000);
        }
        private static Observable<Integer> getLengthWithDelay(String v) {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(3) * 1000);
                return Observable.just(v.length());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static class CompulationScheduler  {
        public static void run() throws InterruptedException {
            Observable.just("A", "AB", "ABC")
                .flatMap(v -> getLengthWithDelay(v)
                    .doOnNext(s -> System.out.println("Processing Thread "
                        + Thread.currentThread().getName()))
                    .subscribeOn(Schedulers.computation()))
                    .subscribe(length -> System.out.println("Receiver Thread "
                        + Thread.currentThread().getName()
                        + ", Item length " + length));
            Thread.sleep(10000);
        }
        private static Observable<Integer> getLengthWithDelay(String v) {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(3) * 1000);
                return Observable.just(v.length());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static class IOScheduler  {
        public static void run() throws InterruptedException {
            Observable.just("A", "AB", "ABC")
                .flatMap(v -> getLengthWithDelay(v)
                    .doOnNext(s -> System.out.println("Processing Thread "
                        + Thread.currentThread().getName()))
                    .subscribeOn(Schedulers.io()))
                    .subscribe(length -> System.out.println("Receiver Thread "
                        + Thread.currentThread().getName()
                        + ", Item length " + length));
            Thread.sleep(10000);
        }
        private static Observable<Integer> getLengthWithDelay(String v) {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(3) * 1000);
                return Observable.just(v.length());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static class FromExecuterScheduler  {
        public static void run() throws InterruptedException {
            Observable.just("A", "AB", "ABC")
                .flatMap(v -> getLengthWithDelay(v)
                    .doOnNext(s -> System.out.println("Processing Thread "
                            + Thread.currentThread().getName()))
                    .subscribeOn(Schedulers.from(Executors.newFixedThreadPool(3))))
                    .subscribe(length -> System.out.println("Receiver Thread "
                        + Thread.currentThread().getName()
                        + ", Item length " + length));
            Thread.sleep(10000);
        }
        private static Observable<Integer> getLengthWithDelay(String v) {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(3) * 1000);
                return Observable.just(v.length());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TrampolineScheduler.run();
        NewThreadScheduler.run();
        CompulationScheduler.run();
        IOScheduler.run();
        FromExecuterScheduler.run();
    }
}
