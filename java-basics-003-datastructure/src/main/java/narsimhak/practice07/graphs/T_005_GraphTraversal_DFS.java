package narsimhak.practice07.graphs;

import java.util.Stack;

/*
 * 	->	Graph traversal algorithms are also called graph search algorithms.
 * 	->	graph search algorithms can be thought of as starting at some source vertex in a graph 
 * 		and �searching� the graph by going through the edges and marking the vertices.
 * 
 * 	Depth First Search:
 * 	------------------
 * 	->	DFS algorithm works in a manner similar to preorder traversal of the trees. Like preorder
 * 		traversal, internally this algorithm also uses stack.
 * 	->	For most algorithms boolean classification, unvisited/visited is enough (for three color
 * 		implementation refer to problems section). That means, for some problems we need to use three 
 * 		colors, but for our discussion two colors are enough.
 * 	->	Initially all vertices are marked unvisited (false). The DFS algorithm starts at a vertex u 
 * 		in the graph. By starting at vertex u it considers the edges from u to other vertices. If the 
 * 		edge leads to an already visited vertex, then backtrack to current vertex u. If an edge leads 
 * 		to an unvisited vertex, then go to that vertex and start processing from that vertex. That 
 * 		means the new vertex becomes the current vertex. Follow this process until we reach the dead-end. 
 * 		At this point start backtracking. The process terminates when backtracking leads back to the 
 * 		start vertex.
 * 
 * 
 * 	->	The time complexity of DFS is O(V + E), if we use adjacency lists for representing the graphs.
 * 		This is because we are starting at a vertex and processing the adjacent nodes only if they are 
 * 		not visited. Similarly, if an adjacency matrix is used for a graph representation, then all edges
 * 		adjacent to a vertex can�t be found efficiently, and this gives O(V2) complexity.
 * 
 * 	Applications of DFS
 * 	-------------------
 * 	1.	Topological sorting
 * 	2.	Finding connected components
 * 	3.	Finding articulation points (cut vertices) of the graph
 * 	4.	Finding strongly connected components
 * 	5.	Solving puzzles such as mazes
 */
public class T_005_GraphTraversal_DFS {
	public class Node{
		public char label;
		public boolean visited;
		
		public Node(char lab) {
			label = lab;
			visited = false;
		}
	}
	
	public class Graph{
		private final int maxNodes = 20;
		private Node nodes[];
		private int nodesCount;
		private int adjMatrix[][];
		private Stack<Integer> stack;
		
		public Graph() {
			nodes = new Node[maxNodes];
			adjMatrix = new int[maxNodes][maxNodes];
			nodesCount = 0;
			stack = new Stack<>();
			for(int y=0; y<maxNodes ; y++){
				for(int x=0; x<maxNodes ; x++){
					adjMatrix[x][y] = 0;
				}
			}
		}
		
		public void addVertex(char lab){
			nodes[nodesCount++] = new Node(lab);
		}
		
		public void addEdge(int start, int end){
			adjMatrix[start][end] = 1;
			adjMatrix[end][start] = 1;
		}
		
		public int getAdjUnvisitedVertex(int v){
			for(int j=0 ; j<nodesCount ; j++){
				if(adjMatrix[v][j] ==1 && !nodes[j].visited)
					return j;
			}
			return -1;
		}
		
		public void displayVertex(int v){
			System.out.print(nodes[v].label);
		}
		
		public void dfs(){
			nodes[0].visited = true;
			displayVertex(0);
			stack.push(0);
			while(!stack.isEmpty()){
				int v = getAdjUnvisitedVertex(stack.peek());
				if(v == -1)
					stack.pop();
				else{
					nodes[v].visited = true;
					displayVertex(v);
					stack.push(v);
				}
			}
			for(int j=0; j<nodesCount ; j++){
				nodes[j].visited = false;
			}
		}
	}
}
