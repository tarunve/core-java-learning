package practice05.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 	->	A tree is called binary tree if each node has zero child, one child or two children.
 * 	->	Empty tree is also a valid binary tree. We can visualize a binary tree as consisting
 * 		of a root and two disjoint binary trees, called the left and right subtrees of the root.
 *
 * 	Strict Binary Tree:
 * 	------------------
 * 	->	 A binary tree is called strict binary tree if each node has exactly two or no children.
 *
 * 	Full Binary Tree:
 * 	----------------
 * 	->	A binary tree is called full binary tree if each node has exactly two children and all
 * 		leaf nodes are at the same level.
 *
 * 	Complete Binary Tree:
 * 	--------------------
 * 	->	Before defining the complete binary tree, let us assume that the height of the binary
 * 		tree is h. In complete binary trees, if we give numbering for the nodes by starting at
 * 		the root (let us say the root node has 1) then we get a complete sequence from 1 to the
 * 		number of nodes in the tree.
 * 	->	While traversing we should give numbering for NULL pointers also. A binary tree is called
 * 		complete binary tree if all leaf nodes are at height h or h – 1 and also without any
 * 		missing number in the sequence.
 *
 * 	Properties:
 * 	----------
 * 	1.	The number of nodes n in a full binary tree is 2^h+1 – 1. Since, there are h levels we need
 * 		to add all nodes at each level [2^0 + 2^1+ 2^2 + . . . + 2^h = 2^h+1 – 1].
 * 	2.	The number of nodes n in a complete binary tree is between 2^h (minimum) and 2^h+1 – 1 (maximum).
 * 	3.	The number of leaf nodes in a full binary tree is 2^h.
 * 	4.	The number of NULL links (wasted pointers) in a complete binary tree of n nodes is n + 1.
 *
 * 	Traversals:
 * 	----------
 * 	1.	Preorder (DLR) Traversal
 * 	2.	Inorder (LDR) Traversal
 * 	3.	Postorder (LRD) Traversal
 * 	->	There is another traversal method which does not depend on the above orders and it is:
 * 		1.	Level Order Traversal: This method is inspired from Breadth First Traversal (BFS of Graph
 * 			algorithms).
 */
public class T_002_BinaryTrees {
	
	public static class BinaryTreeNode {
		public int data;
		public BinaryTreeNode left, right;
		
		public BinaryTreeNode(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	/*
	 * PreOrder Traversal Recursive
	 * Time Complexity 	: 	O(n)
	 * Space Complexity	:	O(n)
	 */
	public static void preOrderRecursive(BinaryTreeNode root) {
		if (root != null) {
			System.out.println(root.data);
			preOrderRecursive(root.left);
			preOrderRecursive(root.right);
		}
	}

	/*
	 * PreOrder Traversal Iterative
	 * Time Complexity 	: 	O(n)
	 * Space Complexity	:	O(n)
	 */
	public static ArrayList<Integer> preOrderIterative(BinaryTreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			BinaryTreeNode temp = stack.pop();
			result.add(temp.data);
			if (temp.right != null) {
				stack.push(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
		return result;
	}

	/*
	 * InOrder Traversal Recursive
	 * Time Complexity 	: 	O(n)
	 * Space Complexity	:	O(n)
	 */
	public static void inOrderRecursive(BinaryTreeNode root) {
		if (root != null) {
			inOrderRecursive(root.left);
			System.out.println(root.data);
			inOrderRecursive(root.right);
		}
	}

	/*
	 * InOrder Traversal Iterative
	 * Time Complexity 	: 	O(n)
	 * Space Complexity	:	O(n)
	 */
	public static ArrayList<Integer> inOrderIterative(BinaryTreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<BinaryTreeNode> stack = new Stack<>();
		BinaryTreeNode currNode = root;
		boolean done = false;
		while (!done) {
			if (currNode != null) {
				stack.push(currNode);
				currNode = currNode.left;
			}
			else {
				if (stack.isEmpty()) {
					done = true;
				}
				else {
					currNode = stack.pop();
					result.add(currNode.data);
					currNode = currNode.right;
				}
			}
		}
		return result;
	}
	
	/*
	 * PostOrder Traversal Recursive
	 * Time Complexity 	: 	O(n)
	 * Space Complexity	:	O(n)
	 */
	public static void postOrderRecursive(BinaryTreeNode root) {
		if (root != null) {
			postOrderRecursive(root.left);
			postOrderRecursive(root.right);
			System.out.println(root.data);
		}
	}

	/*
	 * PostOrder Traversal Iterative
	 * Time Complexity 	: 	O(n)
	 * Space Complexity	:	O(n)
	 */
	public static ArrayList<Integer> postOrderIterative(BinaryTreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);
		BinaryTreeNode prev = null;
		while (!stack.isEmpty()) {
			BinaryTreeNode curr = stack.peek();
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null)
					stack.push(curr.left);
				else if (curr.right != null)
					stack.push(curr.right);
			}
			else if (curr.left == prev) {
				if (curr.right != null) {
					stack.push(curr.right);
				}
			}
			else {
				result.add(curr.data);
				stack.pop();
			}
			prev = curr;
		}
		return result;
	}
	
	/*
	 * Level Order Traversal
	 */
	public static ArrayList<ArrayList<Integer>> levelOrderTraversal(BinaryTreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		ArrayList<Integer> curr = new ArrayList<>();
		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			if (temp != null) {
				curr.add(temp.data);
				if (temp.left != null)
					queue.offer(temp.left);
				if (temp.right != null)
					queue.offer(temp.right);
			}
			else {
				ArrayList<Integer> c_curr = new ArrayList<>(curr);
				result.add(c_curr);
				curr.clear();
				if (!queue.isEmpty())
					queue.offer(null);
			}
		}
		return result;
	}
	
	/*
	 * Give an algorithm for printing the level order data in reverse order. For example,
	 * the output for the below tree should be: 4 5 6 7 2 3 1
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	public static void levelTraversalInReverse(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack<BinaryTreeNode> stack = new Stack<>();
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode tmp = queue.poll();
			if (tmp.left != null)
				queue.offer(tmp.left);
			if (tmp.right != null)
				queue.offer(tmp.right);
			stack.push(tmp);
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().data + " ");
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right = new BinaryTreeNode(3);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		System.out.println(preOrderIterative(root));
		System.out.println(inOrderIterative(root));
		System.out.println(postOrderIterative(root));
		System.out.println(levelOrderTraversal(root));
		levelTraversalInReverse(root);
	}
	
}
