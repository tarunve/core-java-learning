package narsimhak.practice12.string.algorithms;

/*
 * 	->	In this method we use the finite automata which is the concept of the Theory of Computation(ToC)
 * 	->	A finite automaton F is a 5-tuple (Q,q0,A,Σ,δ), where
 * 			• Q is a finite set of states
 * 			• q0 ∈ Q is the start state
 * 			• A ⊆ Q is a set of accepting states
 * 			• Σ is a finite input alphabet
 * 			• δ is the transition function that gives the next state for a given current state and input
 * 	->	How does Finite Automata Work?
 * 			• The finite automaton F begins in state q0
 * 			• Reads characters from Σ one at a time
 * 			• If F is in state q and reads input character a, F moves to state δ(q,a)
 * 			• At the end, if its state is in A, then we say, F accepted the input string read so far
 * 			• If the input string is not accepted it is called the rejected string
 * 
 * 	->	Given a text str[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char str[]) 
 * 		that prints all occurrences of pat[] in str[]. You may assume that n > m.
 * 	->	In FA based algorithm, we pre process the pattern and build a 2D array that represents a 
 * 		Finite Automata. Construction of the FA is the main tricky part of this algorithm. Once 
 * 		the FA is built, the searching is simple. In search, we simply need to start from the first 
 * 		state of the automata and the first character of the text. At every step, we consider next 
 * 		character of text, look for the next state in the built FA and move to a new state. If we 
 * 		reach the final state, then the pattern is found in the text. 
 * 	
 * 	The time complexity of the search process is O(n).
 */
public class T_003_StringMatching_FiniteAutomata {
	private static final int NUM_OF_CHARS = 256;
	
	public static void stringMatchFiniteAutomata(char[] str, char[] pat){
		int m = pat.length;
		int n = str.length;
		int[][] TF = new int[m+1][NUM_OF_CHARS];
		computeTFEfficient(pat, m, TF);
		
		int state = 0;
		for(int i=0; i<n; i++){
			state = TF[state][str[i]];
			if(state==m)
				System.out.println("Pattern found at index : " +(i-m+1));
		}
	}
	
	private static void computeTFEfficient(char[] pat, int m, int[][] TF) {
		int i, lps=0, x;
		for(x=0; x<NUM_OF_CHARS; x++)
			TF[0][x] = 0;
		TF[0][pat[0]] = 1;
		for(i=1; i<m; i++){
			for(x=0; x<NUM_OF_CHARS; x++)
				TF[i][x] = TF[lps][x];
			TF[i][pat[i]] = i+1;
			if(i<m)
				lps=TF[lps][pat[i]];
		}
	}

	public static void main(String[] args)  
    { 
        char[] str = "AABAACAADAABAAABAA".toCharArray(); 
        char[] pat = "ABA".toCharArray(); 
        stringMatchFiniteAutomata(str,pat); 
    } 
}
