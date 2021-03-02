package narsimhak.practice11.hashing;

@SuppressWarnings("unused")
public class Problems_1 {
	/*
	 * 	Implement a separate chaining collision resolution technique. Also, discuss time complexities of each function.
	 */
	public class ListNode{
		public int key;
		public int data;
		public ListNode next;
	}
	
	public class HashTableNode{
		public int blockCount;
		public ListNode startNode;
	}
	
	public class HashTable{
		public int tSize;
		public int count;
		public HashTableNode[] table;
	}
	
	public class HashTableOperations{
		
		private void rehash(HashTable h){
			int index;
			ListNode p, temp2;
			HashTableNode[] oldTable = h.table;
			int oldSize = h.tSize;
			h.tSize = (h.tSize*2);
			h = new HashTable();
			for(int i=0; i<oldSize; i++){
				for(ListNode temp=oldTable[i].startNode.next; temp!=null ; temp = temp.next){
					
				}
			}
		}
	}
}
