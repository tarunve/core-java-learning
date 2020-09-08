package com.practice.junit.stub;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.practice.junit.services.TodoBusinessImpl;
import com.practice.junit.services.TodoService;

public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}
	
	@Test
	public void usingAStub_deleteMethod() {
		TodoService todoService = new TodoServiceStub();
		todoService.deleteTodo(null);
	}
}