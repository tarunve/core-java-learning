package narsimhak.practice05.trees;

import java.util.ArrayList;

public class T_002_BinaryTreesProblems_5 {
	
	public static class BinaryTreeNode {
		public Integer data;
		public BinaryTreeNode left, right;
		
		public BinaryTreeNode(Integer data) {
			this.data = data;
			left = right = null;
		}
	}

	/*
	 * How many different binary trees are possible with n nodes.
	 * Formula - (2^n -n).
	 * Time Complexity: O(n2).
	 * Space Complexity: O(n).
	 */
	public static int numberOfPossibleTrees(int numOfNodes) {
		int count[] = new int[numOfNodes + 1];
		count[0] = 1;
		count[1] = 1;
		for (int i = 2; i <= numOfNodes; i++) {
			for (int j = 0; j < i; j++) {
				count[i] += count[j] * count[i - j - 1];
			}
		}
		return count[numOfNodes];
	}

	/*
	 * how do we generate all different BSTs with n nodes?
	 */
	public static ArrayList<BinaryTreeNode> generateTrees(int n) {
		if (n == 0)
			return generateTrees(1, 0);
		return generateTrees(1, n);
	}
	
	private static ArrayList<BinaryTreeNode> generateTrees(int start, int end) {
		ArrayList<BinaryTreeNode> subTrees = new ArrayList<>();
		if (start > end) {
			subTrees.add(null);
			return subTrees;
		}
		for (int i = start; i <= end; i++) {
			for (BinaryTreeNode left : generateTrees(start, i - 1)) {
				for (BinaryTreeNode right : generateTrees(i + 1, end)) {
					BinaryTreeNode aTree = new BinaryTreeNode(i);
					aTree.left = left;
					aTree.right = right;
					subTrees.add(aTree);
				}
			}
		}
		return subTrees;
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
		//System.out.println("Number Of Trees possible :: " + numberOfPossibleTrees(3));
		int[] intArray = new int[6];
		System.out.println(intArray[0]);
		System.out.println("======================");
		generateTrees(3).forEach(node -> System.out.print(node.data + " "));
	}
}
