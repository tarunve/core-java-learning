package practice13.greedy.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * 	->	Prefix Codes, means the codes (bit sequences) are assigned in such a way that the code assigned 
 * 		to one character is not the prefix of code assigned to any other character. This is how Huffman 
 * 		Coding makes sure that there is no ambiguity when decoding the generated bit stream.
 * 	->	Let us understand prefix codes with a counter example. Let there be four characters a, b, c and d, 
 * 		and their corresponding variable length codes be 00, 01, 0 and 1. This coding leads to ambiguity 
 * 		because code assigned to c is the prefix of codes assigned to a and b. If the compressed bit stream 
 * 		is 0001, the de-compressed output may be “cccd” or “ccb” or “acd” or “ab”.
 * 
 * 	->	There are mainly two major parts in Huffman Coding
 * 		1)	Build a Huffman Tree from input characters.
 * 		2)	Traverse the Huffman Tree and assign codes to characters.
 * 	
 * 	Steps to build Huffman Tree
 * 	---------------------------
 * 	1.	Create a leaf node for each unique character and build a min heap of all leaf nodes (Min Heap 
 * 		is used as a priority queue. The value of frequency field is used to compare two nodes in min heap. 
 * 		Initially, the least frequent character is at root)
 * 	2.	Extract two nodes with the minimum frequency from the min heap.
 * 	3.	Create a new internal node with a frequency equal to the sum of the two nodes frequencies. Make 
 * 		the first extracted node as its left child and the other extracted node as its right child. 
 * 		Add this node to the min heap.
 * 	4.	Repeat steps#2 and #3 until the heap contains only one node. The remaining node is the root node 
 * 		and the tree is complete.
 */
public class T_002_HuffmanCoding {
	
	public static class HuffmanNode implements Comparable<HuffmanNode>{
		int frequency;
		char data;
		HuffmanNode left, right;
		
		@Override
		public int compareTo(HuffmanNode node) {
			return frequency-node.frequency;
		}
	}
	
	static HuffmanNode root;
	private static Map<Character, String> charPrefixHashMap = new HashMap<Character, String>();
	
	private static String encode(String str){
		Map<Character, Integer> freqMap = new HashMap<>();
		for(int i=0; i<str.length(); i++){
			if(!freqMap.containsKey(str.charAt(i))){
				freqMap.put(str.charAt(i), 0);
			}
			freqMap.put(str.charAt(i), freqMap.get(str.charAt(i)) + 1);
		}
		System.out.println("Character Frequency Map = " + freqMap);
		root = buildTree(freqMap);
		setPrefixCodes(root, new StringBuilder());
		System.out.println("Character Prefix Map = " + charPrefixHashMap);

		StringBuilder s = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			s.append(charPrefixHashMap.get(c));
		}
		System.out.println("Encoded String = "+ s.toString());
		return s.toString();
	}
	
	private static HuffmanNode buildTree(Map<Character, Integer> freqMap) {
		PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
		Set<Character> keySet = freqMap.keySet();
		for (Character c : keySet) {
			HuffmanNode huffmanNode = new HuffmanNode();
			huffmanNode.data = c;
			huffmanNode.frequency = freqMap.get(c);
			huffmanNode.left = null;
			huffmanNode.right = null;
			priorityQueue.offer(huffmanNode);
		}
		
		while(priorityQueue.size() > 1){
			HuffmanNode x = priorityQueue.peek();
			priorityQueue.poll();
			HuffmanNode y = priorityQueue.peek();
			priorityQueue.poll();
			HuffmanNode sum = new HuffmanNode();
			sum.frequency = x.frequency + y.frequency;
			sum.data = '-';
			sum.left = x;
			sum.right = y;
			root=sum;
			priorityQueue.offer(sum);
		}
		return priorityQueue.poll();
	}
	
	private static void setPrefixCodes(HuffmanNode node, StringBuilder prefix) {
		if(node != null){
			if(node.left == null && node.right == null){
				charPrefixHashMap.put(node.data, prefix.toString());
			} else {
				prefix.append('0');
				setPrefixCodes(node.left, prefix);
				prefix.deleteCharAt(prefix.length()-1);
				
				prefix.append('1');
				setPrefixCodes(node.right, prefix);
				prefix.deleteCharAt(prefix.length()-1);
			}
		}
	}
	
	private static void decode(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		HuffmanNode temp = root;
		for(int i=0; i<s.length(); i++){
			int j = Integer.parseInt(String.valueOf(s.charAt(i)));
			if(j==0){
				temp = temp.left;
				if(temp.left == null && temp.right == null){
					stringBuilder.append(temp.data);
					temp = root;
				}
			}
			if(j==1){
				temp = temp.right;
				if(temp.left == null && temp.right == null){
					stringBuilder.append(temp.data);
					temp = root;
				}
			}
		}
		System.out.println("Decoded String = "+stringBuilder.toString());
	}


	public static void main(String[] args) {
		String test = "ABCD1%$^AAABBGGDDDDDAAAAA";
		System.out.println("Original Text = "+test);
		String s = encode(test);
		decode(s);
	}

	
}
