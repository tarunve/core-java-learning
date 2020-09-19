package practice07.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * 	Shortest path in Weighted Graph [Dijkstra’s]
 * 	--------------------------------------------
 * 	->	Single source shortest path algorithm.
 * 	->	A famous solution for the shortest path problem was developed by Dijkstra. Dijkstra’s algorithm
 * 		is a generalization of the BFS algorithm. The regular BFS algorithm cannot solve the shortest path
 * 		problem as it cannot guarantee that the vertex at the front of the queue is the vertex closest to
 * 		source s.
 * 	Formulae :
 * 			if(d(u) + c(u,v) < d(v))
 * 				then d(v) = d(u) + c(u,v)
 * 	
 * 	Notes on Dijkstra’s Algorithm
 * 	-----------------------------
 * 	->	It uses greedy method: Always pick the next closest vertex to the source.
 * 	->	It uses priority queue to store unvisited vertices by distance from s.
 * 	->	It does not work with negative weights.
 * 
 * 	Difference between Unweighted Shortest Path and Dijkstra’s Algorithm
 * 	--------------------------------------------------------------------
 * 	1)	To represent weights in the adjacency list, each vertex contains the weights of the edges 
 * 		(in addition to their identifier).
 * 	2)	Instead of ordinary queue we use priority queue [distances are the priorities] and the vertex with 
 * 		the smallest distance is selected for processing.
 * 	3)	The distance to a vertex is calculated by the sum of the weights of the edges on the path from the 
 * 		source to that vertex.
 * 	4)	We update the distances in case the newly computed distance is smaller than the old distance which 
 * 		we have already computed.
 * 
 * 	->	In Dijkstra’s algorithm, the efficiency depends on the number of DeleteMins (V DeleteMins) and
 * 		updates for priority queues (E updates) that are used. If a standard binary heap is used then the
 * 		complexity is O(ElogV). The term ElogV comes from E updates (each update takes logV) for the
 * 		standard heap. If the set used is an array then the complexity is O(E + V2).
 * 
 * 	Disadvantages of Dijkstra’s Algorithm
 * 	-------------------------------------
 * 	->	As discussed above, the major disadvantage of the algorithm is that it does a blind search, 
 * 		thereby wasting time and necessary resources.
 * 	->	Another disadvantage is that it cannot handle negative edges. This leads to acyclic graphs 
 * 		and most often cannot obtain the right shortest path.
 */
public class T_009_ShortestPath_WeightedGraph {
	
	public static class Node implements Comparator<Node> {
		public int node;
		public int cost;
		
		public Node() {}
		
		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compare(Node o1, Node o2) {
			if(o1.cost < o2.cost)
				return -1;
			if(o1.cost > o2.cost)
				return 1;
			return 0;
		}
	}
	
	public static class Graph{
		private int noOfNodes;
		private PriorityQueue<Node> queue;
		private int[] distances;
		private Set<Integer> settled;
		List<List<Node>> adj;
		
		public Graph(int size) {
			this.noOfNodes = size;
			this.distances = new int[noOfNodes];
			this.settled = new HashSet<Integer>(); 
			this.queue = new PriorityQueue<Node>(noOfNodes, new Node());
		}
		
		public void dijkstra(List<List<Node>> adj, int src){
			this.adj = adj;
			for(int i=0; i<noOfNodes ; i++)
				distances[i] = Integer.MAX_VALUE;
			distances[src] = 0;
			queue.add(new Node(src, 0));
			while(settled.size() != noOfNodes){
				int u = queue.remove().node;
				settled.add(u);
				neighbours(u);
			}
		}
		
		public void neighbours(int u){
			int edgeDistance = -1;
			int newDistance = -1;
			for(int i=0; i<adj.get(u).size() ; i++){
				Node v = adj.get(u).get(i);
				if(!settled.contains(v.node)){
					edgeDistance = v.cost;
					newDistance = distances[u] + edgeDistance;
					if(newDistance < distances[v.node]){
						distances[v.node] = newDistance;
					}
					queue.add(new Node(v.node, distances[v.node]));
				}
			}
		}
	}
	
	public static void main(String arg[]) 
    { 
        int V = 5; 
        int source = 0; 
        List<List<Node> > adj = new ArrayList<List<Node>>(); 
        for (int i = 0; i < V; i++) { 
            List<Node> item = new ArrayList<Node>(); 
            adj.add(item); 
        } 
        adj.get(0).add(new Node(1, 9)); 
        adj.get(0).add(new Node(2, 6)); 
        adj.get(0).add(new Node(3, 5)); 
        adj.get(0).add(new Node(4, 3)); 
        adj.get(2).add(new Node(1, 2)); 
        adj.get(2).add(new Node(3, 4)); 
  
        Graph graph = new Graph(V); 
        graph.dijkstra(adj, source); 
        System.out.println("The shorted path from node :"); 
        for (int i = 0; i < graph.distances.length; i++) 
            System.out.println(source + " to " + i + " is " + graph.distances[i]); 
    } 
}
