package com.learning.basics.project.reactor.tutorials;

/**
 *  Hot vs Cold Observables:
 *  -----------------------
 *  -   Cold observable are those which emits an event when someone subscribe to it.
 *      Like listening to podcast. Each subscriber can hear the whole podcast.
 *  -   Hot observable are those which emits an event when no one is listening.
 *      Like watching broadcast TV without a DVR. You only get the data from the
 *      point you tune in.
 *
 *  Observables Creation Methods:
 *  -----------------------------
 *  -   just : from single values.
 *          Observable.just(42)
 *  -   fromXXXX
 *          Observable.fromArray(Long[])
 *          Observable.fromIterable(ArrayList)
 *  -   create
 *  -   generate
 */
public class T002_ObservableCompositionAndFiltering { }
