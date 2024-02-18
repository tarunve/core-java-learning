package com.learning.basics.project.reactor.tutorials;

/**
 *  Attributes of Reactive Applications:
 *  -----------------------------------
 *  1.  Event Driven :
 *      -   Based on Observer Pattern.
 *      -   Observable acts as Subject and Observer subscribe to observable.
 *  2.  Scalable
 *      -   Improved performance with concurrency using Observables which will execute concurrently.
 *  3.  Resilient
 *      -   Graceful error handling.
 *      -   Manage failure.
 *      -   RxJava onError handlers.
 *  4.  Responsive
 *      -   slow response == failure
 *      -   Metrics to actively monitor performance.
 *      -   Define desired levels of performance.
 *
 *  Observable Lifecycle:
 *  --------------------
 *  -   Assembly: Setup observable
 *  -   Subscription: onSubscribe, Capture Disposable
 *  -   Generation: Active emission of events
 *
 *  -   RxJava is single threaded by default. Even when you specify a scheduler, in most cases RxJava
 *      will still only work on a single thread of the designated scheduler.
 */
public class T001_ReactiveProgrammingBasics { }
