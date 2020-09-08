package com.practice.junit.mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.practice.junit.services.TodoBusinessImpl;
import com.practice.junit.services.TodoService;

@SuppressWarnings("unchecked")
public class T_004_BDDTest {
	
	
	@Test
	public void testList_usingGivenWillReturn() {
		List<String> list = mock(List.class);
		//given
		given(list.get(Mockito.anyInt())).willReturn("in28Minutes");
		//then
		assertThat("in28Minutes", is(list.get(0)));
		assertThat("in28Minutes", is(list.get(0)));
	}
	
	@Test
	public void testToDoServiceRelatedToSpring_usingBDD() {
		//Given
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		//When
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		//Then
		assertThat(todos.size(), is(2));
	}

}
