package narsimhak.practice03.queue;

/*
 * 	->	Performance: Let n be the number of elements in the queue:
 *
 * 		Space Complexity (for n enQueue operations)		O(n)
 * 		Time Complexity of enQueueQ 					O(1) (Average)
 * 		Time Complexity of deQueueQ 					O(1)
 * 		Time Complexity of isEmpty() 					O(1)
 * 		Time Complexity of isFull () 					O(1)
 * 		Time Complexity of getQueueSize ()				O(1)
 */
public class T_003_DynamicArrayBasedQueue {

	public static class DynamicArrayBasedQueue {
		protected int[] queueArray;
		protected int size, front, rear;
		private int CAPACITY = 6;

		public DynamicArrayBasedQueue() {
			queueArray = new int[CAPACITY];
			size = 0;
			front = 0;
			rear = 0;
		}

		public DynamicArrayBasedQueue(int capacity) {
			queueArray = new int[capacity];
			size = 0;
			front = 0;
			rear = 0;
		}
		
		public void enQueue(int data) {
			if (size == CAPACITY)
				expand();
			size++;
			queueArray[rear] = data;
			if (size == CAPACITY)
				rear = rear + 1;
			else
				rear = (rear + 1) % CAPACITY;
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
		
		public void expand() {
			int length = size();
			int rear = length - 1;
			int[] newQueueArray = new int[length << 1];
			for (int i = front; i <= rear; i++) {
				newQueueArray[i - front] = queueArray[i % CAPACITY];
			}
			queueArray = newQueueArray;
			front = 0;
			rear = size - 1;
			CAPACITY *= 2;
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
		DynamicArrayBasedQueue queue = new DynamicArrayBasedQueue();
		queue.enQueue(10);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(190);
		queue.enQueue(167);
		System.out.println(queue.CAPACITY);
		queue.enQueue(999);
		System.out.println(queue);
		queue.deQueue();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		System.out.println(queue.CAPACITY);
		System.out.println(queue);
	}

}
