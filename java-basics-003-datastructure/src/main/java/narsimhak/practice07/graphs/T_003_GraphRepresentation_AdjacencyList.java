package practice07.graphs;

import java.util.ArrayList;

/*
 * 	Adjacency List
 * 	--------------
 * 	->	In this representation all the vertices connected to a vertex v are listed on an adjacency list 
 * 		for that vertex v. This can be easily implemented with linked lists. That means, for each vertex v 
 * 		we use a linked list and list nodes represents the connections between v and other vertices to which 
 * 		v has an edge. 
 * 	->	The total number of linked lists is equal to the number of vertices in the graph.
 * 	->	For this representation, the order of edges in the input is important. This is because they 
 * 		determine the order of the vertices on the adjacency lists. The same graph can be represented in
 * 		many different ways in an adjacency list. The order in which edges appear on the adjacency list
 * 		affects the order in which edges are processed by algorithms.
 * 	
 * 	Disadvantage:
 * 	->	Using adjacency list representation we cannot perform some operations efficiently. As an example, 
 * 		consider the case of deleting a node. . In adjacency list representation, it is not enough if we 
 * 		simply delete a node from the list representation, if we delete a node from the adjacency list
 * 		then that is enough. For each node on the adjacency list of that node specifies another vertex. We
 * 		need to search other nodes linked list also for deleting it. This problem can be solved by linking
 * 		the two list nodes that correspond to a particular edge and making the adjacency lists doubly
 * 		linked. But all these extra links are risky to process.
 */
public class T_003_GraphRepresentation_AdjacencyList {
	
	public class ListNode{
		int data, size;
		ListNode next, head;
		
		ListNode(){}
		
		ListNode(int data){
			this.data = data;
			this.next = null;
		}

		public void insertAtBegining(int data) {
			ListNode newNode = new ListNode(data);
			newNode.next = head;
			head = newNode;
			size++;
		}
	}
	
	public class Graph {
		private ArrayList<Integer> vertices;
		private ListNode[] edges;
		@SuppressWarnings("unused")
		private int vertexCount = 0;
		
		public Graph(int vertexCount){
			this.vertexCount = vertexCount;
			vertices = new ArrayList<>();
			edges = new ListNode[vertexCount];
			for(int i=0; i<vertexCount ; i++){
				vertices.add(i);
				edges[i] = new ListNode();
			}
		}
		
		public void addEdge(int source, int destination){
			int i = vertices.indexOf(source);
			int j = vertices.indexOf(destination);
			if(i != -1 && j != -1 ){
				edges[i].insertAtBegining(destination);
				edges[j].insertAtBegining(source);
			}
		}
	}
}
