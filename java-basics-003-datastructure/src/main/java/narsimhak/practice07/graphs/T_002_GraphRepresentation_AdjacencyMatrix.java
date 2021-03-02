package narsimhak.practice07.graphs;

/*
 * 	Graph Representation
 * 	--------------------
 * 	->	As in other ADTs, to manipulate graphs we need to represent them in some useful form. Basically,
 * 		there are three ways of doing this:
 * 		1.	Adjacency Matrix
 * 		2.	Adjacency List
 * 		3.	Adjacency Set
 * 
 * 	Adjacency Matrix:
 * 	----------------
 * 	->	In this method, we use a matrix with size V � V. The values of matrix are boolean. Let us assume
 * 		the matrix is Adj. The value Adj[u, v] is set to 1 if there is an edge from vertex u to vertex v 
 * 		and 0 otherwise.
 * 	->	In the matrix, each edge is represented by two bits for undirected graphs. That means, an edge
 * 		from u to v is represented by 1 value in both Adj[u ,v ] and Adj[u,v]. To save time, we can 
 * 		process only half of this symmetric matrix. Also, we can assume that there is an �edge� from each
 * 		vertex to itself. So, Adj[u, u] is set to 1 for all vertices.
 * 	->	If the graph is a directed graph then we need to mark only one entry in the adjacency matrix.
 * 
 * 	Now, let us concentrate on the implementation. To read a graph, one way is to first read the vertex
 * 	names and then read pairs of vertex names (edges). The code below reads an undirected graph
 */
public class T_002_GraphRepresentation_AdjacencyMatrix {
	
	/*
	 * The adjacency matrix representation is good if the graphs are dense. The matrix requires O(V2)
	 * bits of storage and O(V2) time for initialization. If the number of edges is proportional to V2, 
	 * then there is no problem because V2 steps are required to read the edges. If the graph is sparse, 
	 * the initialization of the matrix dominates the running time of the algorithm as it takes takes O(V2).
	 */
	public class Graph{
		private boolean adjMatrix[][];
		private int vertexCount;
		
		public Graph(int vertexCount){
			this.vertexCount = vertexCount;
			this.adjMatrix = new boolean[vertexCount][vertexCount];
		}
		
		public void addEdge(int i, int j){
			if(i >= 0 && i < vertexCount && j>=0 && j< vertexCount){
				adjMatrix[i][j] = true;
				adjMatrix[j][i] = true;
			}
		}
		
		public void removeEdge(int i, int j){
			if(i >= 0 && i < vertexCount && j>=0 && j< vertexCount){
				adjMatrix[i][j] = false;
				adjMatrix[j][i] = false;
			}
		}
		
		public boolean isEdge(int i, int j){
			if(i >= 0 && i < vertexCount && j>=0 && j< vertexCount)
				return adjMatrix[i][j];
			else 
				return false;
		}
	}
}