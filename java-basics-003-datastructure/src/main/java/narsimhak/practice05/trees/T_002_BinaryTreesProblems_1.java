package narsimhak.practice05.trees;

import java.util.LinkedList;
import java.util.Queue;

public class T_002_BinaryTreesProblems_1 {

	public static class BinaryTreeNode {
		public Integer data;
		public BinaryTreeNode left, right;

		public BinaryTreeNode(Integer data) {
			this.data = data;
			left = right = null;
		}
	}
	
	/*
	 * Give an algorithm for finding maximum element in binary tree.
	 * Time Complexity		: O(n)
	 * Space Complexity		: O(n)
	 */
	public static int findMaxRecursive(BinaryTreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;
		int maxValue = Integer.MIN_VALUE;
		int maxLeftSubTree = findMaxRecursive(root.left);
		int maxRightSubTree = findMaxRecursive(root.right);
		maxValue = (maxLeftSubTree > maxRightSubTree) ? maxLeftSubTree : maxRightSubTree;
		if (root.data > maxValue)
			maxValue = root.data;
		return maxValue;
	}

	public static int findMaxNonRecursive(BinaryTreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;
		int maxValue = Integer.MIN_VALUE;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode tmp = queue.poll();
			if (tmp != null) {
				if (tmp.left != null)
					queue.offer(tmp.left);
				if (tmp.right != null)
					queue.offer(tmp.right);
				
				if (tmp.data > maxValue)
					maxValue = tmp.data;
			}
		}
		return maxValue;
	}
	
	/*
	 * Give an algorithm for finding element in binary tree.
	 * Time Complexity		: O(n)
	 * Space Complexity		: O(n)
	 */
	public static boolean findElementRecursive(BinaryTreeNode root, int key) {
		if (root == null)
			return false;
		if (root.data == key)
			return true;
		return findElementRecursive(root.left, key) || findElementRecursive(root.right, key);
	}

	public static boolean findElementNonRecursive(BinaryTreeNode root, int key) {
		if (root == null)
			return false;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode tmp = queue.poll();
			if (tmp.data == key)
				return true;
			if (tmp != null) {
				if (tmp.left != null)
					queue.offer(tmp.left);
				if (tmp.right != null)
					queue.offer(tmp.right);
			}
		}
		return false;
	}
	
	/*
	 * Give an algorithm for inserting an element into binary tree
	 * Time Complexity	: O(n)
	 * Space Complexity	: O(n)
	 */
	public static BinaryTreeNode insertElementNonRecusive(BinaryTreeNode root, int data) {
		BinaryTreeNode newNode = new BinaryTreeNode(data);
		if (root == null) {
			root = newNode;
			return root;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode tmp = queue.poll();
			if (tmp.left != null)
				queue.offer(tmp.left);
			else {
				tmp.left = newNode;
				return root;
			}
			if (tmp.right != null) {
				queue.offer(tmp.right);
			}
			else {
				tmp.right = newNode;
				return root;
			}
		}
		return root;
	}
	
	public static BinaryTreeNode insertElementRecusive(BinaryTreeNode root, int data) {
		if (root == null) {
			root = new BinaryTreeNode(data);
		}
		else {
			insertHelper(root, data);
		}
		return root;
	}

	public static void insertHelper(BinaryTreeNode root, int data) {
		BinaryTreeNode newNode = new BinaryTreeNode(data);
		if (root.data >= data) {
			if (root.left == null)
				root.left = newNode;
			else
				insertElementRecusive(root.left, data);
		}
		else {
			if (root.right == null) {
				root.right = newNode;
			}
			else {
				insertElementRecusive(root.right, data);
			}
		}
	}
	
	/*
	 * Give an algorithm for finding the size of binary tree.
	 * Time Complexity	: O(n)
	 * Space Complexity	: O(n)
	 */
	public static int sizeOfTreeRecursion(BinaryTreeNode root) {
		int leftCount = (root.left == null ? 0 : sizeOfTreeRecursion(root.left));
		int rightCount = (root.right == null ? 0 : sizeOfTreeRecursion(root.right));
		return 1 + leftCount + rightCount;
	}
	
	public static int sizeOfTreeNonRecursive(BinaryTreeNode root) {
		if (root == null)
			return 0;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int size = 0;
		while (!queue.isEmpty()) {
			BinaryTreeNode tmp = queue.poll();
			size++;
			if (tmp.left != null)
				queue.offer(tmp.left);
			if (tmp.right != null)
				queue.offer(tmp.right);
		}
		return size;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(89);
		root.left = new BinaryTreeNode(2);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(777);
		root.right = new BinaryTreeNode(3);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		System.out.println("Max value Recursion : " + findMaxRecursive(root));
		System.out.println("Max value Without Recursion : " + findMaxNonRecursive(root));
		System.out.println("=====================================");
		System.out.println("Find Element Recursive 6 : " + findElementRecursive(root, 6));
		System.out.println("Find Element Non Recursive 6 : " + findElementNonRecursive(root, 6));
		System.out.println("=====================================");
		BinaryTreeNode root1 = insertElementNonRecusive(null, 6);
		insertElementNonRecusive(root1, 78);
		insertElementNonRecusive(root1, 75);
		insertElementNonRecusive(root1, 79);
		insertElementNonRecusive(root1, 78);
		System.out.println(root1);
		BinaryTreeNode root2 = new BinaryTreeNode(4);
		insertElementRecusive(root2, 6);
		insertElementRecusive(root2, 78);
		insertElementRecusive(root2, 75);
		insertElementRecusive(root2, 79);
		insertElementRecusive(root2, 78);
		System.out.println(root2);
		System.out.println("=====================================");
		System.out.println(sizeOfTreeRecursion(root1));
		System.out.println(sizeOfTreeNonRecursive(root2));
		System.out.println("=====================================");
	}
}
