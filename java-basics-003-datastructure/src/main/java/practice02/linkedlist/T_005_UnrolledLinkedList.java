package practice02.linkedlist;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

@SuppressWarnings({ "unused", "unchecked" })
public class T_005_UnrolledLinkedList<E> {

	protected int nodeCapacity = 0;
	public int modCount;
	public int size;
	private T_005_UnrolledLinkedList<E>.ULLNode lastNode;
	
	private class ULLNode {
		ULLNode next;
		ULLNode previous;
		int numOfElems = 0;
		Object[] elements;

		ULLNode() {
			elements = new Object[nodeCapacity];
		}
	}
	
	private class ULLIterator implements ListIterator<E> {
		
		ULLNode currNode;
		int ptr;
		int index;
		private final int expectedModeCount = modCount;

		public ULLIterator(ULLNode node, int pointer, int index) {
			this.currNode = node;
			this.ptr = pointer;
			this.index = index;
		}
		
		@Override
		public boolean hasNext() {
			return index < (size - 1);
		}

		@Override
		public E next() {
			ptr++;
			if (ptr >= currNode.numOfElems) {
				if (currNode.next != null) {
					currNode = currNode.next;
					ptr = 0;
				}
				else {
					throw new NoSuchElementException();
				}
			}
			index++;
			checkForModification();
			return (E) currNode.elements[ptr];
		}

		@Override
		public boolean hasPrevious() {
			return (index > 0);
		}

		@Override
		public E previous() {
			ptr--;
			if (ptr < 0) {
				if (currNode.previous != null) {
					currNode = currNode.previous;
					ptr = currNode.numOfElems - 1;
				}
				else {
					throw new NoSuchElementException();
				}
			}
			index--;
			checkForModification();
			return (E) currNode.elements[ptr];
		}

		@Override
		public int nextIndex() {
			return index + 1;
		}

		@Override
		public int previousIndex() {
			return index - 1;
		}

		@Override
		public void remove() {
			checkForModification();
		}

		@Override
		public void set(E e) {
			checkForModification();
			currNode.elements[ptr] = e;
		}

		@Override
		public void add(E e) {
			checkForModification();
		}

		private void checkForModification() {
			if (modCount != expectedModeCount) {
				throw new ConcurrentModificationException();
			}
		}

	}

	private void mergeWithNextNode(ULLNode node) {
		ULLNode next = node.next;
		for (int i = 0; i < next.numOfElems; i++) {
			node.elements[node.numOfElems + i] = next.elements[i];
			next.elements[i] = null;
		}
		node.numOfElems += next.numOfElems;
		if (next.next != null) {
			next.next.previous = node;
		}
		node.next = next.next.next;
		if (next == lastNode) {
			lastNode = node;
		}
	}
}
