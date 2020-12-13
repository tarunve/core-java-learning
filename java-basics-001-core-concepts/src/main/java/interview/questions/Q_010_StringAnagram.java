package interview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q_010_StringAnagram {

	public static class AnagramExample1 {
		public static void main(String[] args) {
			String s1 = "abc";
			String s2 = "bca";
			boolean checkAnagram = isAnagram(s1, s2);
			if (checkAnagram)
				System.out.println("Both Strings are Anagrams");
			else
				System.out.println("Both Strings are not Anagrams");
		}

		private static boolean isAnagram(String s1, String s2) {
			char[] c1 = s1.toCharArray();
			char[] c2 = s2.toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			if (Arrays.toString(c1).equals(Arrays.toString(c2)))
				return true;
			return false;
		}
	}
	
	/*
	 * Put all anagrams in a single bucket
	 */
	public static class AnagramExample2 {
		public static void main(String[] args) {
			Map<String, List<String>> result = new HashMap<String, List<String>>();
			String[] words = { "cta", "omt", "act", "dad", "tac", "dda", "add", "tom" };
			for (String word : words) {
				char[] c = word.toCharArray();
				Arrays.sort(c);
				String key = String.valueOf(c);
				if (!result.containsKey(key)) {
					result.put(key, new ArrayList<String>());
				}
				result.get(key).add(word);
			}
			System.out.println("Anagram Map :: " + result);
		}
	}
	
}
