package com.maven.FirstMavenProject;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class AppSubtractTest {
	
	static App app;
	
	@BeforeClass
	public static void beforeClassMethod() {
		System.out.println("Test Cases started ..");
		app = new App();
	}
	
	@AfterClass
	public static void afterClassMethod() {
		System.out.println("Test Cases ended suuccessfully ...");
	}

	@Test
	public void testSubtract() {
		//App app = new App();
		int actual = app.subtract(3, 5);
		int expected = -2;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSubtractNegative() {
		//App app = new App();
		int actual = app.subtract(3, 5);
		int expected = 2;
		assertNotEquals(expected, actual);	
	}
	
	@Ignore
	@Test
	public void testIgnore() {
		System.out.println("This is the ignore method ...");
	}
	
	@Test(timeout=0)
	public void testPerformance() {
		app.performanceTest();
	}
	
	@Test(expected=ArithmeticException.class)
	public void testException() {
		app.exception();
	}
}
