package practice05.trees;


public class T_007_BSTProblems_1 {
	
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
	
	static class ListNode{
		ListNode next;
		int data;
	}
	
	BinarySearchTreeNode root;
	
	/*
	 * Given pointers to two nodes in a binary search tree, find the lowest common ancestor (LCA). 
	 * Assume that both values already exist in the tree.
	 * 	Steps:
	 * 	-----
	 * 	1.	Search the 2 nodes in Binary tree.
	 * 	2.	if(node found) 
	 * 			return node;
	 * 		else
	 * 			return null;
	 * 	3.	when some node receives both left and right pointer as not null, then it is the LCA.
	 * 		Else, return what it receives
	 */
	public static BinarySearchTreeNode findLCA(BinarySearchTreeNode root, int a, int b) {
		
		BinarySearchTreeNode nodeA = new BinarySearchTreeNode(a); 
		BinarySearchTreeNode nodeB = new BinarySearchTreeNode(b);
		if(root == null)
			return root;
		if(root == nodeA || root == nodeB)
			return root;
		if(Math.max(nodeA.data, nodeB.data) < root.data)
			return findLCA(root.left, a, b);
		else if(Math.min(nodeA.data, nodeB.data) > root.data)
			return findLCA(root.right, a, b);
		
		return root;
	}
	
	/*
	 * Give an algorithm to check whether the given binary tree is a BST or not.
	 * Time Complexity: O(n). Space Complexity: O(n), for stack space.
	 */
	public static boolean checkIfBST(BinarySearchTreeNode root){
		return checkIfBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean checkIfBSTHelper(BinarySearchTreeNode node, int min, int max){
		if(node == null)
			return true;
		if(node.data < min || node.data > max)
			return false;
		return checkIfBSTHelper(node.left, min, node.data-1) && checkIfBSTHelper(node.right, node.data+1, max);
	}
	
	/*
	 * Given a sorted doubly linked list, give an algorithm for converting it into balanced binary search tree.
	 * Solution: Find the list length and construct the tree bottom-up.
	 */
	public static BinarySearchTreeNode sortedLLToBST(ListNode head){
		int length = 0;
		ListNode currNode = head;
		while(currNode != null){
			length++;
			currNode = currNode.next;
		}
		return construct(head, length);
	}
	
	private static BinarySearchTreeNode construct(ListNode head, int length) {
		if(length <= 0)
			return null;
		BinarySearchTreeNode left = construct(head, length/2);
		BinarySearchTreeNode root = new BinarySearchTreeNode(head.data);
		root.left = left;
		head = head.next;
		root.right = construct(head, length-length/2-1);
		return root;
	}
	
	/*
	 * Given a sorted array, give an algorithm for converting the array to BST.
	 */
	public static BinarySearchTreeNode sortedArrayToBST(int array[], int left, int right){
		BinarySearchTreeNode newNode ;
		if(left > right){
			return null;
		}
		newNode = new BinarySearchTreeNode();
		if(left == right){
			newNode.data = array[left];
			newNode.left = null;
			newNode.right = null;
		} else {
			int mid = left + (right-left)/2 ;
			newNode.data = array[mid];
			newNode.left = sortedArrayToBST(array, left, mid-1);
			newNode.right = sortedArrayToBST(array, mid+1, right);
		}
		return newNode;
	}
	
	/*
	 * Give an algorithm for finding the kth smallest element in BST.
	 * Time Complexity: O(n). Space Complexity: O(1).
	 */
	public static BinarySearchTreeNode kthSmallestInBST(BinarySearchTreeNode root, int k , int count){
		if(root==null)
			return null;
		BinarySearchTreeNode left = kthSmallestInBST(root.left, k, count);
		if(left != null)
			return left;
		if(++count == k)
			return root;
		return kthSmallestInBST(root.right, k, count);
	}
	
	
	/* A utility function to print preorder traversal of BST */
    static void preOrder(BinarySearchTreeNode node) { 
        if (node == null) { 
            return; 
        } 
        System.out.print(node.data + " "); 
        preOrder(node.left); 
        preOrder(node.right); 
    } 

	public static void main(String[] args) 
	    { 
		 	T_007_BSTProblems_1 tree = new T_007_BSTProblems_1(); 
	        tree.root = new BinarySearchTreeNode(20); 
	        tree.root.left = new BinarySearchTreeNode(8); 
	        tree.root.right = new BinarySearchTreeNode(22); 
	        tree.root.left.left = new BinarySearchTreeNode(4); 
	        tree.root.left.right = new BinarySearchTreeNode(12); 
	        tree.root.left.right.left = new BinarySearchTreeNode(10); 
	        tree.root.left.right.right = new BinarySearchTreeNode(14); 
	   
	        int n1 = 10, n2 = 14; 
	        BinarySearchTreeNode t = findLCA(tree.root, n1, n2); 
	        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data); 
	        n1 = 14; 
	        n2 = 8; 
	        t = findLCA(tree.root, n1, n2); 
	        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data); 
	        n1 = 10; 
	        n2 = 22; 
	        t = findLCA(tree.root, n1, n2); 
	        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data); 
	        System.out.println("================================================");
	        System.out.println(checkIfBST(tree.root));
	        System.out.println("================================================");
	        BinarySearchTreeNode root1 = new BinarySearchTreeNode(); 
	        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7}; 
	        int n = arr.length; 
	        root1 = sortedArrayToBST(arr, 0, n - 1); 
	        System.out.print("Preorder traversal of constructed BST :: "); 
	        preOrder(root1); 
	        System.out.println();
	        System.out.println("================================================");
	    } 
	
}
