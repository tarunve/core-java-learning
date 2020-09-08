package practice05.trees;

/*
 *	->	B-Tree is like other self-balancing trees such as AVL and Red-black tree such that it maintains its balance 
 * 		of nodes while operations are performed against it. B-Tree has the following properties: 
 * 		->	Minimum degree “t” where, except root node, all other nodes must have no less than (t – 1) keys
 * 		->	Each node with n keys has n + 1 children
 * 		->	Keys in each node are lined up where k1 < k2 < .. kn
 * 		->	Each node cannot have more than 2t-l keys, thus 2t children
 * 		->	Root node at least must contain one key. There is no root node if the tree is empty.
 * 		->	Tree grows in depth only when root node is split.
 * 	->	Unlike a binary-tree, each node of a b-tree may have a variable number of keys and children. The keys are 
 * 		stored in non-decreasing order. Each key has an associated child that is the root of a subtree containing 
 * 		all nodes with keys less than or equal to the key but greater than the preceding key. A node also has an 
 * 		additional rightmost child that is the root for a subtree containing all keys greater than any keys in the node.
 * 	->	A b-tree has a minimum number of allowable children for each node known as the minimization factor. If t is 
 * 		this minimization factor, every node must have at least t – 1 keys. Under certain circumstances, the root 
 * 		node is allowed to violate this property by having fewer than t – 1 keys. 
 * 	->	Every node may have at most 2t – 1 keys or, equivalently, 2t children. Since each node tends to have a 
 * 		large branching factor (a large number of children), it is typically necessary to traverse relatively 
 * 		few nodes before locating the desired key. If access to each node requires a disk access, then a B-tree 
 * 		will minimize the number of disk accesses required. The minimization factor is usually chosen so that the 
 * 		total size of each node corresponds to a multiple of the block size of the underlying storage device. 
 * 		This choice simplifies and optimizes disk access. Consequently, a B-tree is an ideal data structure for 
 * 		situations where all data cannot reside in primary storage and accesses to secondary storage are comparatively 
 * 		expensive (or time consuming).
 * 	->	To search the tree, it is similar to binary tree except that the key is compared multiple times in a given node 
 * 		because the node contains more than 1 key. If the key is found in the node, the search terminates. Otherwise,
 * 		it moves down where at child pointed by ci where key k < ki. 
 * 	->	Key insertions of a B-tree happens from the bottom fashion. This means that it walk down the tree from root to the 
 * 		target child node first. If the child is not full, the key is simply inserted. If it is full, the child node is 
 * 		split in the middle, the median key moves up to the parent, then the new key is inserted. When inserting and 
 * 		walking down the tree, if the root node is found to be full, it’s split first and we have a new root node. 
 * 		Then the normal insertion operation is performed.
 * 	->	Key deletion is more complicated as it needs to maintain the number of keys in each node to meet the constraint. 
 * 		If a key is found in leaf node and deleting it still keeps the number of keys in the nodes not too low, it’s 
 * 		simply done right away. If it’s done to the inner node, the predecessor of the key in the corresponding child 
 * 		node is moved to replace the key in the inner node. If moving the predecessor will cause the child node to 
 * 		violate the node count constraint, the sibling child nodes are combined and the key in the inner node is deleted.
 */
public class T_012_B_Trees {
	
}
