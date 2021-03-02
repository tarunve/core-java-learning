package narsimhak.practice07.graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 	Breadth first Search:
 * 	--------------------
 * 	->	The BFS algorithm works similar to level � order traversal of the trees. Like level � order 
 * 		traversal, BFS also uses queues. In fact, level � order traversal got inspired from BFS. BFS
 * 		works level by level. Initially, BFS starts at a given vertex, which is at level 0. In the 
 * 		first stage it visits all vertices at level 1 (that means, vertices whose distance is 1 from 
 * 		the start vertex of the graph). In the second stage, it visits all vertices at the second level. 
 * 		These new vertices are the ones which are adjacent to level 1 vertices. BFS continues this 
 * 		process until all the levels of the graph are completed. Generally queue data structure is 
 * 		used for storing the vertices of a level.
 * 	->	As similar to DFS, assume that initially all vertices are marked unvisited (false). Vertices 
 * 		that have been processed and removed from the queue are marked visited (true). We use a queue 
 * 		to represent the visited set as it will keep the vertices in the order of when they were first visited.
 * 
 * 	->	Time complexity of BFS is O(V + E), if we use adjacency lists for representing the graphs, and O(V2) 
 * 		for adjacency matrix representation.
 * 
 * 	Applications of BFS:
 * 	-------------------
 * 	1.	Finding all connected components in a graph
 * 	2.	Finding all nodes within one connected component
 * 	3.	Finding the shortest path between two nodes
 * 	4.	Testing a graph for bipartiteness.
 */
public class T_006_GraphTraversal_BFS {
	
	public class Vertex{
		public char label;
		public boolean visited;
		
		public Vertex(char lab) {
			label = lab;
			visited = false;
		}
	}
	
	public class Graph{
		private final int maxVertices = 20;
		private Vertex vertexList[];
		private int vertexCount;
		private int adjMatrix[][];
		private Queue<Integer> queue;
		
		public Graph() {
			vertexList = new Vertex[maxVertices];
			adjMatrix = new int[maxVertices][maxVertices];
			vertexCount = 0;
			queue = new LinkedList<>();
			for(int y=0; y<maxVertices ; y++){
				for(int x=0; x<maxVertices ; x++){
					adjMatrix[x][y] = 0;
				}
			}
		}
		
		public void addVertex(char lab){
			vertexList[vertexCount++] = new Vertex(lab);
		}
		
		public void addEdge(int start, int end){
			adjMatrix[start][end] = 1;
			adjMatrix[end][start] = 1;
		}
		
		public int getAdjUnvisitedVertex(int v){
			for(int j=0 ; j<vertexCount ; j++){
				if(adjMatrix[v][j] ==1 && !vertexList[j].visited)
					return j;
			}
			return -1;
		}
		
		public void displayVertex(int v){
			System.out.print(vertexList[v].label);
		}
		
		public void bfs(){
			vertexList[0].visited = true;
			displayVertex(0);
			queue.offer(0);
			int v2;
			while(!queue.isEmpty()){
				int v1 = queue.remove();
				while((v2=getAdjUnvisitedVertex(v1)) != -1){
					vertexList[v2].visited = true;
					displayVertex(v2);
					queue.offer(v2);	
				}
			}
			for(int j=0; j<vertexCount ; j++){
				vertexList[j].visited = false;
			}
		}
	}
}
