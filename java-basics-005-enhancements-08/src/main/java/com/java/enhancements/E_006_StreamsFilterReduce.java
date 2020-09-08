package com.java.enhancements;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class E_006_StreamsFilterReduce {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(12, 20, 35, 76, 39, 75);
		int result = 0;
		for (int i : values) {
			if (i % 5 == 0)
				result += i;
		}
		System.out.println(result);

		//strem api with filter method
		System.out.println(values.stream().filter(i -> i % 5 == 0).reduce(0, (c, e) -> c + e));

		//Stream api with filter impl
		Predicate<Integer> p = new Predicate<Integer>() {
			@Override
			public boolean test(Integer i) {
				return i % 5 == 0;
			}
		};
		System.out.println(values.stream().filter(p).reduce(0, (c, e) -> c + e));

		//Stream api examples
		System.out.println(values.stream().filter(i -> i % 5 == 0).map(i -> i * 2).findFirst().orElse(0));

	}
}
