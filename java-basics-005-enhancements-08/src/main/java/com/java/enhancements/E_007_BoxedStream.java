package com.java.enhancements;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 *	->	In Java 8, if you want to convert stream of objects to collection, then you can use one of the static 
 *		methods in the Collectors class.
 */
public class E_007_BoxedStream {

	public static void main(String[] args) {
		/*
		 * IntStream
		 */
		List<Integer> ints = IntStream.of(1, 2, 3, 4, 5).boxed().collect(Collectors.toList());
		System.out.println(ints);
		Optional<Integer> max = IntStream.of(1, 2, 3, 4, 5).boxed().max(Integer::compareTo);
		max.ifPresent(System.out::println);

		/*
		 * LongStream
		 */
		List<Long> longs = LongStream.of(1L, 2L, 3L, 4L, 5L).boxed().collect(Collectors.toList());
		System.out.println(longs);

		/*
		 * DoubleStream
		 */
		List<Double> doubles = DoubleStream.of(1D, 2D, 3D, 4D, 5D).boxed().collect(Collectors.toList());
		System.out.println(doubles);
	}
}
