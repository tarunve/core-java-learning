package narsimhak.practice04.stack;

public class P_001_ProblemArrayWithTwoStacks {
	
	public Integer[] dataArray;
	public int size, top1, top2;

	public P_001_ProblemArrayWithTwoStacks(int size) {
		if (size < 2)
			throw new IllegalStateException("size < 2 is not permissible.");
		this.size = size;
		dataArray = new Integer[size];
		top1 = -1;
		top2 = size;
	}
	
	public void push(int stackId, Integer data) {
		if (top2 == top1 + 1)
			throw new StackOverflowError("Array is full");
		if (stackId == 1)
			dataArray[++top1] = data;
		else if (stackId == 2)
			dataArray[--top2] = data;
		else
			return;
	}

	public Integer pop(int stackId) throws Exception {
		if (stackId == 1) {
			if (top1 == -1)
				throw new Exception("First Stack is empty.");
			int toPop = dataArray[top1];
			dataArray[top1--] = null;
			return toPop;
		}
		else if (stackId == 2) {
			if (top2 == this.size)
				throw new Exception("Second stack is empty.");
			int toPop = dataArray[top2];
			dataArray[top2++] = null;
			return toPop;
		}
		else
			return null;
	}

	public Integer top(int stackId) throws Exception {
		if (stackId == 1) {
			if (top1 == -1)
				throw new Exception("First stack is empty");
			return dataArray[top1];
		}
		else if (stackId == 2) {
			if (top2 == this.size)
				throw new Exception("Second stack is empty");
			return dataArray[top2];
		}
		else {
			return null;
		}
	}

	public boolean isEmpty(int stackId) throws Exception {
		if (stackId == 1) {
			return top1 == -1;
		}
		else if (stackId == 2) {
			return top2 == this.size;
		}
		else {
			return true;
		}
	}
}
