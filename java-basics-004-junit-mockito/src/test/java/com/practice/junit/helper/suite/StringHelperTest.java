package com.practice.junit.helper.suite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.practice.junit.helper.StringHelper;

public class StringHelperTest {

	// AACD => CD ACD => CD CDEF=>CDEF CDAA => CDAA

	StringHelper helper;

	@Before
	public void before() {
		helper = new StringHelper();
	}

	@Test
	public void testTruncateAInFirst2Positions_AinFirst2Positions() {
		Assert.assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}

	@Test
	public void testTruncateAInFirst2Positions_AinFirstPosition() {
		Assert.assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions_lengthLessThanTwo() {
		Assert.assertEquals("", helper.truncateAInFirst2Positions("A"));
	}

	// ABCD => false, ABAB => true, AB => true, A => false
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
		Assert.assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
		Assert.assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_lengthEqualOne() {
		Assert.assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_lengthEqualsTwo() {
		Assert.assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
	}

}