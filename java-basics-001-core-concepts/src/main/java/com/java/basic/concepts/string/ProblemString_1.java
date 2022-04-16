package com.java.basic.concepts.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class ProblemString_1 {
	/*
	 * How will you find frequency in collection of words.
	 */
	private static void findFrequency(List<String> wordList) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : wordList) {
			map.merge(word, 1, Integer::sum);
		}
		System.out.println(map);
	}
	
	public static void main(String[] args) {
		List<String> wordList = Arrays.asList("Ananas", "Mango", "Cherry", "Apple", "Ananas", "Banana", "Mango", "Cherry", "Apple", "Ananas", "Banana", "Mango", "Cherry");
		findFrequency(wordList);
		System.out.println("=========================");
		//java8
		ConcurrentMap<String, Integer> map = wordList.stream().collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer::sum));
		System.out.println(map);
	}
	
}
