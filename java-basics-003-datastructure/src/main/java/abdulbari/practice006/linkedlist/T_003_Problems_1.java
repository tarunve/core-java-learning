package abdulbari.practice006.linkedlist;

/**
 * 	Problems :
 * 	========
 *	1.	Check if the Linked List is sorted or not.
 *	2.	Remove duplicates from linked list.
 *	3.	Reverse the linked list.
 *	4.	Merge two sorted linked list.
 */
public class T_003_Problems_1{
	
	public static class Node{
		int data;
		Node next;
		
		public Node(){}
		
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public static void insert(Node head, int value){
		if(head == null){
			head = new Node(value);
		} else{
			Node current = head;
			while(current.next != null){
				current = current.next;
			}
			current.next = new Node(value);
		}
	}	
	
	public static void display(Node node){
		while(node != null){
			System.out.print(node.data + "");
			if(node.next != null){
				System.out.print("->");
			}
			node = node.next;
		}
		System.out.println();
	}
	
	public static boolean isSorted(Node head){
		if(head == null || head.next == null){
			return true;
		}
		
		Node current = head;
		while(current.next != null){
			if(current.data > current.next.data){
				return false;
			}
			current = current.next;
		}
		return true;
	}
	
	public static void removeDuplicates(Node head){
		if(head == null || head.next == null){
			return;
		}
		
		Node current = head;
		while(current.next != null){
			if(current.data == current.next.data){
				current.next = current.next.next;
			}else {
				current = current.next;
			}
		}
	}
	
	public static Node reverse(Node head){
		if(head == null || head.next == null){
			return head;
		}
		Node p=head, q=null,r;
		while(p != null){
			r=q;
			q=p;
			p=p.next;
			q.next = r;
		}
		head = q;
		return head;
	}
	
	public static Node merge(Node first , Node second){
		Node dummy = new Node(0);
		Node current= dummy;
		while(true){
			if(first == null){
				current.next = second;
				break;
			}
			if(second == null){
				current.next = first;
				break;
			}
			if(first.data <= second.data){
				current.next = first;
				first = first.next;
			} else {
				current.next = second;
				second = second.next;
			}
			current = current.next;
		}
		
		return dummy.next;
	}
	
	public static Node mergeRecursive(Node first , Node second){
		if(first == null)
			return second;
		if(second == null)
			return first;
		if(first.data < second.data){
			first.next = mergeRecursive(first.next, second);
			return first;
		}else{
			second.next = mergeRecursive(first, second.next);
			return second;
		}
	}
	
	public static boolean ifLoopExists(Node head){
		Node first = head;
		Node second = head;
		while(first!= null && second!=null && first!=second){
			first = first.next;
			second = second.next;
			if(second != null) {
				second = second.next;
			}
		}
		return first == second;
	}
	
	public static void main(String[] args){
		//Check sorting nature of linked list
		Node node = new Node(1);
		insert(node, 12);
		insert(node, 34);
		insert(node, 45);
		insert(node, 23);
		insert(node, 10);
		display(node);
		System.out.println(isSorted(node));
		
		Node node1 = new Node(4);
		insert(node1, 12);
		insert(node1, 34);
		insert(node1, 34);
		insert(node1, 34);
		insert(node1, 34);
		insert(node1, 45);
		insert(node1, 63);
		insert(node1, 70);
		insert(node1, 70);
		display(node1);
		System.out.println(isSorted(node1));
		System.out.println("=======================");
		//remove duplicates from linked list
		removeDuplicates(node1);
		display(node1);
		System.out.println("=======================");
		//reverse the linked list
		Node reversedHead = reverse(node1);
		display(reversedHead);
		System.out.println("=======================");
		//merge two sorted linked list
		Node node2 = new Node(1);
		insert(node2, 3);
		insert(node2, 5);
		insert(node2, 7);
		display(node2);
		Node node3 = new Node(2);
		insert(node3, 4);
		insert(node3, 6);
		insert(node3, 8);
		display(node3);
		Node mergedHead = merge(node2, node3);
		display(mergedHead);
		Node node4 = new Node(1);
		insert(node4, 3);
		insert(node4, 5);
		insert(node4, 7);
		display(node4);
		Node node5 = new Node(2);
		insert(node5, 4);
		insert(node5, 6);
		insert(node5, 8);
		display(node5);
		Node mergedRecursiveHead = merge(node4, node5);
		display(mergedRecursiveHead);
		System.out.println("=======================");
		//check if loop exists
		Node node6 = new Node(1);
		Node node7 = new Node(45);
		node6.next= node7;
		Node node8 = new Node(46);
		node7.next = node8;
		Node node9 = new Node(45);
		node8.next = node9;
		node9.next = node7;
		System.out.println(ifLoopExists(node6));
		System.out.println("=======================");
	}
}