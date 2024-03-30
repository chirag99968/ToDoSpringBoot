package com.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 1;
	
	static {
		todos.add(new Todo(todosCount++, "chirag", "Learn SpringBoot", LocalDate.now().plusYears(1),false));
		todos.add(new Todo(todosCount++, "chirag", "Learn Aws", LocalDate.now().plusYears(1),false));
		todos.add(new Todo(todosCount++, "chirag", "Learn Kubernates", LocalDate.now().plusYears(1),false));

	}

	public List<Todo> findByUsername(String username) {
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done)
	{
		todos.add(new Todo(todosCount++, username, description, targetDate, done));
	}

	public void deleteById(int id)
	{
		todos.removeIf(todo -> todo.getId()==id);
	}

	public Todo findById(int id) {
		return 	todos.stream().filter(todo -> todo.getId()==id).findFirst().get();
	}

	public void updateTodo(Todo todo) {
		Todo todoToUpdate = todos.stream().filter(todos -> todo.getId()==todos.getId()).findFirst().get();
		todoToUpdate.setDescription(todo.getDescription());
		todoToUpdate.setTargetDate(todo.getTargetDate());
		todoToUpdate.setDone(todo.isDone());
	}
}
