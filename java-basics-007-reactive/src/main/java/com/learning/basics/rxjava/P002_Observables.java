package com.learning.basics.rxjava;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

/**
 *  Observables represents the sources of data where as Observers (Subscribers) listen to them.
 *  In nutshell, an Observable emits items and a Subscriber then consumes these items.
 *
 *  Observable:
 *  ----------
 *  -   Observable provides data once subscriber starts listening.
 *  -   Observable can emit any number of items.
 *  -   Observable can emit only signal of completion as well with no item.
 *  -   Observable can terminate successfully.
 *  -   Observable may never terminate. e.g. a button can be clicked any number of times.
 *  -   Observable may throw error at any point of time.
 *
 *  Subscriber:
 *  ----------
 *  -   Observable can have multiple subscribers.
 *  -   When an Observable emits an item, each subscriber onNext() method gets invoked.
 *  -   When an Observable finished emitting items, each subscriber onComplete() method gets invoked.
 *  -   If an Observable emits error, each subscriber onError() method gets invoked.
 *
 *  Following are the base classes to create observables.
 *  ----------------------------------------------------
 *  -   Flowable − 0..N flows, Emits 0 or n items. Supports Reactive-Streams and back-pressure.
 *  -   Observable − 0..N flows ,but no back-pressure.
 *  -   Single − 1 item or error. Can be treated as a reactive version of method call.
 *          public abstract static class Single<T> extends Object implements SingleSource<T> {};
 *  -   Completable − No item emitted. Used as a signal for completion or error. Can be treated as
 *                  a reactive version of Runnable.
 *          public abstract class Completable extends Object implements CompletableSource
 *  -   MayBe − Either No item or 1 item emitted. Can be treated as a reactive version of Optional.
 *          public abstract class Maybe<T> extends Object implements MaybeSource<T>
 *
 *  Following are the convenient methods to create observables in Observable class.
 *  -------------------------------------------------------------------------------
 *  -   just(T item) − Returns an Observable that signals the given (constant reference) item and
 *          then completes.
 *  -   fromIterable(Iterable source) − Converts an Iterable sequence into an ObservableSource that
 *          emits the items in the sequence.
 *  -   fromArray(T... items) − Converts an Array into an ObservableSource that emits the items
 *          in the Array.
 *  -   fromCallable(Callable supplier) − Returns an Observable that, when an observer subscribes
 *          to it, invokes a function you specify and then emits the value returned from that function.
 *  -   fromFuture(Future future) − Converts a Future into an ObservableSource.
 *  -   interval(long initialDelay, long period, TimeUnit unit) − Returns an Observable that emits
 *          a 0L after the initialDelay and ever increasing numbers after each period of time
 *          thereafter.
 */
public class P002_Observables {

    public static void singleObserver() throws InterruptedException {
        //Create the observable
        Single<String> testSingle = Single.just("Hello World");

        //Create an observer
        DisposableSingleObserver<String> disposable = testSingle
            .delay(1, TimeUnit.SECONDS, Schedulers.io())
            .subscribeWith(
                new DisposableSingleObserver<String>() {
                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onSuccess(@NonNull String value) {
                        System.out.println(value);
                    }
                });
        Thread.sleep(1500);
        //start observing
        disposable.dispose();
    }

    public static void maybeObserver() throws InterruptedException {
        //Create the observable
        Maybe<String> testSingle = Maybe.just("Hello World");

        //Create an observer
        DisposableMaybeObserver<String> disposable = testSingle
            .delay(1, TimeUnit.SECONDS, Schedulers.io())
            .subscribeWith(
                new DisposableMaybeObserver<String>() {
                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done!!");
                    }

                    @Override
                    public void onSuccess(@NonNull String value) {
                        System.out.println(value);
                    }
                });
        Thread.sleep(1500);
        //start observing
        disposable.dispose();
    }

    public static void completableObserver() throws InterruptedException {
        //Create an observer
        DisposableCompletableObserver disposable = Completable.complete()
            .delay(1, TimeUnit.SECONDS, Schedulers.io())
            .subscribeWith(
                new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        System.out.println("Done!");
                    }

                    @Override
                    public void onStart() {
                        System.out.println("Started!");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }
                });
        Thread.sleep(1500);
        //start observing
        disposable.dispose();
    }

    public static void main(String[] args) throws InterruptedException {
        singleObserver();
        maybeObserver();
        completableObserver();
    }
}
