package narsimhak.practice12.string.algorithms;

/*
 * 	KMP (Knuth, Morris and Pratt)
 * 	----------------------------- 
 * 	->	Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that 
 * 		prints all occurrences of pat[] in txt[]. You may assume that n > m.
 * 	->	The KMP matching algorithm uses degenerating property (pattern having same sub-patterns appearing more 
 * 		than once in the pattern) of the pattern and improves the worst case complexity to O(n).
 * 	->	The basic idea behind KMP�s algorithm is: whenever we detect a mismatch (after some matches), we already 
 * 		know some of the characters in the text of the next window. We take advantage of this information to avoid 
 * 		matching the characters that we know will anyway match.
 * 	
 * 	Pre processing Overview:
 * 	-----------------------
 * 	->	KMP algorithm pre processes pat[] and constructs an auxiliary lps[] of size m (same as size of pattern) 
 * 		which is used to skip characters while matching. 
 * 	->	name lps indicates longest proper prefix which is also suffix..	A proper prefix is prefix with whole 
 * 		string not allowed. For example, prefixes of �ABC� are ��, �A�, �AB� and �ABC�. Proper prefixes are 
 * 		��, �A� and �AB�. Suffixes of the string are ��, �C�, �BC� and �ABC�.
 * 	->	We search for lps in sub-patterns. More clearly we focus on sub-strings of patterns that are either 
 * 		prefix and suffix. For each sub-pattern pat[0..i] where i = 0 to m-1, lps[i] stores length of the maximum 
 * 		matching proper prefix which is also a suffix of the sub-pattern pat[0..i].
 * 			 lps[i] = the longest proper prefix of pat[0..i] which is also a suffix of pat[0..i].
 * 
 *  Searching Algorithm:
 *  -------------------
 *  ->	How to use lps[] to decide next positions (or to know a number of characters to be skipped)?
 *  	->	We start comparison of pat[j] with j = 0 with characters of current window of text.
 *  	->	We keep matching characters txt[i] and pat[j] and keep incrementing i and j while pat[j] and txt[i] 
 *  		keep matching. When we see a mismatch 
 *  		->	We know that characters pat[0..j-1] match with txt[i-j�i-1] (Note that j starts with 0 and 
 *  			increment it only when there is a match).
 *  		->	We also know (from above definition) that lps[j-1] is count of characters of pat[0�j-1] that 
 *  			are both proper prefix and suffix.
 *  		->	From above two points, we can conclude that we do not need to match these lps[j-1] characters 
 *  			with txt[i-j�i-1] because we know that these characters will anyway match.
 */
public class T_004_StringMatching_KMP {
	
	private static void stringMatchingKMP(String pat, String txt) {
		int m = pat.length();
		int n = txt.length();
		int[] lps = new int[m];
		computeLPSArray(pat, m , lps);
		int i=0;
		int j =0;
		while(i<n){
			if(pat.charAt(j) == txt.charAt(i)){
				i++;
				j++;
			}
			if(j==m){
				System.out.println("Pattern found at index : " + (i-j));
				j = lps[j-1];
			} else if(i<n && pat.charAt(j) != txt.charAt(i)){
				if(j != 0){
					j = lps[j-1];
				} else{
					i++;
				}
			}
		}
	}
	
	private static void computeLPSArray(String pat, int m, int[] lps) {
		int i=1, len=0;
		lps[0]=0;
		while(i<m){
			if(pat.charAt(i) == pat.charAt(len)){
				len++;
				lps[i] = len;
				i++;
			} else{
				if(len != 0)
					len = lps[len-1];
				else{
					lps[i] = len;
					i++;
				}
					
			}
		}
	}

	public static void main(String[] args) {
		String txt = "ABABDABACDABABCABAB"; 
        String pat = "ABABCABAB"; 
        stringMatchingKMP(pat, txt);
	}

	
}
