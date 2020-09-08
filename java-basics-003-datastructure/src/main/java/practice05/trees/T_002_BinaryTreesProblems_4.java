package practice05.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class T_002_BinaryTreesProblems_4 {

	public static class BinaryTreeNode {
		public Integer data;
		public BinaryTreeNode left, right;

		public BinaryTreeNode(Integer data) {
			this.data = data;
			left = right = null;
		}
	}
	
	/*
	 * Give an algorithm for printing all the ancestors of a node in a Binary tree. For
	 * the tree below, for 7 the ancestors are 1 3 7.
	 * Time Complexity: O(n).
	 * Space Complexity: O(n) for recursion.
	 */
	public static boolean printAllAncestorNodes(BinaryTreeNode root, int data) {
		if (root == null)
			return false;
		if (root.data == data)
			return true;
		if (printAllAncestorNodes(root.left, data) || printAllAncestorNodes(root.right, data)) {
			System.out.print(root.data + " ");
			return true;
		}
		return false;
	}

	/*
	 * Give an algorithm for finding LCA (Least Common Ancestor) of two nodes in a Binary Tree.
	 * Time Complexity: O(n).
	 * Space Complexity: O(n) for recursion.
	 */
	public static BinaryTreeNode getLeastCommonAncestor(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
		BinaryTreeNode left, right;
		if (root == null)
			return root;
		if (root == node1 || root == node2)
			return root;
		left = getLeastCommonAncestor(root.left, node1, node2);
		right = getLeastCommonAncestor(root.right, node1, node2);
		if (left != null && right != null)
			return root;
		else
			return (left != null) ? left : right;
	}
	
	/*
	 * Zigzag Tree Traversal: Give an algorithm to traverse a binary tree in Zigzag
	 * order. For example, the output for the tree below should be: 1 3 2 4 5 6 7
	 * Time Complexity: O(n).
	 * Space Complexity: Space for two stacks = O(n) + O(n) = O(n).
	 */
	public static ArrayList<ArrayList<Integer>> zigZagTraversal(BinaryTreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		queue.offer(null);
		ArrayList<Integer> curr = new ArrayList<>();
		boolean leftToRight = true;
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
				if (leftToRight) {
					ArrayList<Integer> c_curr = new ArrayList<>(curr);
					result.add(c_curr);
					curr.clear();
				}
				else {
					Stack<Integer> stack = new Stack<>();
					stack.addAll(curr);
					ArrayList<Integer> c_curr = new ArrayList<>();
					while (!stack.isEmpty()) {
						c_curr.add(stack.pop());
					}
					result.add(c_curr);
					curr.clear();
				}
				if (!queue.isEmpty()) {
					queue.offer(null);
					leftToRight = !leftToRight;
				}
			}
		}

		return result;
		
	}
	
	/*
	 * Give an algorithm for finding the vertical sum of a binary tree.
	 * Time Complexity: O(n)
	 */
	public static void verticalSum(BinaryTreeNode root) {
		if (root == null)
			return;
		HashMap<Integer, Integer> map = new HashMap<>();
		verticalSumHelper(root, 0, map);
		if (map != null)
			System.out.println(map.entrySet());
	}
	
	public static void verticalSumHelper(BinaryTreeNode root, int horizontalDistance, Map<Integer, Integer> map) {
		if (root == null)
			return;
		verticalSumHelper(root.left, horizontalDistance - 1, map);
		int prevSum = (map.get(horizontalDistance) == null) ? 0 : map.get(horizontalDistance);
		map.put(horizontalDistance, prevSum + root.data);
		verticalSumHelper(root.right, horizontalDistance + 1, map);
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
		printAllAncestorNodes(root, 10);
		System.out.println();
		System.out.println("====================");
		System.out.println(getLeastCommonAncestor(root, root.right.left.right, root.right.right).data);
		System.out.println("====================");
		System.out.println(Arrays.toString(zigZagTraversal(root).toArray()));
		System.out.println("====================");
		verticalSum(root);
	}

}
