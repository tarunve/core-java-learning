package practice04.stack;

import java.util.EmptyStackException;

/*
 * 	Performance: Let n be the number of elements in the stack. The complexities of stack operations
 *	-----------	 with this representation can be given as:
 *			Space Complexity (for n push operations) 	O(n)
 *			Time Complexity of create stack				O(1)
 *			Time Complexity of push() 					O(1) (Average)
 *			Time Complexity of pop()	 				O(1)
 *			Time Complexity of top() 					O(1)
 *			Time Complexity of isEmpty() 				O(1)
 *			Time Complexity of deleteStack() 			O(n)
 */
public class T_004_LinkedListBasedStackImpl {

	protected static class ListNode {
		public int data;
		ListNode next;

		public ListNode(int data) {
			this.data = data;
		}
	}

	public static class LinkedListStack {
		public int length;
		public ListNode top;

		public LinkedListStack() {
			length = 0;
			top = null;
		}
		
		public void push(int data) {
			ListNode newNode = new ListNode(data);
			newNode.next = top;
			top = newNode;
			length++;
		}

		public int pop() {
			if (isEmpty())
				throw new EmptyStackException();
			ListNode temp = top;
			top = temp.next;
			length--;
			return temp.data;
		}
		
		public int peek() throws EmptyStackException {
			if (isEmpty())
				throw new EmptyStackException();
			return top.data;
		}

		public boolean isEmpty() {
			return length == 0;
		}
		
		@Override
		public String toString() {
			String result = "";
			ListNode current = top;
			while (current != null) {
				result = result + current.data + " ";
				current = current.next;
			}
			return result;
		}
	}

	public static void main(String[] args) {
		LinkedListStack stack = new LinkedListStack();
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
		System.out.println(stack);
		System.out.println("=================");
		stack.pop();
		stack.push(10);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.push(23);
		System.out.println(stack);
	}

}
