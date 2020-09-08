package practice03.queue;

/*
 * 	->	Performance: Let n be the number of elements in the queue:
 *
 * 		Space Complexity (for n enQueue operations) O(n)
 * 		Time Complexity of enQueueQ 		O(1)
 * 		Time Complexity of deQueueQ 		O(1)
 * 		Time Complexity of isEmpty() 		O(1)
 * 		Time Complexity of isFull () 		O(1)
 * 		Time Complexity of getQueueSize ()	O(1)
 *
 * 	Limitations
 * 	-----------
 * 	The maximum size of the queue must be defined as prior and cannot be changed. Trying to
 * 	EnQueue a new element into a full queue causes an implementation-specific exception.
 */
public class T_002_FixedSizedArrayBasedQueue {
	
	public static class ArrayBasedQueue {
		protected int[] queueArray;
		protected int size, front, rear;
		private static final int CAPACITY = 16;
		
		public ArrayBasedQueue() {
			queueArray = new int[CAPACITY];
			size = 0;
			front = 0;
			rear = 0;
		}
		
		public ArrayBasedQueue(int capacity) {
			queueArray = new int[capacity];
			size = 0;
			front = 0;
			rear = 0;
		}

		public void enQueue(int data) {
			if (size == CAPACITY) {
				throw new IllegalStateException("Queue is full : Overflow");
			}
			else {
				size++;
				queueArray[rear] = data;
				rear = (rear + 1) % CAPACITY;
			}
		}

		public int deQueue() {
			if (size == 0) {
				throw new IllegalStateException("Queue is empty : Underflow");
			}
			else {
				size--;
				int data = queueArray[front % CAPACITY];
				queueArray[front] = Integer.MIN_VALUE;
				front = (front + 1) % CAPACITY;
				return data;
			}
		}

		public boolean isEmpty() {
			return size == 0;
		}
		
		public boolean isFull() {
			return size == CAPACITY;
		}

		public int size() {
			return size;
		}
		
		@Override
		public String toString() {
			String result = "[";
			for (int i = 0; i < size; i++) {
				result += Integer.toString(queueArray[(front + i) % CAPACITY]);
				if (i < size - 1) {
					result += ",";
				}
			}
			result += "]";
			return result;
		}
	}

	public static void main(String[] args) {
		ArrayBasedQueue queue = new ArrayBasedQueue();
		queue.enQueue(10);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(190);
		queue.deQueue();
		System.out.println(queue);
	}

}
