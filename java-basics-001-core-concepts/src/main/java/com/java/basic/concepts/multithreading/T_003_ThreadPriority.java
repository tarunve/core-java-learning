package com.java.basic.concepts.multithreading;

/**
 * 	Thread priority :
 * 	===============
 * ->	Every thread in java has some priority. Either is defined by JVM or programmer.
 * ->	Range is 1-10. Thread.MIN_PRIORITY=1, Thread.NORM_PRIORITY=5, Thread.MAX_PRIORITY=10.
 * ->	Thread scheduler will use Thread priorities to allocate processor. Thread which is having
 * 		highest priority will get chance first. If same priority, then it depends on JVM.
 * ->	Default priority for main thread is 5 and all other threads, default priority will be
 * 		inherited from parent to child.
 * 
 * 	What is Thread Scheduler and Time Slicing?
 * 	=========================================
 * 	->	Thread Scheduler is the Operating System service that allocates the CPU time to the available 
 * 		runnable threads. Once we create and start a thread, it’s execution depends on the implementation 
 * 		of Thread Scheduler. 
 * 	->	Time Slicing is the process to divide the available CPU time to the available runnable threads. 
 * 		Allocation of CPU time to threads can be based on thread priority or the thread waiting for longer 
 * 		time will get more priority in getting CPU time. Thread scheduling can’t be controlled by java, so 
 * 		it’s always better to control it from application itself.
 * 
 * 	What is context-switching in multi-threading?
 * 	============================================
 * 	->	Context Switching is the process of storing and restoring of CPU state so that Thread execution 
 * 		can be resumed from the same point at a later point of time. Context Switching is the essential 
 * 		feature for multitasking operating system and support for multi-threaded environment.
 */
public class T_003_ThreadPriority {

}
