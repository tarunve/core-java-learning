package practice05.trees;

/*
 * 	->	Splay-trees are BSTs with a self-adjusting property. Another interesting property of splay-trees is: 
 * 		starting with an empty tree, any sequence of K operations with maximum of n nodes takes O(Klogn) time 
 * 		complexity in worst case.
 * 	->	Splay trees are easier to program and also ensure faster access to recently accessed items. Similar to 
 * 		AVL and Red-Black trees, at any point that the splay tree becomes imbalanced, we can perform rotations 
 * 		to reinforce the balancing property.
 * 	->	Splay-trees cannot guarantee the O(logn) complexity in worst case. But it gives amortized O(logn) complexity. 
 * 		Even though individual operations can be expensive, any sequence of operations gets the complexity of 
 * 		logarithmic behavior. One operation may take more time (a single operation may take O(n) time) but the 
 * 		subsequent operations may not take worst case complexity and on the average per operation complexity is O(logn).
 */
public class T_011_SplayTrees {
	
}
