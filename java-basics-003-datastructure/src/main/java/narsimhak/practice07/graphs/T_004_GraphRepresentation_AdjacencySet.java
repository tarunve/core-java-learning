package narsimhak.practice07.graphs;

/*
 * 	->	It is very much similar to adjacency list but instead of using Linked lists, Disjoint Sets 
 * 		[Union-Find] are used.
 * 	
 * 	Comparison of Graph Representations
 * 	-----------------------------------
 * 	->	Directed and undirected graphs are represented with the same structures. For directed graphs,
 *  	everything is the same, except that each edge is represented just once. An edge from x to y is
 *  	represented by a 1 value in Adj[x][y] in the adjacency matrix, or by adding y on x�s adjacency list.
 *  	For weighted graphs, everything is the same, except fill the adjacency matrix with weights instead
 *  	of boolean values.
 *  	
 *  	------------------------------------------------------------------------------------------------------
 *  	|	Representation	|	Space	|	Checking edge b/w v and w	|	iterate over edges incident to v? |
 *  	|-----------------------------------------------------------------------------------------------------
 *  	|	List of edges	|	E		|			E					|			E						  |
 *  	|-----------------------------------------------------------------------------------------------------
 *  	|	Adjacent matrix	|	V^2		|			1					|			V						  |
 *  	|-----------------------------------------------------------------------------------------------------
 *  	|	Adjacent List	|	E+V		|			Degree(v)			|			Degree(v)				  |
 *  	|-----------------------------------------------------------------------------------------------------
 *  	|	Adjacent Set	|	E+V		|			log(Degree(v))		|			Degree(v)				  |
 *  	------------------------------------------------------------------------------------------------------
 */
public class T_004_GraphRepresentation_AdjacencySet {
	
}
