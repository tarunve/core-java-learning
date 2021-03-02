package narsimhak.practice02.linkedlist;

public class P_001_ProblemFindIfLoopPresent<T> {
	
	@SuppressWarnings("unchecked")
	public boolean findIfLoopExistsUsingFloyd(T list) {
		T_002_SinglyLinkedList<Integer> newList = (T_002_SinglyLinkedList<Integer>) list;
		T_002_SinglyLinkedList.SLLNode1<Integer> fastPtr = newList.head;
		T_002_SinglyLinkedList.SLLNode1<Integer> slowPtr = newList.head;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (slowPtr == fastPtr) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean findIfLoopExistsUsingFloydCyclic(T list) {
		T_004_CircularLinkedList<Integer> newList = (T_004_CircularLinkedList<Integer>) list;
		T_004_CircularLinkedList.CLLNode1<Integer> fastPtr = newList.tail;
		T_004_CircularLinkedList.CLLNode1<Integer> slowPtr = newList.tail;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (slowPtr == fastPtr) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		T_002_SinglyLinkedList<Integer> list = new T_002_SinglyLinkedList<>();
		list.insertAtBegin(34);
		list.insertAtEnd(56);
		P_001_ProblemFindIfLoopPresent<T_002_SinglyLinkedList<Integer>> obj = new P_001_ProblemFindIfLoopPresent<>();
		System.out.println(obj.findIfLoopExistsUsingFloyd(list));

		P_001_ProblemFindIfLoopPresent<T_004_CircularLinkedList<Integer>> obj2 = new P_001_ProblemFindIfLoopPresent<>();
		T_004_CircularLinkedList<Integer> circularList = new T_004_CircularLinkedList<>();
		circularList.insertAtBegin(34);
		circularList.insertAtEnd(56);
		System.out.println(obj2.findIfLoopExistsUsingFloydCyclic(circularList));
	}
}
