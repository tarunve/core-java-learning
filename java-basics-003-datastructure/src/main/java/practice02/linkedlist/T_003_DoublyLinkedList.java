package practice02.linkedlist;

/*
 * ->	We can navigate in both directions.
 * ->	A node in a singly linked list cannot be removed unless we have
 * 		the pointer to its predecessor. But in a doubly linked list, we
 * 		can delete a node even if we don’t have the previous node’s address.
 *
 * Disadvantages:
 * =============
 * ->	Each node requires an extra pointer, requiring more space.
 * ->	The insertion or deletion of a node takes a bit longer (more pointer operations).
 */
public class T_003_DoublyLinkedList<E> {
	
	protected DLLNode1<E> head;
	protected DLLNode1<E> tail;
	protected int size;
	
	T_003_DoublyLinkedList() {
		this.size = 0;
	}
	
	public void insertAtBegin(E data) {
		DLLNode1<E> newNode = new DLLNode1<E>(data, null, head);
		if (head != null)
			head.previous = newNode;
		head = newNode;
		if (tail == null)
			tail = newNode;
		size++;
	}
	
	public void insertAtEnd(E data) {
		DLLNode1<E> newNode = new DLLNode1<E>(data, tail, null);
		if (tail != null)
			tail.next = newNode;
		tail = newNode;
		if (head == null)
			head = newNode;
		size++;
	}
	
	public void insertAtMid(int position, E data) {
		if (position <= 0)
			insertAtBegin(data);
		else if (position >= size)
			insertAtEnd(data);
		else {
			DLLNode1<E> newNode = new DLLNode1<E>(data);
			DLLNode1<E> currNode = head;
			for (int i = 1; i < position - 1; i++) {
				currNode = currNode.next;
			}
			newNode.next = currNode.next;
			newNode.previous = currNode;
			currNode.next.previous = newNode;
			currNode.next = newNode;
			size++;
		}
	}
	
	public DLLNode1<E> deleteAtBegin() {
		if (head == null || size == 0)
			return null;
		else {
			DLLNode1<E> temp = head;
			head = head.next;
			if (head != null)
				head.previous = null;
			size--;
			return temp;
		}
	}
	
	public DLLNode1<E> deleteAtEnd() {
		if (head == null || size == 0)
			return null;
		else {
			DLLNode1<E> temp = tail;
			tail = tail.previous;
			if (tail != null)
				tail.next = null;
			size--;
			return temp;
		}
	}
	
	public DLLNode1<E> deleteByKey(E data) {
		if (head == null || size == 0)
			return null;
		else {
			DLLNode1<E> currNode = head;
			while (currNode != null) {
				if (currNode.data.equals(data) && currNode.next != null) {
					currNode.previous.next = currNode.next;
					currNode.next.previous = currNode.previous;
					size--;
					return currNode;
				}
				else if (currNode.data.equals(data) && currNode.next == null) {
					currNode.previous.next = null;
					size--;
					return currNode;
				}
				currNode = currNode.next;
			}
		}
		return null;
	}
	
	public DLLNode1<E> deleteAtPosition(int position) {
		if (position <= 1)
			return deleteAtBegin();
		else if (position >= size)
			return deleteAtEnd();
		else {
			DLLNode1<E> currNode = head;
			for (int i = 1; i < position; i++) {
				currNode = currNode.next;
			}
			currNode.previous.next = currNode.next;
			currNode.next.previous = currNode.previous;
			size--;
			return currNode;
		}
	}
	
	public int search(E data) {
		DLLNode1<E> currNode = head;
		int position = 1;
		while (currNode != null) {
			if (currNode.data.equals(data))
				return position;
			position++;
			currNode = currNode.next;
		}
		
		return Integer.MIN_VALUE;
	}
	
	public void printListForward() {
		System.out.println("The size of the list is " + size);
		System.out.println("Print forward :: ");
		DLLNode1<E> currNode = head;
		System.out.print("{");
		while (currNode != null) {
			System.out.print(currNode.data);
			if (currNode.next != null) {
				System.out.print(", ");
			}
			currNode = currNode.next;
		}
		System.out.println("}");
		System.out.println();
	}
	
	public void printListBackward() {
		System.out.println("The size of the list is " + size);
		System.out.println("Print backward :: ");
		DLLNode1<E> currNode = tail;
		System.out.print("{");
		while (currNode != null) {
			System.out.print(currNode.data);
			if (currNode.previous != null) {
				System.out.print(", ");
			}
			currNode = currNode.previous;
		}
		System.out.println("}");
		System.out.println();
	}
	
	static class DLLNode1<E> {
		E data;
		DLLNode1<E> next;
		DLLNode1<E> previous;
		
		DLLNode1(E input) {
			this.data = input;
			previous = null;
			next = null;
		}
		
		DLLNode1(E input1, DLLNode1<E> prev, DLLNode1<E> next) {
			this.data = input1;
			this.previous = prev;
			this.next = next;
		}
	}
	
	static class TestDoublyLinkedList {
		
		public static void main(String[] args) {
			T_003_DoublyLinkedList<Integer> doublyLinkedList = new T_003_DoublyLinkedList<Integer>();
			System.out.println("Delete at Begin :: ");
			doublyLinkedList.deleteAtBegin();
			doublyLinkedList.printListForward();
			System.out.println("Insert at begining :: ");
			doublyLinkedList.insertAtBegin(45);
			doublyLinkedList.printListForward();
			System.out.println("Delete at End :: ");
			doublyLinkedList.deleteAtEnd();
			doublyLinkedList.printListForward();
			System.out.println("Insert at begining :: ");
			doublyLinkedList.insertAtBegin(45);
			doublyLinkedList.insertAtBegin(50);
			doublyLinkedList.insertAtBegin(55);
			doublyLinkedList.insertAtBegin(65);
			doublyLinkedList.printListForward();
			System.out.println("Insert at end :: ");
			doublyLinkedList.insertAtEnd(200);
			doublyLinkedList.insertAtEnd(564);
			doublyLinkedList.printListForward();
			System.out.println("Insert at Mid :: ");
			doublyLinkedList.insertAtMid(4, 207);
			doublyLinkedList.insertAtMid(10, 5678);
			doublyLinkedList.insertAtMid(2, 654);
			doublyLinkedList.printListForward();
			System.out.println("Search element 564 :: ");
			System.out.println(doublyLinkedList.search(564));
			System.out.println("Search element 78888 :: ");
			System.out.println(doublyLinkedList.search(78888));
			System.out.println();
			System.out.println("Print Backward :: ");
			doublyLinkedList.printListBackward();
			System.out.println("Delete at Begin :: ");
			doublyLinkedList.deleteAtBegin();
			doublyLinkedList.printListForward();
			System.out.println("Delete at End :: ");
			doublyLinkedList.deleteAtEnd();
			doublyLinkedList.printListForward();
			System.out.println("Delete element 50 :: ");
			doublyLinkedList.deleteByKey(50);
			doublyLinkedList.printListForward();
			System.out.println("Delete element At -3 :: ");
			doublyLinkedList.deleteAtPosition(-3);
			doublyLinkedList.printListForward();
			System.out.println("Delete element At 2 :: ");
			doublyLinkedList.deleteAtPosition(2);
			doublyLinkedList.printListForward();
			System.out.println("Delete element At 10 :: ");
			doublyLinkedList.deleteAtPosition(10);
			doublyLinkedList.printListForward();
			System.out.println("Print Backward :: ");
			doublyLinkedList.printListBackward();
		}
	}
	
}
