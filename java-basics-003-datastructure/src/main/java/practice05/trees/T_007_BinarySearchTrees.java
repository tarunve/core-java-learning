package practice05.trees;

/*
 * 	->	As the name suggests, the main use of this representation is for searching. In this 
 * 		representation we impose restriction on the kind of data a node can contain. As a result, 
 * 		it reduces the worst case average search operation to O(logn).
 * 	->	In binary search trees, all the left subtree elements should be less than root data and 
 * 		all the right subtree elements should be greater than root data. This is called binary 
 * 		search tree property. Note that, this property should be satisfied at every node in the tree.
 * 		->	The left subtree of a node contains only nodes with keys less than the nodes key.
 * 		->	The right subtree of a node contains only nodes with keys greater than the nodes key.
 * 		->	Both the left and right subtrees must also be binary search trees
 * 
 * 	->	If X has two children then its inorder predecessor is the maximum value in its left subtree and its
 * 		inorder successor the minimum value in its right subtree.
 * 	->	If it does not have a left child, then a nodes inorder predecessor is its first left ancestor.
 */
public class T_007_BinarySearchTrees {
	
	class BinarySearchTreeNode {
		public int data;
		public BinarySearchTreeNode left;
		public BinarySearchTreeNode right;
		
		public BinarySearchTreeNode() {
		}
		
		BinarySearchTreeNode(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	/*	Insertion in BST
	 * 	Time Complexity: O(n).
	 * 	Space Complexity: O(n), for recursive stack. For iterative version, space complexity is O(1).
	 */
	public BinarySearchTreeNode insert(BinarySearchTreeNode root, int data){
		BinarySearchTreeNode newNode = new BinarySearchTreeNode(data);
		if(root == null){
			root = newNode;
		} else {
			if(data < root.data){
				root.left = insert(root.left , data);
			} else{
				root.right = insert(root.right, data);
			}
		}
		return root;
	}
	
	/*	Seletion in BST
	 * 	Time Complexity: O(n).
	 * 	Space Complexity: O(n), for recursive stack. For iterative version, space complexity is O(1).
	 */
	public BinarySearchTreeNode delete(BinarySearchTreeNode root, int data){
		BinarySearchTreeNode temp;
		if(root == null)
			System.out.println("Element is not there in Tree");
		else if(data < root.data)
			root.left = delete(root.left, data);
		else if(data > root.data)
			root.right = delete(root.right, data);
		else {  //Found element
			if(root.left != null && root.right != null){
				//replace with largest in left subtree
				temp = 	findMax(root.left);
				root.data  = temp.data;
				root.left = delete(root.left, root.data);
			} else{
				temp = root;
				if(root.left == null)
					root = root.right;
				if(root.right == null)
					root = root.left;
			}
		}
		return root;
	}

	private BinarySearchTreeNode findMax(BinarySearchTreeNode left) {
		return null;
	}
}
