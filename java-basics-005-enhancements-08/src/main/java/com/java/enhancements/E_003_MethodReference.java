package com.java.enhancements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 	->	In Java 8, we can refer a method from class or object using class::methodName type syntax.
 * 
 * 	Types of Method Reference:
 * 	-------------------------
 * 	1.	Reference to static method : Used to refer static methods from a class. 
 * 			Ex: Math::max equivalent to Math.max(x,y)
 * 	2.	Reference to instance method from instance : Refer to an instance method using a reference to the supplied object
 * 			Ex : System.out::println equivalent to System.out.println(x)
 * 	3.	Reference to instance method from class type : Invoke the instance method on a reference to an object 
 * 													   supplied by the context.
 * 			Ex : String::length equivalent to str.length()
 * 	4.	Reference to constructor : Reference to a constructor
 * 			Ex : ArrayList::new equivalent to new ArrayList()
 */
public class E_003_MethodReference {
	public static void main(String[] args) {
		/*
		 * Method reference to static method – Class::staticMethodName
		 */
		List<Integer> integers = Arrays.asList(1,12,433,5);
		Optional<Integer> max = integers.stream().reduce( Math::max ); 
		max.ifPresent(value -> System.out.println(value)); 
		//or
		integers.stream().reduce( Math::max ).ifPresent(value -> System.out.println(value));
		
		/*
		 * Method reference to instance method from instance – ClassInstance::instanceMethodName
		 */
		List<Integer> integers2 = Arrays.asList(1,12,433,5);
		Optional<Integer> max2 = integers2.stream().reduce( Math::max ); 
		max2.ifPresent( System.out::println ); 
		//or
		integers.stream().reduce( Math::max ).ifPresent(System.out::println);
		
		/*
		 * Method reference to instance method from class type – Class::instanceMethodName
		 */
		List<String> strings = Arrays.asList("how", "to", "do", "in", "java", "dot", "com");		 
		List<String> sorted = strings.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
		System.out.println(sorted);
		List<String> sortedAlt = strings.stream().sorted(String::compareTo).collect(Collectors.toList());
		System.out.println(sortedAlt);
		
		/*
		 * Reference to constructor – Class::new
		 */
		List<Integer> integers3 = IntStream.range(1, 100).boxed().collect(Collectors.toCollection( ArrayList::new ));
		System.out.println(integers3);
		Optional<Integer> max3 = integers3.stream().reduce(Math::max); 
		max3.ifPresent(System.out::println); 
	}
}
