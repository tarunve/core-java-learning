package practice07.graphs;

/*
 * 	Bellman-Ford Algorithm
 * 	----------------------
 * 	->	If the graph has negative edge costs, then Dijkstra’s algorithm does not work. The problem is that
 * 		once a vertex u is declared known, it is possible that from some other, unknown vertex v there is a
 * 		path back to u that is very negative. In such a case, taking a path from s to v back to u is better
 * 		than going from s to u without using v. A combination of Dijkstra’s algorithm and unweighted
 * 		algorithms will solve the problem. Initialize the queue with s. Then, at each stage, we DeQueue a	
 * 		vertex v. We find all vertices W adjacent to v such that,
 * 				distance to V + weight(V,W) < old distance to W
 * 	->	We update w old distance and path, and place w on a queue if it is not already there. A bit can be
 * 		set for each vertex to indicate presence in the queue. We repeat the process until the queue is empty.
 * 	->	This algorithm works if there are no negative-cost cycles. Each vertex can DeQueue at most | V| 
 * 		times, so the running time is O(|E| . |V|) if adjacency lists are used.
 * 
 * 	Overview of Shortest Path Algorithms
 * 	------------------------------------
 * 	Shortest path in unweighted graph [Modified BFS]						-  	O(|E| + |V|)
 * 	Shortest path in weighted graph [Dijkstra’s] 							-	O(|E| log |V|)
 * 	Shortest path in weighted graph with negative edges [Bellman – Ford] 	-	O(|E|.|V|)
 * 	Shortest path in weighted acyclic graph 								-	O(|E| + |V|)	
 */
public class T_010_ShortestPath_WeightedGraphNegativeEdge {
	
	private static void bellmanFord(int[][] graph, int numNodes, int numEdges, int source) {
		int[] distances = new int[numNodes];
		for(int i=0; i<numNodes ; i++){
			distances[i] = Integer.MAX_VALUE;
		}
		distances[source] = 0;
		
		// Relax all edges |V| - 1 times. 
		for(int i=0 ; i< numNodes-1 ;i++){
			for(int j=0 ; j < numEdges; j++){
				if(distances[graph[j][0]] + graph[j][2] < distances[graph[j][1]]  )
					distances[graph[j][1]] = distances[graph[j][0]] + graph[j][2];
			}
		}
		
		for (int i = 0; i < numEdges; i++)  
	    { 
	        int x = graph[i][0]; 
	        int y = graph[i][1]; 
	        int weight = graph[i][2]; 
	        if (distances[x] != Integer.MAX_VALUE && distances[x] + weight < distances[y]) 
	            System.out.println("Graph contains negative weight cycle"); 
	    } 
	  
	    System.out.println("Vertex Distance from Source"); 
	    for (int i = 0; i < numNodes; i++) 
	        System.out.println(i + "\t\t" + distances[i]); 
	}
	
	public static void main(String[] args) {
		int numNodes =5;
		int numEdges = 8;
		int graph[][] = {	{ 0, 1, -1}, { 0, 2, 4 }, 
                			{ 1, 2, 3 }, { 1, 3, 2 },  
                			{ 1, 4, 2 }, { 3, 2, 5 },  
                			{ 3, 1, 1 }, { 4, 3, -3} 
                		}; 
		bellmanFord(graph, numNodes, numEdges, 0);
	}
}
