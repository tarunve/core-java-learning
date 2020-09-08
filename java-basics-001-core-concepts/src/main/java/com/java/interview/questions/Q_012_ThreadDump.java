package com.java.interview.questions;


/**
 *	What is Java Thread Dump, How can we get Java Thread dump of a Program?
 *	======================================================================
 *	->	A thread dump is a list of all the threads active in the JVM, thread dumps are very helpful in analyzing bottlenecks 
 *		in the application and analyzing deadlock situations. There are many ways using which we can generate Thread dump – 
 *		Using Profiler, Kill -3 command, jstack tool, etc. I prefer jstack tool to generate thread dump of a program because 
 *		it’s easy to use and comes with JDK installation. Since it’s a terminal-based tool, we can create a script to generate 
 *		thread dump at regular intervals to analyze it later on.
 *
 *	1.	VisualVM Profiler: 
 *		-----------------
 *		->	If you are analyzing application for slowness, you must use a profiler. We can generate thread dump for any process 
 *			using VisualVM profiler very easily. You just need to right click on the running process and click on “Thread Dump” 
 *			option to generate it.
 *	2.	jstack: 
 *		------
 *		->	Java comes with jstack tool through which we can generate thread dump for a java process. This is a two step process.
 *			->	Find out the PID of the java process using ps -eaf | grep java command
 *			->	Run jstack tool as jstack PID to generate the thread dump output to console, you can append thread dump output 
 *				to file using command “jstack PID >> mydumps.tdump“
 *	3.	We can use kill -3 PID command to generate the thread dump. This is slightly different from other ways to generate thread 
 *		dump. When kill command is issued, thread dump is generated to the System out of the program. So if it’s a java program 
 *		with console as system out, the thread dump will get printed on the console. If the java program is a Tomcat server with 
 *		system out as catalina.out, then thread dump will be generated in the file.
 *	4.	Java 8 has introduced jcmd utility. You should use this instead of jstack if you are on Java 8 or higher. Command to generate 
 *		thread dump using jcmd is jcmd PID Thread.print.
 */
public class Q_012_ThreadDump {

}
