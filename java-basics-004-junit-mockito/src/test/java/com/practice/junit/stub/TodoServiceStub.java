package com.practice.junit.stub;

import java.util.Arrays;
import java.util.List;

import com.practice.junit.services.TodoService;

public class TodoServiceStub implements TodoService {
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
	}

	public void deleteTodo(String todo) {

	}
}