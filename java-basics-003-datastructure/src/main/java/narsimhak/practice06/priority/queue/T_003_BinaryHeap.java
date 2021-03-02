package narsimhak.practice06.priority.queue;

/*
 *	->	In binary heap each node may have up to two children.
 */
public class T_003_BinaryHeap {
	
	public static class Heap {
		public int[] array;
		public int count;
		public int capacity;
		public int heap_type;
		
		//Creating Heap  - Time Complexity: O(1).
		public Heap(int capacity , int heap_type){
			this.heap_type = heap_type;
			this.capacity = capacity;
			this.count = 0;
			this.array = new int[capacity];
		}
		
		/*
		 * Parent of a Node - Time Complexity: O(1).
		 * For a node at ith location, its parent is at location (i-1)/2.
		 */
		public int parent(int i){
			if(i <= 0 || i >= this.count)
				return -1;
			return i-1/2;
		}
		
		/*
		 * Children of a Node - Time Complexity: O(1).
		 * 17 13 6 1  4 2 5
		 * Similar to the above discussion, for a node at ith location, its children are at 2*i + 1 
		 * and 2*i + 2 locations. For example, in the above tree the element 6 is at second location 
		 * and its children 2 and 5 are at5(2*i + l = 2*2 + 1) and 6(2*i + 2 = 2*2 + 2) locations.
		 */
		public int leftChild(int i){
			int left = 2*i + 1;
			if(left >= this.count)
				return -1;
			return left;
		}
		
		public int rightChild(int i){
			int right = 2*i + 2;
			if(right >= this.count)
				return -1;
			return right;
		}
		
		/*
		 * Getting the Maximum Element - Time Complexity: O(1).
		 * Since the maximum element in max heap is always at root, it will be stored at this.array[0].
		 */
		public int getMaximum(){
			if(this.count == 0)
				return -1;
			return this.array[0];
		}
		
		/*
		 * Heapifying an Element
		 * ->	After inserting an element into heap, it may not satisfy the heap property. In that case we 
		 * 		need to adjust the locations of the heap to make it heap again. This process is called heapifying. 
		 * 		In maxheap, to heapify an element, we have to find the maximum of its children and swap it with 
		 * 		the current element and continue this process until the heap property is satisfied at every node.
		 * ->	In the heapifying process, since we are moving from top to bottom, this process is sometimes 
		 * 		called percolate down. Similarly, if we start heapifying from any other node to root, we can that 
		 * 		process percolate up as move from bottom to top.
		 * Time Complexity: O(logn). Heap is a complete binary tree and in the worst case we start at the root and 
		 * come down to the leaf. This is equal to the height of the complete binary tree. Space Complexity: O(1).
		 */
		public void perlocateDown(int i){
			int l, r , temp, max;
			l = leftChild(i);
			r = rightChild(i);
			if(l != -1 && this.array[l] > this.array[i])
				max = l;
			else
				max = i;
			if(r != -1 &&  this.array[r] > this.array[max])
				max = r;
			if(max != i){
				temp = this.array[i];
				this.array[i] = this.array[max];
				this.array[max] = temp;
			}
			perlocateDown(max);
		}
		
		/*
		 * 	Deleting an element:
		 * 	->	To delete element from heap, we just need to delete element from the root. This is the only operation
		 * 		supported by standard heap. After deleting the root element, copy the last element of heap and delete 
		 * 		the last element.
		 * 	->	After replacing the last element, tree may not satisfy the heap property. To make it heap again call
		 * 		the perlocateDown function.
		 * 		->	Copy the first element into some variable.
		 * 		->	Copy the last element into first element location.
		 * 		->	perlocateDown the first element.
		 */
		public int deleteMax(){
			if(this.count == 0)
				return -1;
			int data = this.array[0];
			this.array[0] = this.array[this.count-1];
			this.count--;
			perlocateDown(0);
			return data;
		}
		
		/*
		 * Inserting an element
		 * 	->	Inserting an element is similar to the heapify and deletion process.
		 * 		->	Increase the heap size.
		 * 		->	Keep the new element at the end of the heap.
		 * 		->	Heapify the element from bottom to top(root).
		 * 
		 * Time Complexity: O(logn). 
		 */
		public int insert(int data){
			int i;
			if(this.count == this.capacity)
				resizeHeap();
			this.count++;
			i = this.count -1;
			while(i >= 0 && data > this.array[(i-1)/2]){
				this.array[i] = this.array[(i-1)/2];
				i = i-1/2;
			}
			this.array[i] = data;
			return i;
		}
		
		public void resizeHeap(){
			int[] array_old = new int[this.capacity];
			System.arraycopy(this.array, 0, array_old, 0, this.count-1);
			this.array = new int[this.capacity * 2];
			if(this.array == null){
				System.out.println("Memory error");
				return;
			}
			for(int i=0; i< this.capacity; i++){
				this.array[i] = array_old[i];
			}
			this.capacity *= 2;
			array_old = null;
		}
		
		/*
		 * Destrying the Heap
		 */
		public void destroHeap(){
			this.count = 0;
			this.array = null;
		}
		
		/*
		 * Heapify the array
		 * ->	One simple approach for building the heap is, take n input items and place them into 
		 * 		an empty heap. This can be done with n successive inserts and takes O(nlogn) in worst
		 * 		case. This is due to the fact that each insert operation takes O(logn).
		 */
		public void buildHeap(Heap h, int[] A, int n){
			if(h == null)
				return;
			while(n > this.capacity)
				h.resizeHeap();
			for(int i=0; i<n ; i++)
				h.array[i] = A[i];
			this.count = n;
			for(int i = (n-1)/2 ; i>=0 ; i--)
				h.perlocateDown(i);
		}
	}
}
