package narsimhak.practice04.stack;

/*
 * 	->	A stack is an ordered list in which insertion and deletion are done at one end, called
 *		top. The last element inserted is the first one to be deleted. Hence, it is called the Last in First out
 *		(LIFO) or First in Last out (FILO) list.
 *
 *		Main stack operations
 *		---------------------
 *		1.	void push(int data)	:    Inserts data onto stack.
 * 		2.	int pop()			:    Removes and returns the last inserted element from the stack
 *
 * 		Auxiliary stack operations
 * 		--------------------------
 *		1.	int Top(): Returns the last inserted element without removing it.
 *		2.	int Size(): Returns the number of elements stored in the stack.
 *	 	3.	int IsEmptyStack(): Indicates whether any elements are stored in the stack or not.
 *		4.	int IsFullStack(): Indicates whether the stack is full or not.
 *
 *		Direct applications
 *		-------------------
 *		1.	Balancing of symbols
 *		2.	Infix-to-postfix conversion
 *		3.	Evaluation of postfix expression
 *		4.	Implementing function calls (including recursion)
 *		5.	Page-visited history in a Web browser [Back Buttons]
 *		6.	Matching Tags in HTML and XML
 *
 *		Indirect applications
 *		---------------------
 *		1.	Auxiliary data structure for other algorithms (Example: Tree traversal algorithms)
 *		2.	Component of other data structures (Example: Simulating queues, refer Queues chapter)
 *
 *		Implementations:
 *		---------------
 *		1.	Simple array based implementation
 *		2.	Dynamic array based implementation
 *		3.	Linked lists implementation
 */
public class T_001_StackOverview {

	public T_001_StackOverview() {}

}
