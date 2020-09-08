package com.java.basic.concepts.multithreading;

/**
 * 	Two Types:
 * 	=========
 * 	1.	Process Based Multitasking:	When multiple tasks are to be performed at the same time.
 * 		--------------------------	Ex.	Computer , Movie - multiple scenes at a time.
 *
 * 	2.	Thread Based Multitasking:	When multiple independent tasks of the same program to be run at same time.
 * 		-------------------------	Ex.	Search any string in all the folder in all drives (C,D,E etc.)
 * 		->	Basic idea is to reduce runtime(response time) of program and increase the performance.
 *
 * 	Multi Threading:
 * 	===============
 * 	->	Ability of the CPU to execute multiple programs or threads concurrently.
 * 	->	Both processes and threads are independent sequence of execution.
 *
 * 	Process:
 * 	-------
 * 	->	When you open a software or web browser, these are distinct processes.
 * 	->	The OS assigns distinct registers, stack memory, and heap memory to every single process.
 * 	->	Each process has its own - registers, program counter, stack memory, heap memory etc.
 * 	->	In Java, we can create processes with the help of "ProcessBuilder" class.
 *
 * 	Thread:
 * 	------
 * 	->	It is a light-weight process.
 * 	->	It is a unit of execution within a given process (A process may have several threads).
 * 	->	Each thread in a process shares the memory and resources and this is why programmers have to deal with
 * 		concurrent programming and multi-threading.
 */
public class T_001_MultiTaskingConcept {}
