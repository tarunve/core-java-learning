package narsimhak.practice02.linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P_002_ProblemLinkedListLogics {
	
	static class ListNode {
		ListNode next;
		int data;
		
		ListNode(int data) {
			this.data = data;
		}
	}

	/*
	 * Insert the element in sorted linked list
	 * Space complexity : O(1)
	 * Time Complexity : O(n)
	 */
	public void insertInSortedList(ListNode head, ListNode newNode) {
		if (head == null)
			head = newNode;
		ListNode currNode = head;
		ListNode temp = null;
		while (currNode != null && currNode.data < newNode.data) {
			temp = currNode;
			currNode = currNode.next;
		}
		newNode.next = currNode;
		temp.next = newNode;
	}
	
	/*
	 * Reverse a singly linked list
	 * Space complexity : O(1)
	 * Time Complexity : O(n)
	 */
	public ListNode reverseSinglyLinkedList(ListNode head) {
		ListNode currNode = head;
		ListNode prevNode = null;
		while (currNode != null) {
			ListNode next = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = next;
		}
		return prevNode;
	}
	
	/*
	 * Find Intersecting Node in 2 linked lists
	 *	Space Complexity - O(1)
	 *	Time Complexity - O(max(m,n)) || m,n are the length of the lists
	 */
	public ListNode findIntersectingNode(ListNode head1, ListNode head2) {
		int length1 = 0, length2 = 0, diff = 0;
		ListNode currNode1 = head1, currNode2 = head2;
		while (currNode1 != null) {
			length1++;
			currNode1 = currNode1.next;

		}
		while (currNode2 != null) {
			length2++;
			currNode1 = currNode2.next;

		}
		if (length1 < length2) {
			currNode1 = head2;
			currNode2 = head1;
			diff = length2 - length1;
		}
		else {
			currNode1 = head1;
			currNode2 = head2;
			diff = length1 - length2;
		}
		for (int i = 0; i < diff; i++) {
			currNode1 = currNode1.next;
		}
		while (currNode1 != null && currNode2 != null) {
			if (currNode1 == currNode2) {
				return currNode1;
			}
			currNode1 = currNode1.next;
			currNode2 = currNode2.next;
		}
		return null;
	}

	/*
	 * 	Find the middle element in linked list
	 *	Space complexity : O(1)
	 * 	Time Complexity : O(n)
	 */
	public ListNode findMiddleNode(ListNode head) {
		if (head == null)
			return null;
		else {
			ListNode currNode = head;
			ListNode midNode = head;
			int i = 0;
			while (currNode.next != null) {
				if (i == 0) {
					currNode = currNode.next;
					i = 1;
				}
				else if (i == 1) {
					currNode = currNode.next;
					midNode = midNode.next;
					i = 1;
				}
			}
			return midNode;
		}
	}

	/*
	 * 	Display linked list from the end
	 * 	Time Complexity : O(n)
	 * 	Space Complexity : O(n) -> Stack
	 */
	public void displayListFromEnd(ListNode head) {
		if (head == null)
			return;
		displayListFromEnd(head.next);
		System.out.println(head.data);
	}
	
	/*
	 *	Split a Circular Linked List into two equal parts. If the number of nodes in the
	 *	list are odd then make first list one node extra than second list.
	 * 	Time Complexity : O(n)
	 * 	Space Complexity : O(1)
	 */
	@SuppressWarnings("unused")
	public void splitCircularLLInTwoEqualCircularLL(ListNode head) {
		ListNode fastPtr = head, slowPtr = head;
		ListNode head1 = null, head2 = null;
		if (head == null)
			return;
		while (fastPtr.next != head && fastPtr.next.next != head) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}
		if (fastPtr.next.next == head) {
			fastPtr = fastPtr.next;
		}
		head1 = head;
		if (head.next != head)
			head2 = slowPtr.next;
		fastPtr.next = slowPtr.next;
		slowPtr.next = head;
	}
	
	/*
	 * 	Reverse K nodes
	 */
	public ListNode reverseKNodesRecursive(ListNode head, int k) {
		ListNode current = head;
		ListNode prev = null, next = null;
		int count = k;
		while (current != null && count > 0) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count--;
		}
		if (next != null) {
			head.next = reverseKNodesRecursive(next, k);
		}
		return prev;
	}
	
	public ListNode reverseKNodes(ListNode head, int k) {
		ListNode current = head;
		ListNode prevCurrent = head, prevTail = null;
		while (current != null) {
			int count = k;
			ListNode tail = null;
			while (current != null && count > 0) {
				ListNode next = current.next;
				current.next = tail;
				tail = current;
				current = next;
				count--;
			}
			if (prevTail != null) {
				prevTail.next = tail;
			}
			else {
				head = tail;
			}
			prevTail = prevCurrent;
			prevCurrent = current;
		}
		return head;
	}

	/*
	 * 	Find modular node: Given a singly linked list, write a function to find the last
	 *	element from the beginning whose n%k == 0, where n is the number of elements in the list
	 *	and k is an integer constant. For example, if n = 19 and k = 3 then we should return 18th node.
	 * 	Time Complexity : O(n)
	 * 	Space Complexity : O(1)
	 */
	public ListNode findModularNode(ListNode head, int k) {
		ListNode currNode = head;
		int i = 0;
		if (k <= 0)
			return null;
		for (ListNode temp = head; temp != null; temp = temp.next) {
			if (i % k == 0) {
				currNode = head;
			}
			i++;
		}
		return currNode;
	}

	/*
	 * 	Find fractional node: Given a singly linked list, write a function to find the
	 *	fractional element n/k, where n is the number of elements in the list.
	 * 	Time Complexity : O(n)
	 * 	Space Complexity : O(1)
	 */
	public ListNode findFractionalNode(ListNode head, int k) {
		if (k <= 0 || head == null)
			return null;
		ListNode fractionalNode = null;
		int i = 0;
		for (ListNode temp = head; temp != null; temp = temp.next) {
			if (i % k == 0) {
				if (fractionalNode == null)
					fractionalNode = temp;
				else
					fractionalNode = fractionalNode.next;
			}
			i++;
		}
		return fractionalNode;
	}
	
	/*
	 * 	Given a singly linked list L: L1-> L2-> L3...-> Ln–1-> Ln, reorder it to: L1->Ln-> L2-> Ln–1......
	 * 	Time Complexity : O(n)
	 * 	Space Complexity : O(1)
	 */
	public void reorderList(ListNode head) {
		if (head == null)
			return;
		ListNode slowPtr = head;
		ListNode fastPtr = head.next;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}
		ListNode head2 = slowPtr.next;
		slowPtr.next = null;
		LinkedList<ListNode> list = new LinkedList<>();
		while (head2 != null) {
			ListNode temp = head2;
			head2 = head2.next;
			temp.next = null;
			list.push(temp);
		}
		while (!list.isEmpty()) {
			ListNode temp = list.pop();
			temp.next = head.next;
			head.next = temp;
			head = temp.next;
		}
	}

	/*
	 * 	Given a list, rotate the list to the right by k places, where k is non-negative. For
	 *	example: Given 1_->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		ListNode rotateStart = head, rotateEnd = head;
		while (k-- > 0) {
			rotateEnd = rotateEnd.next;
			if (rotateEnd == null)
				rotateEnd = head;
		}
		if (rotateStart == rotateEnd) {
			return head;
		}
		while (rotateEnd.next != null) {
			rotateStart = rotateStart.next;
			rotateEnd = rotateEnd.next;
		}
		ListNode temp = rotateStart.next;
		rotateEnd.next = head;
		rotateStart.next = null;
		return temp;
	}
	/*
	 * 	You are given two linked lists representing two non-negative numbers. The digits are stored
	 *	in reverse order and each of their nodes contain a single digit. Add the two numbers and
	 *	return it as a linked list. For example with input: (3 -> 4 -> 3) + (5 -> 6 -> 4);
	 *	the output should be 8 -> 0 -> 8
	 */
	public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		ListNode head = new ListNode(0);
		ListNode current = head;
		int advance = 0;
		while (head1 != null && head2 != null) {
			int sum = head1.data + head2.data + advance;
			advance = sum / 10;
			sum = sum % 10;
			current.next = new ListNode(sum);
			current = current.next;
			head1 = head1.next;
			head2 = head2.next;
		}
		if (head1 != null) {
			if (advance != 0) {
				current.next = addTwoNumbers(head1, new ListNode(advance));
			}
			else {
				current.next = head1;
			}
		}
		else if (head2 != null) {
			if (advance != 0) {
				current.next = addTwoNumbers(head2, new ListNode(advance));
			}
			else {
				current.next = head2;
			}
		}
		else if (advance != 0) {
			current.next = new ListNode(advance);
		}
		return head.next;
	}
	/*
	 * 	Given a linked list and a value K, partition it such that all nodes less than K
	 *	come before nodes greater than or equal to K. You should preserve the original relative
	 *	order of the nodes in each of the two partitions. For example, given 1->4->3->2->5->2
	 *	and K= 3, return 1->2->2->4->3->5.
	 * 	Time Complexity : O(n)
	 * 	Space Complexity : O(1)
	 */
	public static ListNode partitonList(ListNode head, int k) {
		ListNode root = new ListNode(0);
		ListNode pivot = new ListNode(k);
		ListNode rootNext = root, pivotNext = pivot;
		ListNode currNode = head;
		while (currNode != null) {
			ListNode next = currNode.next;
			if (currNode.data >= k) {
				pivotNext.next = currNode;
				pivotNext = currNode;
				pivotNext.next = null;
			}
			else {
				rootNext.next = currNode;
				rootNext = currNode;
			}
			currNode = next;
		}
		rootNext.next = pivot.next;
		return root.next;
	}

	/*
	 * Remove duplicate from list with O(n)
	 */
	public static void removeDuplicates(ListNode head) {
		Map<Integer, Boolean> map = new HashMap<>();
		ListNode currNode = head;
		ListNode next;
		while (currNode.next != null) {
			next = currNode.next;
			if (map.get(next.data) != null) {
				currNode.next = next.next;
			}
			else {
				map.put(next.data, true);
				currNode = currNode.next;
			}
		}
	}

	public static void main(String[] args) {
		/*
		 * addTwoNumbers(head1, head2) Test
		 */
		System.out.println("======addTwoNumbers=====");
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next.next = new ListNode(8);
		ListNode head1 = new ListNode(9);
		head1.next = new ListNode(8);
		head1.next.next = new ListNode(7);
		head1.next.next.next = new ListNode(6);

		ListNode newHead = addTwoNumbers(head, head1);
		while (newHead != null) {
			System.out.print(newHead.data + "->");
			newHead = newHead.next;
		}
		System.out.print("NULL");
		System.out.println();
		/*
		 * partitonList(head1, k) Test
		 */
		System.out.println("======partitonList=====");
		ListNode head2 = new ListNode(3);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(8);
		head2.next.next.next = new ListNode(5);
		head2.next.next.next.next = new ListNode(2);
		head2.next.next.next.next.next = new ListNode(9);
		head2.next.next.next.next.next.next = new ListNode(6);
		ListNode newHead1 = partitonList(head2, 4);
		while (newHead1 != null) {
			System.out.print(newHead1.data + "->");
			newHead1 = newHead1.next;
		}
		System.out.print("NULL");
	}
}
