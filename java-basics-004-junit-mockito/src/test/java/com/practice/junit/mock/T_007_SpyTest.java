package com.practice.junit.mock;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class T_007_SpyTest {

	@Test
	public void creatingASpyOnArrayList() {
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("Ranga");
		listSpy.add("in28Minutes");

		verify(listSpy).add("Ranga");
		verify(listSpy).add("in28Minutes");

		assertEquals(2, listSpy.size());
		assertEquals("Ranga", listSpy.get(0));
	}

	@Test
	public void creatingASpyOnArrayList_overridingSpecificMethods() {
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("Ranga");
		listSpy.add("in28Minutes");
		
		assertEquals(2, listSpy.size());

		stub(listSpy.size()).toReturn(-1);

		assertEquals(-1, listSpy.size());
		assertEquals("Ranga", listSpy.get(0));
	}
}
