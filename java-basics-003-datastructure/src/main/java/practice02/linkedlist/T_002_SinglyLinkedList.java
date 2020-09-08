package practice02.linkedlist;

public class T_002_SinglyLinkedList<E> {
	
	protected SLLNode1<E> head;
	protected int size = 0;
	
	public T_002_SinglyLinkedList() {
		head = null;
	}
	
	public void insertAtBegin(E data) {
		SLLNode1<E> newNode = new SLLNode1<E>(data);
		newNode.next = head;
		head = newNode;
		size++;
	}

	public void insertAtEnd(E data) {
		SLLNode1<E> newNode = new SLLNode1<E>(data);
		SLLNode1<E> currentNode = head;
		if (head == null)
			head = newNode;
		else {
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
		size++;
	}
	
	public void insertInMid(int position, E data) {
		SLLNode1<E> newNode = new SLLNode1<E>(data);
		if (position <= 0)
			insertAtBegin(data);
		else if (position >= size)
			insertAtEnd(data);
		else {
			SLLNode1<E> currNode = head;
			for (int i = 1; i < position - 1; i++) {
				currNode = currNode.next;
			}
			newNode.next = currNode.next;
			currNode.next = newNode;
			size++;
		}
	}
	
	public SLLNode1<E> deleteAtBegin() {
		if (head == null)
			return null;
		else {
			SLLNode1<E> temp = head;
			head = head.next;
			size--;
			return temp;
		}
	}

	public SLLNode1<E> deleteAtEnd() {
		if (head == null)
			return null;
		else if (head.next == null) {
			SLLNode1<E> temp = head;
			head = null;
			size--;
			return temp;
		}
		else {
			SLLNode1<E> currNode = head;
			while (currNode.next.next != null) {
				currNode = currNode.next;
			}
			SLLNode1<E> temp = currNode.next;
			currNode.next = null;
			size--;
			return temp;
		}
	}

	public SLLNode1<E> deleteAtPosition(int position) {
		if (position <= 1)
			return deleteAtBegin();
		else if (position >= size)
			return deleteAtEnd();
		else {
			SLLNode1<E> currNode = head;
			for (int i = 1; i < position - 1; i++) {
				currNode = currNode.next;
			}
			SLLNode1<E> temp = currNode.next;
			currNode.next = currNode.next.next;
			size--;
			return temp;
		}
	}

	public SLLNode1<E> deleteByKey(E data) {
		if (head == null)
			return null;
		else if (head.data.equals(data)) {
			head = head.next;
			size--;
			return head;
		}
		else {
			SLLNode1<E> currNode = head;
			SLLNode1<E> prevNode = head;
			while (currNode != null) {
				if (currNode.data.equals(data)) {
					prevNode.next = currNode.next;
					size--;
					return currNode;
				}
				prevNode = currNode;
				currNode = currNode.next;
			}
			return null;
		}
	}

	public int search(E data) {
		SLLNode1<E> currNode = head;
		int position = 1;
		while (currNode != null) {
			if (currNode.data.equals(data))
				return position;
			position++;
			currNode = currNode.next;
		}

		return Integer.MIN_VALUE;
	}
	
	public void printList() {
		System.out.println("The size of the list is " + size);
		SLLNode1<E> currNode = head;
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

	static class SLLNode1<E> {
		SLLNode1<E> next;
		E data;

		public SLLNode1(E input) {
			this.data = input;
		}
	}
	
	static class TestSinglyLinkedListClass {
		
		public static void main(String[] args) {
			T_002_SinglyLinkedList<Integer> list = new T_002_SinglyLinkedList<Integer>();
			System.out.println("Delete from Mid by Key in empty list ::");
			list.deleteByKey(23);
			list.printList();
			System.out.println("Insert value at begining ::");
			list.insertAtBegin(34);
			list.printList();
			System.out.println("Delete from Mid by Key in head element ::");
			list.deleteByKey(34);
			list.printList();
			System.out.println("Insert value at begining ::");
			list.insertAtBegin(34);
			list.insertAtBegin(289);
			list.insertAtBegin(78);
			list.insertAtBegin(999);
			list.printList();
			System.out.println("Insert value at end ::");
			list.insertAtEnd(200);
			list.insertAtEnd(4);
			list.printList();
			System.out.println("Insert value in Mid ::");
			list.insertInMid(3, 567);
			list.printList();
			System.out.println("Insert value in Mid before start index::");
			list.insertInMid(-9, 1);
			list.printList();
			System.out.println("Insert value in Mid after last index::");
			list.insertInMid(100, 10000);
			list.printList();
			System.out.println("Delete from begining ::");
			list.deleteAtBegin();
			list.printList();
			System.out.println("Delete from end ::");
			list.deleteAtEnd();
			list.printList();
			System.out.println("Delete from Mid by Key present in middle ::");
			list.deleteByKey(78);
			list.printList();
			System.out.println("Delete at position 4 ::");
			list.deleteAtPosition(4);
			list.printList();
			System.out.println("Delete at position -9 ::");
			list.deleteAtPosition(-9);
			list.printList();
			System.out.println("Delete at position 18 ::");
			list.deleteAtPosition(18);
			list.printList();

			System.out.println(list.search(200));

			/*SinglyLinkedList_2<String> listStr = new SinglyLinkedList_2<String>();
			listStr.insertAtBegin("A");
			listStr.insertAtBegin("B");
			listStr.insertAtBegin("Z");
			listStr.insertAtBegin("U");
			listStr.insertAtEnd("Tarun");
			listStr.insertAtEnd("Ankit");

			listStr.printList();*/
		}
	}
	
}
