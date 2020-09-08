package com.practice.junit.mock;

import org.junit.Test;
import com.practice.junit.T_001_JunitTerminologies;
import com.practice.junit.T_002_MockitoAnnotations;
import com.practice.junit.T_003_PowerMock;
import com.practice.junit.T_004_FAQ;

import static org.junit.Assert.assertTrue;

public class T_001_FirstMockitoTest {
	
	@Test
	public void testTutorialsObject(){
		new T_001_JunitTerminologies();
		new T_002_MockitoAnnotations();
		new T_003_PowerMock();
		new T_004_FAQ();
	}

	@Test
	public void test() {
		assertTrue(true);
	}
}
