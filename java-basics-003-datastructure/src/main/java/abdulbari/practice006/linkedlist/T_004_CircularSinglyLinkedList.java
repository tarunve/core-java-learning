package abdulbari.practice006.linkedlist;

/**
 * 	Circular Linked List:
 * 	====================
 * 	->	Circular linked list is a linked list where all nodes are connected to
 * 		form a circle. There is no NULL at the end. A circular linked list can
 * 		be a singly circular linked list or doubly circular linked list.
 * 	->	Advantages of Circular Linked Lists:
 * 		1.	Any node can be a starting point. We can traverse the whole list by
 * 			starting from any point. We just need to stop when the first visited
 * 			node is visited again.
 *		2.	Useful for implementation of queue. We don’t need to maintain two
 *			pointers for front and rear if we use circular linked list. We can
 *			maintain a pointer to the last inserted node and front can always be
 *			obtained as next of last.
 *		3.	Circular lists are useful in applications to repeatedly go around the
 *			list. For example, when multiple applications are running on a PC, it
 *			is common for the operating system to put the running applications on
 *			a list and then to cycle through them, giving each of them a slice of
 *			time to execute, and then making them wait while the CPU is given to
 *			another application. It is convenient for the operating system to use
 *			a circular list so that when it reaches the end of the list it can cycle
 *			around to the front of the list.
 *		4.	Circular Doubly Linked Lists are used for implementation of advanced
 *			data structures like Fibonacci Heap.
 */
public class T_004_CircularSinglyLinkedList{
	
	public static class Node {
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}

	public static class CircularSinglyLinkedList{
		private Node head;

		public CircularSinglyLinkedList(){
			this.head = null;
		}

		public void insert(int index, int data){
			if(index < 0 || index > size()){
				return;
			}
			Node newNode = new Node(data);
			if(index == 0){
				if (head == null) {
					head = newNode;
					head.next = head;
				} else {
					newNode.next = head;
					Node current = head;
					while(current.next != head){
						current = current.next;
					}
					current.next = newNode;
					head = newNode;
				}

			} else {
				Node current = head;
				for(int i=0; i<index-1; i++){
					current = current.next;
				}
				newNode.next = current.next;
				current.next = newNode;
			}
		}

		public String search(int key){
			if(head != null){
				Node current = head;
				while(current.next != head && current.data != key){
					current = current.next;
				}
				if(current.next == head && current.data != key){
					return "Node ["+key+"] not found";
				} else {
					return "Node ["+key+"] found";
				}
			}
			return "Node ["+key+"] not found";
		}

		public boolean delete(int index){
			if(index < 0 || index >= size()){
				return false;
			}
			if(head == null ){
				return false;
			}
			Node current = head;
			if(index == 0){
				while(current.next != head){
					current = current.next;
				}
				if(current == head){
					head = null;
				} else{
					current.next = head.next;
					head = head.next;
				}
			} else {
				for(int i=0; i<index-1; i++){
					current = current.next;
				}
				current.next = current.next.next;
			}

			return true;
		}

		public int size(){
			int count = 0;
			if(head == null){
				return count;
			} else {
				count++;
				Node current = head;
				while(current.next != head){
					count++;
					current = current.next;
				}
			}
			return count;
		}

		public void display(){
			if(head != null){
				Node current = head;
				while(current.next != head){
					System.out.print(current.data + " ");
					current = current.next;
				}
				System.out.println(current.data);
			}
		}
	}

	public static void main(String[] args) {
		CircularSinglyLinkedList list = new CircularSinglyLinkedList();
		list.insert(0, 38);
		list.insert(0, 12);
		list.insert(1, 373);
		list.insert(2, 43);
		list.insert(1, 10);
		list.insert(0, 91);
		list.insert(6, 30);
		list.insert(8, 89);
		list.display();
		System.out.println("==========================");
		System.out.println(list.search(38));
		System.out.println(list.search(373));
		System.out.println(list.search(30));
		System.out.println("==========================");
		System.out.println(list.delete(6));
		list.display();
		System.out.println(list.delete(3));
		list.display();
		System.out.println(list.delete(0));
		list.display();
		System.out.println("==========================");
	}
}