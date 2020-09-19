package practice03.queue;

/*
 * 	->	Performance: Let n be the number of elements in the queue:
 *
 * 		Space Complexity (for n enQueue operations)		O(n)
 * 		Time Complexity of enQueueQ 					O(1) (Average)
 * 		Time Complexity of deQueueQ 					O(1)
 * 		Time Complexity of isEmpty() 					O(1)
 * 		Time Complexity of deleteQueue() 				O(1)
 */
public class T_004_LinkedListBasedQueue {
	
	protected static class ListNode {
		public int data;
		ListNode next;

		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public static class LinkedListBasedQueue {
		protected int length;
		ListNode front, rear;

		public LinkedListBasedQueue() {
			length = 0;
			front = rear = null;
		}
		
		public void enQueue(int data) throws Exception {
			ListNode newNode = new ListNode(data);
			if (isEmpty())
				front = newNode;
			else
				rear.next = newNode;
			rear = newNode;
			length++;
		}

		public int deQueue() throws Exception {
			if (isEmpty())
				throw new Exception("Queue is Empty");
			int result = front.data;
			front = front.next;
			length--;
			if (isEmpty())
				rear = null;
			return result;

		}

		public int first() throws Exception {
			if (isEmpty())
				throw new Exception("Queue is Empty");
			return front.data;
		}

		public boolean isEmpty() {
			return length == 0;
		}

		public int size() {
			return length;
		}
		
		@Override
		public String toString() {
			String result = "";
			ListNode current = front;
			while (current != null) {
				result = result + current.data + " ";
				current = current.next;
			}
			return result;
		}
	}
	
	public static void main(String[] args) throws Exception {
		LinkedListBasedQueue queue = new LinkedListBasedQueue();
		queue.enQueue(10);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(190);
		queue.enQueue(167);
		queue.enQueue(999);
		queue.deQueue();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		System.out.println(queue);
	}

}
