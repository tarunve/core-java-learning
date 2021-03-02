package narsimhak.practice14.divide.conquer.algo;

/*
 * 	->	The D & C algorithm works by recursively breaking down a problem into two or more sub 
 * 		problems of the same type, until they become simple enough to be solved directly. The 
 * 		solutions to the sub problems are then combined to give a solution to the original problem.
 * 	->	The D & C strategy solves a problem by:
 * 		1) Divide	:	Breaking the problem into sub problems that are themselves smaller 
 * 						instances of the same type of problem.
 * 		2) Recursion:	Recursively solving these sub problems.
 * 		3) Conquer	: 	Appropriately combining their answers.
 * 
 * 	Advantages:
 * 	----------
 * 	1.	Solving difficult problems: D & C is a powerful method for solving difficult problems. 	
 * 		As an example, consider the Tower of Hanoi problem.
 * 	2.	Parallelism
 * 	3.	Memory access
 * 	
 * 	Disadvantages
 * 	-------------
 * 	1.	One disadvantage of the D & C approach is that recursion is slow. This is because of the	
 * 		overhead of the repeated subproblem calls. Also, the D & C approach needs stack for storing the
 * 		calls (the state at each point in the recursion). Actually this depends upon the implementation
 * 		style. With large enough recursive base cases, the overhead of recursion can become negligible
 * 		for many problems.
 * 	2.	Another problem with D & C is that, for some problems, it may be more complicated than an
 * 		iterative approach. For example, to add n numbers, a simple loop to add them up in sequence is
 * 		much easier than a D & C approach that breaks the set of numbers into two halves, adds them
 * 		recursively, and then adds the sums.
 * 
 * 	Divide and Conquer Applications
 * 	-------------------------------
 * 	� Binary Search
 * 	� Merge Sort and Quick Sort
 * 	� Median Finding
 * 	� Min and Max Finding
 * 	� Matrix Multiplication	
 * 	� Closest Pair problem
 */
public class T_001_DivideConquerOverview {
	
}
