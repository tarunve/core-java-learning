package com.java.enhancements;

import java.util.Optional;

/**
 * 	What is the Type of Null
 * 	========================
 * 	->	The use of null is so common that we rarely put more thoughts on it. For example, field members of objects are automatically 
 * 		initialized to null and programmers typically initialize reference types to null when they don’t have an initial value to 
 * 		give them and, in general, null is used everytime where we don’t know or we don’t have a value to give to a reference.
 * 	->	In Java null is actually a type, a special one. It has no name so we cannot declare variables of its type or cast any 
 * 		variables to it; in fact there is only a single value that can be associated with it (i.e. the literal null). Remember that 
 * 		unlike any other types in Java, a null reference can be safely assigned to any other reference types without any error.
 * 
 * 	What is wrong with just returning null?
 * 	======================================
 * 	->	null is a problem in most of the cases and we get NPE.
 * 	->	A good solution is to always initialize your object references with some value, and never with null. In this way, you will 
 * 		never encounter NullPointerException. Fair enough. But in practical we always don’t have a default value for a reference. 
 * 		So, how those cases should be handled?   ---> Java 8 Optionals
 * 
 * 	How Java 8 Optionals provide the solution?		
 * 	==========================================
 * 	->	Optional is a way of replacing a nullable T reference with a non-null value. An Optional may either contain a non-null T 
 * 		reference (in which case we say the reference is “present”), or it may contain nothing.
 * 	->	Remember that it is never said that optional “contain null”.	
 * 	->	You can also view Optional as a single-value container that either contains a value or doesn’t.
 * 
 * 	What is inside Optional make it work?
 * 	====================================
 * 	->	When you create an Optional then below call happen at end and assign the passed value to ‘value’ attribute.
 * 			this.value = Objects.requireNonNull(value);
 * 	->	When you try to get a value from an Optional, value is fetched if present other wise NoSuchElementException is thrown.
 * 
 * 	What is Optional trying to solve?
 * 	=================================
 * 	->	Optional is an attempt to reduce the number of null pointer exceptions in Java systems, by adding the possibility to build 
 * 		more expressive APIs considering that sometimes return values are missing.
 * 
 * 	What is Optional not trying to solve?
 * 	====================================
 * 	->	Optional is not meant to be a mechanism to avoid all types of null pointers. e.g. The mandatory input parameters of methods 
 * 		and constructors will still have to be tested.
 * 	->	Optional should be used almost all the time as the return type of functions that might not return a value.
 */
public class E_008_Optionals {
	
	public static void main(String[] args) {
		/*
		 * Use Optional.empty() to create empty optional.
		 */
		Optional<Integer> possible = Optional.empty();
		System.out.println(possible);
		
		/*
		 * Use Optional.of() to create optional with default non-null value. If you pass null in of(), then a NPE is thrown immediately.
		 */
		Optional<Integer> possible2 = Optional.of(5);
		possible2.ifPresent(System.out::println);
		
		/*
		 * Use Optional.ofNullable() to create an Optional object that may hold a null value. If parameter is null, the resulting 
		 * Optional object would be empty (remember that value is absent; don’t read it null).
		 */
		Optional<Integer> possible3 = Optional.ofNullable(null);
		System.out.println(possible3);
		//or
		Optional<Integer> possible4 = Optional.ofNullable(5);
		if(possible4.isPresent()){
		    System.out.println(possible4.get());
		}
		//or
		possible4.ifPresent(System.out::println);
		
		/*
		 * Filter using Optional
		 */
		Integer optional = (Integer) Optional.empty().orElse(new Integer(9));
		System.out.println(optional);
	}
}
