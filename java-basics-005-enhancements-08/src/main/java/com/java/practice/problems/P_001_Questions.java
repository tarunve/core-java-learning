package com.java.practice.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P_001_Questions {

	static class Product {
		private String name;
		private double price;
		
		public Product() {}

		public Product(String name, double price) {
			super();
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
	}
	
	public static void main(String[] args) {
		List<Product> list = Arrays.asList(new Product("Product1", 15.20D), new Product("Product2", 20.00D));
		list.stream().filter(p -> p.getName().startsWith("Product")).map(Product::getPrice).reduce((a,b)-> a+b).ifPresent(System.out::println);
		
		list.stream().filter(p->p.getName().startsWith("Pro"))
					 .map(Product::getName)
					 .map(String::toUpperCase)
					 .distinct()
					 .limit(2)
					 .collect(Collectors.toList())
					 .forEach(System.out::println);;
	}
}
