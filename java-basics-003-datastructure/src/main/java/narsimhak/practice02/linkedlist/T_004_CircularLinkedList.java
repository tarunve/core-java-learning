package narsimhak.practice02.linkedlist;

public class T_004_CircularLinkedList<E> {

	CLLNode1<E> tail;
	protected int size;

	public T_004_CircularLinkedList() {
		tail = null;
		size = 0;
	}
	
	public void addToHead(E data) {
		CLLNode1<E> newNode = new CLLNode1<E>(data);
		if (tail == null) {
			tail = newNode;
			tail.next = tail;
		}
		else {
			newNode.next = tail.next;
			tail.next = newNode;
		}
		size++;
	}

	public void insertAtBegin(E data) {
		addToHead(data);
	}

	public void insertAtEnd(E data) {
		addToHead(data);
		tail = tail.next;
	}
	
	public CLLNode1<E> removeAtBegin() {
		if (tail == null)
			return null;
		else {
			CLLNode1<E> temp = tail;
			if (tail == tail.next)
				tail = null;
			else {
				tail.next = temp.next;
				temp.next = null;
			}
			size--;
			return temp;
		}
	}

	public CLLNode1<E> removeAtEnd() {
		if (tail == null)
			return null;
		else {
			CLLNode1<E> currNode = tail;
			while (currNode.next != tail) {
				currNode = currNode.next;
			}
			CLLNode1<E> temp = tail;
			if (currNode == tail)
				tail = null;
			else {
				currNode.next = tail.next;
				tail = currNode;
			}
			size--;
			return temp;
		}
	}
	
	public CLLNode1<E> removeBykey(E data) {
		if (tail == null)
			return null;
		CLLNode1<E> currNode = tail.next;
		CLLNode1<E> prevNode = tail;
		for (int i = 0; i < size && (!data.equals(currNode.data)); i++) {
			prevNode = currNode;
			currNode = currNode.next;
		}
		if (currNode.data.equals(data)) {
			if (tail == tail.next)
				tail = null;
			else {
				if (currNode == tail)
					tail = prevNode;
				prevNode.next = prevNode.next.next;
			}
			prevNode.next = null;
			size--;
			return currNode;
		}
		else {
			return null;
		}
	}

	public int search(E data) {
		if (tail == null)
			return Integer.MIN_VALUE;
		CLLNode1<E> currNode = tail.next;
		int position = 1;
		for (int i = 0; i < size && (!data.equals(currNode.data)); i++) {
			currNode = currNode.next;
			position++;
		}
		if (currNode.data.equals(data)) {
			return position;
		}
		else {
			return Integer.MIN_VALUE;
		}
	}

	@Override
	public String toString() {
		System.out.println("The size of the list is " + size);
		String str = "{";
		if (tail == null)
			str = str + " }";
		str = str + tail.data;
		CLLNode1<E> currNode = tail.next;
		while (currNode != tail) {
			str = str + ", " + currNode.data;
			currNode = currNode.next;
		}
		return str + "}";
	}

	static class CLLNode1<E> {
		E data;
		CLLNode1<E> next;
		
		CLLNode1(E data) {
			this.data = data;
			next = null;
		}
	}
	
	static class TestCircularLinkedList {
		public static void main(String[] args) {
			T_004_CircularLinkedList<Integer> circularLinkedList = new T_004_CircularLinkedList<Integer>();
			System.out.println("Insert at begining :: ");
			circularLinkedList.insertAtBegin(45);
			System.out.println(circularLinkedList);
			System.out.println("Insert at begining :: ");
			circularLinkedList.insertAtBegin(45);
			circularLinkedList.insertAtBegin(50);
			circularLinkedList.insertAtBegin(55);
			circularLinkedList.insertAtBegin(65);
			System.out.println(circularLinkedList);
			System.out.println("Insert at end :: ");
			circularLinkedList.insertAtEnd(200);
			circularLinkedList.insertAtEnd(564);
			System.out.println(circularLinkedList);
			System.out.println("Search element 564 :: ");
			System.out.println(circularLinkedList.search(564));
			System.out.println("Search element 78888 :: ");
			System.out.println(circularLinkedList.search(78888));
			System.out.println();
			System.out.println(circularLinkedList);
		}
	}
}
