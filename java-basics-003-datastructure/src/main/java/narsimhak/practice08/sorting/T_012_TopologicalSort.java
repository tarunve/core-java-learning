package practice08.sorting;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
/*
 * 	->	Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that 
 * 		for every directed edge uv, vertex u comes before v in the ordering. 
 * 	->	Topological Sorting for a graph is not possible if the graph is not a DAG.
 */
public class T_012_TopologicalSort {
	
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
