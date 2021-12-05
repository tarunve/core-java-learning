package com.learning.basics.rxjava;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class P003_Operators {

    public static String[] letters(){
        return new String[]{"a", "b", "c", "d", "e", "f", "g"};
    }
    public static Integer[] numbers(){
        return new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
    }

    // create observable
    //Using fromArray operator to create an Observable
    //Using map operator to transform an Observable
    public static void createObservable(){
        String[] letters = letters();
        final StringBuilder result = new StringBuilder();
        Observable<String> observable = Observable.fromArray(letters);
        observable.map(String::toUpperCase).subscribe(result::append);
        System.out.println(result);
    }

    //Using take operator to filter an Observable
    public static void filterOperator(){
        String[] letters = letters();
        final StringBuilder result = new StringBuilder();
        Observable.fromArray(letters)
                .take(2)
                .subscribe(result::append);
        System.out.println(result);
    }

    //Using combineLatest operator to combine Observables
    public static void combineLatestOperator(){
        Integer[] numbers = numbers();
        String[] letters = letters();
        final StringBuilder result = new StringBuilder();
        Observable<String> observable1 = Observable.fromArray(letters);
        Observable<Integer> observable2 = Observable.fromArray(numbers);
        Observable.combineLatest(observable1, observable2, (a,b) -> a + b)
                .subscribe( letter -> result.append(letter));
        System.out.println(result);
    }

    //Using defaultIfEmpty operator to operate on an Observable
    public static void defaultIfEmptyOperator(){
        final StringBuilder result = new StringBuilder();
        Observable.empty()
                .defaultIfEmpty("No Data")
                .subscribe(s -> result.append(s));
        System.out.println(result);

        String[] letters = letters();
        final StringBuilder result1 = new StringBuilder();
        Observable.fromArray(letters)
                .firstElement()
                .defaultIfEmpty("No data")
                .subscribe(s -> result1.append(s));
        System.out.println(result1);
    }

    //Using connect operator on a ConnectableObservable
    public static void connectOperator(){
        String[] letters = letters();
        final StringBuilder result = new StringBuilder();
        ConnectableObservable<String> connectable = Observable.fromArray(letters).publish();
        connectable.subscribe(letter -> result.append(letter));
        System.out.println(result.length());
        connectable.connect();
        System.out.println(result.length());
        System.out.println(result);
    }

    public static void main(String[] args) {
        createObservable();
        filterOperator();
        combineLatestOperator();
        defaultIfEmptyOperator();
        connectOperator();
    }
}
