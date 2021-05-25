package com.java.enhancements.E005.performance;

/**
 *  -   REMOVED : GC Combinations deprecated in Java 8.
 *  -   DEPRECATED : Concurrent Mark Sweep (CMS) Collector
 *      -   -XX:+UseConcMarkSweepGC
 *      -   If we use above parameter, we get warning : Option UseConcMarkSweepGC
 *          was deprecated in Java 9 & will likely be removed in future releases.
 *
 *  G1 Garbage Collector:
 *  -   It will be the default GC from Java 9.
 *  -   Replaces Concurrent Mark Sweep (CMS) GC.
 *  -   Drawback : Long 'stop-the-world' GC pauses
 *  -   Generational GC :
 *      -   Eden -> Survivor -> Tenured
 *  -   G1 instead of converting the heap into 3 regions, converts the heap into
 *      many regions.
 *      -   Each region is about 32MB large.
 *      -   Each region has different purpose.
 *      -   G1 works incrementally which makes a huge different from earlier.
 *      -   Parallel marking is also done.
 *      -   Designed for large heaps.
 *      -   Low pause times, tune-able pause goals.
 *      -   Slight more CPU intensive.
 *      -   Automatic tuning happens :
 *          -   Heap Region Size
 *          -   Parallel Threads
 *          -   Pause time interval
 *
 */
public class E001_GarbageCollectors { }
