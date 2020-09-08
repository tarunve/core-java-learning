package com.practice.junit.mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import com.practice.junit.services.TodoBusinessImpl;
import com.practice.junit.services.TodoService;

public class T_002_TodoBusinessImplMockitoTest {

	@Test
	public void testToDoServiceRelatedToSpring_nonEmptyList() {
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}
	
	@Test
	public void testToDoServiceRelatedToSpring_emptyList() {
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = new ArrayList<String>();
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(0, todos.size());
	}

	@Test
	public void testToDoServiceRelatedToSpring_deleteMethod() {
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
		verify(todoService).deleteTodo("Learn to Dance");
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring");
		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
	}

	//How to capture an argument which is passed to a mock?
	@Test
	public void testToDoServiceRelatedToSpring_captureArgument() {
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
		verify(todoService).deleteTodo(argumentCaptor.capture());
		assertEquals("Learn to Dance", argumentCaptor.getValue());
	}
}