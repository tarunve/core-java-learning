package narsimhak.practice12.string.algorithms;

/*
 * 	->	In this method, we will use the hashing technique and instead of checking for each possible
 * 		position in T, we check only if the hashing of P and the hashing of m characters of T give 
 * 		the same result.
 * 	->	Initially, apply the hash function to the first m characters of T and check whether this result 
 * 		and P’s hashing result is the same or not. If they are not the same, then go to the next character 
 * 		of T and again apply the hash function to m characters (by starting at the second character). If 
 * 		they are the same then we compare those m characters of T with P.
 * 	
 * 	Selecting Hash Function
 * 	-----------------------
 * 	->	At each step, since we are finding the hash of m characters of T, we need an efficient hash
 * 		function. If the hash function takes O(m) complexity in every step, then the total complexity is 
 * 		O(n × m). This is worse than the brute force method because first we are applying the hash 
 * 		function and also comparing.
 * 	->	Our objective is to select a hash function which takes O(1) complexity for finding the hash of 
 * 		m characters of T every time. Only then can we reduce the total complexity of the algorithm. If 
 * 		the hash function is not good (worst case), the complexity of the Rabin-Karp algorithm is 
 * 		O(n – m + 1) × m) ≈ O(n × m). If we select a good hash function, the complexity of the Rabin-Karp
 * 		algorithm complexity is O(m + n). Now let us see how to select a hash function which can compute 
 * 		the hash of m characters of T at each step in O(1).
 * 	->	For simplicity, let’s assume that the characters used in string T are only integers. That means, 
 * 		all characters in T ∈ {0,1,2,...,9 }. Since all of them are integers, we can view a string of m
 * 		consecutive characters as decimal numbers. For example, string ′61815′ corresponds to the number 
 * 		61815. With the above assumption, the pattern P is also a decimal value, and let us assume that 
 * 		the decimal value of P is p. For the given text T[0..n – 1], let t(i) denote the decimal value 
 * 		of length–m substring T[i.. i + m – 1] for i = 0,1, ...,n – m– 1. So, t(i) == p if and only if 
 * 		T[i..i + m – 1] == P[0..m – 1].
 * 	->	We can compute p in O(m) time using Horner’s Rule as:
 * 			P = P[m-1] + 10(P[m-2] + 10(P[m-3] + 10(P[m-4] + .... + 10(P[1] + 10(P[0]))))))
 * 	->	We can compute all t(i), for i = 0,1,..., n – m – 1 values in a total of O(n) time. The value of 
 * 		t(0) can be similarly computed from T[0.. m – 1] in O(m) time. To compute the remaining values t(0),
 * 		t(1),..., t(n – m – 1), understand that t(i + 1) can be computed from t(i) in constant time.
 * 			T(m+1) = 10*(T[i]-10^(m-1)*T[i]) + T[i+m-1]
 * 	->	Rehashing : 
 * 			hash(str[s+1.....s+m])  = d*(hash(str[s....s+m-1]) - str[s]*h) mod q
 * 				where 
 * 						hash(str[s....s+m-1])  = hash value at shift s.
 * 						hash(str[s+1.....s+m]) = hash value at next shift( or shift s+1)
 * 						d = number of characters in the alphabet
 * 						q = a prime number
 * 						h = d^m-1
 * 					
 */
public class T_002_StringMatching_RabinKarp {
	public final static int d = 256; 
	
	private static void stringMatchRabinKarp(String str, String pat, int q) {
		int m = pat.length();
		int n = str.length();
		int i, j;
		int patHash=0, strHash=0, hash=1;
		for(i=0; i<m-1; i++)
			hash = (hash*d)%q;
		
		for(i=0; i<m; i++){
			patHash = (d*patHash + pat.charAt(i))%q;
			strHash = (d*strHash + str.charAt(i))%q;
		}
		
		for(i=0; i<n-m; i++){
			if(patHash == strHash){
				for(j=0; j<m; j++){
					if(str.charAt(i+j) != pat.charAt(j))
						break;
				}
				if(j==m)
					System.out.println("Pattern found at index : " + i);
			}
			if(i<n-m){
				strHash = (d*(strHash - str.charAt(i)*hash) + str.charAt(i+m))%q;
				if(strHash < 0)
					strHash = strHash + q;
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "GEEKS FOR GEEKS";
		String pat = "GEEK";
		int q = 101;
		stringMatchRabinKarp(str, pat, q);
	}
}
