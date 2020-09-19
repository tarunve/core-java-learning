package practice12.string.algorithms;

/*
 * 	->	In this method, for each possible position in the text T we check whether the pattern P 
 * 		matches or not. Since the length of T is n, we have n – m + 1 possible choices for comparisons. 
 * 		This is because we do not need to check the last m – 1 locations of T as the pattern length 
 * 		is m. The following algorithm searches for the first occurrence of a pattern string P in a 
 * 		text string T.
 * 	->	Time Complexity: O((n – m + 1) × m) ≈O(n × m).
 * 		Space Complexity: O(1).
 */
public class T_001_StringMatching_BruteForce {
	
	public static void stringMatchBruteForce(int[] str,int n, int[] pattern, int m){
		for(int i=0; i<=n-m; i++){
			int j=0;
			while(j<m && pattern[j] == str[i+j])
				j++;
			if(j==m)
				System.out.println("Pattern found at index : " + i);
		}
	}
	
	
	public static void main(String[] args) {
		int[] str = {2,3,4,2,2,34,5,66,9,2,23,4,2,2,3,4,2,11,5343,5334,33,45,5,3};
		int[] pattern = {2,3,4,2};
		stringMatchBruteForce(str, str.length, pattern, pattern.length);
	}
}
