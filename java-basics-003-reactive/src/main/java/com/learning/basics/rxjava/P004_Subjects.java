package com.learning.basics.rxjava;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 *  -   A Subject is a sort of bridge or proxy that is available in some implementations of
 *      ReactiveX that acts both as an observer and as an Observable. Because it is an observer,
 *      it can subscribe to one or more Observables, and because it is an Observable, it can pass
 *      through the items it observes by reemitting them, and it can also emit new items.
 *  -   There are four types of Subjects −
 *      1.  Publish Subject
 *          -   Emits only those items which are emitted after time of subscription.
 *      2.	Replay Subject
 *          -   Emits all the items emitted by source Observable regardless of when it has
 *              subscribed the Observable.
 *      3.  Behavior Subject
 *          -   Upon subscription, emits the most recent item then continue to emit item emitted
 *              by the source Observable.
 *      4.  Async Subject
 *          -   Emits the last item emitted by the source Observable after it's completes emission.
 */
public class P004_Subjects {

    public static void publishSubject(){
        final StringBuilder result1 = new StringBuilder();
        final StringBuilder result2 = new StringBuilder();

        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(value -> result1.append(value) );
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");
        subject.subscribe(value -> result2.append(value));
        subject.onNext("d");
        subject.onComplete();

        //Output will be abcd
        System.out.println(result1);
        //Output will be d only
        //as subscribed after c item emitted.
        System.out.println(result2);
    }

    public static void behaviorSubject(){
        final StringBuilder result1 = new StringBuilder();
        final StringBuilder result2 = new StringBuilder();
        BehaviorSubject<String> subject =  BehaviorSubject.create();
        subject.subscribe(value -> result1.append(value) );
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");
        subject.subscribe(value -> result2.append(value));
        subject.onNext("d");
        subject.onComplete();
        //Output will be abcd
        System.out.println(result1);
        //Output will be cd being BehaviorSubject
        //(c is last item emitted before subscribe)
        System.out.println(result2);
    }

    public static void replaySubject(){
        final StringBuilder result1 = new StringBuilder();
        final StringBuilder result2 = new StringBuilder();

        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(value -> result1.append(value) );
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");
        subject.subscribe(value -> result2.append(value));
        subject.onNext("d");
        subject.onComplete();

        //Output will be abcd
        System.out.println(result1);
        //Output will be abcd being ReplaySubject
        //as ReplaySubject emits all the items
        System.out.println(result2);
    }

    public static void asyncSubject(){
        final StringBuilder result1 = new StringBuilder();
        final StringBuilder result2 = new StringBuilder();

        AsyncSubject<String> subject =  AsyncSubject.create();
        subject.subscribe(value -> result1.append(value) );
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");
        subject.subscribe(value -> result2.append(value));
        subject.onNext("d");
        subject.onComplete();

        //Output will be d being the last item emitted
        System.out.println(result1);
        //Output will be d being the last item emitted
        System.out.println(result2);
    }

    public static void main(String[] args) {
        publishSubject();
        behaviorSubject();
        replaySubject();
        asyncSubject();
    }
}
