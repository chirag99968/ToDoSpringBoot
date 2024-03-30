package com.springboot.firstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@RequestMapping("list-todos")
	public String listAddTodos(ModelMap model) {
		
		List<Todo> todos = todoService.findByUsername("chirag");
		model.put("todos", todos);
		return "listTodos";
	}

	@GetMapping("/add-todos")
	public String showNewTodoPage( ModelMap model)
	{
		model.put("todo", new Todo(0, (String)model.get("name"),"",LocalDate.now() ,false));
		return "todo";
	}

	@PostMapping("/add-todos")
	public String addNewTodo( ModelMap model, @Valid Todo todo, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "todo";
		}
		
		todoService.addTodo((String)model.get("name"), todo.getDescription(), LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}

	@RequestMapping("delete-todo")
	public String listAddTodos( @RequestParam int id, ModelMap model) {
		 todoService.deleteById(id);
		return "redirect:list-todos";
	}

	@GetMapping("/update-todo")
	public String showUpdateTodoPage( @RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.put("todo", todo);
		return "todo";
	}

	@PostMapping("/update-todo")
	public String showUpdateTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {

		if(result.hasErrors())
		{
			return "todo";
		}
		
		todo.setUsername((String)model.get("name"));
		todoService.updateTodo(todo);
		return "redirect:list-todos";

	}

	
}
