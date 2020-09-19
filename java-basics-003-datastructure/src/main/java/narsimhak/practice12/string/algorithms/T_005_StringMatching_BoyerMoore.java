package practice12.string.algorithms;

/*
 * 	->	Boyer Moore algorithm also pre processes the pattern. Boyer Moore is a combination of following two approaches.
 * 		1) Bad Character Heuristic
 * 		2) Good Suffix Heuristic
 * 	->	Both of the above heuristics can also be used independently to search a pattern in a text. Let us first 
 * 		understand how two independent approaches work together in the Boyer Moore algorithm. If we take a look 
 * 		at the Naive algorithm, it slides the pattern over the text one by one. KMP algorithm does pre processing 
 * 		over the pattern so that the pattern can be shifted by more than one. The Boyer Moore algorithm does 
 * 		pre processing for the same reason. It processes the pattern and creates different arrays for both 
 * 		heuristics. At every step, it slides the pattern by the max of the slides suggested by the two heuristics. 
 * 		So it uses best of the two heuristics at every step.
 * 	->	Unlike the previous pattern searching algorithms, Boyer Moore algorithm starts matching from the last 
 * 		character of the pattern.
 * 
 * 	Bad Character Heuristic
 * 	-----------------------
 * 	->	The idea of bad character heuristic is simple. The character of the text which doesn’t match with the 
 * 		current character of the pattern is called the Bad Character. Upon mismatch, we shift the pattern until –
 * 		1) The mismatch becomes a match
 * 		2) Pattern P move past the mismatched character.
 * 
 * 	Case 1 – Mismatch become match
 * 	------------------------------
 * 	->	We will lookup the position of last occurrence of mismatching character in pattern and if mismatching 
 * 		character exist in pattern then we’ll shift the pattern such that it get aligned to the mismatching character 
 * 		in text T.
 * 	Case 2 – Pattern move past the mismatch character
 * 	-------------------------------------------------
 * 	->	We’ll lookup the position of last occurrence of mismatching character in pattern and if character does not 
 * 		exist we will shift pattern past the mismatching character.
 * 
 * 	The bad character heuristic takes O(n/m) time in the best case.
 */
public class T_005_StringMatching_BoyerMoore {
	
	public static final int NUM_CHARS=256;
	
	public static int max(int a, int b){
		return a>b ? a : b;
	}
	
	public static void stringMatchBoyerMooreBadChar(char[] txt, char[] pat){
		int m = pat.length;
		int n = txt.length;
		int[] badChar = new int[NUM_CHARS];
		badCharHeuristic(pat, m, badChar);
		
		int s=0;
		while(s <= (n-m)){
			int j=m-1;
			while(j>=0 && pat[j]==txt[s+j])
				j--;
			
			if(j<0){
				System.out.println("Pattern occur at shift : " + s);
				s += (s+m < n) ? m-badChar[txt[s+m]] : 1;
			}else {
				s += max(1, j-badChar[txt[s+j]]);
			}
		}
	}
	
	private static void badCharHeuristic(char[] pat, int m, int[] badChar) {
		for(int i=0; i<NUM_CHARS; i++)
			badChar[i] = -1;
		
		for(int i=0; i<m ; i++)
			badChar[(int)pat[i]] = i;
	}

	public static void main(String []args) { 
        
        char txt[] = "ABAAABCD".toCharArray(); 
        char pat[] = "ABC".toCharArray(); 
        stringMatchBoyerMooreBadChar(txt, pat); 
   } 
}
