package practice05.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class T_002_BinaryTreesProblems_2 {

	public static class BinaryTreeNode {
		public Integer data;
		public BinaryTreeNode left, right;

		public BinaryTreeNode(Integer data) {
			this.data = data;
			left = right = null;
		}
	}

	/*
	 * Give an algorithm for finding the height (or depth) of the binary tree.
	 * Time Complexity : O(n)
	 * Space Complexity: O(n)
	 */
	public static int maxDepthRecursive(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int depthLeftTree = maxDepthRecursive(root.left);
		int depthRightTree = maxDepthRecursive(root.right);
		return (depthLeftTree > depthRightTree) ? (depthLeftTree + 1) : (depthRightTree + 1);
	}
	
	public static int maxDepthNonRecursive(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int depth = 0;
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
				if (curr.right != null)
					stack.push(curr.right);
			}
			else {
				stack.pop();
			}
			prev = curr;
			if (stack.size() > depth)
				depth = stack.size();
		}
		return depth;
	}
	
	public static int maxDepthLevelTraversal(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int depth = 1;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		while (!queue.isEmpty()) {
			BinaryTreeNode curr = queue.poll();
			if (curr != null) {
				if (curr.left != null)
					queue.offer(curr.left);
				if (curr.right != null)
					queue.offer(curr.right);
			}
			else {
				if (!queue.isEmpty()) {
					depth++;
					queue.offer(null);
				}
			}
		}
		return depth;
	}

	/*
	 * Give an algorithm for finding the minimum depth of the binary tree.
	 * Time Complexity: O(n)
	 * Space Complexity: O(n).
	 */
	public static int minimumDepthNonRecursive(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int count = 1;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		List<Integer> leafNodeDepths = new ArrayList<>();
		while (!queue.isEmpty()) {
			BinaryTreeNode curr = queue.poll();
			if (curr != null) {
				if (curr.left == null && curr.right == null) {
					leafNodeDepths.add(count);
				}
				if (curr.left != null)
					queue.offer(curr.left);
				if (curr.right != null)
					queue.offer(curr.right);
			}
			else {
				if (!queue.isEmpty()) {
					count++;
					queue.offer(null);
				}
			}
		}
		return Collections.min(leafNodeDepths);
	}

	/*
	 * Give an algorithm for finding the deepest node of the binary tree.
	 * Time Complexity: O(n).
	 * Space Complexity: O(n).
	 */
	public static BinaryTreeNode deepestElementInTree(BinaryTreeNode root) {
		if (root == null)
			return null;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		BinaryTreeNode tmp = null;
		while (!queue.isEmpty()) {
			tmp = queue.poll();
			if (tmp.left != null)
				queue.offer(tmp.left);
			if (tmp.right != null)
				queue.offer(tmp.right);
		}
		return tmp;
	}

	/*
	 * Give an algorithm for finding the number of leaves in the binary tree without using
	 * recursion.
	 * Time Complexity: O(n).
	 * Space Complexity: O(n).
	 */
	public static int numberOfLeafNodes(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int numberOfLeafs = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode tmp = queue.poll();
			if (tmp.right == null && tmp.left == null)
				numberOfLeafs++;
			if (tmp.left != null)
				queue.offer(tmp.left);
			if (tmp.right != null)
				queue.offer(tmp.right);
		}
		return numberOfLeafs;
	}
	
	/*
	 * Give an algorithm for finding the number of full nodes in the binary tree without
	 * using recursion.
	 * Time Complexity: O(n).
	 * Space Complexity: O(n).
	 */
	public static int numberOfFullNodes(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int numberOfFullNodes = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode tmp = queue.poll();
			if (tmp.right != null && tmp.left != null)
				numberOfFullNodes++;
			if (tmp.left != null)
				queue.offer(tmp.left);
			if (tmp.right != null)
				queue.offer(tmp.right);
		}
		return numberOfFullNodes;
	}
	
	/*
	 * Give an algorithm for finding the number of half nodes (nodes with only one child)
	 * in the binary tree without using recursion.
	 * Time Complexity: O(n).
	 * Space Complexity: O(n).
	 */
	public static int numberOfHalfNodes(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int numberOfHalfNodes = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode tmp = queue.poll();
			if ((tmp.right != null && tmp.left == null) || (tmp.right == null && tmp.left != null))
				numberOfHalfNodes++;
			if (tmp.left != null)
				queue.offer(tmp.left);
			if (tmp.right != null)
				queue.offer(tmp.right);
		}
		return numberOfHalfNodes;
	}
	
	/*
	 * Diameter of a Tree
	 * Time Complexity: O(n).
	 * Space Complexity: O(n).
	 */
	public static int diameterOftree(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int lheight = height(root.left);
		int rheight = height(root.right);

		int ldiameter = diameterOftree(root.left);
		int rdiameter = diameterOftree(root.right);

		/* 	Return max of following three
		 *	1) Diameter of left subtree
		 *	2) Diameter of right subtree
		 *	3) Height of left subtree + height of right subtree + 1
		 */
		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
	}

	static int height(BinaryTreeNode node) {
		if (node == null)
			return 0;
		return (1 + Math.max(height(node.left), height(node.right)));
	}

	/*
	 * Give an algorithm for finding the width of the binary tree. The diameter of a tree
	 * is the maximum number of nodes at any level (or depth) in the tree.
	 */
	public static int widthOfTree(BinaryTreeNode root) {
		if (root == null)
			return 0;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		int levelMax = 0;
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> curr = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			BinaryTreeNode tmp = queue.poll();
			if (tmp != null) {
				curr.add(tmp.data);
				if (tmp.left != null)
					queue.offer(tmp.left);
				if (tmp.right != null)
					queue.offer(tmp.right);
			}
			else {
				ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
				result.add(c_curr);
				curr.clear();
				if (!queue.isEmpty()) {
					queue.offer(null);
				}
			}
		}
		for (ArrayList<Integer> childList : result) {
			if (childList.size() > levelMax)
				levelMax = childList.size();
		}
		return levelMax;
	}
	
	public static int widthOfTreeAlternative(BinaryTreeNode root) {
		int max = 0;
		int height = maxDepthRecursive(root);
		for (int i = 0; i <= height; i++) {
			int temp = width(root, i);
			if (temp > max)
				max = temp;
		}
		return max;
	}
	
	private static int width(BinaryTreeNode root, int depth) {
		if (root == null)
			return 0;
		else {
			if (depth == 0)
				return 1;
			else
				return width(root.left, depth - 1) + width(root.right, depth - 1);
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(89);
		root.left = new BinaryTreeNode(2);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(777);
		root.right = new BinaryTreeNode(3);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		root.right.left.left = new BinaryTreeNode(10);
		root.right.left.right = new BinaryTreeNode(11);
		System.out.println(maxDepthRecursive(root));
		System.out.println(maxDepthNonRecursive(root));
		System.out.println(maxDepthLevelTraversal(root));
		System.out.println("=============================");
		System.out.println(minimumDepthNonRecursive(root));
		System.out.println("=============================");
		System.out.println(deepestElementInTree(root).data);
		System.out.println("=============================");
		System.out.println(numberOfLeafNodes(root));
		System.out.println("=============================");
		System.out.println(numberOfFullNodes(root));
		System.out.println("=============================");
		System.out.println(numberOfHalfNodes(root));
		System.out.println("=============================");
		System.out.println(diameterOftree(root));
		System.out.println("=============================");
		System.out.println(widthOfTree(root));
		System.out.println("=============================");
		System.out.println(widthOfTreeAlternative(root));
	}
}
