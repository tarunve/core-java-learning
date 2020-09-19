package practice12.string.algorithms;

import java.util.HashMap;
import java.util.Map;

public class Problems_2 {
	/*
	 * Given a set of characters CHARS and a input string INPUT, find the minimum window in str which 
	 * will contain all the characters in CHARS in complexity O(n). For example, INPUT = ABBACBAA and 
	 * CHARS = AAB has the minimum window BAA.
	 */
	public static String minimumWindowString(String inputString, String pattern){
		Map<Character, Integer> map = new HashMap<>();
		for(char temp : inputString.toCharArray())
			map.put(temp, 0);
		for(char temp : pattern.toCharArray()){
			if(map.containsKey(temp))
				map.put(temp, map.get(temp) + 1);
			else
				return "";
		}
		
		int start =0 ,end = 0, minLength = Integer.MAX_VALUE, minStart=0 , numberOfTargets= pattern.length();
		while(end < inputString.length()){
			char current = inputString.charAt(end);
			if(map.get(current) > 0){
				numberOfTargets--;
			}
			map.put(current, map.get(current)-1);
			while(numberOfTargets == 0){
				if(minLength > end-start+1){
					minLength = end-start+1;
					minStart = start;
				}
				char head = inputString.charAt(start);
				if(map.get(head) >= 0)
					numberOfTargets++;
				map.put(head, map.get(head)+1);
				start++;
			}
			end++;
		}
		return minLength == Integer.MAX_VALUE ? "" : inputString.substring(minStart, minStart+minLength);
	}
	
	public static void main(String[] args) {
		System.out.println(minimumWindowString("ADOBECODEBANC", "ABC"));
	}
}
