package narsimhak.practice05.trees;


/*
 * 	->	Since our objective is to reach all nodes of the tree, a possible solution to this is as follows:
 * 		->	At each node link children of same parent (siblings) from left to right.
 * 		->	Remove the links from parent to all children except the first child.
 *
 * 	->	What these above statements say is if we have a link between children then we do not need extra
 * 		links from parent to all children. This is because we can traverse all the elements by starting
 * 		at the first child of the parent. So if we have a link between parent and first child and also
 * 		links between all children of same parent then it solves our problem.
 */
public class T_003_GenericTrees_n_ary {

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
}
