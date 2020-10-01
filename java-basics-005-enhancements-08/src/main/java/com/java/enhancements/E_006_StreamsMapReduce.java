package com.java.enhancements;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class E_006_StreamsMapReduce {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		
		Function<Integer, Integer> f = new Function<Integer , Integer>() {
			public Integer apply(Integer i) {
				return i*2;
			}
		};
		BinaryOperator<Integer> b = new BinaryOperator<Integer>() {
			public Integer apply(Integer i , Integer j) {
				return i+j;
			}
		};
		Stream< Integer> s = list.stream();
		Stream<Integer> s1 = s.map(f);
		Integer result = s1.reduce(0,b);
		
		System.out.println(result);
		
		//lamnbda expression 
		Function<Integer, Integer> f1 = i -> i*2;
		BinaryOperator<Integer> b1 = (i,j) -> i+j;
		Stream< Integer> s0 = list.stream();
		Stream<Integer> s2 = s0.map(f1);
		Integer result1 = s2.reduce(0,b1);
		System.out.println(result1);
		
		//stream 
		Integer result3 = list.stream().map(i -> i*2).reduce(0, (c,e)->c+e);
		System.out.println(result3);
		
		//call by method reference
		System.out.println(list.stream().map(i -> i*2).reduce(0, Integer::sum));
	}
}
