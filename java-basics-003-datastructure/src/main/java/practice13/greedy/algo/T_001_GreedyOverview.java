package practice13.greedy.algo;

/*
 * 	->	Greedy algorithms work in stages. In each stage, a decision is made that is good at that point,
 * 		without bothering about the future. This means that some local best is chosen. It assumes that a
 * 		local good selection makes for a global optimal solution.
 * 	->	The two basic properties of optimal Greedy algorithms are:
 * 		1)	Greedy choice property	:	This property says that the globally optimal solution can be obtained 
 * 										by making a locally optimal solution (Greedy). The choice made by a 
 * 			Greedy algorithm may depend on earlier choices but not on the future. It iteratively makes one 
 * 			Greedy choice after another and reduces the given problem to a smaller one.
 * 		2)	Optimal substructure	:	A problem exhibits optimal substructure if an optimal solution to 
 * 										the problem contains optimal solutions to the subproblems. That 
 * 			means we can solve subproblems and build up the solutions to solve larger problems.
 * 
 * 	->	The main advantage of the Greedy method is that it is straightforward, easy to understand and easy 
 * 		to code. In Greedy algorithms, once we make a decision, we do not have to spend time reexamining the 
 * 		already computed values. Its main disadvantage is that for many problems there is no greedy algorithm. 
 * 		That means, in many cases there is no guarantee that making locally optimal improvements in a locally 
 * 		optimal solution gives the optimal global solution.
 * 	
 * 	Greedy Applications
 * 	-------------------
 * 	• Sorting: Selection sort, Topological sort
 * 	• Priority Queues: Heap sort
 * 	• Huffman coding compression algorithm
 * 	• Prim’s and Kruskal’s algorithms
 * 	• Shortest path in Weighted Graph [Dijkstra’s]
 * 	• Coin change problem
 * 	• Fractional Knapsack problem
 * 	• Disjoint sets-UNION by size and UNION by height (or rank)
 * 	• Job scheduling algorithm
 * 	• Greedy techniques can be used as an approximation algorithm for complex problems
 */
public class T_001_GreedyOverview {
	
}
