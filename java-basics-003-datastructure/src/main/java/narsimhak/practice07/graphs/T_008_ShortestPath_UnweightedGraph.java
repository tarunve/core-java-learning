package narsimhak.practice07.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * 	Applications of Shortest Path Algorithms
 * 	----------------------------------------
 * 	->	Finding fastest way to go from one place to another
 * 	->	Finding cheapest way to fly/send data from one city to another
 * 
 * 	Shortest Path in Unweighted Graph
 * 	---------------------------------
 * 	->	Let s be the input vertex from which we want to find the shortest path to all other vertices.
 * 		Unweighted graph is a special case of the weighted shortest-path problem, with all edges a 
 * 		weight of 1. The algorithm is similar to BFS and we need to use the following data structures:
 * 		->	A distance table with three columns (each row corresponds to a vertex):
 * 			->	Distance from source vertex.
 * 			->	Path � contains the name of the vertex through which we get the shortest distance.
 * 		->	A queue is used to implement breadth-first search. It contains vertices whose distance 
 * 			from the source node has been computed and their adjacent vertices are to be examined.
 * 
 * 
 * 	Running time: O(|E| + |V|), if adjacency lists are used. In for loop, we are checking the outgoing
 * 	edges for a given vertex and the sum of all examined edges in the while loop is equal to the number 
 * 	of edges which gives O(|E|).
 */
public class T_008_ShortestPath_UnweightedGraph {
	
	public static class Graph{
		private static int EDGE_DISTANCE = 1;
		private static LinkedList<Integer> adj[];
		
		@SuppressWarnings("unchecked")
		public Graph(int size) {
			adj = new LinkedList[size];
			for(int i=0; i<size ;i++)
				adj[i] = new LinkedList<Integer>();
		}
		
		public void addEdge(int first, int second){
			adj[first].add(second);
			adj[second].add(first);
		}
		
		public static int[] neighbours(LinkedList<Integer> node){
			int[] neighbours = new int[node.size()];
			int i=0;
			Iterator<Integer> itr = node.iterator();
			while(itr.hasNext()){
				neighbours[i++] = itr.next();
			}
			return neighbours;
		}
		
		public static int[] shortestPath(int startId){
			LinkedList<Integer> queue = new LinkedList<>();
			queue.add(startId);
			
			int[] distances = new int[adj.length];
			Arrays.fill(distances, -1);
			distances[startId] = 0;
			
			while(!queue.isEmpty()){
				int node = queue.poll();
				for(int neighbour : neighbours(adj[node])){
					if(distances[neighbour] == -1){
						distances[neighbour] = distances[node] + EDGE_DISTANCE;
						queue.add(neighbour);
					}
				}
			}
			return distances;
		}
		
		public static void main(String[] args) {
			Graph g = new Graph(6); 
	        g.addEdge(5, 2); 
	        g.addEdge(5, 0); 
	        g.addEdge(4, 0); 
	        g.addEdge(4, 1); 
	        g.addEdge(2, 3); 
	        g.addEdge(3, 1); 
	        System.out.println(Arrays.toString(shortestPath(1)));
		}
	}
}
