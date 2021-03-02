package narsimhak.practice07.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 	->	The algorithm starts with V different trees (V is the vertices in the graph). While constructing the
 * 		minimum spanning tree, every time Kruskal�s algorithm selects an edge that has minimum weight and then 
 * 		adds that edge if it doesn�t create a cycle. So, initially, there are | V | single-node trees in the 
 * 		forest. Adding an edge merges two trees into one. When the algorithm is completed, there will be only 
 * 		one tree, and that is the minimum spanning tree.
 * 	->	There are two ways of implementing Kruskal�s algorithm:
 * 		->	By using Disjoint Sets: Using UNION and FIND operations	
 * 		->	By using Priority Queues: Maintains weights in priority queue
 * 	->	The appropriate data structure is the UNION/FIND algorithm [for implementing forests]. Two vertices 
 * 		belong to the same set if and only if they are connected in the current spanning forest. Each vertex 
 * 		is initially in its own set. If u and v are in the same set, the edge is rejected because it forms a 
 * 		cycle. Otherwise, the edge is accepted, and a UNION is performed on the two sets containing u and v.
 * 	->	The worst-case running time of this algorithm is O(ElogE), which is dominated by the heap operations. 
 * 		That means, since we are constructing the heap with E edges, we need 0(ElogE) time to do that.
 */
public class T_012_MinSpanningTree_KruskalAlgo {
	
	static class Edge
	{
		int src, dest, weight;

		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "(" + src + ", " + dest + ", " + weight + ")";
		}
	}
	
	static class DisjointSet
	{
		Map<Integer, Integer> parent = new HashMap<>();

		public void makeSet(int N) {
			for (int i = 0; i < N; i++)
				parent.put(i, i);
		}

		private int find(int k)	{
			if (parent.get(k) == k)
				return k;
			return find(parent.get(k));
		}

		private void union(int a, int b){
			int x = find(a);
			int y = find(b);
			parent.put(x, y);
		}

		public static List<Edge> KruskalAlgo(List<Edge> edges, int N){
			List<Edge> mst = new ArrayList<>();
			DisjointSet ds = new DisjointSet();
			ds.makeSet(N);

			int index = 0;
			while (mst.size() != N - 1)	{
				Edge next_edge = edges.get(index++);
				int x = ds.find(next_edge.src);
				int y = ds.find(next_edge.dest);
				if (x != y)	{
					mst.add(next_edge);
					ds.union(x, y);
				}
			}
			return mst;
		}

		public static void main(String[] args)
		{
			List<Edge> edges = Arrays.asList(
								new Edge(0, 1, 7), new Edge(1, 2, 8),
								new Edge(0, 3, 5), new Edge(1, 3, 9),
								new Edge(1, 4, 7), new Edge(2, 4, 5),
								new Edge(3, 4, 15), new Edge(3, 5, 6),
								new Edge(4, 5, 8), new Edge(4, 6, 9),
								new Edge(5, 6, 11)
							);
			Collections.sort(edges, (a, b) -> a.weight - b.weight);
			final int N = 7;
			List<Edge> e = KruskalAlgo(edges, N);

			for (Edge edge: e) {
				System.out.println(edge);
			}
		}
	}

}
