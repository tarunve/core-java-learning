package practice03.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P_001_ProblemsQueueLogics {
	/*
	 * How can you implement a queue using two stacks
	 */
	public static class QueueUsingTwoStacks<T> {
		Stack<T> stack1 = new Stack<>();
		Stack<T> stack2 = new Stack<>();
		
		public void enQueue(T data) {
			stack1.push(data);
		}
		
		public T deQueue() {
			if (stack2.empty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
			return stack2.pop();
		}
	}
	
	/*
	 * Show how you can efficiently implement one stack using two queues. Analyze the
	 * running time of the stack operations.
	 */
	public static class StackUsingTwoQueues<T> {
		Queue<T> queue1 = new LinkedList<>();
		Queue<T> queue2 = new LinkedList<>();
		
		public void push(T data) {
			if (queue1.isEmpty()) {
				queue2.offer(data);
			}
			else {
				queue1.offer(data);
			}
		}
		
		public T pop() {
			int i = 0, size;
			if (queue2.isEmpty()) {
				size = queue1.size();
				while (i < size - 1) {
					queue2.offer(queue1.poll());
					i++;
				}
				return queue1.poll();
			}
			else {
				size = queue2.size();
				while (i < size - 1) {
					queue1.offer(queue2.poll());
					i++;
				}
				return queue2.poll();
			}
		}
	}
	
	/*
	 * Given a stack of integers, how do you check whether each successive pair of
	 * numbers in the stack is consecutive or not. The pairs can be increasing or decreasing,
	 * and if the stack has an odd number of elements, the element at the top is left out of
	 * a pair. For example, if the stack of elements are [4, 5, -2, -3, 11, 10, 5, 6, 20],
	 * then the output should be true because each of the pairs (4, 5), (-2, -3), (11, 10),
	 * and (5, 6) consists of consecutive numbers.
	 * Time Complexity : O(n)
	 * Space Complexity : O(n)
	 */
	public static boolean checkStackPairwiseOrder(Stack<Integer> stack) {
		boolean pairwiseOrder = true;
		Queue<Integer> queue = new LinkedList<>();
		while (!stack.isEmpty())
			queue.add(stack.pop());
		while (!queue.isEmpty())
			stack.push(queue.remove());
		while (!stack.isEmpty()) {
			int n = stack.pop();
			queue.add(n);
			if (!stack.isEmpty()) {
				int m = stack.pop();
				queue.add(m);
				if (Math.abs(n - m) != 1)
					pairwiseOrder = false;
			}
		}
		return pairwiseOrder;
	}
	
}
