package com.practice.junit.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class T_003_ListMockitoTest {

	@Test
	public void letsMockListSize() {
		List list = mock(List.class);
		when(list.size()).thenReturn(10);
		assertEquals(10, list.size());
	}

	@Test
	public void letsMockListSizeWithMultipleReturnValues() {
		List list = mock(List.class);
		when(list.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, list.size()); // First Call
		assertEquals(20, list.size()); // Second Call
	}

	@Test
	public void letsMockListGet() {
		List<String> list = mock(List.class);
		when(list.get(0)).thenReturn("in28Minutes");
		assertEquals("in28Minutes", list.get(0));
		assertNull(list.get(1));
	}

	@Test
	public void letsMockListGetWithAny() {
		List<String> list = mock(List.class);
		//Argument Matcher - anyInt()
		when(list.get(Mockito.anyInt())).thenReturn("in28Minutes");
		assertEquals("in28Minutes", list.get(0));
		assertEquals("in28Minutes", list.get(1));
	}
	
	@Test(expected=RuntimeException.class)
	public void letsMockList_throwException() {
		List<String> newList = new ArrayList<String>();
		List<String> list = mock(List.class);
		when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException("Some Error occured"));
		newList.get(0);
	}
}