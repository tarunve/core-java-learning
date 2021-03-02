package narsimhak.practice06.priority.queue;

/*
 * 	->	In some situations we may need to find the minimum/maximum element among a collection of elements. 
 * 		We can do this with the help of Priority Queue ADT. A priority queue ADT is a data structure that 
 * 		supports the operations Insert and DeleteMin (which returns and removes the minimum element) or 
 * 		DeleteMax (which returns and removes the maximum element).
 * 	->	These operations are equivalent to EnQueue and DeQueue operations of a queue. The difference is 
 * 		that, in priority queues, the order in which the elements enter the queue may not be the same in
 * 		which they were processed. An example application of a priority queue is job scheduling, which is 
 * 		prioritized instead of serving in first come first serve.
 * 	->	A priority queue is called an ascending � priority queue, if the item with the smallest key has the
 * 		highest priority (that means, delete the smallest element always). Similarly, a priority queue is
 * 		said to be a descending �priority queue if the item with the largest key has the highest priority
 * 		(delete the maximum element always). Since these two types are symmetric we will be	concentrating 
 * 		on one of them: ascending-priority queue.
 * 
 * 	->	The following operations make priority queues an ADT.
 * 		Main Priority Queues Operations
 * 		-------------------------------
 * 		->	A priority queue is a container of elements, each having an associated key.
 * 			->	Insert (key, data): Inserts data with key to the priority queue. Elements are ordered based on key.
 * 			->	DeleteMin/DeleteMax: Remove and return the element with the smallest/largest key.
 * 			->	GetMinimum/GetMaximum: Return the element with the smallest/largest key without deleting it.
 * 		Auxiliary Priority Queues Operations
 * 		------------------------------------
 * 		->	kth � Smallest/kth � Largest: Returns the kth � Smallest/kth �Largest key in priority queue.
 * 		->	Size: Returns number of elements in priority queue.
 * 		->	Heap Sort: Sorts the elements in the priority queue based on priority (key).
 * 
 * 	Priority Queue Applications
 * 	---------------------------
 * 	->	Data compression: Huffman Coding algorithm
 * 	->	Shortest path algorithms: Dijkstra�s algorithm
 * 	->	Minimum spanning tree algorithms: Prim�s algorithm
 * 	->	Event-driven simulation: customers in a line
 * 	->	Selection problem: Finding kth- smallest element
 * 
 * 	Priority Queue Implementations
 * 	------------------------------
 * 	1.	Unordered Array Implementation :	Elements are inserted into the array without bothering about the order. 
 * 											Deletions (DeleteMax) are performed by searching the key and then deleting.
 * 		Insertions complexity: O(1). DeleteMin complexity: O(n).
 * 	2.	Unordered List Implementation :	It is very similar to array implementation, but instead of using arrays, linked 
 * 										lists are used. Insertions complexity: O(1). DeleteMin complexity: O(n).
 * 	3.	Ordered Array Implementation :	Elements are inserted into the array in sorted order based on key field. Deletions 
 * 										are performed at only one end. Insertions complexity: O(n). DeleteMin complexity: O(1).
 * 	4.	Ordered List Implementation :	Elements are inserted into the list in sorted order based on key field. Deletions 
 * 										are performed at only one end, hence preserving the status of the priority queue. 
 * 		All other functionalities associated with a linked list ADT are performed without modification.
 * 		Insertions complexity: O(n). DeleteMin complexity: O(1).
 * 	5.	Binary Search Trees Implementation :	Both insertions and deletions take O(logn) on average if insertions are 
 * 												random (refer to Trees chapter).
 * 	6.	Balanced Binary Search Trees Implementation :	Both insertions and deletion take O(logn) in the worst case.
 * 	7.	Binary Heap Implementation :	In subsequent sections we will discuss this in full detail. For now, assume that 
 * 										binary heap implementation gives O(logn) complexity for search, insertions and 
 * 		deletions and O(1) for finding the maximum or minimum element.
 */
public class T_001_PriorityQueue {
	
}
