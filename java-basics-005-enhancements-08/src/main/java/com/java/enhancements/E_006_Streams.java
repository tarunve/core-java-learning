package com.java.enhancements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *	->	A Stream in Java can be defined as a sequence of elements from a source that supports aggregate operations on them.
 *	->	Stream keeps the ordering of the data as it is in the source. The aggregate operations or bulk operations are operations 
 *		which allow us to express common manipulations on stream elements easily and clearly.
 *
 *	->	At the basic level, the difference between Collections and Streams has to do with when things are computed.
 *	->	A Collection is an in-memory data structure, which holds all the values that the data structure currently has—every element 
 *		in the Collection has to be computed before it can be added to the Collection.
 *	->	A Stream is a conceptually fixed data structure, in which elements are computed on demand. This gives rise to significant 
 *		programming benefits. The idea is that a user will extract only the values they require from a Stream, and these elements 
 *		are only produced—invisibly to the user—as and when required. This is a form of a producer-consumer relationship.
 *	->	In java, java.util.Stream represents a stream on which one or more operations can be performed. Stream operations are either 
 *		intermediate or terminal. While terminal operations return a result of a certain type, intermediate operations return the 
 *		stream itself so you can chain multiple method calls in a row.
 *	->	Streams are created on a source, e.g. a java.util.Collection like lists or sets (maps are not supported). Stream operations 
 *		can either be executed sequentially or parallel.
 *
 *	characteristics of Stream
 *	=========================
 *	->	Not a data structure
 *	->	Designed for lambdas
 *	->	Do not support indexed access
 *	->	Can easily be outputted as arrays or lists
 *	->	Lazy access supported
 *	->	Parallelizable
 *
 *	Java 8 Stream Intermediate And Terminal Operations :
 *	==================================================
 *	-	The main difference between intermediate and terminal operations is that intermediate operations return a stream
 *		as a result and terminal operations return non-stream values like primitive or object or collection or may not
 *		return anything.
 *	-	As intermediate operations return another stream as a result, they can be chained together to form a pipeline of
 *		operations. Terminal operations can not be chained together.
 *	-	Pipeline of operations may contain any number of intermediate operations, but there has to be only one terminal
 *		operation, that too at the end of pipeline.
 *	-	Intermediate operations are lazily loaded. When you call intermediate operations, they are actually not executed.
 *		They are just stored in the memory and executed when the terminal operation is called on the stream.
 *	-	As the names suggest, intermediate operations doesn't give end result. They just transform one stream to another
 *		stream. On the other hand, terminal operations give end result.
 *	-	Intermediate Operations :
 *			map(), filter(), distinct(), sorted(), limit(), skip()
 *	-	Terminal Operations :
 *			forEach(), toArray(), reduce(), collect(), min(), max(), count(), anyMatch(), allMatch(), noneMatch(),
 *			findFirst(), findAny()
 *
 */
public class E_006_Streams {

	public static class StreamCreation {
		public static void main(String[] args) {
			/*
			 *  Stream.of(val1, val2, val3….)
			 */
			Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
			stream.forEach(p -> System.out.println(p));

			/*
			 * Stream.of(arrayOfElements)
			 */
			Stream<Integer> stream2 = Stream.of(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
			stream2.forEach(p -> System.out.println(p));

			/*
			 *	List.stream()
			 */
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 1; i < 10; i++) {
				list.add(i);
			}
			Stream<Integer> stream3 = list.stream();
			stream3.forEach(p -> System.out.println(p));

			/*
			 * Stream.generate() or Stream.iterate()
			 */
			Stream<Date> stream4 = Stream.generate(() -> {
				return new Date();
			}).limit(10);
			stream4.forEach(p -> System.out.println(p));

			/*
			 * String chars or String tokens
			 */
			IntStream stream5 = "12345_abcdefg".chars();
			stream5.forEach(p -> System.out.println(p));
			//OR
			Stream<String> stream6 = Stream.of("A$B$C".split("\\$"));
			stream6.forEach(p -> System.out.println(p));
		}
	}

	public static class StreamToCollectionConversion {
		public static void main(String[] args) {
			/*
			 * Stream to List – Stream.collect( Collectors.toList() )
			 */
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 1; i < 10; i++) {
				list.add(i);
			}
			Stream<Integer> stream = list.stream();
			List<Integer> evenNumbersList = stream.filter(i -> i % 2 == 0).collect(Collectors.toList());
			System.out.println(evenNumbersList);

			/*
			 *	Stream to array – Stream.toArray( EntryType[]::new )
			 */
			List<Integer> list2 = new ArrayList<Integer>();
			for (int i = 1; i < 10; i++) {
				list2.add(i);
			}
			Stream<Integer> stream2 = list2.stream();
			Integer[] evenNumbersArr = stream2.filter(i -> i % 2 == 0).toArray(Integer[]::new);
			System.out.println(Arrays.toString(evenNumbersArr));
		}

	}

	public static class StreatCoreOperations {

		private static List<String> memberNames = new ArrayList<>();

		static {
			memberNames.add("Amitabh");
			memberNames.add("Shekhar");
			memberNames.add("Aman");
			memberNames.add("Rahul");
			memberNames.add("Shahrukh");
			memberNames.add("Salman");
			memberNames.add("Yana");
			memberNames.add("Lokesh");
		}

		public static void main(String[] args) {
			/*
			 * Stream.filter()
			 * ->	Filter accepts a predicate to filter all elements of the stream. This operation is intermediate 
			 * 		which enables us to call another stream operation (e.g. forEach) on the result.
			 */
			memberNames.stream().filter((s) -> s.startsWith("A")).forEach(System.out::println);

			/*
			 * Stream.map()
			 * ->	The intermediate operation map converts each element into another object via the given function. 
			 * 		The following example converts each string into an upper-cased string. But you can also use map() 
			 * 		to transform each object into another type.
			 */
			memberNames.stream().filter((s) -> s.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);

			/*
			 * Stream.sorted()
			 * ->	Sorted is an intermediate operation that returns a sorted view of the stream. The elements are 
			 * 		sorted in natural order unless you pass a custom Comparator.
			 */
			memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);

			/*
			 * Stream.collect()
			 * ->	collect() method used to receive elements from a steam and store them in a collection and mentioned 
			 * 		in parameter function.
			 */
			List<String> memNamesInUppercase = memberNames.stream().sorted().map(String::toUpperCase).collect(Collectors.toList());
			System.out.print(memNamesInUppercase);

			/*
			 * Stream.match()
			 * ->	Various matching operations can be used to check whether a certain predicate matches the stream. 
			 * 		All of those operations are terminal and return a boolean result.
			 */
			boolean matchedResult = memberNames.stream().anyMatch((s) -> s.startsWith("A"));
			System.out.println(matchedResult);
			matchedResult = memberNames.stream().allMatch((s) -> s.startsWith("A"));
			System.out.println(matchedResult);
			matchedResult = memberNames.stream().noneMatch((s) -> s.startsWith("A"));
			System.out.println(matchedResult);

			/*
			 * Stream.count()
			 * ->	Count is a terminal operation returning the number of elements in the stream as a long value
			 */
			long totalMatched = memberNames.stream().filter((s) -> s.startsWith("A")).count();
			System.out.println(totalMatched);

			/*
			 * Stream.reduce()
			 * ->	This terminal operation performs a reduction on the elements of the stream with the given function. 
			 * 		The result is an Optional holding the reduced value.
			 */
			Optional<String> reduced = memberNames.stream().reduce((s1, s2) -> s1 + "#" + s2);
			reduced.ifPresent(System.out::println);

			/*
			 * Stream.anyMatch()
			 * ->	This will return true once a condition passed as predicate satisfy. It will not process any more elements.
			 */
			boolean matched = memberNames.stream().anyMatch((s) -> s.startsWith("A"));
			System.out.println(matched);

			/*
			 *  Stream.findFirst()
			 *  ->	It will return the first element from the stream and then will not process any more element.
			 */
			String firstMatchedName = memberNames.stream().filter((s) -> s.startsWith("L")).findFirst().get();
			System.out.println(firstMatchedName);
			//or
			memberNames.stream().filter(s -> s.startsWith("L")).findFirst().ifPresent(System.out::println);

		}
	}

	/**
	 * 	->	To enable parallelism, all you have to do is to create a parallel stream, instead of a sequential stream. 
	 * 		And to surprise you, this is really very easy. In any of the above-listed stream examples, anytime you want 
	 * 		to particular job using multiple threads in parallel cores, all you have to call method parallelStream() 
	 * 		method instead of stream() method.
	 */
	public static class StreamParallel {
		public static void main(String[] args) {
			List<Integer> list = new ArrayList<>();
			for (int i = 1; i < 10; i++) {
				list.add(i);
			}
			//Here creating a parallel stream
			Stream<Integer> stream = list.parallelStream();
			Integer[] evenNumbersArr = stream.filter(i -> i % 2 == 0).toArray(Integer[]::new);
			System.out.print(Arrays.toString(evenNumbersArr));
		}
	}
}
