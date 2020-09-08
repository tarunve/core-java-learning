package practice04.stack;

/*
 * 	Performance: Let n be the number of elements in the stack. The complexities of stack operations
 *	-----------	 with this representation can be given as:
 *			Space Complexity (for n push operations) 	O(n)
 *			Time Complexity of create stack				O(1)
 *			Time Complexity of push() 					O(1) (Average)
 *			Time Complexity of pop()	 				O(1)
 *			Time Complexity of top() 					O(1)
 *			Time Complexity of isEmpty() 				O(1)
 *			Time Complexity of isFullStack() 			O(1)
 *			Time Complexity of deleteStack() 			O(1)
 */
public class T_003_DynamicArrayBasedStackImpl {
	
	static class DynamicArrayBasedStack {
		protected int capacity;
		private static final int DEFAULT_CAPACITY = 3;
		protected int stackArray[];
		protected int top = -1;
		
		public DynamicArrayBasedStack() {
			this(DEFAULT_CAPACITY);
		}
		
		public DynamicArrayBasedStack(int capacity) {
			this.capacity = capacity;
			stackArray = new int[capacity];
		}
		
		public int size() {
			return top + 1;
		}
		
		public boolean isEmpty() {
			return (top < 0);
		}
		
		public void push(int data) throws Exception {
			if (size() == capacity) {
				expand();
			}
			stackArray[++top] = data;
		}

		private void expand() {
			int length = size();
			int newStackArray[] = new int[length << 1];
			System.arraycopy(stackArray, 0, newStackArray, 0, length);
			stackArray = newStackArray;
			this.capacity = this.capacity << 1;
		}
		
		public int pop() throws Exception {
			int data;
			if (size() == 0) {
				throw new Exception("Satck is empty");
			}
			data = stackArray[top];
			stackArray[top--] = Integer.MIN_VALUE;
			shrink();
			return data;
		}

		private void shrink() {
			int length = top + 1;
			if (length <= this.capacity >> 1) {
				length = this.capacity >> 1;
				int newStackArray[] = new int[length];
				System.arraycopy(stackArray, 0, newStackArray, 0, top + 1);
				stackArray = newStackArray;
				this.capacity = length;
			}
		}
		
		public int top() throws Exception {
			if (size() == 0) {
				throw new Exception("Satck is empty");
			}
			return stackArray[top];
		}

		@Override
		public String toString() {
			String s = "[";
			if (size() > 0)
				s += stackArray[0];
			if (size() > 1) {
				for (int i = 1; i < size(); i++)
					s += ", " + stackArray[i];
			}
			return s + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		DynamicArrayBasedStack stack = new DynamicArrayBasedStack();
		stack.push(23);
		System.out.println(stack.capacity);
		stack.push(13);
		System.out.println(stack.capacity);
		stack.push(20);
		System.out.println(stack.capacity);
		stack.push(231);
		System.out.println(stack.capacity);
		stack.push(2);
		System.out.println(stack.capacity);
		stack.push(3);
		System.out.println(stack.capacity);
		stack.push(14);
		System.out.println(stack.capacity);
		stack.push(78);
		System.out.println(stack.capacity);
		stack.push(56);
		System.out.println(stack.capacity);
		stack.push(43);
		stack.pop();
		System.out.println(stack.capacity);
		stack.push(888);
		System.out.println(stack.capacity);
		stack.pop();
		System.out.println(stack.capacity);
		stack.push(10);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.capacity);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.capacity);
		stack.push(23);
		stack.push(23);
		stack.push(23);
		stack.push(23);
		stack.push(23);
		System.out.println(stack.capacity);
		System.out.println(stack);
	}
}
