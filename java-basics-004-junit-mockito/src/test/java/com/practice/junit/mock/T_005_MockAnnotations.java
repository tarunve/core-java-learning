package com.practice.junit.mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.practice.junit.services.TodoBusinessImpl;
import com.practice.junit.services.TodoService;

//@RunWith(MockitoJUnitRunner.class)
public class T_005_MockAnnotations {
	
	//Using MockitoJUnit.rule() instead of @RunWith(MockitoJUnitRunner.class). JUnit rules.
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	TodoService todoService;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> argumentCaptor;
	
	@Test
	public void testToDoServiceRelatedToSpring_nonEmptyList() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}
	
	@Test
	public void testToDoServiceRelatedToSpring_emptyList() {
		List<String> allTodos = new ArrayList<String>();
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(0, todos.size());
	}

	@Test
	public void testToDoServiceRelatedToSpring_deleteMethod() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
		verify(todoService).deleteTodo("Learn to Dance");
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring");
		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
	}
	
	@Test
	public void testToDoServiceRelatedToSpring_captureArgument() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
		verify(todoService).deleteTodo(argumentCaptor.capture());
		assertEquals("Learn to Dance", argumentCaptor.getValue());
	}

}
