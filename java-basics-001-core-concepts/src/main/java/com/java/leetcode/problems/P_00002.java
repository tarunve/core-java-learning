package com.java.leetcode.problems;

/*
 * 	You are given two non-empty linked lists representing two non-negative integers. The digits are 
 * 	stored in reverse order and each of their nodes contain a single digit. Add the two numbers and 
 * 	return it as a linked list.
 * 	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 	
 * 	Example:
 * 		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 		Output: 7 -> 0 -> 8	
 * 		Explanation: 342 + 465 = 807.
 * 
 * 	Complexity Analysis:
 * 		Time complexity : O(max(m, n)). Assume that mm and nn represents the length of l1 and l2 
 * 			respectively, the algorithm above iterates at most max(m,n) times.
 * 		Space complexity : O(max(m,n)). The length of the new list is at most max(m,n)+1.
 */
public class P_00002 {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode currNode = result;
        int sum, carry=0;
        while(l1 != null && l2 != null){
            sum=0;
            sum=l1.val +l2.val + carry;
           	carry = sum/10;
            sum = sum%10;
            currNode.next = new ListNode(sum);
            currNode = currNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            if(carry != 0){
            	currNode.next = addTwoNumbers(l1, new ListNode(carry));
            } else{
            	currNode.next= l1;
            }
        } else if(l2 != null){
            if(carry != 0){
            	currNode.next = addTwoNumbers(l2, new ListNode(carry));
            } else{
            	currNode.next= l2;
            }
        } else if(carry != 0){
        	currNode.next= new ListNode(carry);
        }
        return result.next;
    }
	
	public static ListNode addTwoNumbersEnhanced(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}
	
	public static void printList(ListNode root){
		StringBuilder result = new StringBuilder();
		while(root != null){
			result.append(root.val);
			if(root.next != null)
				result.append("->");
			root = root.next;
		}
		System.out.println(result.toString());
	}
	
	public static void main(String[] args) {
		ListNode root1 = new ListNode(2);
		root1.next = new ListNode(4);
		root1.next.next = new ListNode(3);
		root1.next.next.next = new ListNode(9);
		printList(root1);
		ListNode root2 = new ListNode(5);
		root2.next = new ListNode(6);
		root2.next.next = new ListNode(4);
		root2.next.next.next = new ListNode(9);
		printList(root2);
		printList(addTwoNumbers(root1, root2));
	}
}
