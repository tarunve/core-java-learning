package practice07.graphs;

/*
 * 	->	The Spanning tree of a graph is a subgraph that contains all the vertices and is also a tree. A graph 
 * 		may have many spanning trees.
 * 	->	A minimum spanning tree of an undirected graph G is a tree formed from graph edges that connect all 
 * 		the vertices of G with minimum total cost (weights).
 * 	->	A minimum spanning tree exists only if the graph is connected. 
 * 
 * 	Prim’s Algorithm
 * 	----------------
 * 	->	Prim’s algorithm is almost the same as Dijkstra’s algorithm. As in Dijkstra’s algorithm, in Prim’s 
 * 		algorithm we keep the values distance and paths in the distance table. The only exception is that since 
 * 		the definition of distance is different, the updating statement also changes a little. The update 
 * 		statement is simpler than before.
 * 	->	The entire implementation of this algorithm is identical to that of Dijkstra’s algorithm. The running 
 * 		time is O(|V|2) without heaps [good for dense graphs], and O(ElogV) using binary heaps [good for sparse graphs].
 */
public class T_011_MinSpanningTree_PrimsAlgo {
	
	private static void primMST(int[][] graph, int numNodes, int source) {
		int parent[] = new int[numNodes];
		int key[] = new int[numNodes];
		boolean mstSet[] = new boolean[numNodes];
		
		for(int i=0; i<numNodes ; i++){
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		
		key[source] = 0;
		parent[source] = -1;
		
		for(int count=0; count< numNodes-1 ; count++){
			int u = minKey(key, mstSet, numNodes);
			mstSet[u] = true;
			for(int v=0; v<numNodes; v++){
				if(graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]){
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}
		printMST(parent, numNodes, graph);
	}
	
	private static void printMST(int[] parent, int numNodes, int[][] graph) {
		System.out.println("Edge Weight : ");
		for(int i=1; i< numNodes; i++)
			System.out.println(parent[i]+"-"+ i + " " + graph[i][parent[i]]);
	}

	private static int minKey(int[] key, boolean[] mstSet, int numNodes) {
		int min = Integer.MAX_VALUE;
		int min_index = 0;
		for(int i=0; i<numNodes ; i++){
			if(mstSet[i] == false && key[i] < min){
				min = key[i];
				min_index = i;
			}
		}
		return min_index;
	}

	public static void main(String[] args) {
		int numNodes = 5;
		int graph[][] = {{0,2,0,6,0},{2,0,3,8,5},{0,3,0,0,7},{6,8,0,0,9},{0,5,7,9,0}};
		primMST(graph, numNodes, 0);
	}
}
