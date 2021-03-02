package narsimhak.practice05.trees;

import java.util.LinkedList;
import java.util.Queue;

public class T_009_AVLTreesProblems_1 {
	
	static class BinaryTreeNode {
		public int data;
		public BinaryTreeNode left, right, next;
		
		public BinaryTreeNode(int data) {
			this.data = data;
			left = right = next =null;
		}
	}
	
	static class BinarySearchTreeNode {
		public int data;
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
	
	static class AVLTreeNode{
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
	 * Given a height h, give an algorithm for generating the HB(0).
	 * As we have discussed, HB(0) is nothing but generating full binary tree. In full binary tree the number of nodes 
	 * with height h is: 2h+1 � 1 (let us assume that the height of a tree with one node is 0). As a result the nodes 
	 * can be numbered as: 1 to 2h+1 � 1.
	 * 
	 * Time Complexity: O(n). Space Complexity: O(logn), where logn indicates the maximum stack size which is equal 
	 * to height of the tree.
	 */
	static int count = 0;
	public static BinarySearchTreeNode buildHB0(int h){
		BinarySearchTreeNode temp;
		if(h==0)
			return null;
		temp = new BinarySearchTreeNode();
		temp.left = buildHB0(h-1);
		temp.data = count++;
		temp.right = buildHB0(h-1);
		return temp;
	}
	
	/*
	 * Given a binary search tree, check whether it is an AVL tree or not?
	 * Time Complexity: O(n). Space Complexity: O(n).
	 */
	public static boolean isAVL(BinarySearchTreeNode root){
		if(root == null)
			return true;
		return isAVL(root.left) && isAVL(root.right) && (Math.abs(getHeight(root.left) - getHeight(root.right)) <=1);
	}

	private static int getHeight(BinarySearchTreeNode root) {
		int leftHeight , rightHeight;
		if(root == null)
			return 0;
		else{
			leftHeight = getHeight(root.left);
			rightHeight = getHeight(root.right);
			if(leftHeight > rightHeight)
				return leftHeight + 1;
			else 
				return rightHeight +1;
		}
	}
	
	/*
	 * Given a height h, give an algorithm for generating an AVL tree with minimum number of nodes.
	 */
	public static AVLTreeNode generateAVLMinTree(int h){
		AVLTreeNode temp ;
		if(h==0)
			return null;
		temp = new AVLTreeNode();
		temp.left = generateAVLMinTree(h-1);
		temp.data = count++;
		temp.right = generateAVLMinTree(h-2);
		temp.height = temp.left.height + 1;
		return temp;
	}
	
	/*
	 * Given an AVL tree with n integer items and two integers a and b, where a and b can be any 
	 * integers with a <= b. Implement an algorithm to count the number of nodes in the range [a, b].
	 */
	public static int rangeCountAVLTree(AVLTreeNode root , int a, int b){
		if(root == null)
			return 0;
		else if(root.data < a)
			return rangeCountAVLTree(root.right, a, b);
		else if(root.data > b)
			return rangeCountAVLTree(root.left, a, b);
		else if(root.data <= a && root.data >= b)
			return rangeCountAVLTree(root.left, a, b) + rangeCountAVLTree(root.right, a, b) +1;
		return 0;
	}
	
	/*
	 * Given a binary tree, how do you remove all the half nodes (which have only one child)? Note 
	 * that we should not touch leaves.
	 * Time Complexity: O(n).
	 */
	public static BinarySearchTreeNode removeHalfNodes(BinarySearchTreeNode root){
		if(root == null)
			return null;
		root.left =  removeHalfNodes(root.left);
		root.right = removeHalfNodes(root.right);
		if(root.left == null && root.right == null)
			return root;
		if(root.left == null)
			return root.right;
		if(root.right == null)
			return root.left;
		return root;
	}
	
	/*
	 * Given a binary tree, how do you connect all the adjacent nodes at the same level? Assume that 
	 * given binary tree has next pointer along with left and right pointers.
	 */
	public static void linkLevelNodes(BinaryTreeNode root){
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();  
        q.add(root); 
        q.add(null);  
       
        while (!q.isEmpty()) { 
        	BinaryTreeNode p = q.peek(); 
            q.remove(); 
            if (p != null) { 
                p.next = q.peek(); 
                if (p.left != null) 
                    q.add(p.left);  
                if (p.right != null) 
                    q.add(p.right); 
            }  
            else if (!q.isEmpty())  
                q.add(null);  
        } 
	}
}
