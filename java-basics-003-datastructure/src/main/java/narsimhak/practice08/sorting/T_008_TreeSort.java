package narsimhak.practice08.sorting;

/*
 * 	->	Tree sort uses a binary search tree. It involves scanning each element of the input and placing it 
 * 		into its proper position in a binary search tree. This has two phases:
 * 		� First phase is creating a binary search tree using the given array elements.
 * 		� Second phase is traversing the given binary search tree in in-order, thus resulting in a sorted array.
 * 	->	The average number of comparisons for this method is O(nlogn). But in worst case, the number of
 * 		comparisons is reduced by O(n2), a case which arises when the sort tree is skew tree.
 */
public class T_008_TreeSort {
	
	static class Node { 
        int data; 
        Node left, right; 
  
        public Node(int item) { 
            data = item; 
            left = right = null; 
        } 
    } 
	
	static class BST{
		static Node root = null;
		
		public static Node insert(Node root, int data){
			if(root == null){
				root = new Node(data);
				return root;
			}
			
			if(data < root.data)
				root.left = insert(root.left , data);
			else if(data > root.data)
				root.right = insert(root.right, data);
			return root;
		}
		
		public static void insertFromArray(int arr[]){ 
	        for(int i = 0; i < arr.length; i++) 
	            insertFromArr(arr[i]); 
	    }

		public static void insertFromArr(int data) {
			root = insert(root, data);
		} 
		
		public static void inOrderRecursion(Node root){ 
	        if (root != null) { 
	        	inOrderRecursion(root.left); 
	            System.out.print(root.data + " "); 
	            inOrderRecursion(root.right); 
	        } 
	    } 
	}
	
	 public static void main(String[] args){ 
        int arr[] = {5, 4, 7, 2, 11,67,888,1,3,3,88,56}; 
        BST.insertFromArray(arr); 
        BST.inOrderRecursion(BST.root); 
    } 
}
