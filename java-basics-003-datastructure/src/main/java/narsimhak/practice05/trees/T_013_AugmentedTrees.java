package narsimhak.practice05.trees;


/*
 * 	->	In earlier sections, we have seen various problems like finding the Kth � smallest � element in the
 * 		tree and other similar ones. Of all the problems the worst complexity is O(n), where n is the number
 * 		of nodes in the tree. To perform such operations in O(logn), augmented trees are useful. In these trees,
 * 		extra information is added to each node and that extra data depends on the problem we are trying to solve.
 * 	->	For example, to find the kth element in a binary search tree, let us see how augmented trees solve the 
 * 		problem. Let us assume that we are using Red-Black trees as balanced BST (or any balanced BST) and 
 * 		augmenting the size information in the nodes data. For a given node X in Red-Black tree with a field 
 * 		size(X) equal to the number of nodes in the subtree and can be calculated as:
 * 			size(X) = size(X.left) + size(X.right) + 1
 */
public class T_013_AugmentedTrees {
	
	static class BinarySearchTreeNode {
		public int data,size;
		public BinarySearchTreeNode left;
		public BinarySearchTreeNode right;
		
		public BinarySearchTreeNode() {
		}
		
		public BinarySearchTreeNode(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	}
	
	//Kth � smallest � operation can be defined as:
	//Time Complexity: O(logn). Space Complexity: O(logn).
	public BinarySearchTreeNode kthSmallest(BinarySearchTreeNode X, int K){
		int r = X.left.size + 1;
		if(K == r)
			return X;
		if(K < r )
			return kthSmallest(X.left, K);
		if(K > r)
			return kthSmallest(X.right, K);
		return null;
	}
	
}
