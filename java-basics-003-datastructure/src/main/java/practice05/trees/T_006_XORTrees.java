package practice05.trees;

/*
 * 	->	This concept is similar to memory efficient doubly linked lists of Linked Lists chapter. Also, like
 * 		threaded binary trees this representation does not need stacks or queues for traversing the trees.
 * 		This representation is used for traversing back (to parent) and forth (to children) using XOR operation.
 * 		To represent the same in XOR trees, for each node below are the rules used for representation:
 * 		->	Each nodes left will have the XOR of its parent and its left children.
 * 		->	Each nodes right will have the XOR of its parent and its right children.
 * 		->	The root nodes parent is NULL and also leaf nodes children are NULL nodes.
 */
public class T_006_XORTrees {
	
}
