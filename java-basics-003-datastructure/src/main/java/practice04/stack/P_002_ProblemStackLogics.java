package practice04.stack;

import java.util.Stack;

public class P_002_ProblemStackLogics {
	/*
	 * stacks can be used for checking balancing of symbols
	 */
	public static boolean isValidSymbolPattern(String str) {
		Stack<Character> stack = new Stack<>();
		if (str == null || str.length() == 0)
			return true;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					stack.pop();
				}
				stack.pop();
			}
			else if (str.charAt(i) == ']') {
				while (!stack.isEmpty() && stack.peek() != '[') {
					stack.pop();
				}
				stack.pop();
			}
			else if (str.charAt(i) == '}') {
				while (!stack.isEmpty() && stack.peek() != '{') {
					stack.pop();
				}
				stack.pop();
			}
			else {
				stack.push(str.charAt(i));
			}
		}
		
		if (stack.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * Evaluate postfix expression
	 */
	public static int evaluatePostfixExpression(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String str : tokens) {
			if (str.equals("+")) {
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				int result = operand1 + operand2;
				stack.push(result);
			}
			else if (str.equals("-")) {
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				int result = operand2 - operand1;
				stack.push(result);
			}
			else if (str.equals("*")) {
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				int result = operand1 * operand2;
				stack.push(result);
			}
			else if (str.equals("/")) {
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				int result = operand2 + operand1;
				stack.push(result);
			}
			else if (str.equals("%")) {
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				int result = operand2 % operand1;
				stack.push(result);
			}
			else {
				stack.push(Integer.parseInt(str));
			}
		}
		return stack.pop();
	}
	
	/*
	 * Check if string is palindrome.
	 * Time Complexity: O(n).
	 * Space Complexity: O(n/2) => O(n).
	 */
	public static boolean isPalindrome(String str) {
		char input[] = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		int i = 0;
		while (input[i] != 'X') {
			stack.push(input[i]);
			i++;
		}
		i++;
		while (i < input.length) {
			if (stack.isEmpty())
				return false;
			if (input[i] != stack.pop())
				return false;
			i++;
		}
		return true;
	}
	
	/*
	 * Reverse Stack using only one stack operation
	 * Time Complexity: O(n2).
	 * Space Complexity: O(n), for recursive stack.
	 */
	public static Stack<Integer> reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty())
			return null;
		int temp = stack.pop();
		reverseStack(stack);
		insertAtBottom(stack, temp);
		return stack;
	}
	
	public static void insertAtBottom(Stack<Integer> stack, int data) {
		if (stack.isEmpty()) {
			stack.push(data);
			return;
		}
		int temp = stack.pop();
		insertAtBottom(stack, data);
		stack.push(temp);
	}
	
	/*
	 * Largest rectangle under histogram: A histogram is a polygon composed of a
	 * sequence of rectangles aligned at a common base line. For simplicity, assume that the
	 * rectangles have equal widths but may have different heights. For example, the figure on the
	 * left shows a histogram that consists of rectangles with the heights 3, 2, 5, 6, 1, 4, 4,
	 * measured in units where 1 is the width of the rectangles. Here our problem is: given an
	 * array with heights of rectangles (assuming width is 1), we need to find the largest rectangle
	 * possible. For the given example, the largest rectangle is the shared part.
	 */
	public static int maxAreaRectangle(int[] array) {
		Stack<Integer> stack = new Stack<>();
		if (array == null || array.length == 0)
			return 0;

		int maxArea = 0;
		int i = 0;
		while (i < array.length) {
			if (stack.isEmpty() || array[stack.peek()] <= array[i]) {
				stack.push(i++);
			}
			else {
				int top = stack.pop();
				maxArea = Math.max(maxArea, array[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		while (!stack.isEmpty()) {
			int top = stack.pop();
			maxArea = Math.max(maxArea, array[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));
		}
		
		return maxArea;
	}
	public static void main(String[] args) {
		System.out.println(isValidSymbolPattern("((A+B)+(C-D))"));
		System.out.println(evaluatePostfixExpression(new String[] { "10", "20", "30", "*", "+", "5", "-" }));
		System.out.println(isPalindrome("aabaXabaa"));
		Stack<Integer> stack = new Stack<>();
		stack.push(12);
		stack.push(13);
		stack.push(30);
		System.out.println(stack.toString());
		stack = reverseStack(stack);
		System.out.println(stack.toString());
		
		int[] findRectangleArea = { 3, 2, 5, 6, 1, 4, 4 };
		System.out.println(maxAreaRectangle(findRectangleArea));
		
	}
}
