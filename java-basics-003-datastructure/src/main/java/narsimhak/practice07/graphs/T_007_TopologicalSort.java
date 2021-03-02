package narsimhak.practice07.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/*
 * 	->	Topological sort is an ordering of vertices in a directed acyclic graph [DAG] in which each 
 * 		node comes before all nodes to which it has outgoing edges. As an example, consider the course
 * 		prerequisite structure at universities. A directed edge (v,w) indicates that course v must be
 * 		completed before course w. Topological ordering for this example is the sequence which does not
 * 		violate the prerequisite requirement. Every DAG may have one or more topological orderings.
 * 	->	Topological sort is not possible if the graph has a cycle, since for two vertices v and w on the
 * 		cycle, v precedes w and w precedes v.
 * 	->	Topological sort has an interesting property. All pairs of consecutive vertices in the sorted 
 * 		order are connected by edges; then these edges form a directed Hamiltonian path in the DAG. 
 * 		If a Hamiltonian path exists, the topological sort order is unique. If a topological sort does 
 * 		not form a Hamiltonian path, DAG can have two or more topological orderings.
 * 	->	Initially, indegree is computed for all vertices, starting with the vertices which are having 
 * 		indegree 0. That means consider the vertices which do not have any prerequisite. To keep track of
 * 		vertices with indegree zero we can use a queue.
 * 	->	All vertices of indegree 0 are placed on queue. While the queue is not empty, a vertex v is
 * 		removed, and all edges adjacent to v have their indegrees decremented. A vertex is put on the
 * 		queue as soon as its indegree falls to 0. The topological ordering is the order in which the	
 * 		vertices DeQueue.
 * The time complexity of this algorithm is O(|E| + |V|) if adjacency lists are used.
 * 
 * 	Applications of Topological Sorting
 * 	-----------------------------------
 * 	1.	Representing course prerequisites
 * 	2.	Detecting deadlocks
 * 	3.	Pipeline of computing jobs
 * 	4.	Checking for symbolic link loop
 * 	5.	Evaluating formulae in spreadsheet
 */
public class T_007_TopologicalSort {
	
	public static class Graph{
		private int n;
		private LinkedList<Integer> adj[];
		
		@SuppressWarnings("unchecked")
		public Graph(int n) {
			this.n = n;
			adj = new LinkedList[n];
			for(int i=0; i<n ;i++)
				adj[i] = new LinkedList<Integer>();
		}
		
		public void addEdge(int v, int w){
			adj[v].add(w);
		}
		
		public void topologicalSort(){
			Stack<Integer> stack = new Stack<>();
			boolean visited[] = new boolean[n];
			for(int i=0; i<n; i++)
				visited[i] = false;
			for(int i=0; i<n; i++){
				if(visited[i] == false){
					topologicalSortUtil(i, visited, stack);
				}
			}
			while(!stack.isEmpty())
				System.out.print(stack.pop() + " ");
		}

		public void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
			visited[v] = true;
			Integer i;
			Iterator<Integer> iterator = adj[v].iterator();
			while(iterator.hasNext()){
				i = iterator.next();
				if(!visited[i])
					topologicalSortUtil(i, visited, stack);
			}
			stack.push(new Integer(v));
		}
		
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
  
        System.out.println("Following is a Topological " + 
                           "sort of the given graph"); 
        g.topologicalSort(); 
	}
}
