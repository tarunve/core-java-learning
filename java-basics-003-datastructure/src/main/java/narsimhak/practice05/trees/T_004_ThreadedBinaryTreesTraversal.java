package narsimhak.practice05.trees;

/*
 * 	->	In earlier sections we have seen that, preorder, inorder, and postorder binary tree traversals used stacks 
 * 		and level order traversal used queues as an auxiliary data structure. . In this section we will discuss new 
 * 		traversal algorithms which do not need both stacks and queues. Such traversal algorithms are called threaded 
 * 		binary tree traversals or stack/queue less traversals.
 * 	->	The binary trees which store such information in NULL pointers are called threaded binary trees
 * 
 * 	Issues with Regular Binary Tree Traversals
 * 	------------------------------------------
 * 	->	The storage space required for the stack and queue is large.
 * 	->	The majority of pointers in any binary tree are NULL. For example, a binary tree with n nodes has n + 1 
 * 		NULL pointers and these were wasted.
 * 	->	It is difficult to find successor node (preorder, inorder and postorder successors) for a given node.
 * 
 * 	Classifying Threaded Binary Trees
 * 	---------------------------------
 * 	->	The classification is based on whether we are storing useful information in both NULL pointers or only in 
 * 		one of them.
 * 		->	If we store predecessor information in NULL left pointers only then we call such binary trees as left 
 *    		threaded binary trees.
 *    	->	If we store successor information in NULL right pointers only then we call such binary trees as right 
 *    		threaded binary trees.
 *     	->	If we store predecessor information in NULL left pointers and store successor information in NULL right 
 *     		pointers, then we call such binary trees as fully threaded binary trees or simply threaded binary trees.
 *
 *	Types of Threaded Binary Trees
 *	------------------------------
 *	->	Based on above discussion we get three representations for threaded binary trees.
 *		->	Preorder Threaded Binary Trees: NULL left pointer will contain PreOrder predecessor information and 
 *											NULL right pointer will contain PreOrder successor information.
 *		->	Inorder Threaded Binary Trees: 	NULL left pointer will contain InOrder predecessor information and NULL 
 *											right pointer will contain InOrder successor information.
 *		->	Postorder Threaded Binary Trees: NULL left pointer will contain PostOrder predecessor information and 
 *											 NULL right pointer will contain PostOrder successor information.
 */
public class T_004_ThreadedBinaryTreesTraversal {
	
	class ThreadedBinaryTreeNode{
		public ThreadedBinaryTreeNode left;
		public ThreadedBinaryTreeNode right;
		public int LTag;
		public int RTag;
		public int data;
	}
}
