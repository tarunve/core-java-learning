package narsimhak.practice05.trees;


public class T_003_GenericTreesProblems_1 {

	public static class GenericTreeNode {
		Integer data;
		GenericTreeNode firstChild;
		GenericTreeNode nextSibling;

		public GenericTreeNode(Integer data) {
			this.data = data;
			firstChild = null;
			nextSibling = null;
		}
	}

	/*
	 * Given a tree, give an algorithm for finding the sum of all the elements of the tree.
	 */
	public static int findSumTree(GenericTreeNode root) {
		if (root == null)
			return 0;
		return root.data + findSumTree(root.firstChild) + findSumTree(root.nextSibling);
	}

	/*
	 * Given a parent array P, where P[i] indicates the parent of ith node in the tree
	 * (assume parent of root node is indicated with �1). Give an algorithm for finding the height
	 * or depth of the tree.
	 * Time Complexity: O(n^2). For skew trees we will be calculating the same values again and again.
	 * Space Complexity: O(1)
	 */
	public static int findDepth(int[] parents) {
		int maxDepth = -1, currentDepth = -1, j;
		for (int i = 0; i < parents.length; i++) {
			currentDepth = 0;
			j = i;
			while (parents[j] != -1) {
				currentDepth++;
				j = parents[j];
			}
			if (currentDepth > maxDepth)
				maxDepth = currentDepth;
		}
		return maxDepth;
	}
}
