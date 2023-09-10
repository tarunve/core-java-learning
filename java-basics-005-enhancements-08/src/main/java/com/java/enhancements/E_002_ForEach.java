package com.java.enhancements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 *	->	The Java forEach is a utility method to iterate over a collection such as (list, set or map) and stream 
 *		and perform a certain action on each element of it.
 *	
 *	Java 8 forEach method
 *	=====================
 *	1.	Iterable.forEach() :
 *		->	Below code snippet shows the default implementation of forEach in Iterable interface. It makes 
 *			Iterable.forEach() method available to all collection classes except Map.forEach().
 *	2.	Map.forEach()
 *		->	This method performs the given BiConsumer action for each entry in this map until all entries have been 	
 *			processed or the action throws an exception.
 *				
 */
public class E_002_ForEach {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

		//external for loop 
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		//enhanced for loop
		for (int i : list) {
			System.out.println(i);
		}

		//internal loop in Java 8 
		// -> lambda expression  , consumer interface
		list.forEach(System.out::println);

		/*Consumer<Integer> c = new Consumer<Integer>() {
			public void accept(Integer i) {
				System.out.println(i);
			}
		};*/

		Consumer<Integer> c = System.out::println;
		list.forEach(c);
		
		
		/*
		 * List forEach() :: Lambda expression as Method Reference.
		 */
		List<Integer> numberList = Arrays.asList(1,2,3,4,5);
		Consumer<Integer> action = System.out::println;
		numberList.stream().filter(n -> n%2  == 0).forEach( action );
		
		/*
		 * Map forEach()
		 */
		HashMap<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		Consumer<Map.Entry<String, Integer>> action1 = System.out::println;
		map.entrySet().forEach(action1);
		Consumer<String> actionOnKeys = System.out::println;
		map.keySet().forEach(actionOnKeys);
		Consumer<Integer> actionOnValues = System.out::println;
		map.values().forEach(actionOnValues);
		
	}
}
