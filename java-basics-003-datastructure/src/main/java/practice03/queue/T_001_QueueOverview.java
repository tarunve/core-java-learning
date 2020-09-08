package practice03.queue;

/*
 * 	->	A queue is an ordered list in which insertions are done at one end (rear) and deletions
 * 		are done at other end (front). The first element to be inserted is the first one to be
 * 		deleted. Hence, it is called First in First out (FIFO) or Last in Last out (LILO) list.
 * 	->	When an element is inserted in a queue, the concept is called EnQueue, and when an element
 * 		is removed from the queue, the concept is called DeQueue. DeQueueing an empty queue is
 * 		called underflow and EnQueuing an element in a full queue is called overflow.
 *
 * 	Main Queue Operations:
 * 	---------------------
 * 	1.	enQueue(int data)	: Inserts an element at the end of the queue
 *	2.	int deQueue()		: Removes and returns the element at the front of the queue
 *
 *	Auxiliary Queue Operations:
 * 	--------------------------
 * 	1.	int Front()			: Returns the element at the front without removing it
 *	2.	int QueueSize()		: Returns the number of elements stored in the queue
 *	3.	int IsEmptyQueue()	: Indicates whether no elements are stored in the queue or not
 *
 *	Exceptions
 *	----------
 *	Similar to other ADTs, executing DeQueue on an empty queue throws an “Empty Queue Exception”
 *	and executing EnQueue on a full queue throws a “Full Queue Exception”.
 *
 *	Direct Applications
 *	-------------------
 *	1.	Operating systems schedule jobs (with equal priority) in the order of arrival (e.g., a print queue).
 *	2.	Simulation of real-world queues such as lines at a ticket counter, or any other first-come-first-served
 *		requires a queue.
 *	3.	Multiprogramming.
 *	4.	Asynchronous data transfer (file IO, pipes, sockets).
 *	5.	Waiting times of customers at call center.
 *	6.	Determining number of cashiers to have at a supermarket.
 *
 *	Indirect Applications
 *	---------------------
 *	1.	Auxiliary data structure for algorithms
 *	2.	Component of other data structures
 *
 *	Implementation
 *	--------------
 *	1.	Simple circular array based implementation
 *	2.	Dynamic circular array based implementation
 *	3.	Linked list implementation
 */
public class T_001_QueueOverview {
	
	public T_001_QueueOverview() {}
	
}
