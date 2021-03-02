package narsimhak.practice05.trees;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class T_002_BinaryTreesProblems_3 {
	
	public static class BinaryTreeNode {
		public Integer data;
		public BinaryTreeNode left, right;

		public BinaryTreeNode(Integer data) {
			this.data = data;
			left = right = null;
		}
	}
	
	/*
	 * Give an algorithm for finding the level that has the maximum sum in the binary tree.
	 * Time Complexity: O(n).
	 * Space Complexity: O(n)
	 */
	public static int maxLeveBySum(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int level = 1, sum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		queue.offer(null);
		while (!queue.isEmpty()) {
			BinaryTreeNode tmp = queue.poll();
			if (tmp != null) {
				sum += tmp.data;
				if (tmp.left != null)
					queue.offer(tmp.left);
				if (tmp.right != null)
					queue.offer(tmp.right);
			}
			else {
				map.put(sum, level);
				level++;
				sum = 0;
				if (!queue.isEmpty()) {
					queue.offer(null);
				}
			}
		}
		return Integer.valueOf(map.get(Collections.max(map.keySet())));
	}

	/*
	 * Given a binary tree, print out all its root-to-leaf paths
	 * Time Complexity: O(n).
	 * Space Complexity: O(n)
	 */
	public static void printRootToLeafPath(BinaryTreeNode root) {
		int path[] = new int[5];
		printPathsRecur(root, path, 0);
	}

	public static void printPathsRecur(BinaryTreeNode root, int path[], int pathLen) {
		if (root == null)
			return;
		path[pathLen] = root.data;
		pathLen++;
		if (root.left == null && root.right == null) {
			System.out.println(Arrays.toString(path));
		}
		else {
			printPathsRecur(root.left, path, pathLen);
			printPathsRecur(root.right, path, pathLen);
		}
	}
	
	/*
	 * Give an algorithm for checking the existence of path with given sum. That
	 * means, given a sum, check whether there exists a path from root to any of the nodes.
	 * Time Complexity: O(n).
	 * Space Complexity: O(n)
	 */
	public static boolean ifPathExistswithSum(BinaryTreeNode root, int target) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.data == target)
			return true;
		return (ifPathExistswithSum(root.left, target - root.data) || ifPathExistswithSum(root.right, target - root.data));
	}

	/*
	 * Give an algorithm for converting a tree to its mirror. Mirror of a tree is another
	 * tree with left and right children of all non-leaf nodes interchanged
	 * Time Complexity: O(n).
	 * Space Complexity: O(n).
	 */
	public static BinaryTreeNode convertToMirrorTree(BinaryTreeNode root) {
		BinaryTreeNode temp;
		while (root != null) {
			convertToMirrorTree(root.left);
			convertToMirrorTree(root.right);
			temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}
	
	/*
	 * Given two trees, give an algorithm for checking whether they are mirrors of each other.
	 * Time Complexity: O(n).
	 * Space Complexity: O(n).
	 */
	public static boolean ifTreeAreMirrors(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.data != root2.data)
			return false;
		return ifTreeAreMirrors(root1.left, root2.right) || ifTreeAreMirrors(root1.right, root2.left);
	}
	
	/*
	 * Give an algorithm for constructing binary tree from given InOrder and PreOrder traversals.
	 * InOrder Sequence 	:	D B E A F C
	 * PreOrder sequence	: 	A B D E C F
	 * Time Complexity: O(n).
	 * Space Complexity: O(1).
	 */
	public static BinaryTreeNode buildBTFromInAndPreorder(int[] preOrder, int[] inOrder) {
		if (preOrder.length == 0 || inOrder.length == 0 || preOrder.length != inOrder.length)
			return null;
		return buildBinaryTreeFromTraversals(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
	}

	private static BinaryTreeNode buildBinaryTreeFromTraversals(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd)
			return null;
		int data = preOrder[preStart];
		BinaryTreeNode curr = new BinaryTreeNode(data);
		int offset = inStart;
		for (; offset < inEnd; offset++) {
			if (inOrder[offset] == data) {
				break;
			}
		}
		curr.left = buildBinaryTreeFromTraversals(preOrder, preStart + 1, preStart + offset - inStart, inOrder, inStart, offset - 1);
		curr.right = buildBinaryTreeFromTraversals(preOrder, preStart + offset - inStart + 1, preEnd, inOrder, offset + 1, inEnd);
		return curr;
	}
	
	/*
	 * Give an algorithm for constructing binary tree from given InOrder and PostOrder traversals.
	 * InOrder Sequence 	:	D B E A F C
	 * PostOrder sequence	: 	D E B F C A
	 * Time Complexity: O(n).
	 * Space Complexity: O(1).
	 */
	public static BinaryTreeNode buildBTFromInAndPostOrder(int[] postOrder, int[] inOrder) {
		if (postOrder.length == 0 || inOrder.length == 0 || postOrder.length != inOrder.length)
			return null;
		return buildBTFromTraversals(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length - 1);
	}

	private static BinaryTreeNode buildBTFromTraversals(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd) {
		if (postStart > postEnd || inStart > inEnd)
			return null;
		int data = postOrder[postEnd];
		BinaryTreeNode curr = new BinaryTreeNode(data);
		int offset = inStart;
		for (; offset < inEnd; offset++) {
			if (inOrder[offset] == data) {
				break;
			}
		}
		curr.left = buildBTFromTraversals(postOrder, postStart, postStart + offset - inStart - 1, inOrder, inStart, offset - 1);
		curr.right = buildBTFromTraversals(postOrder, postStart + offset - inStart, postEnd - 1, inOrder, offset + 1, inEnd);
		return curr;
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
		System.out.println(maxLeveBySum(root));
		System.out.println("=========================");
		printRootToLeafPath(root);
		System.out.println("=========================");
		System.out.println(ifPathExistswithSum(root, 95));
	}
}
