package practice06.priority.queue;

/*
 * 	->	A heap is a tree with some special properties. The basic requirement of a heap is that the value of
 * 		a node must be > (or <) than the values of its children. This is called heap property. A heap also
 * 		has the additional property that all leaves should be at h or h – 1 levels (where h is the height of
 * 		the tree) for some h > 0 (complete binary trees). That means heap should form a complete binary tree.
 * 	
 * 	Types of Heaps
 * 	--------------
 * 	1.	Min heap: The value of a node must be less than or equal to the values of its children.
 * 	2.	Max heap: The value of a node must be greater than or equal to the values of its children.	
 */
public class T_002_Heap {
	
	public static void main(String[] args) {
		boolean m_is64BitObjidDbEnabled = ((long)32768 & 32768L) != 0L;
		System.out.println(m_is64BitObjidDbEnabled);
	}
}
