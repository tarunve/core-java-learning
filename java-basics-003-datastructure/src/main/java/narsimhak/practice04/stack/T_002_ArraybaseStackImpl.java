package narsimhak.practice04.stack;

/*
 * 	Performance: Let n be the number of elements in the stack. The complexities of stack operations
 *	-----------	 with this representation can be given as:
 *			Space Complexity (for n push operations) 	O(n)
 *			Time Complexity of push() 					O(1)
 *			Time Complexity of pop()	 				O(1)
 *			Time Complexity of size() 					O(1)
 *			Time Complexity of isEmpty() 				O(1)
 *			Time Complexity of isFullStack() 			O(1)
 *			Time Complexity of deleteStack() 			O(1)
 *
 *	Limitations: The maximum size of the stack must first be defined and it cannot be changed. Trying
 *	-----------	 to push a new element into a full stack causes an implementation-specific exception.
 */
public class T_002_ArraybaseStackImpl {
	
	static class ArrayBasedStack {
		protected int capacity;
		private static final int DEFAULT_CAPACITY = 10;
		protected int stackArray[];
		protected int top = -1;
		
		public ArrayBasedStack() {
			this(DEFAULT_CAPACITY);
		}
		
		public ArrayBasedStack(int capacity) {
			this.capacity = capacity;
			stackArray = new int[capacity];
		}
		
		public int size() {
			return top + 1;
		}
		
		public boolean isEmpty() {
			return (size() == 0);
		}
		
		public void push(int data) throws Exception {
			if (size() == capacity) {
				throw new StackOverflowError("Stack is Full");
			}
			stackArray[++top] = data;
		}
		
		public int pop() throws Exception {
			int data;
			if (size() == 0) {
				throw new Exception("Satck is empty");
			}
			data = stackArray[top];
			stackArray[top--] = Integer.MIN_VALUE;
			return data;
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
		ArrayBasedStack stack = new ArrayBasedStack();
		//stack.pop();
		stack.push(23);
		stack.push(13);
		stack.push(20);
		stack.push(231);
		stack.push(2);
		stack.push(3);
		stack.push(14);
		stack.push(78);
		stack.push(56);
		stack.push(43);
		stack.pop();
		stack.push(888);
		stack.pop();
		stack.push(10);
		System.out.println(stack);
	}
}
