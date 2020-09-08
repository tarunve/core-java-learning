package com.java.enhancements;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * 	Fork/Join Framework
 * 	===================
 * 	->	The effective use of parallel cores in a Java program has always been a challenge. There were few home-grown 
 * 		frameworks that would distribute the work across multiple cores and then join them to return the result set. 
 * 		Java 7 has incorporated this feature as a Fork and Join framework.
 * 	->	Basically the Fork-Join breaks the task at hand into mini-tasks until the mini-task is simple enough that it 
 * 		can be solved without further breakups. It’s like a divide-and-conquer algorithm.
 * 	->	One important concept to note in this framework is that ideally no worker thread is idle. They implement a 
 * 		work-stealing algorithm in that idle workers steal the work from those workers who are busy.
 * 
 * 	RecursiveTask<T>
 * 	----------------
 * 	->	It will return a T type.
 * 	->	All the tasks we want to execute in parallel is a subclass of this class. We will
 * 		have to override the compute() method that will return the solution of sub-problem.
 *
 * 	RecursiveAction
 * 	---------------
 * 	->	it is a task, but without any return value.
 *
 * 	ForkJoinPool
 * 	------------
 * 	->	The ForkJoinPool is basically a specialized implementation of ExecutorService implementing the work-stealing 
 * 		algorithm we talked about above. We create an instance of ForkJoinPool by providing the target parallelism 
 * 		level i.e. the number of processors as shown below:
 * 			ForkJoinPool pool = new ForkJoinPool(numberOfProcessors);
 * 			->	where numberOfProcessors = Runtime.getRunTime().availableProcessors();
 * 			->	If you use a no-argument constructor, by default, it creates a pool of size that equals the number 
 * 				of available processors obtained using above technique.
 * 	->	Although you specify any initial pool size, the pool adjusts its size dynamically in an attempt to maintain 
 * 		enough active threads at any given point in time. Another important difference compared to other ExecutorService's 
 * 		is that this pool need not be explicitly shutdown upon program exit because all its threads are in daemon mode.
 * 	->	There are three different ways of submitting a task to the ForkJoinPool.
 * 		1.	execute() method //Desired asynchronous execution; call its fork method to split the work between multiple threads.
 * 		2.	invoke() method: //Await to obtain the result; call the invoke method on the pool.
 * 		3.	submit() method: //Returns a Future object that you can use for checking status and obtaining the result on its completion.
 * 
 * 	ForkJoinTask:
 * 	------------
 * 	->	This is an abstract class for creating tasks that run within a ForkJoinPool. 
 * 	->	The RecursiveAction and RecursiveTask are the only two direct, known subclasses of ForkJoinTask. 
 * 	->	The only difference between these two classes is that the RecursiveAction does not return a value while RecursiveTask 
 * 		does have a return value and returns an object of specified type.
 * 	->	In both cases, you would need to implement the compute method in your subclass that performs the main computation 
 * 		desired by the task.
 * 	->	The ForkJoinTask class provides several methods for checking the execution status of a task. 
 * 		->	The isDone() method returns true if a task completes in any way. 
 * 		->	The isCompletedNormally() method returns true if a task completes without cancellation or encountering an exception, 
 * 		->	The isCancelled() returns true if the task was cancelled. 
 * 		->	The isCompletedabnormally() returns true if the task was either cancelled or encountered an exception.
 *
 * 	Methods:
 * 	-------
 * 	1.	fork():	asynchronously execute the given task in the pool. We can call this on
 * 				RecursiveAction or RecursiveTask<T>
 * 	2.	join():	returns the result of the computation when it is done.
 * 	3.	invoke():	execute the given task + return its result upon computation.
 */
public class E_007_ForkJoinFramework {

	public static class FolderProcessor extends RecursiveTask<List<String>> {
		private static final long serialVersionUID = 1L;
		//This attribute will store the full path of the folder this task is going to process.
		private final String path;
		//This attribute will store the name of the extension of the files this task is going to look for.
		private final String extension;

		//Implement the constructor of the class to initialize its attributes
		public FolderProcessor(String path, String extension) {
			this.path = path;
			this.extension = extension;
		}

		//Implement the compute() method. As you parameterized the RecursiveTask class with the List<String> type, 
		//this method has to return an object of that type.
		@Override
		protected List<String> compute() {
			//List to store the names of the files stored in the folder.
			List<String> list = new ArrayList<String>();
			//FolderProcessor tasks to store the subtasks that are going to process the subfolders stored in the folder
			List<FolderProcessor> tasks = new ArrayList<FolderProcessor>();
			//Get the content of the folder.
			File file = new File(path);
			File content[] = file.listFiles();
			//For each element in the folder, if there is a subfolder, create a new FolderProcessor object 
			//and execute it asynchronously using the fork() method.
			if (content != null) {
				for (int i = 0; i < content.length; i++) {
					if (content[i].isDirectory()) {
						FolderProcessor task = new FolderProcessor(content[i].getAbsolutePath(), extension);
						task.fork();
						tasks.add(task);
					}
					//Otherwise, compare the extension of the file with the extension you are looking for using the checkFile() method 
					//and, if they are equal, store the full path of the file in the list of strings declared earlier.
					else {
						if (checkFile(content[i].getName())) {
							list.add(content[i].getAbsolutePath());
						}
					}
				}
			}
			//If the list of the FolderProcessor subtasks has more than 50 elements, 
			//write a message to the console to indicate this circumstance.
			if (tasks.size() > 50) {
				System.out.printf("%s: %d tasks ran.\n", file.getAbsolutePath(), tasks.size());
			}
			//add to the list of files the results returned by the subtasks launched by this task.
			addResultsFromTasks(list, tasks);
			//Return the list of strings
			return list;
		}

		//For each task stored in the list of tasks, call the join() method that will wait for its finalization and then will return the result of the task. 
		//Add that result to the list of strings using the addAll() method.
		private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks) {
			for (FolderProcessor item : tasks) {
				list.addAll(item.join());
			}
		}

		//This method compares if the name of a file passed as a parameter ends with the extension you are looking for.
		private boolean checkFile(String name) {
			return name.endsWith(extension);
		}
	}
	
	public static void main(String[] args)
	   {
	      //Create ForkJoinPool using the default constructor.
	      ForkJoinPool pool = new ForkJoinPool();
	      //Create three FolderProcessor tasks. Initialize each one with a different folder path.
	      FolderProcessor system = new FolderProcessor("C:\\Windows", "log");
	      FolderProcessor apps = new FolderProcessor("C:\\Program Files", "log");
	      FolderProcessor documents = new FolderProcessor("C:\\Documents And Settings", "log");
	      //Execute the three tasks in the pool using the execute() method.
	      pool.execute(system);
	      pool.execute(apps);
	      pool.execute(documents);
	      //Write to the console information about the status of the pool every second 
	      //until the three tasks have finished their execution.
	      do
	      {
	         System.out.printf("******************************************\n");
	         System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
	         System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
	         System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
	         System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
	         System.out.printf("******************************************\n");
	         try
	         {
	            TimeUnit.SECONDS.sleep(1);
	         } catch (InterruptedException e)
	         {
	            e.printStackTrace();
	         }
	      } while ((!system.isDone()) || (!apps.isDone()) || (!documents.isDone()));
	      //Shut down ForkJoinPool using the shutdown() method.
	      pool.shutdown();
	      //Write the number of results generated by each task to the console.
	      List<String> results;
	      results = system.join();
	      System.out.printf("System: %d files found.\n", results.size());
	      results = apps.join();
	      System.out.printf("Apps: %d files found.\n", results.size());
	      results = documents.join();
	      System.out.printf("Documents: %d files found.\n", results.size());
	   }
}
