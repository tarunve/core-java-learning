package com.maven.FirstMavenProject;

/**
 * Hello world!
 *
 */

public class App 
{
	public int sum(int a , int b) {
		System.out.println("This is sum method");
		return a+b;
	}
	
	public int subtract( int a , int b) {
		System.out.println("This is Subtraction method");
		return a-b;
	}
	
	public void performanceTest() {
		for(int i=0 ; i<10000 ; i++) {
			Math.max(45, 98);
		}
	}
	
	public void exception() {
		int a=0;
		int b = 1/a;
		System.out.println(b);
	}
}
