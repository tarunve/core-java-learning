package practice12.string.algorithms;


public class Problems_1 {
	
	/*
	 * 	If the string is editable, how do we create a string that is the reverse of given string?
	 * 	Time Complexity: O(n), where n is the length of the given string. Space Complexity: O(n).
	 */
	public static String reverseStringEditable(String str){
		int end = str.length()-1;
		char[] arr= str.toCharArray();
		char temp;
		if(str == null || end ==0)
			return "";
		for(int start=0; start<end; start++, end--){
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
		}
		return String.valueOf(arr);
	}
	
	/*
	 * 	If the string is not editable, how do we create a string that is the reverse of given string?
	 * 	Time Complexity: O(n), where n is the length of the given string. Space Complexity: O(n).
	 */
	public static String reverseStringNonEditable(String str){
		int length = str.length();
		StringBuffer strBuff = new StringBuffer(length);
		for(int i=length-1; i>=0; i--){
			strBuff.append(str.charAt(i));
		}
		return strBuff.toString();
	}
	
	/*
	 * 	Can we reverse the string without using any temporary variable?
	 * 	->	Yes, we can use XOR logic for swapping the variables
	 * Time Complexity: O(n/2) = O(n) , where n is the length of the given string.
	 * Space Complexity: O(n).
	 */
	public static String reverseStringXORWithoutTempVar(String str){
		char[] strArr = str.toCharArray();
		int end = str.length()-1, start=0;
		while(start<end){
			strArr[start] ^= strArr[end];
			strArr[end] ^= strArr[start];
			strArr[start] ^=strArr[end];
			start++;
			end--;
		}
		return String.valueOf(strArr);
	}
	
	/*
	 * 	Give an algorithm for reversing words in a sentence.
	 * 	Example: Input: “This is a Career Monk String”, Output: “String Monk Career a is This”
	 * Time Complexity: O(2n) ≈ O(n), where n is the length of the string. Space Complexity: O(1).
	 */
	public static String reverseWordsInString(String str){
		if(str == null || str.length() == 0)
			return "";
		str = reverseStringEditable(str);
		int curr=0, start=0;
		StringBuilder sb = new StringBuilder();
		while(curr<str.length()){
			if(str.charAt(curr) != ' ')
				curr++;
			else{
				if(start != curr){
					sb.append(reverseStringEditable(str.substring(start, curr))+" ");
					start=curr;
				} else {
					start++;
					curr++;
				}
			}
		}
		if(start != curr)
			sb.append(reverseStringEditable(str.substring(start, curr) + " "));
		
		return sb.length() != 0 ? sb.toString().substring(0, sb.length()) : " ";
	}
	
	/*
	 * 	Permutations of a string [anagrams]: Give an algorithm for printing all possible permutations 
	 * 	of the characters in a string. Unlike combinations, two permutations are considered distinct 
	 * 	if they contain the same characters but in a different order. For simplicity assume that each 
	 * 	occurrence of a repeated character is a distinct character. That is, if the input is “aaa”, the 
	 * 	output should be six repetitions of “aaa”. The permutations may be output in any order.
	 * 
	 * 	The solution is reached by generating n! strings, each of length n, where n is the length of 
	 * 	the input string.
	 */
	public static class Permutations{
		private static void permute(String str, int l, int r){ 
	        if (l == r) 
	            System.out.println(str); 
	        else { 
	            for (int i = l; i <= r; i++) { 
	                str = swap(str, l, i); 
	                permute(str, l + 1, r); 
	                str = swap(str, l, i); 
	            } 
	        } 
	    } 
		
		public static String swap(String a, int i, int j){ 
	        char temp; 
	        char[] charArray = a.toCharArray(); 
	        temp = charArray[i]; 
	        charArray[i] = charArray[j]; 
	        charArray[j] = temp; 
	        return String.valueOf(charArray); 
	    } 
	}
	
	/*
	 * 	Combinations Combinations of a String: Unlike permutations, two combinations are considered to be 
	 * 	the same if they contain the same characters, but may be in a different order. Give an algorithm 
	 * 	that prints all possible combinations of the characters in a string. For example, “ac” and “ab” are 
	 * 	different combinations from the	input string “abc”, but “ab” is the same as “ba”.
	 * 
	 * 	The solution is achieved by generating n!/r! (n – r)! strings, each of length between 1 and n 
	 * 	where n is the length of the given input string.
	 */
	public static class Combinations{
		
		public static void combine(String str, int start, int end, StringBuilder output){
			for(int i=start; i<=end; ++i){
				output.append(str.charAt(i));
				System.out.println(output);
				if(i<str.length())
					combine(str, i+1, end, output);
				output.setLength(output.length()-1);
			}
	    } 
	}
	
	/*
	 * Given a string “ABCCBCBA”, give an algorithm for recursively removing the adjacent characters if 
	 * they are the same. For example, ABCCBCBA --> ABBCBA- >ACBA.
	 */
	public static String removeAdjacentpairsRecursively(String str){
		char[] stack = new char[str.length()];
		int i=0;
		for(int j=0; j<str.length(); j++){
			char curr_char = str.charAt(j);
			if(i>0 && stack[i-1] ==  curr_char){
				i--;
			} else {
				stack[i++] = curr_char;
			}
		}
		return new String(stack, 0, i);
	}
	
	// Function to remove adjacent duplicates characters from a string
	public static String removeDuplicates(char[] chars){
		char prev = '\0';
		int k = 0;
		for (int i = 0; i < chars.length; i++){
			if (prev != chars[i]) {
				chars[k++] = chars[i];
				prev = chars[i];
			}
		}
		return String.valueOf(chars);
	}

	
	public static void main(String[] args) {
		System.out.println(reverseStringNonEditable("Tarun"));
		System.out.println(reverseStringXORWithoutTempVar("Tarun"));
		System.out.println(reverseWordsInString("My Name is Tarun"));
		String str = "ABC";
		Permutations.permute(str, 0, str.length()-1);
		Combinations.combine(str, 0, str.length()-1, new StringBuilder());
		System.out.println(removeDuplicates("AABNCVDBKS".toCharArray()));
		System.out.println(removeAdjacentpairsRecursively("ABCCBCBA"));
	}
}
