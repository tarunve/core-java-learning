package narsimhak.practice05.trees;

/*
 * 	Adelson-Velskii and Landis
 * 	--------------------------
 * 	->	In HB(k), if k = 1 (if balance factor is one), such a binary search tree is called an AVL tree. That means 
 * 		an AVL tree is a binary search tree with a balance condition: the difference between left subtree height and 
 * 		right subtree height is at most 1.
 * 	->	A binary tree is said to be an AVL tree, if:
 * 		->	It is a binary search tree, and
 * 		->	For any node X, the height of left subtree of X and height of right subtree of X differ by at most 1.
 * 
 * 	->	Minimum Number of nodes in AVL Trees :- N(h) = N(h-1) + N(h-2) + 1 
 * 											 ==>	N(h) = O(1.618^h)
 * 											 ==>	h = 1.44logn  ==> O(logn)
 * 	->	Maximum Number of nodes in AVL Trees :- N(h) = N(h-1) + N(h-1) + 1 
 * 											 ==>	N(h) = O(2^h)
 * 											 ==>	h = logn  ==> O(logn)
 * 		In both the cases, AVL tree property is ensuring that the height of an AVL tree with n nodes is O(logn).
 * 	-> 	Number of shapes in AVL Trees ==> NS(h) = 2 * NS(h-1) * NS(h-2) 
 * 
 * 	Types of Violations
 * 	-------------------
 * 	->	Let us assume the node that must be re-balanced is X. Since any node has at most two children, and a height 
 * 		imbalance requires that X�s two subtree heights differ by two, we can easily observe that a violation might 
 * 		occur in four cases:
 * 		1.	An insertion into the left subtree of the left child of X.
 * 		2.	An insertion into the right subtree of the left child of X.
 * 		3.	An insertion into the left subtree of the right child of X.
 * 		4.	An insertion into the right subtree of the right child of X.
 */
public class T_009_AVLTrees {
	
	class AVLTreeNode{
		int data, height;
		AVLTreeNode left, right;
		
		public int getHeight(AVLTreeNode root){
			if(root == null)
				return -1;
			else 
				return root.height;
		}
	}
	
	/*
	 * Left Left Rotation (LL Rotation) [Case-1]: In the case below, node X is not satisfying the AVL tree property. 
	 * As discussed earlier, the rotation does not have to be done at the root of a tree. In general, we start at the 
	 * node inserted and travel up the tree, updating the balance information at every node on the path.
	 */
	public AVLTreeNode singleRotateLeft(AVLTreeNode X){
		AVLTreeNode W = X.left;
		X.left = W.right;
		W.right = X;
		X.height = Math.max(X.left.height, X.right.height) +1;
		W.height = Math.max(W.left.height, X.height) + 1;
		return W;
	}
	
	/*
	 * Right Right Rotation (RR Rotation) [Case-4]: In this case, node X is not satisfying the AVL
	 */
	public AVLTreeNode singleRotateRight(AVLTreeNode W){
		AVLTreeNode X = W.right;
		W.right = X.left;
		X.left = W;
		W.height = Math.max(W.right.height, W.left.height) +1;
		X.height = Math.max(X.right.height, W.height) + 1;
		return X;
	}
	
	/*
	 * Left Right Rotation (LR Rotation) [Case-2]: For case-2 and case-3 single rotation does not fix the problem. 
	 * We need to perform two rotations.
	 */
	public AVLTreeNode doubleRotateLeft(AVLTreeNode Z){
		Z.left = singleRotateRight(Z.left);
		return singleRotateLeft(Z);
	}
	
	/*
	 * Right Left Rotation (RL Rotation) [Case-3]: Similar to case-2, we need to perform two rotations to fix this scenario.
	 */
	public AVLTreeNode doubleRotateRight(AVLTreeNode Z){
		Z.right = singleRotateLeft(Z.right);
		return singleRotateRight(Z);
	}
	
	/*
	 * Insert Method 
	 */
	public AVLTreeNode insert(AVLTreeNode root, AVLTreeNode parent , int data){
		if(root == null){
			root = new AVLTreeNode();
			root.data = data;
			root.height = 0;
			root.left = null;
			root.right = null;
		} else if(data < root.data){
			root.left = insert(root.left, root, data);
			if(root.left.height - root.right.height == 2){
				if(data < root.left.data)
					root = singleRotateLeft(root);
				else
					root = doubleRotateLeft(root);
			}
		} else if(data > root.data){
			root.right = insert(root.right, root, data);
			if(root.right.height - root.left.height == 2){
				if(data < root.right.data)
					root = singleRotateRight(root);
				else
					root = doubleRotateRight(root);
			}
		}
		root.height = Math.max(root.left.height, root.right.height) + 1;
		return root;
	}
}
