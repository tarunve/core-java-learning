package narsimhak.practice07.graphs;

/*
 * 	Graph:
 * 	=====
 *  ->	A graph is a pair (V, E), where V is a set of nodes, called vertices, and E is a collection of 
 *  	pairs of vertices, called edges.
 *  	->	Vertices and edges are positions and store elements.
 *  	->	Definitions that we use:
 *  		->	Directed edge:	
 *  			->	ordered pair of vertices (u, v)
 *  			->	first vertex u is the origin
 *  			->	second vertex v is the destination
 *  			Example: one-way road traffic
 *  		->	Undirected edge:
 *  			->	unordered pair of vertices (u, v)
 *  			Example: railway lines
 *  		->	Directed graph:
 *  			->	all the edges are directed
 *  			Example: route network
 *  		->	Undirected graph:
 *  			->	 all
 *  	->	When an edge connects two vertices, the vertices are said to be adjacent to each other and 
 *  		the edge is incident on both vertices.
 *  	->	A graph with no cycles is called a tree. A tree is an acyclic connected graph.
 *  	->	A self loop is an edge that connects a vertex to itself.
 *  	->	Two edges are parallel if they connect the same pair of vertices.
 *  	->	The Degree of a vertex is the number of edges incident on it.
 *  	->	A subgraph is a subset of a graph�s edges (with associated vertices) that form a graph.
 *  	->	A path in a graph is a sequence of adjacent vertices. Simple path is a path with no repeated vertices.
 *  	->	A cycle is a path where the first and last vertices are the same. A simple cycle is a cycle with 
 *  		no repeated vertices or edges (except the first and last vertices).
 *  	->	We say that one vertex is connected to another if there is a path that contains both of them.
 *  	->	A graph is connected if there is a path from every vertex to every other vertex.
 *  	->	If a graph is not connected then it consists of a set of connected components.
 *  	->	A directed acyclic graph [DAG] is a directed graph with no cycles.
 *  	->	A forest is a disjoint set of trees.
 *  	->	A spanning tree of a connected graph is a subgraph that contains all of that graph�s vertices and 
 *  		is a single tree. A spanning forest of a graph is the union of spanning trees of its connected 
 *  		components.
 *  	->	A bipartite graph is a graph whose vertices can be divided into two sets such that all edges 
 *  		connect a vertex in one set with a vertex in the other set.
 *  	->	In weighted graphs integers (weights) are assigned to each edge to represent (distances or costs).
 *  	->	Graphs with all edges present are called complete graphs.
 *  	->	Graphs with relatively few edges (generally if its edges < |V| log |V|) are called sparse graphs.
 *  	->	Graphs with relatively few of the possible edges missing are called dense.
 *  	->	Directed weighted graphs are sometimes called network.
 *  	->	We will denote the number of vertices in a given graph by |V|, and the number of edges by |E|. 
 *  		Note that E can range anywhere from 0 to |V|(|V| � l)/2 (in undirected graph). This is because 
 *  		each node can connect to every other node.
 *  
 *  	Applications of Graphs
 *  	----------------------
 *  	1.	Representing relationships between components in electronic circuits.
 *  	2.	Transportation networks: Highway network, Flight network
 *  	3.	Computer networks: Local area network, Internet, Web
 *  	4.	Databases: For representing ER (Entity Relationship) diagrams in databases, for representing 
 *  		dependency of tables in databases.
 */
public class T_001_GraphOverview {
	
}
