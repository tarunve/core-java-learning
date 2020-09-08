package com.maven.FirstMavenProject;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppAddTest {
	
	App app ;
	
	@Before
	public void beforeMethod() {
		System.out.println("Test Case started ...");
		app = new App();
	}
	
	@After
	public void afterMethod() {
		System.out.println("Test Case ended successfully ...");
	}

	@Test
	public void testAdd() {
		//App app = new App();
		int actual = app.sum(3, 5);
		int expected = 8;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddNegative() {
		//App app = new App();
		int actual = app.sum(3, 5);
		int expected = 12;
		assertNotEquals(expected, actual);
	}
}