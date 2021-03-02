package narsimhak.practice11.hashing;


public class Problems_2 {
	/*
	 * Given an array of characters, give an algorithm for removing the duplicates.
	 */
	//Time Complexity: O(n2). Space Complexity: O(1).
	public void removeDuplicatesBruteForce(char[] s, int n){
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n;){
				if(s[i] == s[j])
					s[j] = s[--n];
				else
					j++;
			}
			s[i] ='\0';
		}
	}
	
	//With String as input
	public static String removeDeplicatesStringBuilder(String s){
		StringBuilder noDup = new StringBuilder();
		for(int i=0; i<s.length(); i++){
			String si = s.substring(i, i+1);
			if(noDup.indexOf(si) == -1)
				noDup.append(si);
		}
		return noDup.toString();
	}
	
	/*
	 * Give an algorithm to remove the specified characters from a given string which are given in another string?
	 */
	public static void removeCharsFromArray(char[] str, char[] charsToRemove){
		int srcIndex, destIndex;
		int aux[] = new int[256];
		for(srcIndex=0; srcIndex<256;srcIndex++){
			aux[srcIndex] = 0;
		}
		srcIndex=0;
		while(charsToRemove[srcIndex] != ' '){
			aux[charsToRemove[srcIndex]]=1;
			srcIndex++;
		}
		srcIndex = destIndex = 0;
		while(str[srcIndex++] != ' '){
			if(aux[str[srcIndex]] != 1){
				str[destIndex++] = str[srcIndex];
			}
		}
	}
	
	/*
	 * Give an algorithm for finding the first non-repeated character in a string. For
	 * example, the first non-repeated character in the string �abzddab� is �z�.
	 */
	public static char firstNonRepeatedChar(char[] str, int len){
		int i,j;
		for(i=0; i<len; i++){
			for(j=0; j<len; j++){
				if(i!=j && str[i]==str[j]){
					return str[i];
				}
			}
		}
		return ' ';
	}
	
	
	public static void main(String[] args) {
		System.out.println(removeDeplicatesStringBuilder("Taruna"));
		System.out.println(firstNonRepeatedChar("Taruna".toCharArray(), 6));
		/*char[] srcArr = "Tarun".toCharArray();
		char[] remArr = "a".toCharArray();
		removeCharsFromArray(srcArr, remArr);*/
	}
}
