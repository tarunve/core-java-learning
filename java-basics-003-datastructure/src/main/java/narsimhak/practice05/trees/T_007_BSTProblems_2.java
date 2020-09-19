package practice05.trees;

public class T_007_BSTProblems_2 {
	
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
	
	BinarySearchTreeNode root;
	
	/*
	 * Given a BST and two numbers K1 and K2, give an algorithm for printing all the elements of BST in the range K1 and K2
	 * Time Complexity: O(n). Space Complexity: O(n), for stack space
	 */
	public static void rangePrinter(BinarySearchTreeNode root, int K1, int K2){
		if(root == null)
			return;
		if(root.data >= K1)
			rangePrinter(root.left, K1, K2);
		if(root.data >= K1 && root.data <= K2)
			System.out.print(root.data + " ");
		if(root.data <= K2)
			rangePrinter(root.right, K1, K2);
	}
	
	public static void main(String[] args) 
    { 
	 	T_007_BSTProblems_2 tree = new T_007_BSTProblems_2(); 
        tree.root = new BinarySearchTreeNode(20); 
        tree.root.left = new BinarySearchTreeNode(8); 
        tree.root.right = new BinarySearchTreeNode(22); 
        tree.root.left.left = new BinarySearchTreeNode(4); 
        tree.root.left.right = new BinarySearchTreeNode(12); 
        tree.root.left.right.left = new BinarySearchTreeNode(10); 
        tree.root.left.right.right = new BinarySearchTreeNode(14); 
        rangePrinter(tree.root, 1, 20);
        System.out.println("============================================");
        
    }
	
}
